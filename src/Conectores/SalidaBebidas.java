/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conectores;

import Tareas.Slots;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.transform.TransformerException;
import org.w3c.dom.Document;

/**
 *
 * @author Hannibal
 */
public class SalidaBebidas {
    
    ControladorXML conXML;
    
    public SalidaBebidas(){
        
        this.conXML = new ControladorXML("src/FicheroEntrada/FicheroEntrada.xml","src/FicheroSalida/FicheroSalida.xml");
        
    }
    
    public void EscribirBebidasDisponibles (Slots IN) throws FileNotFoundException{
        
        try {
            //Leemos del puerto de entrada
            conXML.EscribirXML(IN.getDocument(0));
        } catch (TransformerException ex) {
            Logger.getLogger(SalidaBebidas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
