/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectocafe;

import org.w3c.dom.Document;

/**
 *
 * @author Hannibal
 */
public class Replicator extends Router{
    
    Document doc;
    
    public Replicator (Slots in, Slots out1, Slots out2){
        
        doc = in.getDocument();
        out1.setDocument(doc);
        out2.setDocument(doc);
        
    }  
    
}
