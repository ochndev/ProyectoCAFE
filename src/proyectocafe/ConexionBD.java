/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectocafe;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hannibal
 */
public class ConexionBD {
    
    Connection conn;
    
    void Conexion(){
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
           
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectocafe", "root", "");
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    void Desconexion(){
        
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void incio_transaccion() throws SQLException{
        conn.setAutoCommit(false);
    }
    
    public void fin_transaccion_commit() throws SQLException{
        conn.commit();
    }
    
    public void fin_transaccion_rollback() throws SQLException{
        conn.rollback();
    }
    
}
