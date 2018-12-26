/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.ucenfotec.ui;

import com.jfoenix.controls.JFXButton;
import cr.ac.ucenfotec.bl.Proyecto;
import cr.ac.ucenfotec.tl.Gestor;
import static cr.ac.ucenfotec.ui.ControllerClienteJuridico.controller;
import java.io.IOException;
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
public class ControllerActividad {
    
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
        
        
     public String bitacoraActividad(String nombre, Proyecto miproyecto){
         miproyectoActividad = miproyecto;
         nombreBitacora = nombre;
         
         return nombreBitacora;
     }   
        
    @FXML
    public boolean validation() throws Exception {
          boolean berror = true;

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
        
       
        
        return berror;
    }
           public void registrarActividad(ActionEvent event) throws IOException, Exception {
     boolean berror;   
         berror = validation();
            
        Stage stage = null;
        Parent root;
        
     
        if (berror == true && event.getSource() == btnRegistrarActividad) {

      controller.registrarActividadSinFecha(txtNombre.getText(), txtCodigo.getText(), txtDescripcion.getText(), nombreBitacora);
     
                    
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
