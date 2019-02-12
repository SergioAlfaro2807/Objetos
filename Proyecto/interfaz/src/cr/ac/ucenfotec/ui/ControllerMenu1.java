package cr.ac.ucenfotec.ui;

import com.jfoenix.controls.JFXButton;
import cr.ac.ucenfotec.bl.Usuario;
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
import javafx.stage.Stage;

public class ControllerMenu1 implements Initializable{

    @FXML
    private JFXButton btnClientes;

    @FXML
    private JFXButton btnProyectos;
    
     @FXML
    private JFXButton btnListarJuridicos;

    @FXML
    private JFXButton btnBitacoras;

    @FXML
    private JFXButton btnTecnologias;

    @FXML
    private JFXButton btnCerrarSesion;
       @FXML
    private JFXButton btnInicio;
      @FXML
    private JFXButton btnRegistrarClienteFisico;
      @FXML
    private JFXButton btnRegistrarClienteJuridico; 
      
      @FXML
    private JFXButton btnRegistrarTecnologia;   
      
         @FXML
    private JFXButton btnRegistrarProyecto;   
      
           @FXML
    private JFXButton btnListarFisicos;  
      
           @FXML
    private JFXButton btnListarTecnologias;  
           
            @FXML
    private JFXButton btnListarProyectos;         
       
                @FXML
    private JFXButton  btnModificarContrasenna;    
                       
            @FXML
    private JFXButton btnPerfil;  
           
           
     static String contrasennaEncriptada1;
      
            @FXML
    private Label labelNombreUsuario;

    @FXML
    private Label labelCorreoUsuario;

    @FXML
    private Label labelAvatarUsuario;

    @FXML
    private Label labellIdentificacionUsuario;
    
    static Usuario miusuarioLogeado;
    
    static Gestor controller = new Gestor();
    
           public String verUsuario(String contrasennaEncriptada) throws Exception {
        
        contrasennaEncriptada1 = contrasennaEncriptada;
        miusuarioLogeado = controller.buscarUsuarioLogeado(contrasennaEncriptada1);
        
        perfil();
        return contrasennaEncriptada1;

    }
           
           
       public void MenuChanging(ActionEvent event) throws IOException, Exception{
    
        
        if(event.getSource() == btnClientes){
               
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/Clientes.fxml"));
             Parent tableViewParent = (Parent) loader.load();
          Scene tableViewScene = new Scene(tableViewParent);
           Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
           
             window.setScene(tableViewScene);
          window.show();
          ControllerMenu controllerProyecto = loader.getController();
         
         controllerProyecto.verUsuario(contrasennaEncriptada1);
        }
    
        
        if(event.getSource() == btnProyectos){
                
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/Proyectos.fxml"));
             Parent tableViewParent = (Parent) loader.load();
          Scene tableViewScene = new Scene(tableViewParent);
           Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
           
             window.setScene(tableViewScene);
          window.show();
          ControllerMenu controllerProyecto = loader.getController();
         
         controllerProyecto.verUsuario(contrasennaEncriptada1);
        }
        
          if(event.getSource() == btnInicio){
                
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/InicioPrincipal.fxml"));
             Parent tableViewParent = (Parent) loader.load();
          Scene tableViewScene = new Scene(tableViewParent);
           Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
           
             window.setScene(tableViewScene);
          window.show();
          ControllerMenu controllerProyecto = loader.getController();
         
         controllerProyecto.verUsuario(contrasennaEncriptada1);
        }
        
       
         
         if(event.getSource() == btnTecnologias){
                  FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/Tecnologias.fxml"));
             Parent tableViewParent = (Parent) loader.load();
          Scene tableViewScene = new Scene(tableViewParent);
           Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
           
             window.setScene(tableViewScene);
          window.show();
          ControllerMenu controllerProyecto = loader.getController();
         
         controllerProyecto.verUsuario(contrasennaEncriptada1);
         
        }
         
              
  
         
            if(event.getSource() == btnCerrarSesion){
            Parent blah = FXMLLoader.load(getClass().getResource("../fxml/InicioSesion.fxml"));
            Scene scene = new Scene(blah);
            Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            appStage.setScene(scene);
            appStage.show(); 
        }
                  
            
            
         
            
           if(event.getSource() == btnPerfil){
              
                 FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/MenuPrincipal.fxml"));
             Parent tableViewParent = (Parent) loader.load();
          Scene tableViewScene = new Scene(tableViewParent);
           Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
           
             window.setScene(tableViewScene);
          window.show();
          ControllerMenu1 controllerProyecto = loader.getController();
         
         controllerProyecto.verUsuario(contrasennaEncriptada1);
        }
        
         
           
         
    }
       public void registrarChanging(ActionEvent event) throws IOException, Exception{
           
           if(event.getSource() == btnRegistrarClienteFisico){
            Parent blah = FXMLLoader.load(getClass().getResource("../fxml/RegistrarClienteFisico.fxml"));
            Scene scene = new Scene(blah);
            Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            appStage.setScene(scene);
            appStage.show();
        }
           
               if(event.getSource() == btnRegistrarClienteJuridico){
            Parent blah = FXMLLoader.load(getClass().getResource("../fxml/RegistrarClienteJuridico.fxml"));
            Scene scene = new Scene(blah);
            Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            appStage.setScene(scene);
            appStage.show();
        }
        
        if(event.getSource() == btnRegistrarTecnologia){
            Parent blah = FXMLLoader.load(getClass().getResource("../fxml/RegistrarTecnologia.fxml"));
            Scene scene = new Scene(blah);
            Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            appStage.setScene(scene);
            appStage.show(); 
        }
        
        if(event.getSource() == btnRegistrarProyecto){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/RegistrarProyecto.fxml"));
             Parent tableViewParent = (Parent) loader.load();
          Scene tableViewScene = new Scene(tableViewParent);
           Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
           
             window.setScene(tableViewScene);
          window.show();
          ControllerProyecto controllerProyecto = loader.getController();
         
         controllerProyecto.verUsuario(contrasennaEncriptada1);
            
            
        }
          
           
       }   
       
