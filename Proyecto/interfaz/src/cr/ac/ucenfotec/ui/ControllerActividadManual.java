/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.ucenfotec.ui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTimePicker;
import cr.ac.ucenfotec.bl.Proyecto;
import cr.ac.ucenfotec.tl.Gestor;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author Dell
 */
public class ControllerActividadManual {
    
       @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtCodigo;
    
    
       @FXML
    private TextArea txtDescripcion;
    
       @FXML
    private Label NombreLabel;

    @FXML
    private Label CodigoLabel;

    @FXML
    private Label DescripcionLabel;


        @FXML
    private JFXButton btnRegistrarActividad;
        
         @FXML
    private JFXButton btnVolver;
   
    private String nombreBitacora;  
 
        static Gestor controller = new Gestor();
        
    private Proyecto miproyectoActividad;
        @FXML
    private JFXDatePicker fechaInicio;

    @FXML
    private JFXTimePicker horaInicio;

    @FXML
    private JFXTimePicker horaFin;

    @FXML
    private JFXDatePicker fechaFin;  
        
     public String bitacoraActividad(String nombre, Proyecto miproyecto){
         miproyectoActividad = miproyecto;
         nombreBitacora = nombre;
         
         return nombreBitacora;
     }   
        
     
     
    @FXML
    public boolean validation() throws Exception {
          boolean berror = true;
          LocalDate fechaHoy = LocalDate.now();
          LocalDate fechaIniciada = fechaInicio.getValue();
          LocalDate fechaTerminada = fechaFin.getValue();
          LocalTime horahoy = LocalTime.now();
          LocalTime horainiciada = horaInicio.getValue();
          LocalTime horaTerminada = horaFin.getValue();
        boolean primerNombreVacio = Validation.textFieldNotEmpty(txtNombre, NombreLabel, "El nombre es requerido");

        if (primerNombreVacio == false) {
            berror = false;
        }
        
        
        
        boolean primerNombreVacio1 = Validation.textAreadNotEmpty(txtDescripcion, DescripcionLabel, "La descripción es requerida");

        if (primerNombreVacio1 == false) {
            berror = false;
        }
        
        
               
            boolean codigoVacio = Validation.textFieldNotEmpty(txtCodigo, CodigoLabel, "El codigo es requerido");
        if (codigoVacio == false) {
            berror = false;
        }   
             if (codigoVacio == true) {
          
                boolean telefonoExiste = controller.buscarActividad(txtCodigo.getText());
                if (telefonoExiste == true) {
                    CodigoLabel.setText("El codigo ingresado ya existe");
                    Validation.textFieldStringRed(txtCodigo);
                    berror = false;
                }else{
                    Validation.textFieldStringNoRed(txtCodigo);
                }

            
     
            

        }
             
             
             if(fechaIniciada == null || fechaIniciada.isAfter(fechaHoy)){
                 fechaInicio.getStyleClass().add("error2");
                 berror = false;
            
             }else{
                    if(fechaIniciada.isAfter(fechaTerminada)){
                        fechaInicio.getStyleClass().add("error2");
                        berror = false;
                    }else{
                          fechaInicio.getStyleClass().remove("error2");
                    }
                 
            
             }
             
             
               if(fechaTerminada == null || fechaTerminada.isAfter(fechaHoy)){
                 fechaFin.getStyleClass().add("error2");
                 berror = false;
              
             }else{
                   if(fechaTerminada.isBefore(fechaIniciada)){
                     fechaFin.getStyleClass().add("error2");
                     berror = false;
                   }else{
                        fechaFin.getStyleClass().remove("error2");
                   }
                
                 
            }
               
               if(horainiciada == null){
                   horaInicio.getStyleClass().add("error2");
                   berror = false;
               }else{
                      horaInicio.getStyleClass().remove("error2");
                   }
               
               
               
               if(horaTerminada == null){
                   horaFin.getStyleClass().add("error2");
                   berror = false;
               }else{
                
                      horaFin.getStyleClass().remove("error2");
                   
               }
               
               
               
               
        
       
        
        return berror;
    }
           public void registrarActividad(ActionEvent event) throws IOException, Exception {
     boolean berror;   
         berror = validation();
            
        Stage stage = null;
        Parent root;
        
     
        if (berror == true && event.getSource() == btnRegistrarActividad) {
                 LocalDate fechaIniciada = fechaInicio.getValue();
          LocalDate fechaTerminada = fechaFin.getValue();
 LocalTime horainiciada = horaInicio.getValue();
          LocalTime horaTerminada = horaFin.getValue();
          
      controller.registrarActividadManual(txtNombre.getText(), txtCodigo.getText(), txtDescripcion.getText(), nombreBitacora, fechaIniciada, horainiciada, fechaTerminada, horaTerminada);
     
                    
         FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/VerBitácora.fxml"));
        
          Parent tableViewParent = (Parent) loader.load();
           Scene tableViewScene = new Scene(tableViewParent);
          
          
          Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
          
          window.setScene(tableViewScene);
          window.show();
          ControllerListarActividades controllerModificar = loader.getController();
         
         controllerModificar.visualizarBitacora(miproyectoActividad);  
        }
        
        
        
    }
           
           
             public void volver(ActionEvent event) throws IOException, Exception{
        if(event.getSource() == btnVolver){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/VerBitácora.fxml"));
        
          Parent tableViewParent = (Parent) loader.load();
           Scene tableViewScene = new Scene(tableViewParent);
          
          
          Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
          
          window.setScene(tableViewScene);
          window.show();
          ControllerListarActividades controllerModificar = loader.getController();
         
         controllerModificar.visualizarBitacora(miproyectoActividad);  
        }
    }
    
    
}
