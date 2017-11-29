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
public class Replicator extends Router{
    
    public Replicator (){
        
    }
    
    public void Replicar (Slots in, Slots out1, Slots out2) throws ParserConfigurationException{
        for(int i = 0; i< in.buffer.size(); i++){
            DocumentBuilderFactory dbFactory  = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();            
            Document doc1 = dBuilder.newDocument();
            Document doc2 = dBuilder.newDocument();
            doc1 = in.buffer.get(i);
            doc2 = in.buffer.get(i);
            out1.setDocument(in.buffer.get(i));
            out2.setDocument(in.buffer.get(i));
        }
    }
    
}
