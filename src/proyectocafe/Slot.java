/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectocafe;

import java.util.ArrayList;
import org.w3c.dom.Document;

/**
 *
 * @author Hannibal
 */
public class Slot {
    
    ArrayList<Document> buffer;

    Document getDocument() {
        return buffer.get(0);
    }

    void setDocument(Document doc) {
        buffer.add(doc);
    }

}
