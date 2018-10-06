/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.ModelAgenda;
import views.ViewAgenda;

/**
 *
 * @author Jose Felix
 */
public class ControllerAgenda {

    ModelAgenda modelAgenda;
    ViewAgenda viewAgenda;

    /**
     * Objeto de tipo ActionListener para atrapar los eventos actionPerformed y
     * llamar a los metodos para ver los registros almacenados en la bd.
     */
    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == viewAgenda.jbtn_primero) {
                jbtn_primero_actionPerformed();
            } else if (e.getSource() == viewAgenda.jbtn_anterior) {
                jbtn_anterior_actionPerformed();
            } else if (e.getSource() == viewAgenda.jbtn_siguiente) {
                jbtn_siguiente_actionPerformed();
            } else if (e.getSource() == viewAgenda.jbtn_ultimo) {
                jbtn_ultimo_actionPerformed();
            } else if (e.getSource() == viewAgenda.jbtn_nuevo) {
                jbtn_nuevo_actionPerformed();
            } else if (e.getSource() == viewAgenda.jbtn_insertar) {
                jbtn_insertar_actionPerformed();
            } else if (e.getSource() == viewAgenda.jbtn_modificar) {
                jbtn_modificar_actionPerformed();
            } else if (e.getSource() == viewAgenda.jbtn_eliminar) {
                jbtn_eliminar_actionPerformed();
            } else if (e.getSource() == viewAgenda.jbtn_guardar) {
                jbtn_guardar_actionPerformed();
            } else if (e.getSource() == viewAgenda.jbtn_cancelar) {
                jbtn_cancelar_actionPerformed();
            }

        }

    };

    /**
     * Constructor de Controlador para unir el ModelAgenda y ViewAgenda
     *
     * @param modelAgenda objeto de tipo ModelAgenda
     * @param viewAgenda objeto de tipo ViewAgenda
     */
    public ControllerAgenda(ModelAgenda modelAgenda, ViewAgenda viewAgenda) {
        this.modelAgenda = modelAgenda;
        this.viewAgenda = viewAgenda;
        initComponents();
        setActionListener();
        initDB();
    }

    /**
     * Método que llama al método conectarBD del modelo y muestra el nombre y
     * email del primer registro en las cajas de texto de ViewAgenda.
     */
    public void initDB(){
        modelAgenda.conectarDB();
        viewAgenda.jtf_nombre.setText(modelAgenda.getNombre());
        viewAgenda.jtf_email.setText(modelAgenda.getEmail());
        viewAgenda.jtf_id_contactos.setText(modelAgenda.getId_contactos());
    }
    /**
     * Metodo para inicializar la ViewAgenda
     */
    public void initComponents() {
        viewAgenda.jbtn_insertar.setVisible(false);
        viewAgenda.jbtn_cancelar.setVisible(false);
        viewAgenda.jbtn_guardar.setVisible(false);
        viewAgenda.jtf_id_contactos.setVisible(false);
        viewAgenda.setLocationRelativeTo(null);
        viewAgenda.setTitle("Agenda MVC");
        viewAgenda.setVisible(true);
    }

    /**
     * Método para agregar el actionListener a cada boton de la vista
     */
    public void setActionListener() {
        viewAgenda.jbtn_primero.addActionListener(actionListener);
        viewAgenda.jbtn_anterior.addActionListener(actionListener);
        viewAgenda.jbtn_siguiente.addActionListener(actionListener);
        viewAgenda.jbtn_ultimo.addActionListener(actionListener);
        viewAgenda.jbtn_nuevo.addActionListener(actionListener);
        viewAgenda.jbtn_insertar.addActionListener(actionListener);
        viewAgenda.jbtn_modificar.addActionListener(actionListener);
        viewAgenda.jbtn_eliminar.addActionListener(actionListener);
        viewAgenda.jbtn_cancelar.addActionListener(actionListener);
        viewAgenda.jbtn_guardar.addActionListener(actionListener);
    }

    /**
     * Método para ver el primer registro de la tabla contactos
     */
    private void jbtn_primero_actionPerformed() {
        modelAgenda.moverPrimerRegistro();
        viewAgenda.jtf_nombre.setText(modelAgenda.getNombre());
        viewAgenda.jtf_email.setText(modelAgenda.getEmail());
        viewAgenda.jtf_id_contactos.setText(modelAgenda.getId_contactos());
        //invocar al metodo moverPrimerRegistro
        //mostrar nombre en la vista
        //mostar email en la vista
    }

    /**
     * Método para ver el registro anterior de la tabla contactos
     */
    private void jbtn_anterior_actionPerformed() {
        modelAgenda.moverAnteriorRegistro();
        viewAgenda.jtf_nombre.setText(modelAgenda.getNombre());
        viewAgenda.jtf_email.setText(modelAgenda.getEmail());
        viewAgenda.jtf_id_contactos.setText(modelAgenda.getId_contactos());
        //invocar al metodo moverAnteriorRegistro
        //mostrar nombre en la vista
        //mostar email en la vista
    }

    /**
     * Método para ver el último registro de la tabla contactos
     */
    private void jbtn_ultimo_actionPerformed() {
        modelAgenda.moverUltimoRegistro();
        viewAgenda.jtf_nombre.setText(modelAgenda.getNombre());
        viewAgenda.jtf_email.setText(modelAgenda.getEmail());
        viewAgenda.jtf_id_contactos.setText(modelAgenda.getId_contactos());
        //invocar al metodo moverUltimoRegistro
        //mostrar nombre en la vista
        //mostar email en la vista
    }

    /**
     * Método para ver el siguiente registro de la tabla contactos
     */
    private void jbtn_siguiente_actionPerformed() {
        modelAgenda.moverSiguienteRegistro();
        viewAgenda.jtf_nombre.setText(modelAgenda.getNombre());
        viewAgenda.jtf_email.setText(modelAgenda.getEmail());
        viewAgenda.jtf_id_contactos.setText(modelAgenda.getId_contactos());
        //invocar al metodo moverSiguienteRegistro
        //mostrar nombre en la vista
        //mostar email en la vista
    }
    /**
     * Permite limpiar los jtf de la vista e hacerlos editables
     * oculta los jbtn nuevo, eliminar, modificar, y los de moverse entre los registros
     */
    private void jbtn_nuevo_actionPerformed() {
        viewAgenda.jtf_nombre.setText("");
        viewAgenda.jtf_nombre.setEditable(true);
        viewAgenda.jtf_email.setText("");
        viewAgenda.jtf_id_contactos.setText("");
        viewAgenda.jtf_email.setEditable(true);
        viewAgenda.jbtn_nuevo.setVisible(false);
        viewAgenda.jbtn_eliminar.setVisible(false);
        viewAgenda.jbtn_modificar.setVisible(false);
        viewAgenda.jbtn_primero.setVisible(false);
        viewAgenda.jbtn_siguiente.setVisible(false);
        viewAgenda.jbtn_anterior.setVisible(false);
        viewAgenda.jbtn_ultimo.setVisible(false);
        viewAgenda.jbtn_insertar.setVisible(true);
        viewAgenda.jbtn_cancelar.setVisible(true);
    }
    /**
     * Permite obtener lo que tienen los jtf de la vista y mandarlo a las variable del modelo
     * Invoca al metodo de ginsertar que se encuentra en el modelo
     * Limpia los jtf de la vista
     */
    private void jbtn_insertar_actionPerformed() {
        modelAgenda.setNombre(viewAgenda.jtf_nombre.getText()); 
        modelAgenda.setEmail(viewAgenda.jtf_email.getText()); 
        modelAgenda.insertarRegistro();
        viewAgenda.jtf_nombre.setText("");
        viewAgenda.jtf_email.setText("");
    }
    /**
     * Permite hacer editable los jtf de la vista
     * Oculta los jbtn nuevo,eliminar, cancelar
     * Hace visible los jbtn de cancelar y guardar
     */
    private void jbtn_modificar_actionPerformed() {
        viewAgenda.jtf_nombre.setEditable(true);
        viewAgenda.jtf_email.setEditable(true);
        viewAgenda.jbtn_cancelar.setVisible(true);
        viewAgenda.jbtn_guardar.setVisible(true);
        viewAgenda.jbtn_nuevo.setVisible(false);
        viewAgenda.jbtn_eliminar.setVisible(false);
        viewAgenda.jbtn_modificar.setVisible(false);
    }
    /**
     * Ivoca al meodo eliminarRegistro que se encuentra en el modelo
     */
    private void jbtn_eliminar_actionPerformed() {
        modelAgenda.eliminarRegistro();
        initDB();
    }
    /**
     * Toma lo que tiene los jtf de la vista y lo manda a las variables del modelo
     * Invoca al metodo de guardarRegistro que se encuentra en el modelo 
     */
    private void jbtn_guardar_actionPerformed() {
        modelAgenda.setNombre(viewAgenda.jtf_nombre.getText()); 
        modelAgenda.setEmail(viewAgenda.jtf_email.getText()); 
        modelAgenda.setId_contactos(viewAgenda.jtf_id_contactos.getText());
        modelAgenda.guardarRegistro();
    }
    /**
     * Hece ineditable los jtf de la vista
     * Hace invisible los jbtn de de inserter, cancelar y guardar
     * Hace visible los botones de Nnuevo, eliminar y modificar
     * Hace visible los jbtn para desplazarce entre los registros de la base de datos
     * Invoca al metodo initDB para mostrar el primer registro
     */
    private void jbtn_cancelar_actionPerformed() {
        viewAgenda.jtf_nombre.setEditable(false);
        viewAgenda.jtf_nombre.setEditable(false);
        viewAgenda.jbtn_nuevo.setVisible(true);
        viewAgenda.jbtn_eliminar.setVisible(true);
        viewAgenda.jbtn_modificar.setVisible(true);
        viewAgenda.jbtn_primero.setVisible(true);
        viewAgenda.jbtn_siguiente.setVisible(true);
        viewAgenda.jbtn_anterior.setVisible(true);
        viewAgenda.jbtn_ultimo.setVisible(true);
        viewAgenda.jbtn_insertar.setVisible(false);
        viewAgenda.jbtn_cancelar.setVisible(false);
        viewAgenda.jbtn_guardar.setVisible(false);
        initDB();
    }
    
}
