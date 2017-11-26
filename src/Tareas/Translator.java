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
public class Translator extends Transformer {
    
    Document doc;
    Slots entrada, salida;
    
    public Translator(Slots entrada, Slots salida){
        
        this.entrada = entrada;
        this.salida = salida;
        
    }
    
    public void Translate(){
                
        for (int i = 0; i < entrada.buffer.size(); i++) {
            doc = entrada.getDocument(i);
            salida.setDocument(doc);
        }
        
    }
    
}
