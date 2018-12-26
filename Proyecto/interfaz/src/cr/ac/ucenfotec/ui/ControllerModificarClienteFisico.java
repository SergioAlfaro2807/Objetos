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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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
public class ControllerModificarClienteFisico implements Initializable {

    @FXML
    private TextField txtModificarPrimerNombre;

    @FXML
    private TextField txtModificarPrimerApellido;

    @FXML
    private TextField txtModificarSegundoApellido;

    @FXML
    private TextField txtModificarCorreo;

    @FXML
    private TextField txtModificarTelefono;

    @FXML
    private TextField txtModificarCanton;

    @FXML
    private TextField txtModificarProvincia;

    @FXML
    private TextField txtModificarDistrito;

    @FXML
    private TextArea txtModificarDireccion;

    @FXML
    private Label PrimerNombreLabel;

    @FXML
    private Label PrimerApellidoLabel;

    @FXML
    private Label SegundoApellidoLabel;

    @FXML
    private Label correoLabel;

    @FXML
    private Label TelefonoLabel;

    @FXML
    private Label ProvinciaLabel;

    @FXML
    private Label CantonLabel;

    @FXML
    private Label DistritoLabel;

    @FXML
    private Label PrimerNombreLabel1;

    @FXML
    private Label PrimerApellidoLabel1;

    @FXML
    private Label SegundoApellidoLabel1;

    @FXML
    private Label correoLabel1;

    @FXML
    private Label DireccionLabel;

    private ClienteFisico miclienteFisico;
    
        @FXML
    private JFXButton btnModificarCliente;
        
            
        @FXML
    private JFXButton btnVolver;
        
         static Gestor controller = new Gestor();

