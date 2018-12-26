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
import static cr.ac.ucenfotec.ui.ControllerClienteJuridico.controller;
import static cr.ac.ucenfotec.ui.ControllerModificarClienteJuridico.controller;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
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
public class ControllerModificarContacto {
    
        @FXML
    private TextField txtPrimerNombre;

    @FXML
    private TextField txtIdentificacion;

    @FXML
    private TextField txtTelefono;

    @FXML
    private TextField txtProvincia;

    @FXML
    private TextField txtCanton;

    @FXML
    private TextField txtDistrito;

    @FXML
    private Label NombreLabel;

    @FXML
    private Label identificacionLabel;

    @FXML
    private Label telefonoLabel;

    @FXML
    private Label provinciaLabel;

    @FXML
    private Label CantonLabel;

    @FXML
    private Label DistritoLabel;

    @FXML
    private Label DireccionLabel;

    @FXML
    private Label PrimerNombreLabel1;

    @FXML
    private Label SegundoApellidoLabel1;

    @FXML
    private TextArea txtDireccion;

    @FXML
    private Label identificacionLabel1;
    
    
    @FXML
    private TextField txtModificarPrimerNombreContacto;

    @FXML
    private TextField txtModificarPrimerApellidoContacto;

    @FXML
    private TextField txtModificarSegundoApellidoContacto;

    @FXML
    private TextField txtModificarCorreoContacto;

    @FXML
    private TextField txtModificarCedulaContacto;

    @FXML
    private TextField txtModificarTelefonoContacto;

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
    private Label TelefonoContactoLabel1;
    

    @FXML
    private JFXButton registrarClienteJuridicoSiguiente;
    
       @FXML
    private JFXButton btnModificarContacto;

             @FXML
    private JFXButton   btnVolver; 
     
       private ClienteJuridico miclienteJuridicoOriginal;
       
             private ClienteJuridico miclienteJuridicoModificar;
       
       private Contacto micontacto;
       
       static Gestor controller = new Gestor();
       
    public ControllerModificarContacto(){
        
    }
    
    
    public void initialize(URL location, ResourceBundle resources) {

    }
        public Contacto modificarDatos(Contacto micontactoModificar, ClienteJuridico miclienteJuridicoO, String nombre, String identificacion, String telefono, String canton, String distrito, String direccion, String provincia) {

        micontacto = micontactoModificar;
        miclienteJuridicoOriginal = miclienteJuridicoO;
        miclienteJuridicoModificar = new ClienteJuridico(identificacion, telefono, nombre, provincia, canton, distrito, direccion);
        txtModificarPrimerNombreContacto.setText(micontactoModificar.getNombre());
        txtModificarPrimerApellidoContacto.setText(micontactoModificar.getPrimerApellido());
        txtModificarSegundoApellidoContacto.setText(micontactoModificar.getSegundoApellido());
        txtModificarCorreoContacto.setText(micontactoModificar.getCorreo());
        txtModificarCedulaContacto.setText(micontactoModificar.getCedula());
        txtModificarTelefonoContacto.setText(micontactoModificar.getTelefono());

        return micontacto;

    }
    

