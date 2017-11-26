/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conectores;

import Tareas.Slots;
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
    
    public SalidaBebidas(ControladorXML conXML){
        
        this.conXML = conXML;
        
    }
    
    public void EscribirBebidasDisponibles (Slots IN){
        
        //Leemos del puerto de entrada
        Document doc = IN.getDocument(0);
        
        try {
            conXML.EscribirXML(doc);
        } catch (TransformerException ex) {
            Logger.getLogger(SalidaBebidas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