    public ControllerModificarClienteFisico() {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public ClienteFisico modificarDatos(ClienteFisico miclienteFisicoModificar) {

        miclienteFisico = miclienteFisicoModificar;

        txtModificarPrimerNombre.setText(miclienteFisicoModificar.getNombre());
        txtModificarPrimerApellido.setText(miclienteFisicoModificar.getPrimerApellido());
        txtModificarSegundoApellido.setText(miclienteFisicoModificar.getSegundoApellido());
        txtModificarCorreo.setText(miclienteFisicoModificar.getCorreo());
        txtModificarTelefono.setText(miclienteFisicoModificar.getTelefono());
        txtModificarCanton.setText(miclienteFisicoModificar.getCanton());
        txtModificarDistrito.setText(miclienteFisicoModificar.getDistrito());
        txtModificarDireccion.setText(miclienteFisicoModificar.getDireccion());
        txtModificarProvincia.setText(miclienteFisicoModificar.getProvincia());

        return miclienteFisico;

    }

    public boolean validation() throws Exception {

        boolean berror = true;

        boolean primerNombreVacio = Validation.textFieldNotEmpty(txtModificarPrimerNombre, PrimerNombreLabel, "El primer nombre es requerido");

        if (primerNombreVacio == false) {
            berror = false;
        }
        boolean primerNombreString = Validation.textFieldString(txtModificarPrimerNombre, PrimerNombreLabel1, "Por favor ingrese letras");
        if (primerNombreString == false) {
            berror = false;
        }
        boolean primerApellidoVacio = Validation.textFieldNotEmpty(txtModificarPrimerApellido, PrimerApellidoLabel, "El primer apellido es requerido");
        if (primerApellidoVacio == false) {
            berror = false;
        }
        boolean primerApellidoString = Validation.textFieldString(txtModificarPrimerApellido, PrimerApellidoLabel1, "Por favor ingrese letras");
        if (primerApellidoString == false) {
            berror = false;
        }

        boolean segundoApellidoVacio = Validation.textFieldNotEmpty(txtModificarSegundoApellido, SegundoApellidoLabel, "El segundo apellido es requerido");
        if (segundoApellidoVacio == false) {
            berror = false;
        }
        boolean segundoApellidoString = Validation.textFieldString(txtModificarSegundoApellido, SegundoApellidoLabel1, "Por favor ingrese letras");
        if (segundoApellidoString == false) {
            berror = false;
        }

        boolean correoVacio = Validation.textFieldNotEmpty(txtModificarCorreo, correoLabel, "El correo electronico es requerido");
        if (correoVacio == false) {
            berror = false;
        }

        if (correoVacio == true) {
            boolean correoTipo = Validation.isValidEmailAddress(txtModificarCorreo, correoLabel1, "Por favor ingrese un correo valido");
            if (correoTipo == false) {
                berror = false;
            }

            if (correoTipo == true) {

                boolean correoExiste = controller.buscarClienteFisico(txtModificarCorreo.getText());
                if (miclienteFisico.getCorreo().equals(txtModificarCorreo.getText())) {

                    correoExiste = false;
                } else {
                    if (correoExiste == true) {
                        correoLabel.setText("El correo ingresado ya existe");
                        Validation.textFieldStringRed(txtModificarCorreo);
                        berror = false;
                    } else {
                        Validation.textFieldStringNoRed(txtModificarCorreo);
                    }

                }

            }

        }

        boolean telefonoVacio = Validation.textFieldNotEmpty(txtModificarTelefono, TelefonoLabel, "El teléfono es requerido");
        if (telefonoVacio == false) {
            berror = false;
        }

        if (telefonoVacio == true) {

            boolean telefonoExiste = controller.buscarClienteFisicoTelefono(txtModificarTelefono.getText());
            if (miclienteFisico.getTelefono().equals(txtModificarTelefono.getText())) {
                telefonoExiste = false;
            } else {
                if (telefonoExiste == true) {
                    TelefonoLabel.setText("El teléfono ingresado ya existe");
                    Validation.textFieldStringRed(txtModificarTelefono);
                    berror = false;
                } else {
                    Validation.textFieldStringNoRed(txtModificarTelefono);
                }
            }

        }

        boolean provinciaVacio = Validation.textFieldNotEmpty(txtModificarProvincia, ProvinciaLabel, "La provincia es requerida");
        if (provinciaVacio == false) {
            berror = false;
        }

        boolean cantonVacio = Validation.textFieldNotEmpty(txtModificarCanton, CantonLabel, "El cantón es requerido");
        if (cantonVacio == false) {
            berror = false;
        }

        boolean distritoVacio = Validation.textFieldNotEmpty(txtModificarCanton, DistritoLabel, "El distrito es requerido");
        if (distritoVacio == false) {
            berror = false;
        }

        boolean direccionVacio = Validation.textAreadNotEmpty(txtModificarDireccion, DireccionLabel, "La dirección  es requerida");
        if (direccionVacio == false) {
            berror = false;
        }

        return berror;

    }
    
    
    
    
    public void modificiarUsuario(ActionEvent event) throws IOException, Exception{
             boolean berror;   
         berror = validation();
            
        Stage stage = null;
        Parent root;
        
     
        
        
        if (berror == true && event.getSource() == btnModificarCliente) {
            ClienteFisico nuevoCliente = new ClienteFisico(txtModificarPrimerApellido.getText(), txtModificarSegundoApellido.getText(), txtModificarCorreo.getText(), txtModificarTelefono.getText(), txtModificarProvincia.getText(), txtModificarCanton.getText(), txtModificarDistrito.getText(), txtModificarDireccion.getText(), txtModificarPrimerNombre.getText());
            
            controller.modificarClienteFisico(nuevoCliente,miclienteFisico.getCorreo());
            Parent blah = FXMLLoader.load(getClass().getResource("../fxml/ListaClienteFisico.fxml"));
            Scene scene = new Scene(blah);
            Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            appStage.setScene(scene);
            appStage.show();
        }
        
        
        
    }
    
      
    public void volver(ActionEvent event) throws IOException{
        if(event.getSource() == btnVolver){
             Parent blah = FXMLLoader.load(getClass().getResource("../fxml/ListaClienteFisico.fxml"));
            Scene scene = new Scene(blah);
            Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            appStage.setScene(scene);
            appStage.show();
        }
    }
}
