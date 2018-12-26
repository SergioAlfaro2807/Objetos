/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.ucenfotec.ui;

import com.jfoenix.controls.JFXButton;
import cr.ac.ucenfotec.bl.ClienteFisico;
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
public class ControllerListaFisicos implements Initializable {
    @FXML private TableColumn<ClienteFisico, String> clmNombre;
    @FXML private TableColumn<ClienteFisico, String> clmPrimerApellido;
    @FXML private TableColumn<ClienteFisico, String> clmSegundoApellido;
    @FXML private TableColumn<ClienteFisico, String> clmCorreo;
    @FXML private TableColumn<ClienteFisico, String> clmTelefono;
    @FXML private TableColumn<ClienteFisico, String> clmProvincia;
    @FXML private ObservableList<ClienteFisico> listaClientesFisicos;
    @FXML private TableView<ClienteFisico> tblListaClienteFisico;
    @FXML private TextField txtBuscar;
        @FXML
    private ImageView ImgVolver;
    @FXML
    private JFXButton btnVolver;
    
    
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
      listaClientesFisicos = FXCollections.observableArrayList();
        try {
            listaClientesFisicos = controller.llenarTablaClienteFisico(listaClientesFisicos);
        } catch (Exception ex) {
            Logger.getLogger(ControllerListaFisicos.class.getName()).log(Level.SEVERE, null, ex);
        }
        JFXButton btnVolver = new JFXButton();
        
        
     
        

        tblListaClienteFisico.setItems(listaClientesFisicos);
        
        clmNombre.setCellValueFactory(new PropertyValueFactory<ClienteFisico, String>("nombre"));
        clmPrimerApellido.setCellValueFactory(new PropertyValueFactory<ClienteFisico, String>("primerApellido"));
        clmSegundoApellido.setCellValueFactory(new PropertyValueFactory<ClienteFisico, String>("segundoApellido"));
        clmCorreo.setCellValueFactory(new PropertyValueFactory<ClienteFisico, String>("correo"));
        clmTelefono.setCellValueFactory(new PropertyValueFactory<ClienteFisico, String>("telefono"));
        clmProvincia.setCellValueFactory(new PropertyValueFactory<ClienteFisico, String>("provincia"));
        gestionarEventos();
        
        
        
        
        
    }
    
    public void search(KeyEvent event){
        FilteredList<ClienteFisico> filter = new FilteredList<>(listaClientesFisicos, p -> true);
        txtBuscar.textProperty().addListener((observable, oldValue, newValue) -> {
           filter.setPredicate((Predicate<? super ClienteFisico>) (ClienteFisico clientefisico) -> {
           
           if(newValue.isEmpty() || newValue == null){
               return true;
           }
           else if(clientefisico.getCorreo().contains(newValue)){
               return true;
           }
           
           else if(clientefisico.getNombre().contains(newValue)){
               return true;
           }
           
            else if(clientefisico.getPrimerApellido().contains(newValue)){
               return true;
           }
           
            else if(clientefisico.getSegundoApellido().contains(newValue)){
               return true;
           }
           
                      
            else if(clientefisico.getTelefono().contains(newValue)){
               return true;
           }
           
          
           return false;
           });
        });  
      
        
        SortedList sort = new SortedList(filter);
        sort.comparatorProperty().bind(tblListaClienteFisico.comparatorProperty());
        tblListaClienteFisico.setItems(sort);
    }
    
    
    public void gestionarEventos(){
        tblListaClienteFisico.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<ClienteFisico>(){
            @Override
            public void changed(ObservableValue<? extends ClienteFisico> arg0,
                    ClienteFisico volverAnterios, ClienteFisico valorSeleccionado) {
                
            
       
                    
                  

                  
            }
                    
                }
        );
        
    }
    
      public void modificar(ActionEvent event) throws IOException{
               if(tblListaClienteFisico.getSelectionModel().getSelectedItem() == null){
                   modificarPane.setVisible(true);
               }else{
                     
         FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/ModificarClienteFisico.fxml"));
        
          Parent tableViewParent = (Parent) loader.load();
           Scene tableViewScene = new Scene(tableViewParent);
          
          
          Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
          
          window.setScene(tableViewScene);
          window.show();
          ControllerModificarClienteFisico controllerModificar = loader.getController();
          controllerModificar.modificarDatos(tblListaClienteFisico.getSelectionModel().getSelectedItem());  
               }
        
          
         
          
        
        
       
    }
 
      public void eliminar(ActionEvent event) throws IOException, Exception{
         if (tblListaClienteFisico.getSelectionModel().getSelectedItem() == null) {
            entendidoEliminar.setVisible(true);
          
           
                  
        }else{
             
                   if (event.getSource() == btnEliminar){
          eliminarPane.setVisible(true);
      }
        
            if(event.getSource() == btnSiEliminar ){
                controller.eliminarClienteFisico(tblListaClienteFisico.getSelectionModel().getSelectedItem());
                listaClientesFisicos.remove(tblListaClienteFisico.getSelectionModel().getSelectedIndex());
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
