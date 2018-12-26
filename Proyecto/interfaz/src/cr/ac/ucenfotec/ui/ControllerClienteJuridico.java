/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.ucenfotec.ui;

import com.jfoenix.controls.JFXButton;
import cr.ac.ucenfotec.bl.ClienteJuridico;
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


/**
 *
 * @author Dell
 */
public class ControllerClienteJuridico {
  

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
    private TextArea txtDireccion;


    


    @FXML
    private JFXButton registrarClienteJuridicoSiguiente;
    

    @FXML
    private JFXButton btnVolver;
    
    static Gestor controller = new Gestor();
    
    public boolean validation() throws Exception {
          boolean berror = true;

        boolean nombreVacio = Validation.textFieldNotEmpty(txtPrimerNombre, NombreLabel, "El nombre es requerido");

        if (nombreVacio == false) {
            berror = false;
        }
        boolean nombreString = Validation.textFieldString(txtPrimerNombre, PrimerNombreLabel1, "Por favor ingrese letras");
        if (nombreString == false) {
            berror = false;
        }
        boolean identificacionVacio = Validation.textFieldNotEmpty(txtIdentificacion, identificacionLabel, "La identificacion es requerida");
        if (identificacionVacio == false) {
            berror = false;
        }
        if(identificacionVacio == true){
                 boolean identificacionValidar = Validation.textFieldCedulaJuridica(txtIdentificacion, identificacionLabel, "Por favor ingrese una cédula valida");
                 System.out.println(identificacionValidar);
        if (identificacionValidar == false) {
            berror = false;
        }
        
         if(identificacionValidar == true){
            boolean identificacionExiste = controller.buscarClienteJuridicoIdentificacion(txtIdentificacion.getText());
             if (identificacionExiste == true) {
                    identificacionLabel.setText("La identificacion ingresada ya existe");
                    Validation.textFieldStringRed(txtIdentificacion);
                    berror = false;
                }else{
                    Validation.textFieldStringNoRed(txtIdentificacion);
                }
        }
        }
        
       
        
        
        
        
              boolean telefonoVacio = Validation.textFieldNotEmpty(txtTelefono, telefonoLabel, "El teléfono es requerido");
        if (telefonoVacio == false) {
            berror = false;
        }
        
              if (telefonoVacio == true) {
            
           

       
                boolean telefonoExiste = controller.buscarClienteJuridicoTelefono(txtTelefono.getText());
                if (telefonoExiste == true) {
                    telefonoLabel.setText("El teléfono ingresado ya existe");
                    Validation.textFieldStringRed(txtTelefono);
                    berror = false;
                }else{
                    Validation.textFieldStringNoRed(txtTelefono);
                }

            
     
            

        }
              
        boolean provinciaVacio = Validation.textFieldNotEmpty(txtProvincia, provinciaLabel, "La provincia es requerida");
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
        
                 boolean direccionVacio = Validation.textAreadNotEmpty(txtDireccion, DireccionLabel, "La dirección es requerida");
        if (direccionVacio == false) {
            berror = false;
        }


       
        return berror;
    }
    
   
    
    
    
    
    
    
    public void registrarClienteJuridicoSiguiente(ActionEvent event) throws IOException, Exception {
     boolean berror;   
         berror = validation();
            
        Stage stage = null;
        Parent root;

      
        if (berror == true && event.getSource() == registrarClienteJuridicoSiguiente) {
             ClienteJuridico cliente = new ClienteJuridico(txtIdentificacion.getText(), txtTelefono.getText(), txtPrimerNombre.getText(), txtProvincia.getText(), txtCanton.getText(), txtDistrito.getText(), txtDireccion.getText());
             
            
              FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/RegistrarContacto.fxml"));
        
          Parent tableViewParent = (Parent) loader.load();
           Scene tableViewScene = new Scene(tableViewParent);
          
          
          Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
          
          window.setScene(tableViewScene);
          window.show();
          ControllerContacto controllerContacto = loader.getController();
          controllerContacto.modificarDatos(cliente);  
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

