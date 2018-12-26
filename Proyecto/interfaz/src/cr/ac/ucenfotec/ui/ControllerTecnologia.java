/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.ucenfotec.ui;

import com.jfoenix.controls.JFXButton;
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author Dell
 */
public class ControllerTecnologia {
    
       @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtCodigo;
    
    
       @FXML
    private Label NombreLabel;

    @FXML
    private Label CodigoLabel;

    @FXML
    private Label NombreLabel1;

    @FXML
    private Label CodigoLabel1;
    
        @FXML
    private JFXButton btnRegistrarTecnologia;
        
         @FXML
    private JFXButton btnVolver;
   
        
 
        static Gestor controller = new Gestor();
    @FXML
    public boolean validation() throws Exception {
          boolean berror = true;

        boolean primerNombreVacio = Validation.textFieldNotEmpty(txtNombre, NombreLabel, "El nombre es requerido");

        if (primerNombreVacio == false) {
            berror = false;
        }
        
        
               
            boolean codigoVacio = Validation.textFieldNotEmpty(txtCodigo, CodigoLabel, "El codigo es requerido");
        if (codigoVacio == false) {
            berror = false;
        }   
             if (codigoVacio == true) {
          
                boolean telefonoExiste = controller.buscarTecnologia(txtCodigo.getText());
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
           public void registrarTecnologia(ActionEvent event) throws IOException, Exception {
     boolean berror;   
         berror = validation();
            
        Stage stage = null;
        Parent root;
        
     
        if (berror == true && event.getSource() == btnRegistrarTecnologia) {

      controller.registrarTecnologia(txtNombre.getText(), txtCodigo.getText());
     
            Parent blah = FXMLLoader.load(getClass().getResource("../fxml/Tecnologias.fxml"));
            Scene scene = new Scene(blah);
            Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            appStage.setScene(scene);
            appStage.show();
        }
        
        
        
    }
           
           
             public void volver(ActionEvent event) throws IOException{
        if(event.getSource() == btnVolver){
             Parent blah = FXMLLoader.load(getClass().getResource("../fxml/Tecnologias.fxml"));
            Scene scene = new Scene(blah);
            Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            appStage.setScene(scene);
            appStage.show();
        }
    }
    
    
}