        public boolean validation2() throws Exception {
          boolean berror = true;

        boolean primerNombreVacio = Validation.textFieldNotEmpty(txtModificarPrimerNombreContacto, PrimerNombreContactoLabel, "El nombre es requerido");

        if (primerNombreVacio == false) {
            berror = false;
        }
        boolean primerNombreString = Validation.textFieldString(txtModificarPrimerNombreContacto, PrimerNombreContactoLabel1, "Por favor ingrese letras");
        if (primerNombreString == false) {
            berror = false;
        }
        
           boolean primerApellidoVacio = Validation.textFieldNotEmpty(txtModificarPrimerApellidoContacto, PrimerApellidoContactoLabel, "El nombre es requerido");

        if (primerApellidoVacio == false) {
            berror = false;
        }
        boolean primerApellidoString = Validation.textFieldString(txtModificarPrimerApellidoContacto, PrimerApellidoContactoLabel1, "Por favor ingrese letras");
        if (primerApellidoString == false) {
            berror = false;
        }
        
           boolean segundoApellidoVacio = Validation.textFieldNotEmpty(txtModificarSegundoApellidoContacto, SegundoApellidoContactoLabel, "El nombre es requerido");

        if (segundoApellidoVacio == false) {
            berror = false;
        }
        boolean segundoApellidoString = Validation.textFieldString(txtModificarSegundoApellidoContacto, SegundoApellidoContactoLabel1, "Por favor ingrese letras");
        if (segundoApellidoString == false) {
            berror = false;
        }
        boolean identificacionVacio = Validation.textFieldNotEmpty(txtModificarCedulaContacto, CedulaContactoLabel, "La identificacion es requerida");
        if (identificacionVacio == false) {
            berror = false;
        }
        if(identificacionVacio == true){
                 boolean identificacionValidar = Validation.textFieldCedulaJuridica(txtModificarCedulaContacto, CedulaContactoLabel1, "Por favor ingrese una cédula valida");
        if (identificacionValidar == false) {
            berror = false;
        }
        
         if(identificacionValidar == true){
            boolean identificacionExiste = controller.buscarContactoIdentificacion(txtModificarCedulaContacto.getText());
               if(micontacto.getCedula().equals(txtModificarCedulaContacto.getText())){
                identificacionExiste = false;
            }
            
             if (identificacionExiste == true) {
                    CedulaContactoLabel1.setText("La cédula ingresada ya existe");
                    Validation.textFieldStringRed(txtModificarCedulaContacto);
                    berror = false;
                }else{
                    Validation.textFieldStringNoRed(txtModificarCedulaContacto);
                }
        }
         
         
        }
        
       
        boolean correoVacio = Validation.textFieldNotEmpty(txtModificarCorreoContacto, correoContactoLabel, "El correo electronico es requerido");
        if (correoVacio == false) {
            berror = false;
        }

        if (correoVacio == true) {
            boolean correoTipo = Validation.isValidEmailAddress(txtModificarCorreoContacto, correoContactoLabel1, "Por favor ingrese un correo valido");
            if (correoTipo == false) {
                berror = false;
            }

            if (correoTipo == true) {
                boolean correoExiste = controller.buscarContactoCorreo(txtModificarCorreoContacto.getText());
                  if(micontacto.getCorreo().equals(txtModificarCorreoContacto.getText())){
                correoExiste = false;
            }
            
                if (correoExiste == true) {
                    correoContactoLabel1.setText("El correo ingresado ya existe");
                    Validation.textFieldStringRed(txtModificarCorreoContacto);
                    berror = false;
                }else{
                    Validation.textFieldStringNoRed(txtModificarCorreoContacto);
                }

            }
     
            

        }
        
        
        
        
        
              boolean telefonoVacio = Validation.textFieldNotEmpty(txtModificarTelefonoContacto, TelefonoContactoLabel, "El teléfono es requerido");
        if (telefonoVacio == false) {
            berror = false;
        }
        
              if (telefonoVacio == true) {
            
           

       
                boolean telefonoExiste = controller.buscarContactoTelefono(txtModificarTelefonoContacto.getText());
                   if(micontacto.getTelefono().equals(txtModificarTelefonoContacto.getText())){
                telefonoExiste = false;
            }
                if (telefonoExiste == true) {
                    TelefonoContactoLabel.setText("El teléfono ingresado ya existe");
                    Validation.textFieldStringRed(txtModificarTelefonoContacto);
                    berror = false;
                }else{
                    Validation.textFieldStringNoRed(txtModificarTelefonoContacto);
                }

            
     
            

        }
               
       

        return berror;
    }
    
    
    
    public void modificarClienteJuridico(ActionEvent event) throws IOException, Exception{
             boolean berror;   
         berror = validation2();
            
        Stage stage = null;
        Parent root;
        
     
        
        
        if (berror == true && event.getSource() == btnModificarContacto) {
     controller.modificarClienteJuridico(miclienteJuridicoModificar.getCedula(), txtModificarCedulaContacto.getText(), miclienteJuridicoModificar.getPrimerNombre(), miclienteJuridicoModificar.getProvincia() , miclienteJuridicoModificar.getCanton(), miclienteJuridicoModificar.getDistrito(),miclienteJuridicoModificar.getDireccion() , miclienteJuridicoModificar.getTelefono(), miclienteJuridicoOriginal.getCedula());
      controller.modificarContacto(txtModificarPrimerNombreContacto.getText(), txtModificarPrimerApellidoContacto.getText(), txtModificarSegundoApellidoContacto.getText(), txtModificarCedulaContacto.getText(), txtModificarTelefonoContacto.getText(), txtModificarCorreoContacto.getText(), micontacto.getCedula());
            
     //       controller.modificarClienteFisico(nuevoCliente,miclienteFisico.getCorreo());
            Parent blah = FXMLLoader.load(getClass().getResource("../fxml/ListaClienteJuridico.fxml"));
            Scene scene = new Scene(blah);
            Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            appStage.setScene(scene);
            appStage.show();
        }
        
        
        
    }
    
      
    public void volver(ActionEvent event) throws IOException{
        if(event.getSource() == btnVolver){
             Parent blah = FXMLLoader.load(getClass().getResource("../fxml/ListaClienteJuridico.fxml"));
            Scene scene = new Scene(blah);
            Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            appStage.setScene(scene);
            appStage.show();
        }
    }
}
