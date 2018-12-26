package cr.ac.ucenfotec.ui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import cr.ac.ucenfotec.tl.Gestor;
import java.io.IOException;
import javafx.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.apache.commons.codec.digest.DigestUtils;

public class ControllerLogIn implements Initializable {

    @FXML
    JFXButton btnIniciarSesion;
    @FXML
    JFXButton btnNuevaCuenta;

    @FXML
    JFXButton btnCrearCuenta;

    @FXML
    JFXButton Volver;

    @FXML
    TextField txtPrimerNombre;

    @FXML
    TextField txtPrimerApellido;

    @FXML
    TextField txtSegundoApellido;

    @FXML
    TextField txtCorreo;

    @FXML
    TextField txtIdentificacion;

    @FXML
    TextField txtAvatar;

    @FXML
    ToggleGroup rbSexo;

    @FXML
    JFXRadioButton rbMasculino;

    @FXML
    JFXRadioButton rbFemenino;

    @FXML
    JFXRadioButton rbOtro;

    @FXML
    PasswordField txtContrasenna;
    @FXML
    TextField txtContrasenna1;

    @FXML
    Label primerNombreLabel;

    @FXML
    Label primerNombreLabel1;

    @FXML
    Label primerApellidoLabel;
    @FXML
    Label primerApellidoLabel1;

    @FXML
    Label segundoApellidoLabel;

    @FXML
    Label segundoApellidoLabel1;

    @FXML
    Label identificacionLabel;
    @FXML
    Label correoElectronicoLabel;

    @FXML
    Label correoElectronicoLabel1;

    @FXML
    Label sexoLabel;

    @FXML
    Label avatarLabel;
    
        @FXML
    Label contrasennaLabel;
        
        
      @FXML
    Label avatarLogInLabel;
            
       @FXML
    Label contrasennaLogInLabel;
       
             @FXML
    JFXTextField txtAvatarLogin; 
             
             
            @FXML
    JFXPasswordField  txtContrasennaLogin;          
             
    @FXML
    ImageView btnVerContrasenna;
    @FXML
    private RadioButton rbVer;
    
    
    @FXML
    private Hyperlink btnRecuperarContrasenna;

    static Gestor controller = new Gestor();

    public void initialize() {
        // Perform any necessary initialization here.
    }

    public void exitButtonListener() {

        System.exit(0);

    }

    @FXML
    private void handleButtonAction(ActionEvent event) throws Exception {
        Stage stage;
        Parent root;

        if (event.getSource() == btnNuevaCuenta) {
            stage = (Stage) btnNuevaCuenta.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("../fxml/CrearCuenta.fxml"));
        } else {

            stage = (Stage) Volver.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("../fxml/InicioSesion.fxml"));
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void mousePressed(ActionEvent event) {
        if (rbVer.isSelected()) {

            txtContrasenna1.setVisible(true);
            txtContrasenna1.setText(txtContrasenna.getText());

        } else {
            txtContrasenna1.setVisible(false);

        }

    }

    public boolean validation() throws Exception {
        boolean berror = true;

        boolean primerNombreVacio = Validation.textFieldNotEmpty(txtPrimerNombre, primerNombreLabel, "El primer nombre es requerido");

        if (primerNombreVacio == false) {
            berror = false;
        }
        boolean primerNombreString = Validation.textFieldString(txtPrimerNombre, primerNombreLabel1, "Por favor ingrese letras");
        if (primerNombreString == false) {
            berror = false;
        }
        boolean primerApellidoVacio = Validation.textFieldNotEmpty(txtPrimerApellido, primerApellidoLabel, "El primer apellido es requerido");
        if (primerApellidoVacio == false) {
            berror = false;
        }
        boolean primerApellidoString = Validation.textFieldString(txtPrimerApellido, primerApellidoLabel1, "Por favor ingrese letras");
        if (primerApellidoString == false) {
            berror = false;
        }

        boolean segundoApellidoVacio = Validation.textFieldNotEmpty(txtSegundoApellido, segundoApellidoLabel, "El segundo apellido es requerido");
        if (segundoApellidoVacio == false) {
            berror = false;
        }
        boolean segundoApellidoString = Validation.textFieldString(txtSegundoApellido, segundoApellidoLabel1, "Por favor ingrese letras");
        if (segundoApellidoString == false) {
            berror = false;
        }

        boolean correoVacio = Validation.textFieldNotEmpty(txtCorreo, correoElectronicoLabel, "El correo electronico es requerido");
        if (correoVacio == false) {
            berror = false;
        }

        if (correoVacio == true) {
            boolean correoTipo = Validation.isValidEmailAddress(txtCorreo, correoElectronicoLabel1, "Por favor ingrese un correo valido");
            if (correoTipo == false) {
                berror = false;
            }

            if (correoTipo == true) {
                boolean correoExiste = controller.buscarCorreo(txtCorreo.getText());
                if (correoExiste == true) {
                    correoElectronicoLabel.setText("El correo ingresado ya existe");
                    Validation.textFieldStringRed(txtCorreo);
                    berror = false;
                }else{
                    Validation.textFieldStringNoRed(txtCorreo);
                }

            }

        }

        boolean identificacionVacio = Validation.textFieldNotEmpty(txtIdentificacion, identificacionLabel, "La identificacion es requerida");
        if (identificacionVacio == false) {
            berror = false;
        }

        boolean identificacionExiste = controller.buscarUsuario(txtIdentificacion.getText());
        if (identificacionExiste == true) {
            identificacionLabel.setText("La identificacion ingresada ya existe");
            Validation.textFieldStringRed(txtIdentificacion);
            berror = false;
        }else{
            Validation.textFieldStringNoRed(txtIdentificacion);
        }

        boolean sexo = Validation.radioButtonEmpty(rbMasculino, rbFemenino, rbOtro, "El genero es requerido", sexoLabel);
        if (sexo == false) {
            berror = false;
        }

        boolean avatarVacio = Validation.textFieldNotEmpty(txtAvatar, avatarLabel, "El avatar es requerido");
        if(avatarVacio == true){
            boolean avatarExiste = controller.buscarAvatar(txtAvatar.getText());
            if(avatarExiste == true){
                avatarLabel.setText("El avatar ingresado ya existe");
                Validation.textFieldStringRed(txtAvatar);
                berror = false;
            }else{
                Validation.textFieldStringNoRed(txtAvatar);
            }
        }
        
        boolean contrasennaVacio = Validation.textFieldNotEmpty(txtContrasenna, contrasennaLabel, "La contraseña es requerida");
        if(contrasennaVacio == false){
            berror = false;
        }

        return berror;
    }

