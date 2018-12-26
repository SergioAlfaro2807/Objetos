package cr.ac.ucenfotec.ui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import cr.ac.ucenfotec.bl.Bitacora;
import cr.ac.ucenfotec.bl.ClienteFisico;
import cr.ac.ucenfotec.bl.ClienteJuridico;
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

public class ControllerProyecto implements Initializable {

    @FXML
    private JFXComboBox<Tecnologia> cmTecnologias;

    @FXML
    private JFXComboBox<String> cmTipoCliente;

    @FXML
    private JFXComboBox<ClienteJuridico> cmClienteJuridico;

    @FXML
    private JFXComboBox<ClienteFisico> cmClienteFisico;

    private ObservableList<Tecnologia> listaTecnologias;
    private ObservableList<Tecnologia> listaTecnologiasProyecto;
    private ObservableList<String> listaTipo;
    private ObservableList<String> listaTipoCliente;
    private ObservableList<ClienteJuridico> ClienteJuridico;
    private ObservableList<ClienteFisico> ClienteFisico;

    @FXML
    private JFXComboBox<String> cmTipoProyecto;

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
    private Label tipoLabel;

    @FXML
    private Text labelJuridico;

    @FXML
    private Text labelTipoCliente;

    @FXML
    private Text labelFisico;

    @FXML
    private AnchorPane errorPane;

    @FXML
    private JFXButton btnRegistrarProyecto;

    @FXML
    private JFXButton btnVolver;

    @FXML
    private Label tipoClienteLabel;

    @FXML
    private Label labelClienteJuridico;

    @FXML
    private Label labelClienteFisico;

    @FXML
    private Label DescripcionLabel;

    @FXML
    private JFXButton btnEntendido;

    private Usuario miusuario;

    private ArrayList<Tecnologia> arrayTecnologias = new ArrayList<Tecnologia>();
    ;

    
    static Gestor controller = new Gestor();

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

        boolean comboBoxVacio = Validation.comboBoxEmpty(cmTipoProyecto, tipoLabel, "Por favor seleccione un tipo de proyecto");
        if (comboBoxVacio == false) {
            berror = false;
        }
        if (comboBoxVacio == true && cmTipoProyecto.getSelectionModel().getSelectedItem() == "Comercial") {
            boolean comboBoxTipoCliente = Validation.comboBoxEmpty(cmTipoCliente, tipoClienteLabel, "Por favor seleccione un tipo de cliente");
            if (comboBoxTipoCliente == false) {
                berror = false;
            }

            if (comboBoxTipoCliente == true && cmTipoCliente.getSelectionModel().getSelectedItem() == "Juridico") {
                labelClienteJuridico.setVisible(true);
                labelClienteFisico.setVisible(false);
                Validation.comboBoxNoRed(cmClienteFisico);
                boolean comboBoxClienteJuridico = Validation.comboBoxEmpty(cmClienteJuridico, labelClienteJuridico, "Por favor seleccione un cliente juridico");
                if (comboBoxClienteJuridico == false) {
                    berror = false;
                }
            }

            if (comboBoxTipoCliente == true && cmTipoCliente.getSelectionModel().getSelectedItem() == "Físico") {
                labelClienteFisico.setVisible(true);
                labelClienteJuridico.setVisible(false);
                Validation.comboBoxNoRed(cmClienteJuridico);
                boolean comboBoxClienteFisico = Validation.comboBoxEmpty(cmClienteFisico, labelClienteFisico, "Por favor seleccione un cliente fisico");
                if (comboBoxClienteFisico == false) {
                    berror = false;
                }
            }
        } else {
        
            labelClienteJuridico.setVisible(false);
            labelFisico.setVisible(false);
        }

