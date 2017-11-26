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
public class Merge extends Router{
    
    private Slots entrada1, entrada2, salida;
    
    public Merge (Slots entrada1,Slots entrada2, Slots salida){
        
            this.entrada1 = entrada1;
            this.entrada2 = entrada2;
            this.salida = salida;        
    }
    
    public void Merge(){
        
        for(int i = 0; i<entrada1.buffer.size(); i++){
            salida.setDocument(entrada1.buffer.get(i));
        }
        
        for(int j = 0; j<entrada2.buffer.size(); j++){
            salida.setDocument(entrada1.buffer.get(j));
        }
        
    }
    
}
