/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tareas;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Templates;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamSource;
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
    
    public Aggregator(Slots entrada, Slots salida){
        this.entrada = entrada;
        this.salida = salida;
    }
    
    public void Aggregate(String xslFilename) throws FileNotFoundException, ParserConfigurationException{
        
            DocumentBuilderFactory dbFactory  = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();


        
        //Aqui aplicamos un estilo XSL
        
        System.out.println("Agregando");
        
        for (int i = 0; i < entrada.buffersize(); i++) {
            
            Document docAux = dBuilder.newDocument();            
            Document docSalida = dBuilder.newDocument();
            doc = entrada.getDocument(i);
            NodeList nodosnombre = doc.getElementsByTagName("name");
            NodeList nodostipo = doc.getElementsByTagName("type");
            NodeList nodosdisponible = doc.getElementsByTagName("available");
            
            //Creamos un documento nuevo mezclando las entradas del buffer
            
            Element orderElement = docAux.createElement("cafe_order");
            docAux.appendChild(orderElement);
            
            Element orderIdElement = docAux.createElement("order_id");
            orderElement.appendChild(orderIdElement);
            
            Element drinksElement = docAux.createElement("drinks");
            orderElement.appendChild(drinksElement);
            
            for (int j = 0 ; j < nodosnombre.getLength(); j++){
                
                Element drinkElement = docAux.createElement("drink");
                drinksElement.appendChild(drinkElement);

                Element nameElement = docAux.createElement("name");
                nameElement.appendChild(docAux.createTextNode(nodosdisponible.item(j).getTextContent()));
                drinkElement.appendChild(nameElement);

                Element typeElement = docAux.createElement("type");
                typeElement.appendChild(docAux.createTextNode(nodostipo.item(j).getTextContent()));
                drinkElement.appendChild(typeElement);
                
                Element availableElement = docAux.createElement("available");
                availableElement.appendChild(docAux.createTextNode(nodosdisponible.item(j).getTextContent()));
                drinkElement.appendChild(availableElement);
            }
            
            salida.setDocument(docSalida);

        }
    }
    
}
