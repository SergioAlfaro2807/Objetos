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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ControllerClienteFisico {

    @FXML
    private TextField txtPrimerNombre;

    @FXML
    private TextField txtPrimerApellido;

    @FXML
    private TextField txtSegundoApellido;

    @FXML
    private TextField txtCorreo;

    @FXML
    private TextField txtTelefono;

    @FXML
    private TextField txtCanton;

    @FXML
    private TextField txtProvincia;

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
    private TextField txtDistrito;

    @FXML
    private Label PrimerNombreLabel1;
    
    @FXML
    private Label PrimerApellidoLabel1;
    
     @FXML
    private Label SegundoApellidoLabel1;
     
        @FXML
    private Label correoLabel1;
        


    @FXML
    private TextArea txtDireccion;

    @FXML
    private JFXButton btnRegistrarCliente;

    @FXML
    private JFXButton btnVolver;

    @FXML
    private Label DireccionLabel;
    static Gestor controller = new Gestor();
    @FXML
    public boolean validation() throws Exception {
          boolean berror = true;

        boolean primerNombreVacio = Validation.textFieldNotEmpty(txtPrimerNombre, PrimerNombreLabel, "El primer nombre es requerido");

        if (primerNombreVacio == false) {
            berror = false;
        }
        boolean primerNombreString = Validation.textFieldString(txtPrimerNombre, PrimerNombreLabel1, "Por favor ingrese letras");
        if (primerNombreString == false) {
            berror = false;
        }
        boolean primerApellidoVacio = Validation.textFieldNotEmpty(txtPrimerApellido, PrimerApellidoLabel, "El primer apellido es requerido");
        if (primerApellidoVacio == false) {
            berror = false;
        }
        boolean primerApellidoString = Validation.textFieldString(txtPrimerApellido, PrimerApellidoLabel1, "Por favor ingrese letras");
        if (primerApellidoString == false) {
            berror = false;
        }

        boolean segundoApellidoVacio = Validation.textFieldNotEmpty(txtSegundoApellido, SegundoApellidoLabel, "El segundo apellido es requerido");
        if (segundoApellidoVacio == false) {
            berror = false;
        }
        boolean segundoApellidoString = Validation.textFieldString(txtSegundoApellido, SegundoApellidoLabel1, "Por favor ingrese letras");
        if (segundoApellidoString == false) {
            berror = false;
        }

        boolean correoVacio = Validation.textFieldNotEmpty(txtCorreo, correoLabel, "El correo electronico es requerido");
        if (correoVacio == false) {
            berror = false;
        }

        if (correoVacio == true) {
            boolean correoTipo = Validation.isValidEmailAddress(txtCorreo, correoLabel1, "Por favor ingrese un correo valido");
            if (correoTipo == false) {
                berror = false;
            }

            if (correoTipo == true) {
                boolean correoExiste = controller.buscarClienteFisico(txtCorreo.getText());
                if (correoExiste == true) {
                    correoLabel.setText("El correo ingresado ya existe");
                    Validation.textFieldStringRed(txtCorreo);
                    berror = false;
                }else{
                    Validation.textFieldStringNoRed(txtCorreo);
                }

            }
     
            

        }
        
        
               
            boolean telefonoVacio = Validation.textFieldNotEmpty(txtTelefono, TelefonoLabel, "El teléfono es requerido");
        if (telefonoVacio == false) {
            berror = false;
        }
        
              if (telefonoVacio == true) {
            
           

       
                boolean telefonoExiste = controller.buscarClienteFisicoTelefono(txtTelefono.getText());
                if (telefonoExiste == true) {
                    TelefonoLabel.setText("El teléfono ingresado ya existe");
                    Validation.textFieldStringRed(txtTelefono);
                    berror = false;
                }else{
                    Validation.textFieldStringNoRed(txtTelefono);
                }

            
     
            

        }
        
        
        
        
            boolean provinciaVacio = Validation.textFieldNotEmpty(txtProvincia, ProvinciaLabel, "La provincia es requerida");
        if (provinciaVacio == false) {
            berror = false;
        }
        
                 
            boolean cantonVacio = Validation.textFieldNotEmpty(txtCanton, CantonLabel, "El cantón es requerido");
        if (cantonVacio == false) {
            berror = false;
        }
        
                 
            boolean distritoVacio = Validation.textFieldNotEmpty(txtDistrito, DistritoLabel, "El distrito es requerido");
        if (distritoVacio == false) {
            berror = false;
        }
        
                 boolean direccionVacio = Validation.textAreadNotEmpty(txtDireccion, DireccionLabel, "La dirección  es requerida");
        if (direccionVacio == false) {
            berror = false;
        }
        
        return berror;
    }
    
    
    
    
    
    
    public void registrarClienteFisico(ActionEvent event) throws IOException, Exception {
     boolean berror;   
         berror = validation();
            
        Stage stage = null;
        Parent root;
        
     
        
        
        if (berror == true && event.getSource() == btnRegistrarCliente) {
     
            
            controller.registrarClienteFisico(txtPrimerApellido.getText(), txtSegundoApellido.getText(), txtCorreo.getText(), txtTelefono.getText(), txtProvincia.getText(), txtCanton.getText(), txtDistrito.getText(), txtDireccion.getText(), txtPrimerNombre.getText());
            Parent blah = FXMLLoader.load(getClass().getResource("../fxml/Clientes.fxml"));
            Scene scene = new Scene(blah);
            Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            appStage.setScene(scene);
            appStage.show();
        }
        
        
        
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
