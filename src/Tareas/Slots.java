/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tareas;

import java.util.ArrayList;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

/**
 *
 * @author Hannibal
 */
public class Slots {
    
   // ArrayList<Document> buffer;
    private ArrayList<String> bufferString;
    private ArrayList<Object> bufferObject;
    private ArrayList<Document> buffer;

    public Slots(){
        buffer = new ArrayList<>();
        bufferString = new ArrayList<>();
        bufferObject = new ArrayList<>();
    }
    
    public int buffersize(){
        return bufferObject.size();
    }
    
    public Object getObject(int i){        
        return bufferObject.get(i);
    }
    
    public void setObject(Object Obj){
        this.bufferObject.add(Obj);
    }
    
    public Document getDocument(int i) {
        return buffer.get(i);
    }

    public void setDocument(Document doc) {
        buffer.add(doc);
    }
    
    public String getString(int i) {
        return bufferString.get(i);
    }

    public void setString(String doc) {
        bufferString.add(doc);
    }
    
    public int tamanyo(){
        return buffer.size();
    }

}
