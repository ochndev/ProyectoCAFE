/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tareas;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author Hannibal
 */
public class Correlator extends Router{
    
    private Slots entrada1, entrada2, salida1, salida2;

    public Correlator(Slots entrada1, Slots entrada2, Slots salida1, Slots salida2) {
        this.entrada1 = entrada1;
        this.entrada2 = entrada2;
        this.salida1 = salida1;
        this.salida2 = salida2;
    }
    
    public void Correlacionar (){
        
        Document doc=null;
        String disponibilidad = "";
        
        for (int i = 0; i < entrada1.buffer.size(); i++) {
            if((boolean)entrada2.bufferObject.get(i)){
                disponibilidad = "yes";
            }
            else disponibilidad = "no";
            
            Element availableElement = doc.createElement("availability");
            availableElement.appendChild(doc.createTextNode(disponibilidad));
            
            salida1.setDocument(doc);
            salida2.setDocument(entrada1.getDocument(i));
        }
        
    }
    
}
