/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conectores;

import Tareas.Slots;
import org.w3c.dom.Document;

/**
 *
 * @author Hannibal
 */
public class EntradaBebidas {
    
    ControladorXML conXML;
    
    public EntradaBebidas(ControladorXML conXML){
        this.conXML = conXML;
    }
    
    public void LeerComanda(Slots Salida){
        
        // Leo el documento XML de entrada a través del Controlador XML        
        // Escribo el documento generado en el buffer
        Salida.setDocument(conXML.LeerXML());
        
    }
    
    
}