        public void listarChanging(ActionEvent event) throws IOException, Exception{
           
           if(event.getSource() == btnListarFisicos){
            Parent blah = FXMLLoader.load(getClass().getResource("../fxml/ListaClienteFisico.fxml"));
            Scene scene = new Scene(blah);
            Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            appStage.setScene(scene);
            appStage.show();
        }
           
           
                
           if(event.getSource() == btnListarJuridicos){
            Parent blah = FXMLLoader.load(getClass().getResource("../fxml/ListaClienteJuridico.fxml"));
            Scene scene = new Scene(blah);
            Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            appStage.setScene(scene);
            appStage.show();
        }
           
               if(event.getSource() == btnListarTecnologias){
            Parent blah = FXMLLoader.load(getClass().getResource("../fxml/ListarTecnologia.fxml"));
            Scene scene = new Scene(blah);
            Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            appStage.setScene(scene);
            appStage.show();
        }
        
        if(event.getSource() == btnListarProyectos){
            Parent blah = FXMLLoader.load(getClass().getResource("../fxml/ListarProyectos.fxml"));
            Scene scene = new Scene(blah);
            Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            appStage.setScene(scene);
            appStage.show(); 
        }                  
       }

        
        
        public void modificarContrasenna(ActionEvent event) throws IOException, Exception{
           
       if(event.getSource() == btnModificarContrasenna){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/ModificarContrasenna.fxml"));
             Parent tableViewParent = (Parent) loader.load();
          Scene tableViewScene = new Scene(tableViewParent);
           Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
           
             window.setScene(tableViewScene);
          window.show();
          ControllerModificarContrasenna controllerProyecto = loader.getController();
         
         controllerProyecto.modificarDatos(contrasennaEncriptada1);
           
           
                
              
       }
        }  
  
    public void perfil() {
        
     
  labelNombreUsuario.setText(miusuarioLogeado.getNombre());
  
  labelCorreoUsuario.setText(miusuarioLogeado.getCorreo());
  
  labelAvatarUsuario.setText(miusuarioLogeado.getAvatar());
  
  labellIdentificacionUsuario.setText(miusuarioLogeado.getCedula());


    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if(miusuarioLogeado == null){
            
            
        }else{
                 labelNombreUsuario.setText(miusuarioLogeado.getNombre());
  
  labelCorreoUsuario.setText(miusuarioLogeado.getCorreo());
  
  labelAvatarUsuario.setText(miusuarioLogeado.getAvatar());
  
  labellIdentificacionUsuario.setText(miusuarioLogeado.getCedula());
        }
     
    }
        
        
        

  
       }