/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tareas;

import basededatos.Bebida;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    Slots entrada;
    Slots salida;
    
    public ContextEnricher (Slots entrada, Slots salida){

        this.entrada = entrada;
        this.salida = salida;
        
    }
    
    public ContextEnricher(){
        
    }
    
    public void EnriquecerContexto(ArrayList<Bebida> AL, Document original){
        
        Bebida aux;
        
        for(int i = 0; i<AL.size(); i++){
                Element drinkElement = docenriquecido.createElement("drink");
                drinkElement.appendChild(drinkElement);
                           
                Element nameElement = docenriquecido.createElement("name");
                nameElement.appendChild(docenriquecido.createTextNode(AL.get(i).getNombre()));
                drinkElement.appendChild(nameElement);
                            
                Element availableElement = docenriquecido.createElement("availability");
                nameElement.appendChild(docenriquecido.createTextNode(AL.get(i).getNombre()));
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
