/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectocafe;

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
        
         Slot[] slots = new Slot[10];
        
        //Objeto Controlador XML
        ControladorXML conXML= new ControladorXML("src/FicheroEntrada/FicheroEntrada.xml");
        
        ConexionBD CBD = new ConexionBD();
        
        CamareroBebidasCalientes CBB = new CamareroBebidasCalientes(CBD);        
        
        
        Document doc= conXML.LeerXML();
        
    }
    
}
