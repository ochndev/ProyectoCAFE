/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tareas;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author Hannibal
 */
public class ContextEnricher extends Modifier{
    
    Document docenriquecido;
    Slots entrada1, entrada2;
    Slots salida;
    
    public ContextEnricher (Slots entrada1,Slots entrada2, Slots salida){

        
        this.entrada1 = entrada1;
        this.entrada2 = entrada2;
        this.salida = salida;
        
    }
    
    public void EnrichContext() throws ParserConfigurationException{
        
                
        DocumentBuilderFactory dbFactory  = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();           
        docenriquecido = dBuilder.newDocument();
        
        for(int i = 0; i<entrada1.buffersize(); i++){
                
                Element drinkElement = docenriquecido.createElement("drink");
                drinkElement.appendChild(drinkElement);
                           
                Element nameElement = docenriquecido.createElement("name");
                nameElement.appendChild(docenriquecido.createTextNode(entrada1.getDocument(i).getElementsByTagName("name").item(0).getTextContent()));
                drinkElement.appendChild(nameElement);
                            
                Element availableElement = docenriquecido.createElement("availability");
                nameElement.appendChild(docenriquecido.createTextNode(entrada1.getDocument(i).getElementsByTagName("availability").item(0).getTextContent()));
                drinkElement.appendChild(availableElement);
            
        }
        
        salida.setDocument(this.docenriquecido);
        
        
        
                    //Creacion del Document
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
        try {
            javax.xml.transform.Transformer transformer = transformerFactory.newTransformer();
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(ContextEnricher.class.getName()).log(Level.SEVERE, null, ex);
        }
            DOMSource source = new DOMSource(docenriquecido);
            
    }
    
}
