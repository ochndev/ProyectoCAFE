/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conectores;

import Tareas.Slots;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import basededatos.ConexionBD;

/**
 *
 * @author Hannibal
 */
public class CamareroBebidasFrias {
    
    ConexionBD con;
    Slots entrada, salida;
    
    
    public CamareroBebidasFrias(){
        this.con = new ConexionBD();
    }
    
    
    private boolean ConsultarDisponibilidad(String consulta){
            
            int numero = 0;
            Statement stmt = null;           
            
            try {
                stmt = con.getConnection().createStatement();
            } catch (SQLException ex) {
                Logger.getLogger(CamareroBebidasFrias.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            try {
            ResultSet RS;
            RS = stmt.executeQuery(consulta);
            
            while(RS.next()){
                numero = RS.getInt(1);
                System.out.println("El numero de bebidas frias es: "+numero);
            }
            
            RS.close();
            stmt.close();
            

            
        } catch (SQLException ex) {
            Logger.getLogger(CamareroBebidasCalientes.class.getName()).log(Level.SEVERE, null, ex);
        }   
            
            if(numero > 0){
                return true;
            }else
            {
                return false;
            }
        
    }

    public void EjecutarQuerys(Slots IN, Slots OUT) {
        
        con.Conexion();
        
        for (int i = 0; i < IN.buffersize(); i++) {
            OUT.setObject(ConsultarDisponibilidad(IN.getString(i)));            
        }
        
        con.Desconexion();
        
    }
    
}
