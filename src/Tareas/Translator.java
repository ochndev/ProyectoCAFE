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
public class Translator extends Transformer {
    
    Document doc;
    Slots entrada, salida;
    
    public Translator(Slots entrada, Slots salida){
        
        this.entrada = entrada;
        this.salida = salida;
        
    }
    
    public void Translate() throws ParserConfigurationException{
        
                
        DocumentBuilderFactory dbFactory  = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();           
        doc = dBuilder.newDocument();
        
        System.out.println("Traduciendo");
        
        for (int i = 0; i < entrada.buffersize(); i++) {
            doc = entrada.getDocument(i);           
            salida.setDocument(doc);
        }
        
    }
    
}
