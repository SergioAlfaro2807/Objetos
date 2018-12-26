/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.ucenfotec.tl;

import cr.ac.ucenfotec.bl.Actividad;
import cr.ac.ucenfotec.bl.Bitacora;
import cr.ac.ucenfotec.bl.ClienteFisico;
import cr.ac.ucenfotec.bl.ClienteJuridico;
import cr.ac.ucenfotec.bl.Contacto;
import cr.ac.ucenfotec.bl.Proyecto;
import cr.ac.ucenfotec.bl.Tecnologia;
import cr.ac.ucenfotec.bl.Usuario;
import cr.ac.ucenfotec.dl.MultiActividad;
import cr.ac.ucenfotec.dl.MultiBitacora;
import cr.ac.ucenfotec.dl.MultiClienteFisico;
import cr.ac.ucenfotec.dl.MultiClienteJuridico;
import cr.ac.ucenfotec.dl.MultiContacto;
import cr.ac.ucenfotec.dl.MultiProyecto;
import cr.ac.ucenfotec.dl.MultiTecnologia;
import cr.ac.ucenfotec.dl.MultiUsuario;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Random;
import javafx.collections.ObservableList;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.apache.commons.codec.digest.DigestUtils;

/**
 * Inicio de la clase gestor que está conectado con la interfaz y la capa lógica
 *
 * @author Sergio Alfaro Blanco
 * @version 16/12/2018
 */
public class Gestor {

    final String username = "cloudtimepoo@gmail.com ";
    final String password = "Andrey2807";

    /**
     * Este metodo registra al nuevo usuario, recibe los parámetros y los
     * registra en la base de datos
     *
     * @param nombre Es el nombre del usuario
     * @param primerApellido Es el primer apellido del nuevo usuario
     * @param segundoApellido Es el segundo apellido del nuevo usuario
     * @param correo Es el correo del nuevo usuario
     * @param cedula Es la identificacion del nuevo usuario
     * @param genero Es el genero del nuevo usuario
     * @param avatar Es el avatar del nuevo usuario
     * @param contrasenna Es la contrasenna del nuevo usuario
     * @throws Exception
     */
    public void registrarUsuario(String nombre, String primerApellido, String segundoApellido, String correo, String cedula, String genero, String avatar, String contrasenna) throws Exception {
        Usuario miusuario = (new MultiUsuario()).crearUsuario(nombre, primerApellido, segundoApellido, correo, cedula, genero, avatar, contrasenna);
    }
    
    /**
     * Este metodo recibe una identificacion y verifica si existe en la base de datos
     * @param cedula Es la cedula del usuario que desea registrarse
     * @return retorna un boolean que dice si existe la identificacion o no, si existe devuelve un true
     * @throws Exception 
     */
    public boolean buscarUsuario(String cedula) throws Exception {
        boolean existe = true;
        Usuario miusuario = (new MultiUsuario()).buscarUsuario(cedula);

        if (miusuario == null) {
            existe = false;
        }

        return existe;
    }

    /**
     * Este metodo recibe un correo y verifica si existe en la base de datos
     * @param correo Es el correo del usuario que desea registrarse
     * @return retorna un boolean que dice si existe el correo o no, si existe devuelve un true
     * @throws Exception 
     */
    public boolean buscarCorreo(String correo) throws Exception {
        boolean existe = true;
        Usuario miusuario = (new MultiUsuario()).buscarCorreo(correo);

        if (miusuario == null) {
            existe = false;
        }

        return existe;
    }
    
    /**
     * Este metodo recibe un avatar y verifica si existe en la base de datos
     * @param avatar Es el avatar del usuario que desea registrarse
     * @return retorna un boolean que dice si existe el avatar o no, si existe devuelve un true
     * @throws Exception 
     */
    public boolean buscarAvatar(String avatar) throws Exception {
        boolean existe = true;
        Usuario miusuario = (new MultiUsuario()).buscarAvatar(avatar);

        if (miusuario == null) {
            existe = false;
        }

        return existe;
    }
    
