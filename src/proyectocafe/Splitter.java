/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectocafe;

import java.util.logging.Level;
import java.util.logging.Logger;
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
    
    public void Splittear(){
        
        String xPathExpression = "/cafe_order/drinks/drink";
        
        for(int i=0; i<entrada.buffer.size() ; i++){
            try {
                doc = entrada.getDocument();
                
                // Preparación de xpath
                XPath xpath = XPathFactory.newInstance().newXPath();
                
                // Consultas
                NodeList nodos = (NodeList) xpath.evaluate(xPathExpression, doc, XPathConstants.NODESET);
                for (int j=0 ; j<nodos.getLength() ; j++){
                    
                    
                    
		}
                
                nodos.item(i).getTextContent();
                
                salida.setDocument(doc);
            } catch (XPathExpressionException ex) {
                Logger.getLogger(Splitter.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
}
