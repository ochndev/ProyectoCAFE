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
        
        Document doc;
        
        try {
            String xPathExpression = "/cafe_order/drinks/drink";
            
            DocumentBuilderFactory dbFactory  = DocumentBuilderFactory.newInstance();
            
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            
            
            
            for(int i=0; i<entrada.buffer.size() ; i++){
                    doc = entrada.buffer.get(i);

                    // Preparación de xpath
                    XPath xpath = XPathFactory.newInstance().newXPath();
                    
                    // Consultas
                    NodeList nodos = (NodeList) xpath.evaluate(xPathExpression, doc, XPathConstants.NODESET);
                    
                    //Por cada nodo en la lista crea un documento y lo añade al buffer
                    
                    for (int j=0 ; j<nodos.getLength() ; j++){
                        
                        Document doc1 = dBuilder.newDocument();
                        doc1.adoptNode(nodos.item(i));
                        salida.setDocument(doc1);
                        
                    }
                    
            }
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Splitter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
