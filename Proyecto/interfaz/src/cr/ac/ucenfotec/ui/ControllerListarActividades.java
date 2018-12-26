/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.ucenfotec.ui;

import com.jfoenix.controls.JFXButton;
import cr.ac.ucenfotec.bl.Actividad;
import cr.ac.ucenfotec.bl.ClienteFisico;
import cr.ac.ucenfotec.bl.ClienteJuridico;
import cr.ac.ucenfotec.bl.Contacto;
import cr.ac.ucenfotec.bl.Proyecto;
import cr.ac.ucenfotec.bl.Tecnologia;
import cr.ac.ucenfotec.bl.Usuario;
import cr.ac.ucenfotec.tl.Gestor;
import java.io.IOException;
import java.net.URL;
import static java.nio.file.Files.list;
import static java.rmi.Naming.list;
import java.time.LocalDate;
import java.time.LocalTime;
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
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
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
public class ControllerListarActividades implements Initializable {
    @FXML private TableColumn<Actividad, String> clmNombre;
     @FXML private TableColumn<Actividad, String> clmCodigo;
    @FXML private TableColumn<Actividad, String> clmFechaInicio;
      @FXML private TableColumn<Actividad, String> clmHoraInicio;
    @FXML private TableColumn<Actividad, String> clmFechaFin;
      @FXML private TableColumn<Actividad, String> clmHoraFin;
   
    @FXML private ObservableList<Actividad> listaActividades;
    @FXML private TableView<Actividad> tblActividades;
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
         
    @FXML
    private JFXButton btnRegistroManual;
       @FXML
    private JFXButton btnIniciar;
    
    
    
    @FXML
    private Proyecto miproyecto;
    
        @FXML
    private Label labelNombreBitacora;

        private Usuario miusuario;
    
    static Gestor controller = new Gestor();
             
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        listaActividades = FXCollections.observableArrayList();
    
     
    }
    
    public void visualizarBitacora(Proyecto miproyectoBitacora) throws Exception{
        miproyecto = miproyectoBitacora;
        String bitacoraNombre = "Bitacora " + miproyectoBitacora.getNombre();
        labelNombreBitacora.setText(bitacoraNombre);
        labelNombreBitacora.setMaxWidth(Double.MAX_VALUE);
        labelNombreBitacora.setAlignment(Pos.CENTER);
          listaActividades = controller.llenarActividades(listaActividades,bitacoraNombre);
      
        tblActividades.setItems(listaActividades);
        
             clmNombre.setCellValueFactory(new PropertyValueFactory<Actividad, String>("nombre"));
             clmCodigo.setCellValueFactory(new PropertyValueFactory<Actividad, String>("codigo"));
        clmFechaInicio.setCellValueFactory(new PropertyValueFactory<Actividad, String>("fechaInicio"));
          
             clmHoraInicio.setCellValueFactory(new PropertyValueFactory<Actividad, String>("horaInicio"));
        clmFechaFin.setCellValueFactory(new PropertyValueFactory<Actividad, String>("fechaFin"));
          
             clmHoraFin.setCellValueFactory(new PropertyValueFactory<Actividad, String>("horaFin"));
    
    }
    
    
    
    public void search(KeyEvent event){
        FilteredList<Actividad> filter = new FilteredList<>(listaActividades, p -> true);
        txtBuscar.textProperty().addListener((observable, oldValue, newValue) -> {
           filter.setPredicate((Predicate<? super Actividad>) (Actividad miactividad) -> {
           
           if(newValue.isEmpty() || newValue == null){
               return true;
           }
           else if(miactividad.getCodigo().contains(newValue)){
               return true;
           }
           
           else if(miactividad.getNombre().contains(newValue)){
               return true;
           }
         
              
           return false;
           });
        });  
      
        
        SortedList sort = new SortedList(filter);
        sort.comparatorProperty().bind(tblActividades.comparatorProperty());
        tblActividades.setItems(sort);
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
  
          
        
        

    
    public void volver(ActionEvent event) throws IOException{
        if(event.getSource() == btnVolver || event.getSource() == ImgVolver){
             Parent blah = FXMLLoader.load(getClass().getResource("../fxml/ListarProyectos.fxml"));
            Scene scene = new Scene(blah);
            Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            appStage.setScene(scene);
            appStage.show();
        }
    }
    
        public void registrar(ActionEvent event) throws IOException{
        if(event.getSource() == btnRegistrar){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/RegistrarActividad.fxml"));
       
          Parent tableViewParent = (Parent) loader.load();
          Scene tableViewScene = new Scene(tableViewParent);
         
         
         Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
          
         window.setScene(tableViewScene);
          window.show();
          ControllerActividad controllerModificar = loader.getController();
        controllerModificar.bitacoraActividad(labelNombreBitacora.getText(), miproyecto); 
        }
    }
        
       public void registrarActividadManual(ActionEvent event) throws IOException{
        if(event.getSource() == btnRegistroManual){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/RegistrarActividadManual.fxml"));
       
          Parent tableViewParent = (Parent) loader.load();
          Scene tableViewScene = new Scene(tableViewParent);
         
         
         Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
          
         window.setScene(tableViewScene);
          window.show();
          ControllerActividadManual controllerModificar = loader.getController();
        controllerModificar.bitacoraActividad(labelNombreBitacora.getText(), miproyecto); 
        }
    }  
        
        
        public void iniciarActividad(ActionEvent event) throws IOException, Exception{
               if(tblActividades.getSelectionModel().getSelectedItem() == null){
                   entendidoEliminar.setVisible(true);
               }else{
                     
               
                   
                LocalDate fechaAhora = LocalDate.now();
                LocalTime horaAhora = LocalTime.now();
                String fecha = fechaAhora.toString();
                   controller.iniciarActividad(tblActividades.getSelectionModel().getSelectedItem());
                 listaActividades.clear();
                 listaActividades = controller.llenarActividades(listaActividades,labelNombreBitacora.getText());
               }
    
        }
        
                public void terminarActividad(ActionEvent event) throws IOException, Exception{
               if(tblActividades.getSelectionModel().getSelectedItem() == null){
                   entendidoEliminar.setVisible(true);
               }else{
                     
               
               
                   controller.terminarActividad(tblActividades.getSelectionModel().getSelectedItem());
                 listaActividades.clear();
                 listaActividades = controller.llenarActividades(listaActividades,labelNombreBitacora.getText());
               }
    
        }
        
        
        
        
        
    public void entendido(ActionEvent event){
         if(event.getSource() == btnEntendido || event.getSource() == btnEntendidoEliminar ){
             modificarPane.setVisible(false);
                entendidoEliminar.setVisible(false);
            
         }
    }
      
}
