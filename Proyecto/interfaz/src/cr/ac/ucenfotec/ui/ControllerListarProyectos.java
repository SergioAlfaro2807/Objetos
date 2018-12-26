/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.ucenfotec.ui;

import com.jfoenix.controls.JFXButton;
import cr.ac.ucenfotec.bl.ClienteFisico;
import cr.ac.ucenfotec.bl.Proyecto;
import cr.ac.ucenfotec.bl.Usuario;
import cr.ac.ucenfotec.tl.Gestor;
import static cr.ac.ucenfotec.ui.ControllerListarActividades.controller;
import static cr.ac.ucenfotec.ui.ControllerMenu.contrasennaEncriptada1;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
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
public class ControllerListarProyectos implements Initializable {
    @FXML private TableColumn<Proyecto, String> clmNombre;
    @FXML private TableColumn<Proyecto, String> clmCodigo;
    @FXML private TableColumn<Proyecto, String> clmDescripcion;
    @FXML private TableColumn<Proyecto, String> clmTipo;
    @FXML private TableColumn<Proyecto, String> clmAsociado;
    @FXML private TableColumn<Proyecto, LocalDate> clmFechaInicio;
    @FXML private TableColumn<Proyecto, LocalDate> clmFechaFin;
    @FXML private ObservableList<Proyecto> listaProyectos;
    @FXML private TableView<Proyecto> tblProyectos;
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
    private AnchorPane entendidoPaneBiTe;
    
      @FXML
    private JFXButton btnEntendido;
      
       @FXML
    private JFXButton btnRegistrar;
       
        @FXML
    private JFXButton btnEntendidoBiTe;  
           @FXML
    private JFXButton btnBitacora;  
       
           
           private Usuario miusuario;
       
    @FXML
    private JFXButton btnEntendidoEliminar;
  
    static Gestor controller = new Gestor();
             
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String notienefin = "No tiene fecha";
        LocalDate SinFecha = LocalDate.of(2015, Month.AUGUST, 17);
      listaProyectos = FXCollections.observableArrayList();
        try {
            listaProyectos = controller.llenarTablaProyectos(listaProyectos);
        } catch (Exception ex) {
            Logger.getLogger(ControllerListarProyectos.class.getName()).log(Level.SEVERE, null, ex);
        }
        JFXButton btnVolver = new JFXButton();
        
      
        tblProyectos.setItems(listaProyectos);
        
        clmNombre.setCellValueFactory(new PropertyValueFactory<Proyecto, String>("nombre"));
        clmCodigo.setCellValueFactory(new PropertyValueFactory<Proyecto, String>("codigo"));
        clmDescripcion.setCellValueFactory(new PropertyValueFactory<Proyecto, String>("descripcion"));
        clmTipo.setCellValueFactory(new PropertyValueFactory<Proyecto, String>("tipo"));
        clmAsociado.setCellValueFactory(new PropertyValueFactory<Proyecto, String>("asociado"));
        
 
        
        


