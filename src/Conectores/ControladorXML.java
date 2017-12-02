/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conectores;

import Tareas.Aggregator;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Templates;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

/**
 *
 * @author usuario
 */
public class ControladorXML {
    private String inputFile, outputFile;

    public ControladorXML(String inputFile, String outputFile) {
        this.inputFile = inputFile;
        this.outputFile = outputFile;
    }
    
    public Document LeerXML(){
        
        Document doc=null;
        
        try {
            File inputFile = new File(this.inputFile);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder;

            dBuilder = dbFactory.newDocumentBuilder();

            doc = dBuilder.parse(inputFile);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return doc;
    }
    
    public void EscribirXML(Document doc) throws TransformerException, FileNotFoundException {
        
        String nom_fich= "src/FicheroSalida/FicheroSalida.xml";
        String xslFilename = "src/FicheroXSL/FicheroXSL.xsl";
        
            try {
                
                DOMSource source = new DOMSource(doc);
                StreamResult result = new StreamResult(new File(nom_fich));
                
                // Create transformer factory
                TransformerFactory factory = TransformerFactory.newInstance();

                // Use the factory to create a template containing the xsl file
                Templates template = factory.newTemplates(new StreamSource(
                new FileInputStream(xslFilename)));

                // Use the template to create a transformer
                javax.xml.transform.Transformer xformer = template.newTransformer();

                xformer.transform(source, result);
                
                //Output to cosole for testing
                StreamResult consoleResult = new StreamResult(System.out);
                xformer.transform(source, consoleResult);

            } catch (TransformerException ex) {
                Logger.getLogger(Aggregator.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        /*try {
            
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(nom_fich));
            transformer.transform(source, result);
            
            //Output to cosole for testing
            StreamResult consoleResult = new StreamResult(System.out);
            transformer.transform(source, consoleResult);
            
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(ControladorXML.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }
}
