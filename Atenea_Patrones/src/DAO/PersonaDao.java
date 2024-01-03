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
import modelo.Persona;

public class PersonaDao {
    Conexion conectar = new Conexion();
    Connection conexion;
    PreparedStatement ps;
    ResultSet rs;
    
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
    
    public int agregar(Persona p){
        String sql = "INSERT INTO PERSONA(nombre, telefono, direccion, f_nacimiento, email, tipo) VALUES(?,?,?,?,?,?)";
        try {
            conexion = conectar.getConnection();
            ps = conexion.prepareStatement(sql);
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getTelefono());
            ps.setString(3, p.getDireccion());
            ps.setDate(4, p.getF_nacimiento());
            ps.setString(5, p.getEmail());
            ps.setString(6, p.getTipo());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return 1;
    }
            
            
    
    
}