        gestionarEventos();
        
   
        
        
        
    }
    
    public void search(KeyEvent event){
        FilteredList<Proyecto> filter = new FilteredList<>(listaProyectos, p -> true);
        txtBuscar.textProperty().addListener((observable, oldValue, newValue) -> {
           filter.setPredicate((Predicate<? super Proyecto>) (Proyecto proyecto) -> {
           
           if(newValue.isEmpty() || newValue == null){
               return true;
           }
           else if(proyecto.getCodigo().contains(newValue)){
               return true;
           }
           
           else if(proyecto.getNombre().contains(newValue)){
               return true;
           }
           
            else if(proyecto.getAsociado().contains(newValue)){
               return true;
           }
        
            
     
           return false;
           });
        });  
      
        
        SortedList sort = new SortedList(filter);
        sort.comparatorProperty().bind(tblProyectos.comparatorProperty());
        tblProyectos.setItems(sort);
    }
    
    
    public void gestionarEventos(){
        tblProyectos.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<Proyecto>(){
            @Override
            public void changed(ObservableValue<? extends Proyecto> arg0,
                    Proyecto volverAnterios, Proyecto valorSeleccionado) {
                
            
       
                    
                  

                  
            }
                    
                }
        );
        
    }
    
      public void modificar(ActionEvent event) throws IOException, Exception{
               if(tblProyectos.getSelectionModel().getSelectedItem() == null){
                   modificarPane.setVisible(true);
               }else{
                     
         FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/ModificarProyecto.fxml"));
        
          Parent tableViewParent = (Parent) loader.load();
           Scene tableViewScene = new Scene(tableViewParent);
          
          
          Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
          
          window.setScene(tableViewScene);
          window.show();
          ControllerModificarProyecto controllerModificar = loader.getController();
         controllerModificar.modificarDatos(tblProyectos.getSelectionModel().getSelectedItem());  
               }
        
          
         
          
        
        
       
    }
 
      public void eliminar(ActionEvent event) throws IOException, Exception{
         if (tblProyectos.getSelectionModel().getSelectedItem() == null) {
            entendidoEliminar.setVisible(true);
          
           
                  
        }else{
             
                   if (event.getSource() == btnEliminar){
          eliminarPane.setVisible(true);
      }
        
            if(event.getSource() == btnSiEliminar ){
                controller.eliminarBitacora(tblProyectos.getSelectionModel().getSelectedItem());
                controller.eliminarTecnologiaProyecto(tblProyectos.getSelectionModel().getSelectedItem());
              controller.eliminarProyecto(tblProyectos.getSelectionModel().getSelectedItem());
                listaProyectos.remove(tblProyectos.getSelectionModel().getSelectedIndex());
                eliminarPane.setVisible(false);
            }
            
            if(event.getSource() == btnNoEliminar){
                eliminarPane.setVisible(false);
            }
       
             
         }

    }
    
    
      public void bitacora(ActionEvent event) throws IOException, Exception{
               if(tblProyectos.getSelectionModel().getSelectedItem() == null){
                   entendidoPaneBiTe.setVisible(true);
               }else{
                  if(event.getSource() == btnBitacora ){   
         FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/VerBitácora.fxml"));
        
          Parent tableViewParent = (Parent) loader.load();
           Scene tableViewScene = new Scene(tableViewParent);
          
          
          Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
          
          window.setScene(tableViewScene);
          window.show();
          ControllerListarActividades controllerModificar = loader.getController();
         
         controllerModificar.visualizarBitacora(tblProyectos.getSelectionModel().getSelectedItem());  
               }
        
          
               }
          
        
        
       
    }
    
    
    
    
    public void volver(ActionEvent event) throws IOException{
        if(event.getSource() == btnVolver || event.getSource() == ImgVolver){
             Parent blah = FXMLLoader.load(getClass().getResource("../fxml/Proyectos.fxml"));
            Scene scene = new Scene(blah);
            Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            appStage.setScene(scene);
            appStage.show();
        }
    }
    
        public void registrar(ActionEvent event) throws IOException, Exception{
        if(event.getSource() == btnRegistrar){
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/RegistrarProyecto.fxml"));
             Parent tableViewParent = (Parent) loader.load();
          Scene tableViewScene = new Scene(tableViewParent);
           Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
           
             window.setScene(tableViewScene);
          window.show();
          ControllerProyecto controllerProyecto = loader.getController();
         
         controllerProyecto.verUsuario(contrasennaEncriptada1);
        }
    }
    
    
    public void entendido(ActionEvent event){
         if(event.getSource() == btnEntendido || event.getSource() == btnEntendidoEliminar || event.getSource() == btnEntendidoBiTe  ){
             modificarPane.setVisible(false);
                entendidoEliminar.setVisible(false);
            entendidoPaneBiTe.setVisible(false);
         }
    }
            
    
       public Usuario verUsuario(String usuarioBuscar) throws Exception {

        miusuario = controller.buscarUsuarioLogeado(usuarioBuscar);
        return miusuario;

    }
    
    
    
}