    /**
     * Este metodo recibe el correo y la contrasenna del usuario que se está intentando logear, si el usuario existe y sus datos coinciden
     * en la base de datos
     * @param correo El correo del usuario que se esta intentando logear
     * @param contrasenna Es la contrasenna del usuario que se esta intentando logear
     * @return retorna un boolean que dice si existe el usuario o no, si existe devuelve un true
     * @throws Exception 
     */
    public boolean buscarUsuarioExistente(String correo, String contrasenna) throws Exception {
        boolean existe = true;
        String contrasennaEncriptada = DigestUtils.md5Hex(contrasenna);

        Usuario miusuario = (new MultiUsuario()).buscarUsuarioExistente(correo, contrasennaEncriptada);

        if (miusuario == null) {
            existe = false;
        }

        return existe;
    }
    /**
     * Este metodo recibe la contrasenna encriptada del usuario logeado para poder mostrar sus respectivos datos
     * @param contrasenna Es la contrasenna del usuario logeada (encriptada)
     * @return retorna un Usuario solamente con su contrasenna
     * @throws Exception 
     */
    public Usuario buscarUsuarioLogeado(String contrasenna) throws Exception {

        Usuario miusuario = (new MultiUsuario()).buscarUsuarioLogeado(contrasenna);
   
        return miusuario;
    }

    /**
     * Este metodo registrar una nueva actividad pero sin su fecha y lo registra en la base de datos
     * @param nombre Es el nombre de la nueva actividad
     * @param codigo Es el codigo de la nueva actividad
     * @param descripcion Es la descripcion de la nueva actividad
     * @param bitacora Es la bitacora asociada a la actividad
     * @throws Exception 
     */
    public void registrarActividadSinFecha(String nombre, String codigo, String descripcion, String bitacora) throws Exception {
        Actividad miactividad = (new MultiActividad()).registrarActividadSinFecha(nombre, codigo, descripcion, bitacora);
    }
    
    /**
     * Este metodo registra una nueva actividad pero con todos sus parametros, es el registro manual de la actividad
     * @param nombre Es el nombre de la nueva actividad
     * @param codigo Es el codigo de la nueva actividad
     * @param descripcion Es la descripcion de la nueva actividad
     * @param bitacora Es la bitacora asociada a la actividad
     * @param fechainicio Es la fecha de inicio de la actividad
     * @param horainicio Es la hora de inicio de la actividad
     * @param fechafin Es la fecha de fin de la actividad
     * @param horafin Es la hora de fin de la actividad
     * @throws Exception 
     */
    public void registrarActividadManual(String nombre, String codigo, String descripcion, String bitacora, LocalDate fechainicio, LocalTime horainicio, LocalDate fechafin, LocalTime horafin) throws Exception {
        Actividad miactividad = (new MultiActividad()).registrarActividadManual(nombre, codigo, descripcion, bitacora, fechainicio, horainicio, fechafin, horafin);
    }

    /**
     * Este metodo recibe el correo del usuario que se le ha olvidado la contrasenna y registra la nueva contrasenna en la base de datos
     * @param correo Correo del usuario que se le ha olvidado la contrasenna
     * @throws Exception 
     */
    public void recuperarContrasenna(String correo) throws Exception {
        String nuevaContrasenna1 = GenerarContrasenna();
        enviarCorreo(correo, nuevaContrasenna1);
        String nuevaContrasenna = DigestUtils.md5Hex(nuevaContrasenna1);
        Usuario miusuario = (new MultiUsuario()).modificarContrasennaCorreo(nuevaContrasenna, correo);
    }
    
