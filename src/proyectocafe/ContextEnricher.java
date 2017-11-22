/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectocafe;

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
            
            AL.get(i).isDisponible();
                      
            
                            Element drinkElement = docenriquecido.createElement("drink");
                            drinkElement.appendChild(drinkElement);
                            
                            Element nameElement = docenriquecido.createElement("name");
                            nameElement.appendChild(docenriquecido.createTextNode(AL.get(i).nombre));
                            drinkElement.appendChild(nameElement);
                            
                            Element availableElement = docenriquecido.createElement("availability");
                            if(AL.get(i).disponible){
                                availableElement.appendChild(docenriquecido.createTextNode("yes"));
                            }
                            else{
                                availableElement.appendChild(docenriquecido.createTextNode("no"));
                                }

                            drinkElement.appendChild(availableElement);
                            //Elemento name



            
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
