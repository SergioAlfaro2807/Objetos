/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.ucenfotec.ui;

import com.jfoenix.controls.JFXButton;
import cr.ac.ucenfotec.bl.ClienteJuridico;
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
public class ControllerContacto {
    

    
    @FXML
    private TextField txtPrimerNombreContacto;

    @FXML
    private TextField txtPrimerApellidoContacto;

    @FXML
    private TextField txtSegundoApellidoContacto;

    @FXML
    private TextField txtCorreoContacto;

    @FXML
    private TextField txtCedulaContacto;

    @FXML
    private TextField txtTelefonoContacto;

    @FXML
    private Label PrimerNombreContactoLabel;

    @FXML
    private Label PrimerApellidoContactoLabel;

    @FXML
    private Label SegundoApellidoContactoLabel;

    @FXML
    private Label correoContactoLabel;

    @FXML
    private Label CedulaContactoLabel;

    @FXML
    private Label TelefonoContactoLabel;

    @FXML
    private Label PrimerNombreContactoLabel1;

    @FXML
    private Label PrimerApellidoContactoLabel1;

    @FXML
    private Label SegundoApellidoContactoLabel1;

    @FXML
    private Label correoContactoLabel1;

    @FXML
    private Label CedulaContactoLabel1;



       @FXML
    private JFXButton btnRegistrarContacto;

       private ClienteJuridico miclienteJuridico;

    @FXML
    private JFXButton btnVolver;
    
    public ControllerContacto(){
        
    }
    
    public ClienteJuridico modificarDatos (ClienteJuridico miclienteJuridicoModificar){
        miclienteJuridico = miclienteJuridicoModificar;
        
        
        return miclienteJuridico;
    }
    
    
        public void registrarClienteJuridico(ActionEvent event) throws IOException, Exception {
     boolean berror;   
         berror = validation2();
            
        Stage stage = null;
        Parent root;
        
     
        if (berror == true && event.getSource() == btnRegistrarContacto) {

      controller.registrarClienteJuridico(miclienteJuridico.getCedula(), txtCedulaContacto.getText(), miclienteJuridico.getPrimerNombre(), miclienteJuridico.getProvincia() , miclienteJuridico.getCanton(), miclienteJuridico.getDistrito(),miclienteJuridico.getDireccion() , miclienteJuridico.getTelefono());
      controller.registrarContacto(txtPrimerNombreContacto.getText(), txtPrimerApellidoContacto.getText(), txtSegundoApellidoContacto.getText(), txtCedulaContacto.getText(), txtTelefonoContacto.getText(), txtCorreoContacto.getText());
            Parent blah = FXMLLoader.load(getClass().getResource("../fxml/Clientes.fxml"));
            Scene scene = new Scene(blah);
            Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            appStage.setScene(scene);
            appStage.show();
        }
        
        
        
    }
        
           public boolean validation2() throws Exception {
          boolean berror = true;

        boolean primerNombreVacio = Validation.textFieldNotEmpty(txtPrimerNombreContacto, PrimerNombreContactoLabel, "El nombre es requerido");

        if (primerNombreVacio == false) {
            berror = false;
        }
        boolean primerNombreString = Validation.textFieldString(txtPrimerNombreContacto, PrimerNombreContactoLabel1, "Por favor ingrese letras");
        if (primerNombreString == false) {
            berror = false;
        }
        
           boolean primerApellidoVacio = Validation.textFieldNotEmpty(txtPrimerApellidoContacto, PrimerApellidoContactoLabel, "El nombre es requerido");

        if (primerApellidoVacio == false) {
            berror = false;
        }
        boolean primerApellidoString = Validation.textFieldString(txtPrimerApellidoContacto, PrimerApellidoContactoLabel1, "Por favor ingrese letras");
        if (primerApellidoString == false) {
            berror = false;
        }
        
           boolean segundoApellidoVacio = Validation.textFieldNotEmpty(txtSegundoApellidoContacto, SegundoApellidoContactoLabel, "El nombre es requerido");

        if (segundoApellidoVacio == false) {
            berror = false;
        }
        boolean segundoApellidoString = Validation.textFieldString(txtSegundoApellidoContacto, SegundoApellidoContactoLabel1, "Por favor ingrese letras");
        if (segundoApellidoString == false) {
            berror = false;
        }
        boolean identificacionVacio = Validation.textFieldNotEmpty(txtCedulaContacto, CedulaContactoLabel, "La identificacion es requerida");
        if (identificacionVacio == false) {
            berror = false;
        }
        if(identificacionVacio == true){
                 boolean identificacionValidar = Validation.textFieldCedulaJuridica(txtCedulaContacto, CedulaContactoLabel1, "Por favor ingrese una cédula valida");
        if (identificacionValidar == false) {
            berror = false;
        }
        
         if(identificacionValidar == true){
            boolean identificacionExiste = controller.buscarContactoIdentificacion(txtCedulaContacto.getText());
             if (identificacionExiste == true) {
                    CedulaContactoLabel1.setText("La cédula ingresada ya existe");
                    Validation.textFieldStringRed(txtCedulaContacto);
                    berror = false;
                }else{
                    Validation.textFieldStringNoRed(txtCedulaContacto);
                }
        }
         
         
        }
        
       
        boolean correoVacio = Validation.textFieldNotEmpty(txtCorreoContacto, correoContactoLabel, "El correo electronico es requerido");
        if (correoVacio == false) {
            berror = false;
        }

        if (correoVacio == true) {
            boolean correoTipo = Validation.isValidEmailAddress(txtCorreoContacto, correoContactoLabel1, "Por favor ingrese un correo valido");
            if (correoTipo == false) {
                berror = false;
            }

            if (correoTipo == true) {
                boolean correoExiste = controller.buscarContactoCorreo(txtCorreoContacto.getText());
                if (correoExiste == true) {
                    correoContactoLabel1.setText("El correo ingresado ya existe");
                    Validation.textFieldStringRed(txtCorreoContacto);
                    berror = false;
                }else{
                    Validation.textFieldStringNoRed(txtCorreoContacto);
                }

            }
     
            

        }
        
        
        
        
        
              boolean telefonoVacio = Validation.textFieldNotEmpty(txtTelefonoContacto, TelefonoContactoLabel, "El teléfono es requerido");
        if (telefonoVacio == false) {
            berror = false;
        }
        
              if (telefonoVacio == true) {
            
           

       
                boolean telefonoExiste = controller.buscarContactoTelefono(txtTelefonoContacto.getText());
                if (telefonoExiste == true) {
                    TelefonoContactoLabel.setText("El teléfono ingresado ya existe");
                    Validation.textFieldStringRed(txtTelefonoContacto);
                    berror = false;
                }else{
                    Validation.textFieldStringNoRed(txtTelefonoContacto);
                }

            
     
            

        }
               
       

        return berror;
    }
        public void volver(ActionEvent event) throws IOException, Exception {
    
            
        Stage stage = null;
        Parent root;
        
     
        
        
        if (event.getSource() == btnVolver) {
     
            
         
            Parent blah = FXMLLoader.load(getClass().getResource("../fxml/Clientes.fxml"));
            Scene scene = new Scene(blah);
            Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            appStage.setScene(scene);
            appStage.show();
        }
        
        
        
    }
}