    /**
     * Este metodo genera una contrasenna aleatoria para luego ser asignada como la nueva contrasenan del usuario que se le ha
     * olvidado la contrasenna
     * @return retorna una contrasenna aleatoria 
     * @throws NoSuchAlgorithmException 
     */
    public String GenerarContrasenna() throws NoSuchAlgorithmException {

        String[] symbols = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};
        int length = 10;
        Random random = SecureRandom.getInstanceStrong(); // as of JDK 8, this should return the strongest algorithm available to the JVM
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int indexRandom = random.nextInt(symbols.length);
            sb.append(symbols[indexRandom]);
        }
        String password = sb.toString();

        return password;
    }
    
    /**
     * Este metodo envia el correo al usuario que se le ha olvidado la contrasenna
     * @param correo Es el correo de usuario
     * @param nuevaContrasenna Es la nueva contrasenna generada aletariamente
     */
    public void enviarCorreo(String correo, String nuevaContrasenna) {

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {

            // Define message
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setSubject("Recuperación de la contraseña Cloud Time");
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(correo));
            message.setText("Su nueva contraseña es " + nuevaContrasenna);
            // Envia el mensaje
            Transport transport = session.getTransport();
            transport.send(message);

        } catch (Exception e) {
        }

    }

    /**
     * Este metodo modifica la contrasenna del usuario y actualiza sus datos en la base de datos
     * @param contrasennaVieja Es la contrasenna vieja del usuario (encriptada)
     * @param contrasennaNueva Es la contrasenna nueva del usuario (encriptada)
     * @throws Exception 
     */
    public void modificarContrasenna(String contrasennaVieja, String contrasennaNueva) throws Exception {
        Usuario miusuario = (new MultiUsuario()).modificarContrasenna(contrasennaVieja, contrasennaNueva);
    }
    
    /**
     * Este metodo inicia la actividad y le registra los nuevos datos a la actividad en la base de datos
     * @param miactividad Es un objeto de Actividad que trae todos los datos de la actividad
     * @throws Exception 
     */
    public void iniciarActividad(Actividad miactividad) throws Exception {
        LocalDate fechainiciada = LocalDate.now();
        LocalTime horainiciada = LocalTime.now();
        String codigoActividad = miactividad.getCodigo();
        Actividad miactividad1 = (new MultiActividad()).iniciarActividad(codigoActividad, fechainiciada, horainiciada);
    }
    
    /**
     * Este metodo termina la actividad y le registrar los nuevos datos a la actividad en la base de datos
     * @param miactividad
     * @throws Exception 
     */
    public void terminarActividad(Actividad miactividad) throws Exception {
        LocalDate fechainiciada = LocalDate.now();
        LocalTime horainiciada = LocalTime.now();
        String codigoActividad = miactividad.getCodigo();
        Actividad miactividad1 = (new MultiActividad()).terminarActividad(codigoActividad, fechainiciada, horainiciada);
    }
    
    /**
     * Este metodo recibe el codigo de la actividad y revisa que no exista otro igual
     * @param codigo Es el codigo de la nueva actividad
     * @return retorna un boolean que dice si existe el codigo o no, si existe devuelve un true
     * @throws Exception 
     */
    public boolean buscarActividad(String codigo) throws Exception {
        boolean existe = true;

        Actividad miactividad = (new MultiActividad()).buscarActividad(codigo);

        if (miactividad == null) {
            existe = false;
        }

        return existe;
    }
    
    
    /**
     * Este metodo registrar un nuevo proyecto de tipo academico, como es de tipo academico registra un proyecto asociado a un usuario
     * en la base de datos
     * @param descripcion Es la descripcion del proyecto
     * @param fechaInicio Es la fecha de inicio del proyecto
     * @param tecnologias Son las tecnologias asociadas al proyecto
     * @param miavatar Es el usuario asociado al proyecto
     * @param tipo Es el tipo de proyecto
     * @param bitacora Es la bitacora creada automaticamente al crear el proyecto
     * @param nombre Es el nombre del proyecto
     * @param codigo Es el codigo del proyecto
     * @throws Exception 
     */
    public void registrarProyectoUsuario(String descripcion, LocalDate fechaInicio, ArrayList<Tecnologia> tecnologias, Usuario miavatar, String tipo, Bitacora bitacora, String nombre, String codigo) throws Exception {
        Proyecto miproyecto = (new MultiProyecto()).registrarProyectoUsuario(descripcion, fechaInicio, miavatar, tipo, bitacora, nombre, codigo);
        Bitacora mibitacora = (new MultiBitacora()).registrarBitacora(bitacora);
        Tecnologia mitecnologia = (new MultiTecnologia()).registrarTecnologiaxProyecto(tecnologias, codigo);
    }

    /**
     * Este metodo registra un nuevo proyecto de tipo comercial pero con el cliente juridico de asociado
     * @param descripcion Es la descripcion del proyecto
     * @param fechaInicio Es la fecha de inicio del proyecto
     * @param tecnologias Son las tecnologias asociadas al proyecto
     * @param micliente Es el cliente juridico asociado al proyecto
     * @param tipo Es el tipo de proyecto
     * @param bitacora Es la bitacora creada automaticamente al crear el proyecto
     * @param nombre Es el nombre del proyecto
     * @param codigo Es el codigo del proyecto
     * @throws Exception 
     */
    public void registrarProyectoClienteJuridico(String descripcion, LocalDate fechaInicio, ArrayList<Tecnologia> tecnologias, ClienteJuridico micliente, String tipo, Bitacora bitacora, String nombre, String codigo) throws Exception {
        Proyecto miproyecto = (new MultiProyecto()).registrarProyectoClienteJuridico(descripcion, fechaInicio, micliente, tipo, bitacora, nombre, codigo);
        Bitacora mibitacora = (new MultiBitacora()).registrarBitacora(bitacora);
        Tecnologia mitecnologia = (new MultiTecnologia()).registrarTecnologiaxProyecto(tecnologias, codigo);
    }

    /**
     * Este metodo registra un nuevo proyecto de tipo comercial pero con el cliente fisico de asociado
     * @param descripcion Es la descripcion del proyecto
     * @param fechaInicio Es la fecha de inicio del proyecto
     * @param tecnologias Son las tecnologias asociadas al proyecto
     * @param micliente Es el cliente fisico asociado al proyecto
     * @param tipo Es el tipo de proyecto
     * @param bitacora Es la bitacora creada automaticamente al crear el proyecto
     * @param nombre Es el nombre del proyecto
     * @param codigo Es el codigo del proyecto
     * @throws Exception 
     */
    public void registrarProyectoClienteFisico(String descripcion, LocalDate fechaInicio, ArrayList<Tecnologia> tecnologias, ClienteFisico micliente, String tipo, Bitacora bitacora, String nombre, String codigo) throws Exception {
        Proyecto miproyecto = (new MultiProyecto()).registrarProyectoClienteFisico(descripcion, fechaInicio, micliente, tipo, bitacora, nombre, codigo);
        Bitacora mibitacora = (new MultiBitacora()).registrarBitacora(bitacora);
        Tecnologia mitecnologia = (new MultiTecnologia()).registrarTecnologiaxProyecto(tecnologias, codigo);

    }

    /**
     * Este metodo recibe un codigo el cual lo busca en la base de datos para verificar si existe
     * @param codigo Es el codigo del proyecto
     * @return retorna un boolean que dice si existe el codigo o no, si existe devuelve un true
     * @throws Exception 
     */
    public boolean buscarProyecto(String codigo) throws Exception {
        boolean existe = true;

        Proyecto miproyecto = (new MultiProyecto()).buscarProyecto(codigo);

        if (miproyecto == null) {
            existe = false;
        }

        return existe;

    }
    
    /**
     * Este metodo registra un nuevo cliente fisico
     * @param primerApellido Primer apellido del cliente
     * @param segundoApellido Segundo apellido del cliente
     * @param correo Correo del cliente
     * @param telefono Telefono del cliente
     * @param provincia Provincia del cliente
     * @param canton Canton del cliente
     * @param distrito Distrito del cliente
     * @param direccionExacta Direccion exacta del cliente
     * @param primerNombre Primer nombre del cliente
     * @throws Exception 
     */
    public void registrarClienteFisico(String primerApellido, String segundoApellido, String correo, String telefono, String provincia, String canton, String distrito, String direccionExacta, String primerNombre) throws Exception {
        ClienteFisico miClienteFisico = (new MultiClienteFisico()).crearClienteFisico(primerApellido, segundoApellido, correo, telefono, provincia, canton, distrito, direccionExacta, primerNombre);
    }
    
    /**
     * Este metodo recibe un correo el cual lo busca en la base de datos para verificar si existe
     * @param correo Correo del cliente fisico
     * @return retorna un boolean que dice si existe el correo o no, si existe devuelve un true
     * @throws Exception 
     */
    public boolean buscarClienteFisico(String correo) throws Exception {
        boolean existe = true;

        ClienteFisico miclienteFisico = (new MultiClienteFisico()).buscarClienteFisico(correo);

        if (miclienteFisico == null) {
            existe = false;
        }

        return existe;
    }
    
    /**
     * Este metodo recibe un telefono el cual lo busca en la base de datos para verificar si existe
     * @param telefono Telefono del cliente fisico
     * @return retorna un boolean que dice si existe el telefono o no, si existe devuelve un true
     * @throws Exception 
     */
    public boolean buscarClienteFisicoTelefono(String telefono) throws Exception {
        boolean existe = true;

        ClienteFisico miclienteFisico = (new MultiClienteFisico()).buscarClienteFisicoTelefono(telefono);

        if (miclienteFisico == null) {
            existe = false;
        }

        return existe;
    }

    
    /**
     * Este metodo recibe un ObservableList vacio el cual lo llena con todos los clientes fisicos registrados en la base de datos
     * @param lista Es una lista vacia de clientes fisicos
     * @return retorna una lista llena de todos los cliente fisicos de la base de datos
     * @throws Exception 
     */
    public ObservableList<ClienteFisico> llenarTablaClienteFisico(ObservableList<ClienteFisico> lista) throws Exception {

        lista = (new MultiClienteFisico()).buscarClientesFisicos(lista);

        return lista;

    }
    
    /**
     * Este metodo recibe un ObservableList vacio el cual lo llena con todos los clientes juridicos registrados en la base de datos
     * @param lista Es una lista vacia de clientes juridicos
     * @return retorna una lista llena de todos los cliente juridicos de la base de datos
     * @throws Exception 
     */ 
    public ObservableList<ClienteJuridico> llenarTablaClienteJuridico(ObservableList<ClienteJuridico> lista) throws Exception {

        lista = (new MultiClienteJuridico()).buscarClientesJuridicos(lista);

        return lista;

    }
    
    /**
     * Este metodo recibe un ObservableList vacio el cual lo llena con todos los proyectos registrados en la base de datos
     * @param lista Es una lista vacia de proyectos
     * @return retorna una lista llena de todos los proyectos de la base de datos
     * @throws Exception 
     */
    public ObservableList<Proyecto> llenarTablaProyectos(ObservableList<Proyecto> lista) throws Exception {

        lista = (new MultiProyecto()).buscarProyectos(lista);

        return lista;

    }
    
    /**
     * Este metodo recibe un cliente fisico el cual será eliminado de la base de datos
     * @param miclienteFisico El cliente fisico que sera eliminado
     * @throws Exception 
     */
    public void eliminarClienteFisico(ClienteFisico miclienteFisico) throws Exception {

        ClienteFisico miclienteFisicoEliminar = (new MultiClienteFisico()).eliminarClienteFisico(miclienteFisico);

    }

    /**
     * Este metodo recibe los datos del cliente fisico el cual se desea modificar y se actualiza en la base de datos
     * @param miclienteFisico Son los datos modificados
     * @param correoModificar Es el correo que se buscara en la base de datos para que sea actualizado
     * @throws Exception 
     */
    public void modificarClienteFisico(ClienteFisico miclienteFisico, String correoModificar) throws Exception {
        ClienteFisico miClienteFisicoModificar = (new MultiClienteFisico()).modificarClienteFisico(miclienteFisico.getPrimerApellido(), miclienteFisico.getSegundoApellido(), miclienteFisico.getCorreo(), miclienteFisico.getTelefono(), miclienteFisico.getProvincia(), miclienteFisico.getCanton(), miclienteFisico.getDistrito(), miclienteFisico.getDireccionExacta(), miclienteFisico.getNombre(), correoModificar);
    }
    
    /**
     * Este metodo registra un nuevo cliente juridico junto con su contacto
     * @param cedula Cedula del cliente
     * @param cedulaContacto Cedula del contacto
     * @param primerNombre Primer nombre del cliente
     * @param provincia Provincia del cliente
     * @param canton Canton del cliente
     * @param distrito Distrito del cliente
     * @param direccionExacta Direccion exacta del cliente
     * @param telefono Telefono del cliente
     * @throws Exception 
     */
    public void registrarClienteJuridico(String cedula, String cedulaContacto, String primerNombre, String provincia, String canton, String distrito, String direccionExacta, String telefono) throws Exception {
        Contacto micontacto = new Contacto(cedulaContacto);
        ClienteJuridico miclientejuridico = (new MultiClienteJuridico()).registrarClienteJuridico(cedula, micontacto, primerNombre, provincia, canton, distrito, direccionExacta, telefono);
    }
    
    /**
     * Este metodo modifica un cliente, recibe sus nuevos datos y su identificacion anterior para ser acutlizado en la base de datos
     * @param cedula Cedula cliente
     * @param cedulaContacto Cedula contacto
     * @param primerNombre Primer nombre cliente 
     * @param provincia Provincia del cliente
     * @param canton Canton del cliente
     * @param distrito Distrito del cliente
     * @param direccionExacta Direccion exacta del cliente
     * @param telefono Telefono del cliente
     * @param identificacionBuscar Identifiacion para buscar en la base datos
     * @throws Exception 
     */
    public void modificarClienteJuridico(String cedula, String cedulaContacto, String primerNombre, String provincia, String canton, String distrito, String direccionExacta, String telefono, String identificacionBuscar) throws Exception {
        Contacto micontacto = new Contacto(cedulaContacto);
        ClienteJuridico miclientejuridico = (new MultiClienteJuridico()).modificarClienteJuridico(cedula, micontacto, primerNombre, provincia, canton, distrito, direccionExacta, telefono, identificacionBuscar);
    }

    /**
     * Este metodo recibe un telefono el cual verifica si existe entren todos los clientes juridicos de la base de datos
     * @param telefono Es el telefono del cliente juridico
     * @return retorna un boolean que dice si existe el telefono o no, si existe devuelve un true
     * @throws Exception 
     */
    public boolean buscarClienteJuridicoTelefono(String telefono) throws Exception {
        boolean existe = true;

        ClienteJuridico miclienteJuridico = (new MultiClienteJuridico()).buscarClienteJuridicoTelefono(telefono);

        if (miclienteJuridico == null) {
            existe = false;
        }

        return existe;
    }

    /**
     * Este metodo recibe una identificacion la cual verifica si existe entre todos los clientes juridicos de la base de datos
     * @param identificacion Es la identificacion del cliente juridico
     * @return retorna un boolean que dice si existe la identificacion o no, si existe devuelve un true
     * @throws Exception 
     */
    public boolean buscarClienteJuridicoIdentificacion(String identificacion) throws Exception {
        boolean existe = true;

        ClienteJuridico miclienteJuridico = (new MultiClienteJuridico()).buscarClienteJuridicoIdentificacion(identificacion);

        if (miclienteJuridico == null) {
            existe = false;
        }

        return existe;
    }

    /**
     * Este metodo recibe un cliente juridico el cual será eliminado de la base de datos
     * @param miclienteJuridico Es el cliente juridico que sera eliminado
     * @throws Exception 
     */
    public void eliminarClienteJuridico(ClienteJuridico miclienteJuridico) throws Exception {

        ClienteJuridico miclienteJuridicoS = (new MultiClienteJuridico()).eliminarClienteJuridico(miclienteJuridico);

    }

    /**
     * Este metodo recibe un contacto el cual será eliminado de la base de datos
     * @param miclienteJuridico Es el contacto que sera eliminado
     * @throws Exception 
     */
    public void eliminarContacto(ClienteJuridico miclienteJuridico) throws Exception {

        String cedulaContacto = miclienteJuridico.getMicontacto().getCedula();
        Contacto micontacto = (new MultiContacto()).eliminarContacto(cedulaContacto);

    }
    
    /**
     * Este metodo recibe los datos respectivos para registrar un contacto en la base de datos
     * @param nombre Nombre del contacto
     * @param primerApellido Primer apellido del contacto
     * @param segundoApellido Segundo apellido del contacto
     * @param cedula Identificacion del contacto
     * @param telefono Telefono del contacto
     * @param correo Correo del contacto
     * @throws Exception 
     */
    public void registrarContacto(String nombre, String primerApellido, String segundoApellido, String cedula, String telefono, String correo) throws Exception {
        Contacto micontacto = (new MultiContacto()).registrarContacto(nombre, primerApellido, segundoApellido, cedula, telefono, correo);
        // logica.registrarContacto(micontacto);
    }
    
    /**
     * Este metodo recibe todos los datos respecitovos para actualizar un contacto en la base de datos
     * @param nombre Nombre del contacto
     * @param primerApellido Primer apellido del contacto
     * @param segundoApellido Segundo apellido del contacto
     * @param cedula Identificacion del contacto
     * @param telefono Telefono del contacto
     * @param correo Correo del contacto
     * @param identificacionBuscar La identificacion para buscar y actualizar
     * @throws Exception 
     */
    public void modificarContacto(String nombre, String primerApellido, String segundoApellido, String cedula, String telefono, String correo, String identificacionBuscar) throws Exception {
        Contacto micontacto = (new MultiContacto()).modificarContacto(nombre, primerApellido, segundoApellido, cedula, telefono, correo, identificacionBuscar);
        // logica.registrarContacto(micontacto);
    }

    /**
     * Este metodo recibe una identificacion la cual verifica si existe entre todos los contactos de la base de datos
     * @param identificacion
     * @return retorna un boolean que dice si existe la identificacion o no, si existe devuelve un true
     * @throws Exception 
     */
    public boolean buscarContactoIdentificacion(String identificacion) throws Exception {
        boolean existe = true;

        Contacto micontacto = (new MultiContacto()).buscarContactoIdentificacion(identificacion);

        if (micontacto == null) {
            existe = false;
        }

        return existe;
    }

    /**
     * Este metodo recibe un telefono la cual verifica si existe entre todos los contactos de la base de datos
     * @param telefono
     * @return retorna un boolean que dice si existe la identificacion o no, si existe devuelve un true
     * @throws Exception 
     */
    public boolean buscarContactoTelefono(String telefono) throws Exception {
        boolean existe = true;

        Contacto micontacto = (new MultiContacto()).buscarContactoTelefono(telefono);

        if (micontacto == null) {
            existe = false;
        }

        return existe;
    }

    /**
     * Este metodo recibe un correo la cual verifica si existe entre todos los contactos de la base de datos
     * @param correo
     * @return retorna un boolean que dice si existe la identificacion o no, si existe devuelve un true
     * @throws Exception 
     */
    public boolean buscarContactoCorreo(String correo) throws Exception {
        boolean existe = true;

        Contacto micontacto = (new MultiContacto()).buscarContactoCorreo(correo);

        if (micontacto == null) {
            existe = false;
        }

        return existe;
    }

    /**
     * Este metodo recibe un identificacion la cual buscare etre todos los contactos de la base de datos
     * @param identificacion la identificacion a buscar
     * @return retorna el un objeto contacto con todos sus datos
     * @throws Exception 
     */
    public Contacto buscarContacto(String identificacion) throws Exception {

        Contacto micontacto = (new MultiContacto()).buscarContacto(identificacion);

        return micontacto;
    }

    /**
     * Este metodo recibe los datos respectivos para registrar una nueva tecnologia
     * @param nombre Nombre de la tecnologia
     * @param codigo Codigo de la tecnologia
     * @throws Exception 
     */
    public void registrarTecnologia(String nombre, String codigo) throws Exception {
        Tecnologia mitecnolgoia = (new MultiTecnologia()).registrarTecnologia(nombre, codigo);
    }

    /**
     * Este metodo recibe los datos respectivos para modificar una tecnologia
     * @param nombre Nombre de la tecnoliga
     * @param codigo Codigo de la tecnologia
     * @param codigoModificar Es el codigo el cual sera buscado y actualizado en la base de datos
     * @throws Exception 
     */
    public void modificarTecnologia(String nombre, String codigo, String codigoModificar) throws Exception {
        Tecnologia mitecnolgoia = (new MultiTecnologia()).modificarTecnologia(nombre, codigo, codigoModificar);
    }

    /**
     * Este metodo recibe una tecnologia la cual sera eliminada en la base de datos
     * @param mitecnologia Tecnologia que sera eliminada
     * @throws Exception 
     */
    public void eliminarTecnologia(Tecnologia mitecnologia) throws Exception {
        Tecnologia mitecnolgoia = (new MultiTecnologia()).eliminarTecnologia(mitecnologia.getNombre(), mitecnologia.getCodigo());
    }


    /**
     * Este metodo recibe un ObservableList vacio el cual lo llena con todas las tecnologias registradas en la base de datos
     * @param lista lista vacia de tecnologias
     * @return Es una lista vacia de proyectos
     * @throws Exception 
     */
    public ObservableList<Tecnologia> llenarTablaTecnologia(ObservableList<Tecnologia> lista) throws Exception {

        lista = (new MultiTecnologia()).buscarTecnologias(lista);

        return lista;

    }
    
    /**
     * Este metodo recibe un ObservableList vacio el cual lo llena con todas las actividades registradas en la base de datos y que coincida con su bitacora respectiva
     * @param lista lista vacia de actividades
     * @param nombreBitacora bitacora asociada a esas actividades
     * @return retorna una lista con todas las actividades de su respectiva bitacora
     * @throws Exception 
     */
    public ObservableList<Actividad> llenarActividades(ObservableList<Actividad> lista, String nombreBitacora) throws Exception {

        lista = (new MultiActividad()).buscarActividades(lista, nombreBitacora);

        return lista;

    }

    /**
     * Este metodo recibe un ObservableList vacio el cual lo llena con todas las tecnologias registradas en la base de datos y que coicidan con su respectivo proyecto
     * @param lista
     * @param codigo
     * @return
     * @throws Exception 
     */
    public ObservableList<Tecnologia> buscarTecnologiasProyecto(ObservableList<Tecnologia> lista, String codigo) throws Exception {

        lista = (new MultiProyecto()).buscarTecnologiasProyecto(lista, codigo);

        return lista;

    }

    /**
     * Este metodo recibe dos arraylist uno con la lista de tecnologias que eran las que estaban asociadas al proyecto 
     * y otra que son las nuevas tecnologias que seran asignadas al proyecto
     * @param listaVieja lista de tecnologias viejas
     * @param listaNueva lista de tecnologias nuevas
     * @param codigo codigo del proyecto asociado
     * @return retorna una tecnologia con sus respectivos datos
     * @throws Exception 
     */
    public Tecnologia modificarProyectoxTecnologia(ArrayList<Tecnologia> listaVieja, ArrayList<Tecnologia> listaNueva, String codigo) throws Exception {

        Tecnologia mitecnologia = (new MultiProyecto()).eliminarTecnologiaxProyecto(listaVieja, codigo);
        Tecnologia mitecnologia1 = (new MultiTecnologia()).registrarTecnologiaxProyecto(listaNueva, codigo);
        return mitecnologia1;
    }
    
    /**
     * Este metodo recibe los datos respectivos para actulizar un proyecto
     * @param descripcion descripcion del proyecto
     * @param nombre Nombre del proyecto
     * @param codigo Codigo del proyecto
     * @param codigoModificar Codigo para actualizar el proyecto respectivo
     * @throws Exception 
     */
    public void modificarProyecto(String descripcion, String nombre, String codigo, String codigoModificar) throws Exception {
        Proyecto miproyecto = (new MultiProyecto()).modificarProyecto(descripcion, nombre, codigo, codigoModificar);
    }

    /**
     * Este metodo recibe los datos respectivos para actulizar una bitacora
     * @param BitacoraNueva Es la bitacora que sera registrada
     * @param BitacoraVieja Es la bitacora que sera actualizada
     * @throws Exception 
     */
    public void modificarBitacora(String BitacoraNueva, String BitacoraVieja) throws Exception {
        Bitacora mibitacora = (new MultiBitacora()).modificarBitacora(BitacoraVieja, BitacoraNueva);
    }

    /**
     * Este metodo recibe un proyecto que sera eliminado en la base de datos
     * @param miproyecto Proyecto que sera eliminado
     * @throws Exception 
     */
    public void eliminarProyecto(Proyecto miproyecto) throws Exception {
        String miproyectoCodigo = miproyecto.getCodigo();
        Proyecto miproyecto1 = (new MultiProyecto()).eliminarProyecto(miproyectoCodigo);
    }

    /**
     * Este metodo recibe un proyecto para eliminar todas las tecnologias asociadas a el
     * @param miproyecto Proyecto que sera eliminado
     * @throws Exception 
     */
    public void eliminarTecnologiaProyecto(Proyecto miproyecto) throws Exception {
        String miproyectoCodigo = miproyecto.getCodigo();
        Tecnologia mitecnologia = (new MultiTecnologia()).eliminarTecnologiaProyecto(miproyectoCodigo);
    }

    /**
     * Este metodo recibe un proyecto para eliminar su bitacora asociada
     * @param miproyecto Proyecto que sera eliminado
     * @throws Exception 
     */
    public void eliminarBitacora(Proyecto miproyecto) throws Exception {
        String miproyectoNombre = miproyecto.getNombre();
        String bitacoraNombre = "Bitacora " + miproyectoNombre;
        Bitacora mibitacora = (new MultiBitacora()).eliminarBitacora(bitacoraNombre);
    }

    /**
     * Este metodo recibe un codigo el cual sera buscado entre todas las tecnologias de la base de datos
     * @param codigo Codigo tecnologia
     * @return retorna un boolean que dice si existe el codigo o no, si existe devuelve un true
     * @throws Exception 
     */
    public boolean buscarTecnologia(String codigo) throws Exception {
        boolean existe = true;
        Tecnologia mitecnolgoia = (new MultiTecnologia()).buscarTecnologia(codigo);

        if (mitecnolgoia == null) {
            existe = false;
        }

        return existe;
    }

    /**
     * Este metodo recibe un ObservableList el cual es llenado con todas las tecnologias de la base de datos
     * @param listaTecnologia lista de tecnologias
     * @throws Exception 
     */
    public void llenarTecnologias(ObservableList listaTecnologia) throws Exception {
        listaTecnologia = (new MultiTecnologia()).llenarTecnologia(listaTecnologia);
    }



}
