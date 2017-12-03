/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tareas;

import java.io.FileNotFoundException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 *
 * @author Hannibal
 */
public class Aggregator extends Transformer {
    
    Slots entrada, salida;
    String xslFilename;
    Document doc;
    Document docAux;
    
    public Aggregator(Slots entrada, Slots salida){
        this.entrada = entrada;
        this.salida = salida;
    }
    
    public void Aggregate(String xslFilename) throws FileNotFoundException, ParserConfigurationException{
        
        System.out.println("Agregando");
        
        DocumentBuilderFactory dbFactory  = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        docAux = dBuilder.newDocument();
        
        //Creamos un documento nuevo mezclando las entradas del buffer y
        //le añadimos las cabeceras
        
        Element orderElement = docAux.createElement("cafe_order");
        docAux.appendChild(orderElement);
            
        Element orderIdElement = docAux.createElement("order_id");
        orderElement.appendChild(orderIdElement);
            
        Element drinksElement = docAux.createElement("drinks");
        orderElement.appendChild(drinksElement);
        
        for (int i = 0; i < entrada.buffersize(); i++) {
            
            doc = entrada.getDocument(i);
            
            NodeList nodosnombre = doc.getElementsByTagName("name");
            NodeList nodostipo = doc.getElementsByTagName("type");
            NodeList nodosdisponible = doc.getElementsByTagName("available");
                
            Element drinkElement = docAux.createElement("drink");
            drinksElement.appendChild(drinkElement);

            Element nameElement = docAux.createElement("name");
            nameElement.appendChild(docAux.createTextNode(nodosnombre.item(0).getTextContent()));
            drinkElement.appendChild(nameElement);

            Element typeElement = docAux.createElement("type");
            typeElement.appendChild(docAux.createTextNode(nodostipo.item(0).getTextContent()));
            drinkElement.appendChild(typeElement);
                
            Element availableElement = docAux.createElement("available");
            availableElement.appendChild(docAux.createTextNode(nodosdisponible.item(0).getTextContent()));
            drinkElement.appendChild(availableElement);            

        }
        
        salida.setDocument(docAux);

    }
    
}
