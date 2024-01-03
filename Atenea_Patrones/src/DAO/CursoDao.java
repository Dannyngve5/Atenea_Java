/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import java.sql.Connection;
import modelo.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import modelo.Curso;

public class CursoDao {
    Conexion conectar = new Conexion();
    Connection conexion;
    PreparedStatement ps;
    ResultSet rs;
    
    /*
    public List listar(){
        String sql = "SELECT * FROM PERSONA";
        List<Persona>datos = new ArrayList<>();
        try {
            conexion = conectar.getConnection();
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Persona p = new Persona();
                p.setId((rs.getInt(1)));
                p.setNombre((rs.getString(2)));
                p.setTelefono((rs.getString(3)));
                p.setDireccion((rs.getString(4)));
                p.setF_nacimiento(rs.getDate(5));
                p.setEmail((rs.getString(6)));
                p.setTipo((rs.getString(7)));
                datos.add(p);
                
            }
        } catch (Exception e) {
        }
        return datos;
    }
    */
    
    public int agregar(Curso c){
        String sql = "INSERT INTO CURSO(nombre, f_inicio, hora_inicio, limite_estudiantes, instructor_id, monitor_id) VALUES(?,?,?,?,?,?)";
        try {
            conexion = conectar.getConnection();
            ps = conexion.prepareStatement(sql);
            
            ps.setString(1, c.getNombre());
            ps.setDate(2, c.getF_inicio());
            ps.setTime(3, c.getHora_inicio());
            ps.setInt(4, c.getLimite_estudiantes());
            ps.setInt(5, c.getInstructor_id());
            ps.setInt(6, c.getMonitor_id());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return 1;
    }
            
            
    
    
}
