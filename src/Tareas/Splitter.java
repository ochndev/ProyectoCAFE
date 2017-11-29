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
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Hannibal
 */
public class Splitter extends Transformer{
    
    Document doc;
    Slots entrada,salida;
    
    public Splitter(Slots entrada, Slots salida){
        this.entrada = entrada;
        this.salida = salida;
    }
    
    public void Splittear() throws XPathExpressionException{
        
        
        try {
            String xPathExpression = "/cafe_order/drinks";            
            DocumentBuilderFactory dbFactory  = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc1 = dBuilder.newDocument();
            
            
            for(int i=0; i<entrada.buffer.size() ; i++){
                
                doc = entrada.getDocument(i);
                
                NodeList nodos = doc.getElementsByTagName("drink");
                
                    for (int j=0 ; j<nodos.getLength() ; j++){
                        
                        Node nod = nodos.item(i);
                
                    Element drinkElement = doc1.createElement("drink");
                    doc1.appendChild(drinkElement);
                           
                    Element nameElement = doc1.createElement("name");
                    nameElement.appendChild(doc1.createTextNode(nodos.item(i).getNodeValue()));
                    drinkElement.appendChild(nameElement);
                
                    Element typeElement = doc1.createElement("type");
                    typeElement.appendChild(doc1.createTextNode(nodos.item(i).getNodeValue()));
                    drinkElement.appendChild(typeElement);
                
                        System.out.println(doc1.getElementsByTagName("*").item(i).getTextContent());
                        salida.setDocument(doc1);
                        
                    }
                    
            }
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Splitter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}