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
import javax.xml.transform.Templates;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamSource;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author Hannibal
 */
public class Aggregator extends Transformer {
    
    Slots entrada, salida;
    String xslFilename;
    
    public Aggregator(Slots entrada, Slots salida){
        this.entrada = entrada;
        this.salida = salida;
    }
    
    public void Aggregate(String xslFilename) throws FileNotFoundException{
        
        Document doc;
        Document docSalida = null;
        
        //Aqui habria que aplicarle un estilo XSL para simplificarlo
        
        for (int i = 0; i < entrada.buffer.size(); i++) {
                
            try {
                DOMSource source = new DOMSource(entrada.buffer.get(i));
                DOMResult result = new DOMResult(docSalida);
                
                // Create transformer factory
                TransformerFactory factory = TransformerFactory.newInstance();
                
                // Use the factory to create a template containing the xsl file
                Templates template = factory.newTemplates(new StreamSource(
                        new FileInputStream(xslFilename)));
                
                // Use the template to create a transformer
                javax.xml.transform.Transformer xformer = template.newTransformer();
                            
                xformer.transform(source, result);
                
            } catch (TransformerException ex) {
                Logger.getLogger(Aggregator.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            salida.setDocument(docSalida);
            
        }
        
    }
    
    
}