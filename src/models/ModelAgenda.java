/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 *@author Jose Felix
 */
public class ModelAgenda {

    private Connection conexion;
    private Statement st;
    private ResultSet rs;

    private String nombre;
    private String email;
    private String id_contactos;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
     public String getId_contactos() {
        return id_contactos;
    }

    public void setId_contactos(String id_contactos) {
        this.id_contactos = id_contactos;
    }

    /**
     * Método que realiza las siguietnes acciones:
     * 1.- Conecta con la base agenda_mvc.
     * 2.- Consulta todo los registros de la tabla contactos.
     * 3.- Obtiene el nombre y el email y los guarda en las variables globales
     * nombre y email.
     */
    public void conectarDB() {
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3307/agenda_mvc", "user_mvc", "pass_mvc.2018");
            st = conexion.createStatement();
            rs = st.executeQuery("SELECT * FROM contactos;");
            rs.next();
            llenarDatos();
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Error ModelAgenda 01: " + err.getMessage());
        }

    }
    public void llenarDatos(){
        try {
            nombre = rs.getString("nombre");
            email = rs.getString("email");
            id_contactos = rs.getString("id_contacto");
        } catch (SQLException ex) {
            Logger.getLogger(ModelAgenda.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    /**
     * Método que realiza las siguiente acciones:
     * 1.- Moverse al primer registro
     * 2.- obtener el valor del nombre de rs y guardarlo en la variable nombre
     * 3.- obtener el valor del email de rs y guardarlo en la variable email
     */
    public void moverPrimerRegistro(){
        try {
            rs.first();
            llenarDatos();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error 02" + ex.getMessage());
        }
    }
    
    /**
     * Método que realiza las siguiente acciones:
     * 1.- Moverse al siguiente registro
     * 2.- obtener el valor del nombre de rs y guardarlo en la variable nombre
     * 3.- obtener el valor del email de rs y guardarlo en la variable email
     */
    public void moverSiguienteRegistro(){
        try {
            if (!rs.isLast()) {
                rs.next();
                llenarDatos();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error 03" + ex.getMessage());
        }
    }
    
    /**
     * Método que realiza las siguiente acciones:
     * 1.- Moverse al anterior registro
     * 2.- obtener el valor del nombre de rs y guardarlo en la variable nombre
     * 3.- obtener el valor del email de rs y guardarlo en la variable email
     */
    public void moverAnteriorRegistro(){
         try {
            if (!rs.isFirst()) {
                rs.previous();
                llenarDatos();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error 04" + ex.getMessage());
        }
    }
    
    /**
     * Método que realiza las siguiente acciones:
     * 1.- Moverse al ultimo registro
     * 2.- obtener el valor del nombre de rs y guardarlo en la variable nombre
     * 3.- obtener el valor del email de rs y guardarlo en la variable email
     */
    public void moverUltimoRegistro(){
        try {
            rs.last();
            llenarDatos();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error 05" + ex.getMessage());
        }
    }
    /**
     * Permite guadar en la base de datos, un nuevo registro en la tabla contactos, con los valores que tiene la variable nombre e imail 
     */
    public void insertarRegistro(){ 
        try {
            st.executeUpdate("insert into contactos(nombre,email)"+" values ('"+nombre+"','"+email+"');");
        } catch (SQLException ex) {
            Logger.getLogger(ModelAgenda.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null,"Se a guardado el contacto");
    }
    /**
     * Permite eliminar un registrio de la base de datos de la tabla contactos, toma el valos de la variable id_contacos, compara si existe en la base de datos y lo borra
     */
    public void eliminarRegistro(){
        try {
            st.executeUpdate("delete from contactos where id_contacto='" +id_contactos+ "';");
            JOptionPane.showMessageDialog(null, "Se borro el contacto");
            
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Error " + err.getMessage());
        }
    }
    /**
     * Permite actualizar un registro de la base de datos, tomando los valores de las variables nombre e imail y lo actualiza en la base de datos.
     */
    public void guardarRegistro(){
        String sql = ("update contactos set nombre='" +nombre+ "', email='" +email+ "' where id_contacto='" +id_contactos+ "';");
        try {
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ModelAgenda.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null,"El contacto fue actualizado");
    }

   
}
