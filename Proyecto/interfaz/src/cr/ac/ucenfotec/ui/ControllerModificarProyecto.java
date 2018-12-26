package cr.ac.ucenfotec.ui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import cr.ac.ucenfotec.bl.Bitacora;
import cr.ac.ucenfotec.bl.ClienteFisico;
import cr.ac.ucenfotec.bl.ClienteJuridico;
import cr.ac.ucenfotec.bl.Proyecto;
import cr.ac.ucenfotec.bl.Tecnologia;
import cr.ac.ucenfotec.bl.Usuario;
import cr.ac.ucenfotec.tl.Gestor;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ControllerModificarProyecto implements Initializable {

    @FXML
    private JFXComboBox<Tecnologia> cmTecnologias;


    private ObservableList<Tecnologia> listaTecnologias;
    private ObservableList<Tecnologia> listaTecnologiasProyecto;

 
  

 
    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtCodigo;

    @FXML
    private TextArea txtDescripcion;

    @FXML
    private TableView<Tecnologia> tblTecnologias;

    @FXML
    private TableColumn<Tecnologia, String> clmNombre;

    @FXML
    private TableColumn<Tecnologia, String> clmCodigo;

    @FXML
    private JFXButton btnEliminar;

    @FXML
    private JFXButton btnAñadir;

    @FXML
    private Label nombreLabel;

    @FXML
    private Label codigoLabel;

    @FXML
    private Label tecnologiaLabel;


    @FXML
    private AnchorPane errorPane;

    @FXML
    private JFXButton btnRegistrarProyecto;

    @FXML
    private JFXButton btnVolver;

    @FXML
    private Label DescripcionLabel;

    @FXML
    private JFXButton btnEntendido;

    private Usuario miusuario;
    
    private Proyecto miproyecto;

       private ObservableList<Tecnologia> listaTecnologiasProyectoEliminar;
    
    private ArrayList<Tecnologia> arrayTecnologias = new ArrayList<Tecnologia>();

    private ArrayList<Tecnologia> arrayTecnologiasViejas = new ArrayList<Tecnologia>();

    static Gestor controller = new Gestor();
    
    
    
    
    
    public Proyecto modificarDatos(Proyecto miproyectoModificar) throws Exception {

        miproyecto = miproyectoModificar;

        txtNombre.setText(miproyectoModificar.getNombre());
        txtCodigo.setText(miproyectoModificar.getCodigo());
        txtDescripcion.setText(miproyectoModificar.getDescripcion());
        listaTecnologiasProyecto = controller.buscarTecnologiasProyecto(listaTecnologiasProyecto, miproyectoModificar.getCodigo());
       
        tblTecnologias.setItems(listaTecnologiasProyecto);
          clmNombre.setCellValueFactory(new PropertyValueFactory<Tecnologia, String>("nombre"));
        clmCodigo.setCellValueFactory(new PropertyValueFactory<Tecnologia, String>("codigo"));
        
          for (int i = 0; i < listaTecnologiasProyecto.size(); i++) {
                    arrayTecnologiasViejas.add(listaTecnologiasProyecto.get(i));
                    
                }
        
        return miproyecto;

    }

    @FXML
    public boolean validation() throws Exception {
        boolean berror = true;

        boolean nombreVacio = Validation.textFieldNotEmpty(txtNombre, nombreLabel, "El nombre es requerido");

        if (nombreVacio == false) {
            berror = false;
        }

        boolean codigoVacio = Validation.textFieldNotEmpty(txtCodigo, codigoLabel, "El codigo es requerido");
        if (codigoVacio == false) {
            berror = false;
        }

        if (codigoVacio == true) {

            boolean codigoExiste = controller.buscarProyecto(txtCodigo.getText());
            if(miproyecto.getCodigo().equals(txtCodigo.getText())){
                codigoExiste = false;
            }
            if (codigoExiste == true) {
                codigoLabel.setText("El codigo ingresado ya existe");
                Validation.textFieldStringRed(txtCodigo);
                berror = false;
            } else {
                Validation.textFieldStringNoRed(txtCodigo);
            }

        }

        boolean descripcionVacio = Validation.textAreadNotEmpty(txtDescripcion, DescripcionLabel, "La descripción es requerida");
        if (descripcionVacio == false) {
            berror = false;
        }

        boolean tablaVacio = Validation.tableNotEmpty(cmTecnologias, tecnologiaLabel, "Por favor seleccione una tecnología", listaTecnologiasProyecto);
        if (tablaVacio == false) {
            berror = false;
        }

     


       

        return berror;
    }

    public Usuario verUsuario(String usuarioBuscar) throws Exception {

        miusuario = controller.buscarUsuarioLogeado(usuarioBuscar);
        return miusuario;

    }

    public void modificarProyecto(ActionEvent event) throws IOException, Exception {
        boolean berror;
        berror = validation();

        Stage stage = null;
        Parent root;

        if (berror == true && event.getSource() == btnRegistrarProyecto) {



                for (int i = 0; i < listaTecnologiasProyecto.size(); i++) {
                    arrayTecnologias.add(listaTecnologiasProyecto.get(i));
                    
                }
                
                
                
             String bitacoraNombre = "Bitacora " + txtNombre.getText();
             String bitacoraVieja = "Bitacora " + miproyecto.getNombre();
                controller.modificarBitacora(bitacoraNombre, bitacoraVieja);
                controller.modificarProyectoxTecnologia(arrayTecnologiasViejas, arrayTecnologias, miproyecto.getCodigo());
                controller.modificarProyecto(txtDescripcion.getText(), txtNombre.getText(), txtCodigo.getText(), miproyecto.getCodigo());

                    

                

            

            Parent blah = FXMLLoader.load(getClass().getResource("../fxml/ListarProyectos.fxml"));
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

            Parent blah = FXMLLoader.load(getClass().getResource("../fxml/ListarProyectos.fxml"));
            Scene scene = new Scene(blah);
            Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            appStage.setScene(scene);
            appStage.show();
        }

    }

    public void añadirTecnologia(ActionEvent event) {

        listaTecnologiasProyecto.add(cmTecnologias.getSelectionModel().getSelectedItem());
        if (cmTecnologias.getSelectionModel().getSelectedItem() == null) {
            errorPane.setVisible(true);

        } else {
            tblTecnologias.setItems(listaTecnologiasProyecto);
            clmNombre.setCellValueFactory(new PropertyValueFactory<Tecnologia, String>("nombre"));
            clmCodigo.setCellValueFactory(new PropertyValueFactory<Tecnologia, String>("codigo"));

        }

    }



    public void quitarPanel(ActionEvent event) {
        if (event.getSource() == btnEntendido) {
            errorPane.setVisible(false);
        }
    }

    public void eliminarTecnologia(ActionEvent event) throws Exception {

        tblTecnologias.getSelectionModel().getSelectedItem();
        if (tblTecnologias.getSelectionModel().getSelectedItem() == null) {
            errorPane.setVisible(true);
        } else {
            
            listaTecnologiasProyecto.remove(tblTecnologias.getSelectionModel().getSelectedItem());
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        listaTecnologias = FXCollections.observableArrayList();
     
        try {
            controller.llenarTecnologias(listaTecnologias);
           
      
        } catch (Exception ex) {
            Logger.getLogger(ControllerModificarProyecto.class.getName()).log(Level.SEVERE, null, ex);
        }
        cmTecnologias.setItems(listaTecnologias);
         cmTecnologias.setPromptText("Seleccione una tecnología");

        listaTecnologiasProyecto = FXCollections.observableArrayList();
        
        tblTecnologias.refresh();
      
    }

}
