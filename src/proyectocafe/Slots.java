/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectocafe;

import java.util.ArrayList;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

/**
 *
 * @author Hannibal
 */
public class Slots {
    
    ArrayList<Document> buffer;

    Document getDocument(int i) {
        return buffer.get(i);
    }

    void setDocument(Document doc) {
        buffer.add(doc);
    }

}
