/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.ucenfotec.ui;

import com.jfoenix.controls.JFXButton;
import cr.ac.ucenfotec.bl.ClienteJuridico;
import cr.ac.ucenfotec.bl.Contacto;
import cr.ac.ucenfotec.tl.Gestor;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


/**
 *
 * @author Dell
 */
public class ControllerListaJuridicos implements Initializable {
    @FXML private TableColumn<ClienteJuridico, String> clmNombre;
    @FXML private TableColumn<ClienteJuridico, String> clmIdentificacion;
    @FXML private TableColumn<ClienteJuridico, String> clmTelefono;
    @FXML private TableColumn<ClienteJuridico, String> clmProvincia;
    @FXML private TableColumn<ClienteJuridico, String> clmDireccionExacta;
    @FXML private TableColumn<Contacto, Contacto> clmContacto;
    @FXML private ObservableList<ClienteJuridico> listaClientesJuridicos;
    @FXML private TableView<ClienteJuridico> tblListaClienteJuridico;
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
      listaClientesJuridicos = FXCollections.observableArrayList();
        try {
            listaClientesJuridicos = controller.llenarTablaClienteJuridico(listaClientesJuridicos);
        
        } catch (Exception ex) {
            Logger.getLogger(ControllerListaJuridicos.class.getName()).log(Level.SEVERE, null, ex);
        }
        JFXButton btnVolver = new JFXButton();
        
        
                
        

        tblListaClienteJuridico.setItems(listaClientesJuridicos);
        
        clmNombre.setCellValueFactory(new PropertyValueFactory<ClienteJuridico, String>("primerNombre"));
        clmIdentificacion.setCellValueFactory(new PropertyValueFactory<ClienteJuridico, String>("cedula"));
        clmTelefono.setCellValueFactory(new PropertyValueFactory<ClienteJuridico, String>("telefono"));
        clmProvincia.setCellValueFactory(new PropertyValueFactory<ClienteJuridico, String>("provincia"));
        clmDireccionExacta.setCellValueFactory(new PropertyValueFactory<ClienteJuridico, String>("direccionExacta"));
        clmContacto.setCellValueFactory(new PropertyValueFactory<Contacto, Contacto>("cedula"));
        gestionarEventos();                 
    }
    
    public void search(KeyEvent event){
        FilteredList<ClienteJuridico> filter = new FilteredList<>(listaClientesJuridicos, p -> true);
        txtBuscar.textProperty().addListener((observable, oldValue, newValue) -> {
           filter.setPredicate((Predicate<? super ClienteJuridico>) (ClienteJuridico clientejuridico) -> {
           
           if(newValue.isEmpty() || newValue == null){
               return true;
           }
           else if(clientejuridico.getCedula().contains(newValue)){
               return true;
           }
           
           else if(clientejuridico.getNombre().contains(newValue)){
               return true;
           }
           
            else if(clientejuridico.getNombre().contains(newValue)){
               return true;
           }
           
            else if(clientejuridico.getMicontacto().getCedula().contains(newValue)){
               return true;
           }
           
                      
            else if(clientejuridico.getTelefono().contains(newValue)){
               return true;
           }
           
          
           return false;
           });
        });  
      
        
        SortedList sort = new SortedList(filter);
        sort.comparatorProperty().bind(tblListaClienteJuridico.comparatorProperty());
        tblListaClienteJuridico.setItems(sort);
    }
    
    
    public void gestionarEventos(){
        tblListaClienteJuridico.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<ClienteJuridico>(){
            @Override
            public void changed(ObservableValue<? extends ClienteJuridico> arg0,
                    ClienteJuridico volverAnterios, ClienteJuridico valorSeleccionado) {
                
            
       
                    
                  

                  
            }
                    
                }
        );
        
    }
    
     public void modificar(ActionEvent event) throws IOException, Exception{
              if(tblListaClienteJuridico.getSelectionModel().getSelectedItem() == null){
                  modificarPane.setVisible(true);
               }else{
                     
         FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/ModificarClienteJuridico.fxml"));
       
          Parent tableViewParent = (Parent) loader.load();
          Scene tableViewScene = new Scene(tableViewParent);
         
         
         Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
          
         window.setScene(tableViewScene);
          window.show();
          ControllerModificarClienteJuridico controllerModificar = loader.getController();
          controllerModificar.modificarDatos(tblListaClienteJuridico.getSelectionModel().getSelectedItem());  
          
              }
     
              
                  
              } 
         
          
        
        
       

 
    public void eliminar(ActionEvent event) throws IOException, Exception{
       if (tblListaClienteJuridico.getSelectionModel().getSelectedItem() == null) {
           entendidoEliminar.setVisible(true);
          
           
                  
       }else{
            
                  if (event.getSource() == btnEliminar){
         eliminarPane.setVisible(true);
     }
        
           if(event.getSource() == btnSiEliminar ){
               controller.eliminarClienteJuridico(tblListaClienteJuridico.getSelectionModel().getSelectedItem());
               controller.eliminarContacto(tblListaClienteJuridico.getSelectionModel().getSelectedItem());
              listaClientesJuridicos.remove(tblListaClienteJuridico.getSelectionModel().getSelectedIndex());
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
             Parent blah = FXMLLoader.load(getClass().getResource("../fxml/RegistrarClienteFisico.fxml"));
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
