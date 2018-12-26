/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.ucenfotec.ui;

import com.jfoenix.controls.JFXButton;
import cr.ac.ucenfotec.bl.ClienteFisico;
import cr.ac.ucenfotec.bl.ClienteJuridico;
import cr.ac.ucenfotec.bl.Contacto;
import cr.ac.ucenfotec.tl.Gestor;
import static cr.ac.ucenfotec.ui.ControllerClienteFisico.controller;
import static cr.ac.ucenfotec.ui.ControllerClienteJuridico.controller;
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
public class ControllerModificarClienteJuridico implements Initializable {

    @FXML
    private TextField txtModificarPrimerNombre;

    @FXML
    private TextField txtModificarIdentificacion;

    @FXML
    private TextField txtModificarTelefono;

    @FXML
    private TextField txtModificarProvincia;

    @FXML
    private TextField txtModificarDistrito;

    @FXML
    private TextField txtModificarCanton;

    @FXML
    private TextArea txtModificarDireccion;



    private ClienteJuridico miclienteJuridico;
    
    private Contacto micontacto;
    
        @FXML
    private JFXButton btnModificarCliente;
        
        
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
    private Label identificacionLabel1;
        
            
        @FXML
    private JFXButton btnVolver;
      
            @FXML
    private JFXButton  btnModificarJuridicoSiguiente;
     
        
         static Gestor controller = new Gestor();

    public ControllerModificarClienteJuridico() {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    public ClienteJuridico modificarDatos(ClienteJuridico miclienteJuridicoModificar) throws Exception {

        miclienteJuridico = miclienteJuridicoModificar;

        txtModificarPrimerNombre.setText(miclienteJuridicoModificar.getNombre());
        txtModificarIdentificacion.setText(miclienteJuridicoModificar.getCedula());
        txtModificarTelefono.setText(miclienteJuridicoModificar.getTelefono());
        txtModificarCanton.setText(miclienteJuridicoModificar.getCanton());
        txtModificarDistrito.setText(miclienteJuridicoModificar.getDistrito());
        txtModificarDireccion.setText(miclienteJuridicoModificar.getDireccion());
        txtModificarProvincia.setText(miclienteJuridicoModificar.getProvincia());
        String cedulaContacto = miclienteJuridicoModificar.getMicontacto().getCedula();
        micontacto = controller.buscarContacto(cedulaContacto);
        return miclienteJuridico;

    }
    


     public boolean validation() throws Exception {
         System.out.println(micontacto.toString());
          boolean berror = true;

        boolean nombreVacio = Validation.textFieldNotEmpty(txtModificarPrimerNombre, NombreLabel, "El nombre es requerido");

        if (nombreVacio == false) {
            berror = false;
        }
        boolean nombreString = Validation.textFieldString(txtModificarPrimerNombre, PrimerNombreLabel1, "Por favor ingrese letras");
        if (nombreString == false) {
            berror = false;
        }
        boolean identificacionVacio = Validation.textFieldNotEmpty(txtModificarIdentificacion, identificacionLabel, "La identificacion es requerida");
        if (identificacionVacio == false) {
            berror = false;
        }
        if(identificacionVacio == true){
                 boolean identificacionValidar = Validation.textFieldCedulaJuridica(txtModificarIdentificacion, identificacionLabel, "Por favor ingrese una cédula valida");
                 System.out.println(identificacionValidar);
        if (identificacionValidar == false) {
            berror = false;
        }
        
         if(identificacionValidar == true){
            boolean identificacionExiste = controller.buscarClienteJuridicoIdentificacion(txtModificarIdentificacion.getText());
            if(miclienteJuridico.getCedula().equals(txtModificarIdentificacion.getText())){
                identificacionExiste = false;
            }
             if (identificacionExiste == true) {
                    identificacionLabel.setText("La identificacion ingresada ya existe");
                    Validation.textFieldStringRed(txtModificarIdentificacion);
                    berror = false;
                }else{
                    Validation.textFieldStringNoRed(txtModificarIdentificacion);
                }
        }
        }
        
       
        
        
        
        
              boolean telefonoVacio = Validation.textFieldNotEmpty(txtModificarTelefono, telefonoLabel, "El teléfono es requerido");
        if (telefonoVacio == false) {
            berror = false;
        }
        
              if (telefonoVacio == true) {
            
           

       
                boolean telefonoExiste = controller.buscarClienteJuridicoTelefono(txtModificarTelefono.getText());
                  if(miclienteJuridico.getTelefono().equals(txtModificarTelefono.getText())){
                telefonoExiste = false;
            }
                if (telefonoExiste == true) {
                    telefonoLabel.setText("El teléfono ingresado ya existe");
                    Validation.textFieldStringRed(txtModificarTelefono);
                    berror = false;
                }else{
                    Validation.textFieldStringNoRed(txtModificarTelefono);
                }

            
     
            

        }
              
        boolean provinciaVacio = Validation.textFieldNotEmpty(txtModificarProvincia, provinciaLabel, "La provincia es requerida");
        if (provinciaVacio == false) {
            berror = false;
        }
        
                 
            boolean cantonVacio = Validation.textFieldNotEmpty(txtModificarCanton, CantonLabel, "El cantón es requerido");
        if (cantonVacio == false) {
            berror = false;
        }
        
                 
            boolean distritoVacio = Validation.textFieldNotEmpty(txtModificarDistrito, DistritoLabel, "El distrito es requerido");
        if (distritoVacio == false) {
            berror = false;
        }
        
                 boolean direccionVacio = Validation.textAreadNotEmpty(txtModificarDireccion, DireccionLabel, "La dirección es requerida");
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
        
     
        
        
        if (berror == true && event.getSource() == btnModificarJuridicoSiguiente) {
       FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/ModificarContacto.fxml"));
       
          Parent tableViewParent = (Parent) loader.load();
          Scene tableViewScene = new Scene(tableViewParent);
         
         
         Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
          
         window.setScene(tableViewScene);
          window.show();
          ControllerModificarContacto controllerModificar = loader.getController();
          controllerModificar.modificarDatos(micontacto, miclienteJuridico, txtModificarPrimerNombre.getText(), txtModificarIdentificacion.getText(), txtModificarTelefono.getText() , txtModificarCanton.getText(), txtModificarDistrito.getText() , txtModificarDireccion.getText() , txtModificarProvincia.getText());  
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