    public void crearCuenta(ActionEvent event) throws IOException, Exception {
        boolean berror = validation();
        Stage stage = null;
        Parent root;
        
     
        
        
        if (berror == true && event.getSource() == btnCrearCuenta) {
            String sexo = null;
            if(rbMasculino.isSelected() == true){
                sexo = "Masculino";
            }
             if(rbFemenino.isSelected() == true){
                sexo = "Femenino";
            }
              if(rbOtro.isSelected() == true){
                sexo = "Otro";
            }
          
            String contrasennaEncriptada = DigestUtils.md5Hex(txtContrasenna.getText());
            

            controller.registrarUsuario(txtPrimerNombre.getText(), txtPrimerApellido.getText(), txtSegundoApellido.getText(), txtCorreo.getText(), txtIdentificacion.getText(), sexo, txtAvatar.getText(), contrasennaEncriptada);
            Parent blah = FXMLLoader.load(getClass().getResource("../fxml/InicioSesion.fxml"));
            Scene scene = new Scene(blah);
            Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            appStage.setScene(scene);
            appStage.show();
        }

    }
    
    
    public boolean validationLogIn() throws Exception{
       boolean berror = true;
       
       boolean avatarVacio = Validation.textFieldNotEmpty(txtAvatarLogin, avatarLogInLabel, "Por favor escriba su correo");
       if(avatarVacio == false){
           berror = false;
       }
       
         boolean contrasennaVacio = Validation.textFieldNotEmpty(txtContrasennaLogin, contrasennaLogInLabel, "Por favor escriba su contraseña");
       if(contrasennaVacio == false){
           berror = false;
       }
       
       
       if(avatarVacio = true && contrasennaVacio == true){
         
       
           boolean usuarioExiste = controller.buscarUsuarioExistente(txtAvatarLogin.getText(), txtContrasennaLogin.getText());
           if(usuarioExiste == false){
              avatarLogInLabel.setText("El correo ingresado es incorrecto");
                Validation.textFieldStringRed(txtAvatarLogin);
                contrasennaLogInLabel.setText("La contraseña ingresada es incorrecta");
                Validation.textFieldStringRed(txtContrasennaLogin);
                berror = false; 
               
           }else{
                avatarLogInLabel.setText("");
                 contrasennaLogInLabel.setText("");
           }
           
               
           }
                
          
    
       
       
       
       
       return berror;
    }
    
    public void iniciarSesion(ActionEvent event) throws IOException, Exception{
        
        boolean berror = validationLogIn();
        
        if(berror == true){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/MenuPrincipal.fxml"));
             Parent tableViewParent = (Parent) loader.load();
          Scene tableViewScene = new Scene(tableViewParent);
           Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
           
             window.setScene(tableViewScene);
          window.show();
          ControllerMenu1 controllerMenu = loader.getController();
          String contrasennaEncriptada = DigestUtils.md5Hex(txtContrasennaLogin.getText());
        controllerMenu.verUsuario(contrasennaEncriptada);
           
        
        }
        
         
        
    }
    
    
      public void RecuperarContrasenna(ActionEvent event) throws IOException, Exception{
    
        
        if(event.getSource() == btnRecuperarContrasenna){
            Parent blah = FXMLLoader.load(getClass().getResource("../fxml/RecuperarContrasenna.fxml"));
            Scene scene = new Scene(blah);
            Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            appStage.setScene(scene);
            appStage.show();
        }
      }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
 
    }

}
