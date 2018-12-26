/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.ucenfotec.ui;

import com.jfoenix.controls.JFXButton;
import cr.ac.ucenfotec.bl.ClienteFisico;
import cr.ac.ucenfotec.bl.ClienteJuridico;
import cr.ac.ucenfotec.bl.Contacto;
import cr.ac.ucenfotec.bl.Tecnologia;
import cr.ac.ucenfotec.tl.Gestor;
import java.io.IOException;
import java.net.URL;
import static java.nio.file.Files.list;
import static java.rmi.Naming.list;
import static java.util.Collections.list;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


/**
 *
 * @author Dell
 */
public class ControllerListarTecnologia implements Initializable {
    @FXML private TableColumn<Tecnologia, String> clmNombre;
    @FXML private TableColumn<Tecnologia, String> clmCodigo;
    @FXML private ObservableList<Tecnologia> listaTecnologias;
    @FXML private TableView<Tecnologia> tblTecnologias;
    @FXML private TextField txtBuscar;
        @FXML
    private ImageView ImgVolver;
    @FXML
    private JFXButton btnVolver;
    
       @FXML
    private JFXButton btnModificar;
    
              @FXML
    private JFXButton btnEliminar;
              
            @FXML
    private JFXButton btnSiEliminar;

           @FXML
    private JFXButton btnNoEliminar;
    @FXML
    private AnchorPane eliminarPane;
    @FXML
    private AnchorPane modificarPane;
    
    @FXML
    private AnchorPane entendidoEliminar;
      @FXML
    private JFXButton btnEntendido;
      
       @FXML
    private JFXButton btnRegistrar;
       
    @FXML
    private JFXButton btnEntendidoEliminar;
  
    static Gestor controller = new Gestor();
             
    @Override
    public void initialize(URL location, ResourceBundle resources) {
      listaTecnologias = FXCollections.observableArrayList();
        try {
            listaTecnologias = controller.llenarTablaTecnologia(listaTecnologias);
        
        } catch (Exception ex) {
            Logger.getLogger(ControllerListarTecnologia.class.getName()).log(Level.SEVERE, null, ex);
        }
        JFXButton btnVolver = new JFXButton();
        
        
                
        

        tblTecnologias.setItems(listaTecnologias);
        
        clmNombre.setCellValueFactory(new PropertyValueFactory<Tecnologia, String>("nombre"));
        clmCodigo.setCellValueFactory(new PropertyValueFactory<Tecnologia, String>("codigo"));
      //  gestionarEventos();                 
    }
    
    public void search(KeyEvent event){
        FilteredList<Tecnologia> filter = new FilteredList<>(listaTecnologias, p -> true);
        txtBuscar.textProperty().addListener((observable, oldValue, newValue) -> {
           filter.setPredicate((Predicate<? super Tecnologia>) (Tecnologia mitecnologia) -> {
           
           if(newValue.isEmpty() || newValue == null){
               return true;
           }
           else if(mitecnologia.getCodigo().contains(newValue)){
               return true;
           }
           
           else if(mitecnologia.getNombre().contains(newValue)){
               return true;
           }
         
              
           return false;
           });
        });  
      
        
        SortedList sort = new SortedList(filter);
        sort.comparatorProperty().bind(tblTecnologias.comparatorProperty());
        tblTecnologias.setItems(sort);
    }
    
    
  //  public void gestionarEventos(){
    //    tblTecnologias.getSelectionModel().selectedItemProperty().addListener(
         //       new ChangeListener<ClienteJuridico>(){
        //    @Override
        //    public void changed(ObservableValue<? extends ClienteJuridico> arg0,
      //              ClienteJuridico volverAnterios, ClienteJuridico valorSeleccionado) {
                
            
       
                    
                  

                  
        //    }
                    
            //    }
      //  );
        
  //  }
  //  
     public void modificar(ActionEvent event) throws IOException, Exception{
              if(tblTecnologias.getSelectionModel().getSelectedItem() == null){
                  modificarPane.setVisible(true);
               }else{
                     
         FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/ModificarTecnologia.fxml"));
       
          Parent tableViewParent = (Parent) loader.load();
          Scene tableViewScene = new Scene(tableViewParent);
         
         
         Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
          
         window.setScene(tableViewScene);
          window.show();
          ControllerModificarTecnologia controllerModificar = loader.getController();
        controllerModificar.modificarDatos(tblTecnologias.getSelectionModel().getSelectedItem());  
          
              }
     
              
                  
              } 
         
          
        
        
       

 
    public void eliminar(ActionEvent event) throws IOException, Exception{
    if (tblTecnologias.getSelectionModel().getSelectedItem() == null) {
          entendidoEliminar.setVisible(true);
          
           
                  
      }else{
            
                 if (event.getSource() == btnEliminar){
         eliminarPane.setVisible(true);
     }
        
          if(event.getSource() == btnSiEliminar ){
              controller.eliminarTecnologia(tblTecnologias.getSelectionModel().getSelectedItem());
            listaTecnologias.remove(tblTecnologias.getSelectionModel().getSelectedIndex());
             eliminarPane.setVisible(false);
          }
            
          if(event.getSource() == btnNoEliminar){
               eliminarPane.setVisible(false);
          }
       
             
       }

    }
    
    
    
    
    
    
    
    public void volver(ActionEvent event) throws IOException{
        if(event.getSource() == btnVolver || event.getSource() == ImgVolver){
             Parent blah = FXMLLoader.load(getClass().getResource("../fxml/Clientes.fxml"));
            Scene scene = new Scene(blah);
            Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            appStage.setScene(scene);
            appStage.show();
        }
    }
    
        public void registrar(ActionEvent event) throws IOException{
        if(event.getSource() == btnRegistrar){
             Parent blah = FXMLLoader.load(getClass().getResource("../fxml/RegistrarTecnologia.fxml"));
            Scene scene = new Scene(blah);
            Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            appStage.setScene(scene);
            appStage.show();
        }
    }
    
    
    public void entendido(ActionEvent event){
         if(event.getSource() == btnEntendido || event.getSource() == btnEntendidoEliminar ){
             modificarPane.setVisible(false);
                entendidoEliminar.setVisible(false);
            
         }
    }
      
}
