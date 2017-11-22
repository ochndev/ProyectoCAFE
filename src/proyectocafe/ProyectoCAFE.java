/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectocafe;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.w3c.dom.Document;

/**
 *
 * @author Hannibal
 */
public class ProyectoCAFE {

    /**
     * @param args the command line arguments
     */
    
   
    
    public static void main(String[] args) {
        
         Slots[] slots = new Slots[10];
        
        //Objeto Controlador XML
        ControladorXML conXML= new ControladorXML("src/FicheroEntrada/FicheroEntrada.xml");
        
        
        //Conectamos la base de datos
        ConexionBD CBD = new ConexionBD();
        CBD.Conexion();
        
        //Creamos una bebida        
        Bebida beb = new Bebida();
        
        // Creamos el conector CamareroBebidasCalientes
        
        CamareroBebidasCalientes CBC = new CamareroBebidasCalientes(CBD);
        CBC.ConsultarDisponibilidad(beb, CBD);
        
        // Creamos el conector ControladorXML
        conXML.LeerXML();
        
        CamareroBebidasFrias CBF = new CamareroBebidasFrias(CBD);
        CBF.ConsultarDisponibilidad(beb, CBD);

        
        
        Document doc = conXML.LeerXML();
        
    }
    
}
