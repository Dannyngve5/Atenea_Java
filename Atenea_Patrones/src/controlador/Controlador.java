/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import DAO.CursoDao;
import DAO.PersonaDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Curso;
import modelo.Persona;
import vista.Vista;

/**
 *
 * @author Hogar
 */
public class Controlador implements ActionListener{
    
    PersonaDao pdao = new PersonaDao();
    Persona p = new Persona();
    CursoDao cdao = new CursoDao();
    Curso c = new Curso();    
    Vista vista = new Vista();
    DefaultTableModel modelo = new DefaultTableModel();

    public Controlador(Vista v) {
        this.vista = v;
        this.vista.btnMostrar.addActionListener(this);
        this.vista.btnAgregar.addActionListener(this);
        this.vista.btnLimpiar.addActionListener(this);
        this.vista.btnAgregarCurso.addActionListener(this);
    }
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==vista.btnMostrar){
            limpiar(vista.tabla);
            listar(vista.tabla);
        }
        if(ae.getSource()==vista.btnLimpiar){
            limpiar(vista.tabla);
        }
        if(ae.getSource()==vista.btnAgregar){
            agregarPersona();
        }
        if(ae.getSource()==vista.btnAgregarCurso){
            agregarCurso();
        }
    }
    
    public void agregarPersona(){
        Date f_nacimiento = null;
        String nombre = vista.txtNombreCurso.getText();
        String telefono = vista.txtTelefono.getText();
        String direccion = vista.txtDireccion.getText();
        String fNacimiento = vista.txtFecha.getText();
        String email = vista.txtEmail.getText();
        String tipo = vista.txtTipo.getText();
        
        // Formato de fecha esperado
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        boolean fCorrecta = true;
        try {
            java.util.Date utilDate = sdf.parse(fNacimiento);
            f_nacimiento = new java.sql.Date(utilDate.getTime());
        // Ahora 'f_nacimiento' contiene la fecha como tipo Date
        } catch (ParseException e) {
            e.printStackTrace(); 
            fCorrecta= false;
        }
        
        if(fCorrecta){
            p.setNombre(nombre);
            p.setTelefono(telefono);
            p.setDireccion(direccion);
            p.setF_nacimiento(f_nacimiento);
            p.setEmail(email);
            p.setTipo(tipo);

            int respuesta =  pdao.agregar(p);
            if(respuesta == 1){
                JOptionPane.showMessageDialog(vista, "Usuario agregado");
            }else{
                JOptionPane.showMessageDialog(vista, "Usuario no agregado");
            } 
        }else{
            JOptionPane.showMessageDialog(vista, "Formato fecha incorrecto");
        }
        
    }
    
    public void listar(JTable tabla){
        modelo = (DefaultTableModel)tabla.getModel();
        List <Persona> lista = pdao.listar();
        Object[]object = new Object[7];
        for(int i=0; i< lista.size(); i++){
            object[0] = lista.get(i).getId();
            object[1] = lista.get(i).getNombre();
            object[2] = lista.get(i).getTelefono();
            object[3] = lista.get(i).getDireccion();
            object[4] = lista.get(i).getF_nacimiento();
            object[5] = lista.get(i).getEmail();
            object[6] = lista.get(i).getTipo();
            modelo.addRow(object);
        }
        vista.tabla.setModel(modelo);
    }
    
    public void limpiar(JTable tabla){
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        modelo.setRowCount(0);
        
    }    

    private void agregarCurso() {
    Date f_inicio = null;
    Time hora_inicio = null;
    
    String nombre = vista.txtNombreCurso.getText();
    String fecha = vista.txtFechaInicio.getText();
    String hora = vista.txtHoraInicio.getText();
    int limiteEstudiantes = Integer.parseInt(vista.txtLimiteEstudiantes.getText());
    int instructorId = Integer.parseInt(vista.txtInstructor.getText());
    int monitorId = Integer.parseInt(vista.txtMonitor.getText());

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat horaFormat = new SimpleDateFormat("HH:mm:ss");

    boolean fechaCorrecta = true;
    boolean horaCorrecta = true;

    try {
        java.util.Date utilDate = sdf.parse(fecha);
        f_inicio = new java.sql.Date(utilDate.getTime());
        
        utilDate = horaFormat.parse(hora);
        hora_inicio = new Time(utilDate.getTime());
    } catch (ParseException e) {
        e.printStackTrace();
        fechaCorrecta = false;
        horaCorrecta = false;
    }
    
    

    if (fechaCorrecta && horaCorrecta) {
        Curso curso = new Curso();
        curso.setNombre(nombre);
        curso.setF_inicio(f_inicio);
        curso.setHora_inicio(hora_inicio);
        curso.setLimite_estudiantes(limiteEstudiantes);
        curso.setInstructor_id(instructorId);
        curso.setMonitor_id(monitorId);

        int respuesta = cdao.agregar(curso);
        if (respuesta == 1) {
            JOptionPane.showMessageDialog(vista, "Curso agregado");
        } else {
            JOptionPane.showMessageDialog(vista, "Curso no agregado");
        }
    } else {
        JOptionPane.showMessageDialog(vista, "Formato de fecha incorrecto");
    }
}

}
