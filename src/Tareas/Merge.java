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
public class Merge extends Router{
    

    Document doc_entrada1;
    Document doc_entrada2;
    Document doc_salida;
    
    private Slots entrada1, entrada2, salida;
    
    public Merge (Slots entrada1,Slots entrada2, Slots salida){
        
  
        this.entrada1 = entrada1;
        this.entrada2 = entrada2;
            this.salida = salida;        
    }
    
    public void Merge() throws ParserConfigurationException{
        
        DocumentBuilderFactory dbFactory  = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        doc_entrada1 = dBuilder.newDocument();
        doc_entrada2 = dBuilder.newDocument();
        doc_salida = dBuilder.newDocument();

        
        for(int i = 0; i<entrada1.buffer.size(); i++){
            doc_entrada1 = entrada1.buffer.get(i);
            System.out.println("Merge: "+doc_entrada1.getTextContent());
            salida.setDocument(entrada1.buffer.get(i));
        }
        
        for(int j = 0; j<entrada2.buffer.size(); j++){
            salida.setDocument(entrada1.buffer.get(j));
        }
        
    }
    
}
