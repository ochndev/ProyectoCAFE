/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tareas;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
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
        
        System.out.println("Traduciendo SQL");
        
        for (int i = 0; i < IN.buffersize(); i++) {
            
                    
            DocumentBuilderFactory dbFactory  = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();           
            docaux = dBuilder.newDocument();
            
            String nombre = "", tipo = "", consulta = "";            
            docaux = IN.getDocument(i);
            nombre = docaux.getElementsByTagName("name").item(0).getTextContent();
            tipo = docaux.getElementsByTagName("type").item(0).getTextContent();
            
            consulta = "select count(*) from bebidas where name = '"+nombre+"' and type = '"+tipo+"'";
            
            OUT.setString(consulta);
            
        }
        
    }
    
    
}
