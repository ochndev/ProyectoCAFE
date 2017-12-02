/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tareas;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
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
    
    public void Correlate () throws ParserConfigurationException{
        
        String disponibilidad = "";
        DocumentBuilderFactory dbFactory  = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

        
        System.out.println("Correlacionando");
        
        for (int i = 0; i < entrada1.buffersize(); i++) {
            
            
            
            Document doc = dBuilder.newDocument();
            
            if((boolean)entrada2.getObject(i)){
                disponibilidad = "yes";
            }
            else disponibilidad = "no";
            
            
            
            Element availableElement = doc.createElement("available");
            availableElement.appendChild(doc.createTextNode(disponibilidad));
            doc.appendChild(availableElement);
            
            salida1.setDocument(entrada1.getDocument(i));
            salida2.setDocument(doc);
        }
        
    }
    
}
