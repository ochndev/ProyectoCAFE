/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tareas;

import org.w3c.dom.Document;

/**
 *
 * @author Hannibal
 */
public class Replicator extends Router{
    
    public Replicator (){
        
    }
    
    public void Replicar (Slots in, Slots out1, Slots out2){
        for(int i = 0; i< in.buffer.size(); i++){
            out1.setDocument(in.buffer.get(i));
            out2.setDocument(in.buffer.get(i));
        }
    }
    
}
