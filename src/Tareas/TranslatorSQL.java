/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tareas;

import java.io.FileInputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Templates;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamSource;
import org.w3c.dom.Document;

/**
 *
 * @author Hannibal
 */
public class TranslatorSQL {
    
    Slots IN,OUT;
    Document docaux;

    public TranslatorSQL(Slots IN, Slots OUT) {
        this.IN = IN;
        this.OUT = OUT;
    }
    
    public void translate() throws ParserConfigurationException{
        
        for (int i = 0; i < IN.buffersize(); i++) {
            
                    
            DocumentBuilderFactory dbFactory  = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();           
            docaux = dBuilder.newDocument();
            
            String nombre = "", tipo = "", consulta = "";            
            docaux = IN.getDocument(i);
            nombre = docaux.getElementsByTagName("name").item(0).getTextContent();
            tipo = docaux.getElementsByTagName("type").item(0).getTextContent();
            
            consulta = "SELECT COUNT(*) FROM BEBIDAS WHERE nombre = '"+nombre+"' AND tipo = '"+tipo+"'";
            
            OUT.setString(consulta);
            
        }
        
    }
    
    
}
