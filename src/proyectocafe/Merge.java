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
public class Merge extends Router{
    
    private Slots entrada1, entrada2, entrada3, salida;
    
    public Merge (Slots entrada1,Slots entrada2, Slots entrada3, Slots salida){
        
            this.entrada1 = entrada1;
            this.entrada2 = entrada2;
            this.entrada3 = entrada3;
            this.salida = salida;
        
    }
    
    public void Merge(){
        
        System.out.println("Actua la Tarea Merge");
        salida.setDocument(entrada1.getDocument());
        salida.setDocument(entrada2.getDocument());
        salida.setDocument(entrada3.getDocument());
        
    }
    

    
    
    
    
}
