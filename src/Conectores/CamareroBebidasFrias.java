/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conectores;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import basededatos.Bebida;
import basededatos.ConexionBD;

/**
 *
 * @author Hannibal
 */
public class CamareroBebidasFrias {
    
    ConexionBD con;
    ArrayList bebidas;
    
    
    public CamareroBebidasFrias(ConexionBD con){
        this.con = con;
    }
    
    
    public boolean ConsultarDisponibilidad(Bebida bebida, ConexionBD con){
            
            int numero = 0;
            Statement stmt = null;
            
            String consulta = "SELECT COUNT(*) FROM BEBIDAS WHERE nombre = 'CocaCola' AND tipo = 'cold'";
            
            
            try {
                stmt = con.getConnection().createStatement();
            } catch (SQLException ex) {
                Logger.getLogger(CamareroBebidasCalientes.class.getName()).log(Level.SEVERE, null, ex);
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
    
}
