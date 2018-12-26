/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.ucenfotec.ui;

import com.jfoenix.controls.JFXButton;
import cr.ac.ucenfotec.tl.Gestor;
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
public class ControllerRecuperarContrasenna {
    
       @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtCorreo;
    
       @FXML
    private Label correoElectronicoLabel;

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

       boolean correoVacio = Validation.textFieldNotEmpty(txtCorreo, correoElectronicoLabel, "El correo electronico es requerido");
        if (correoVacio == false) {
            berror = false;
        }

        if (correoVacio == true) {
            boolean correoTipo = Validation.isValidEmailAddress(txtCorreo, correoElectronicoLabel, "Por favor ingrese un correo valido");
            if (correoTipo == false) {
                berror = false;
            }

       

        }
        
       
        
        return berror;
    }
           public void enviarCorreo(ActionEvent event) throws IOException, Exception {
     boolean berror;   
         berror = validation();
            
        Stage stage = null;
        Parent root;
        
     
        if (berror == true && event.getSource() == btnRegistrarTecnologia) {

      controller.recuperarContrasenna(txtCorreo.getText());
     
            Parent blah = FXMLLoader.load(getClass().getResource("../fxml/InicioSesion.fxml"));
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
