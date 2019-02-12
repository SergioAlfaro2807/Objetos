/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.ucenfotec.ui;

import com.jfoenix.controls.JFXButton;
import cr.ac.ucenfotec.bl.Usuario;
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
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author Dell
 */
public class ControllerModificarContrasenna {
    
       @FXML
    private TextField txtContrasennaNueva;

    @FXML
    private TextField txtConstrasennaVieja;
    
    
    @FXML
    private PasswordField passVieja;

    @FXML
    private PasswordField passNueva;
    
       @FXML
    private Label labelContrasennaVieja;

    @FXML
    private Label CodigoLabel1;

    @FXML
    private Label NombreLabel1;

    @FXML
    private Label labelContrasennaNueva;
    
        @FXML
    private JFXButton btnRegistrarTecnologia;
        
         @FXML
    private JFXButton btnVolver;
   
    private String micontrasennaVieja;
 
        @FXML
    private RadioButton rbContrasennaVieja;

    @FXML
    private RadioButton rbContrasennaNueva;
    
    
        static Gestor controller = new Gestor();
        
        
        
           public String modificarDatos(String contrasennaVieja) {

        micontrasennaVieja = contrasennaVieja;
     

        return micontrasennaVieja;

    }
        
        
        
        
        
        
        
    @FXML
    public boolean validation() throws Exception {
          boolean berror = true;

        boolean primerNombreVacio = Validation.textFieldNotEmpty(passVieja, labelContrasennaVieja, "Por favor escriba su contraseña antigua");

        if (primerNombreVacio == false) {
            berror = false;
        }
        
        
               
            boolean codigoVacio = Validation.textFieldNotEmpty(passNueva, labelContrasennaNueva, "Por favor escriba su nueva contraseña");
        if (codigoVacio == false) {
            berror = false;
        }   
        
        
          String contrasennaEncriptada = DigestUtils.md5Hex(passVieja.getText());
          
          if(contrasennaEncriptada.equals(micontrasennaVieja)){
               passVieja.getStyleClass().remove("error2");
          }else{
              passVieja.getStyleClass().add("error2");
              labelContrasennaVieja.setText("Por favor digite su contraseña anterior");
              berror = false;
          }
            
        
       
        
        return berror;
    }
    
      public void mousePressed1(ActionEvent event) {
        if (rbContrasennaVieja.isSelected()) {

            txtConstrasennaVieja.setVisible(true);
            txtConstrasennaVieja.setText(passVieja.getText());
             passVieja.setVisible(false);
        } else {
            txtConstrasennaVieja.setVisible(false);
             passVieja.setVisible(true);
        }

    }

       public void mousePressed2(ActionEvent event) {
        if (rbContrasennaNueva.isSelected()) {

            txtContrasennaNueva.setVisible(true);
            txtContrasennaNueva.setText(passNueva.getText());
            passNueva.setVisible(false);

        } else {
            txtContrasennaNueva.setVisible(false);
              passNueva.setVisible(true);

        }

    }
  

    
    
    
           public void modificarContrasenna(ActionEvent event) throws IOException, Exception {
     boolean berror;   
         berror = validation();
            
        Stage stage = null;
        Parent root;
        
     
        if (berror == true && event.getSource() == btnRegistrarTecnologia) {

       
           String contrasennaVieja = DigestUtils.md5Hex(passVieja.getText());
           String contrasennaNueva = DigestUtils.md5Hex(passNueva.getText());
            
            
     controller.modificarContrasenna(contrasennaVieja, contrasennaNueva);
     
            Parent blah = FXMLLoader.load(getClass().getResource("../fxml/MenuPrincipal.fxml"));
            Scene scene = new Scene(blah);
            Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            appStage.setScene(scene);
            appStage.show();
        }
        
        
        
    }
           
           
             public void volver(ActionEvent event) throws IOException{
        if(event.getSource() == btnVolver){
             Parent blah = FXMLLoader.load(getClass().getResource("../fxml/MenuPrincipal.fxml"));
            Scene scene = new Scene(blah);
            Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            appStage.setScene(scene);
            appStage.show();
        }
    }
    
    
}
