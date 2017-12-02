/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tareas;

import java.util.ArrayList;
import org.w3c.dom.Document;

/**
 *
 * @author Hannibal
 */
public class Slots {
    
   // ArrayList<Document> buffer;
    private ArrayList<Object> buffer;

    public Slots(){
        buffer = new ArrayList<>();
    }
    
    public int buffersize(){
        return buffer.size();
    }
    
    public void setObject(Object OBJ){
        buffer.add(OBJ);
    }
    
    public Object getObject(int i){        
        return buffer.get(i);
    }
    
    public Document getDocument(int i) {
        return (Document)buffer.get(i);
    }

    public void setDocument(Document OBJ) {
        buffer.add(OBJ);
    }
    
    public String getString(int i) {
        return (String)buffer.get(i);
    }

    public void setString(String doc) {
        buffer.add(doc);
    }

}