        return berror;
    }

    public Usuario verUsuario(String usuarioBuscar) throws Exception {

        miusuario = controller.buscarUsuarioLogeado(usuarioBuscar);
        return miusuario;

    }

    public void registrarProyecto(ActionEvent event) throws IOException, Exception {
        boolean berror;
        berror = validation();

        Stage stage = null;
        Parent root;

        if (berror == true && event.getSource() == btnRegistrarProyecto) {

            if (cmTipoProyecto.getSelectionModel().getSelectedItem() == "Academico") {

                LocalDate fechaInicio = LocalDate.now();
                String tipo = "A";
                String bitacoraNombre = "Bitacora " + txtNombre.getText();
                String bitacoraCodigo = "Bitacora " + txtCodigo.getText();
                Bitacora mibitacora = new Bitacora(bitacoraNombre, bitacoraCodigo);

                for (int i = 0; i < listaTecnologiasProyecto.size(); i++) {
                    arrayTecnologias.add(listaTecnologiasProyecto.get(i));
                }

                controller.registrarProyectoUsuario(txtDescripcion.getText(), fechaInicio, arrayTecnologias, miusuario, tipo, mibitacora, txtNombre.getText(), txtCodigo.getText());

            } else {

                if (cmTipoProyecto.getSelectionModel().getSelectedItem() == "Comercial") {
                    if (cmTipoCliente.getSelectionModel().getSelectedItem() == "Juridico") {

                        LocalDate fechaInicio = LocalDate.now();
                        String tipo = "C";
                        String bitacoraNombre = "Bitacora " + txtNombre.getText();
                        String bitacoraCodigo = "Bitacora " + txtCodigo.getText();
                        Bitacora mibitacora = new Bitacora(bitacoraNombre, bitacoraCodigo);
                        ClienteJuridico micliente = cmClienteJuridico.getSelectionModel().getSelectedItem();
                        for (int i = 0; i < listaTecnologiasProyecto.size(); i++) {
                            arrayTecnologias.add(listaTecnologiasProyecto.get(i));
                        }

                        controller.registrarProyectoClienteJuridico(txtDescripcion.getText(), fechaInicio, arrayTecnologias, micliente, tipo, mibitacora, txtNombre.getText(), txtCodigo.getText());

                    }

                    if (cmTipoCliente.getSelectionModel().getSelectedItem() == "Físico") {

                        LocalDate fechaInicio = LocalDate.now();
                        String tipo = "C";
                        String bitacoraNombre = "Bitacora " + txtNombre.getText();
                        String bitacoraCodigo = "Bitacora " + txtCodigo.getText();
                        Bitacora mibitacora = new Bitacora(bitacoraNombre, bitacoraCodigo);
                        ClienteFisico micliente = cmClienteFisico.getSelectionModel().getSelectedItem();
                        for (int i = 0; i < listaTecnologiasProyecto.size(); i++) {
                            arrayTecnologias.add(listaTecnologiasProyecto.get(i));
                        }

                        controller.registrarProyectoClienteFisico(txtDescripcion.getText(), fechaInicio, arrayTecnologias, micliente, tipo, mibitacora, txtNombre.getText(), txtCodigo.getText());

                    }

                }

            }

            Parent blah = FXMLLoader.load(getClass().getResource("../fxml/Proyectos.fxml"));
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

            Parent blah = FXMLLoader.load(getClass().getResource("../fxml/Proyectos.fxml"));
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

    public void tipoProyecto(ActionEvent event) {
        if (cmTipoProyecto.getSelectionModel().getSelectedItem() == "Comercial") {
            labelTipoCliente.setVisible(true);
            cmTipoCliente.setVisible(true);

        } else {
            cmTipoCliente.setVisible(false);
            labelTipoCliente.setVisible(false);
            cmClienteJuridico.setVisible(false);
            labelJuridico.setVisible(false);
            cmClienteFisico.setVisible(false);
            labelFisico.setVisible(false);
            cmClienteJuridico.getSelectionModel().clearSelection();
            cmClienteFisico.getSelectionModel().clearSelection();
            cmTipoCliente.getSelectionModel().clearSelection();
            labelClienteJuridico.setText("");
            labelClienteFisico.setText("");
            tipoClienteLabel.setText("");
            Validation.comboBoxNoRed(cmClienteFisico);
            Validation.comboBoxNoRed(cmClienteJuridico);
            Validation.comboBoxNoRed(cmTipoCliente);
        }
    }

    public void tipoCliente(ActionEvent event) {
        if (cmTipoCliente.getSelectionModel().getSelectedItem() == "Juridico") {
            cmClienteJuridico.setVisible(true);
            labelJuridico.setVisible(true);
        } else {
            cmClienteJuridico.setVisible(false);
            labelJuridico.setVisible(false);
            cmClienteJuridico.getSelectionModel().clearSelection();
        }

        if (cmTipoCliente.getSelectionModel().getSelectedItem() == "Físico") {
            labelFisico.setVisible(true);
            cmClienteFisico.setVisible(true);
        } else {
            cmClienteFisico.setVisible(false);
            labelFisico.setVisible(false);
            cmClienteFisico.getSelectionModel().clearSelection();
        }

    }

    public void quitarPanel(ActionEvent event) {
        if (event.getSource() == btnEntendido) {
            errorPane.setVisible(false);
        }
    }

    public void eliminarTecnologia(ActionEvent event) {

        tblTecnologias.getSelectionModel().getSelectedItem();
        if (tblTecnologias.getSelectionModel().getSelectedItem() == null) {
            errorPane.setVisible(true);
        } else {
            listaTecnologiasProyecto.remove(tblTecnologias.getSelectionModel().getSelectedIndex());
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        listaTecnologias = FXCollections.observableArrayList();
        listaTipo = FXCollections.observableArrayList("Academico", "Comercial");
        listaTipoCliente = FXCollections.observableArrayList("Juridico", "Físico");
        ClienteJuridico = FXCollections.observableArrayList();
        ClienteFisico = FXCollections.observableArrayList();
        try {
            controller.llenarTecnologias(listaTecnologias);
            controller.llenarTablaClienteJuridico(ClienteJuridico);
            controller.llenarTablaClienteFisico(ClienteFisico);
        } catch (Exception ex) {
            Logger.getLogger(ControllerProyecto.class.getName()).log(Level.SEVERE, null, ex);
        }
        cmTecnologias.setItems(listaTecnologias);
        cmTipoProyecto.setItems(listaTipo);
        cmClienteJuridico.setItems(ClienteJuridico);
        cmClienteFisico.setItems(ClienteFisico);
        cmTipoCliente.setItems(listaTipoCliente);
        cmTipoCliente.setPromptText("Seleccione un tipo de cliente");
        cmTecnologias.setPromptText("Seleccione una tecnología");
        cmTipoProyecto.setPromptText("Seleccione el tipo");
        cmClienteJuridico.setPromptText("Seleccione un cliente");
        cmClienteFisico.setPromptText("Seleccione un cliente");
        listaTecnologiasProyecto = FXCollections.observableArrayList();
    }

}
