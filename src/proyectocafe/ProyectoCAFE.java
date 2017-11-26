/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectocafe;

import Conectores.ControladorXML;
import basededatos.ConexionBD;
import basededatos.Bebida;
import Conectores.*;
import Tareas.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.xpath.XPathExpressionException;
import org.w3c.dom.Document;

/**
 *
 * @author Hannibal
 */
public class ProyectoCAFE {

    /**
     * @param args the command line arguments
     */
    
   
    
    public static void main(String[] args) {
        
        String xslFilename = "src/FicheroXSL/FicheroXSL.xsl";
        
        //Creamos e inicializamos los slots
        Slots[] slots = new Slots[10];
        for (int i = 0; i < slots.length; i++) {
            slots[i] = new Slots();            
        }
         
        
        //Objeto Controlador XML
        ControladorXML conXML = new ControladorXML("src/FicheroEntrada/FicheroEntrada.xml","src/FicheroSalida/FicheroSalida.xml");
        
        //Conectamos la base de datos
        ConexionBD CBD = new ConexionBD();
        CBD.Conexion();
        
        //Creamos una bebida        
        Bebida beb = new Bebida();
        
        // Creamos el conector CamareroBebidasCalientes
        
        CamareroBebidasCalientes CBC = new CamareroBebidasCalientes(CBD);
        CBC.ConsultarDisponibilidad(beb, CBD);
        
       // Creamos el conector CamareroBebidasFrias       
        
        CamareroBebidasFrias CBF = new CamareroBebidasFrias(CBD);
        CBF.ConsultarDisponibilidad(beb, CBD);
        
        // Creamos el conector EntradaBebidas
        EntradaBebidas EB = new EntradaBebidas(conXML);
        SalidaBebidas SB = new SalidaBebidas(conXML);
        
        // Leemos del documento
        
        EB.LeerComanda(slots[0]);
        
        
        //Creamos un Translator y traducimos
        Translator TSL1 = new Translator(slots[0],slots[1]);
        TSL1.Translate();
        
        //Creamos la tarea splitter        
        // Dividimos con el splitter dependiendo si es bebida fria o caliente       
        Splitter SP = new Splitter(slots[1], slots[2]);
        try {
            SP.Splittear();
        } catch (XPathExpressionException ex) {
            Logger.getLogger(ProyectoCAFE.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Creamos la tarea distributos y distribuimos en dos ramas
        Distributor DIST = new Distributor(slots[2],slots[3],slots[4]);
        DIST.Distribuir(slots[2], slots[3], slots[4]);
        
        //Creamos los replicators y replicamos las bebidas frias y calientes respectivamente
        Replicator REP1 = new Replicator();
        REP1.Replicar(slots[3], slots[5], slots[6]);
        Replicator REP2 = new Replicator();
        REP2.Replicar(slots[4], slots[7], slots[8]);
        
        //Traducimos para acceder a la base de datos        
        Translator TSL2 = new Translator(slots[5],slots[9]);
        TSL2.Translate();
        
        //Consultamos bebidas calientes
        CBC.

        //Correlacionamos
        
        
        
        //Enriquecemos
        
        
                
        //Traducimos para obtener acceder a BD de bebidas frias        
        
        Translator TSL3 = new Translator(slots[7], slots[10]);
        TSL3.translate();
                
        //Consultamos bebidas frias
                
        //Correlacionamos
                
        //Enriquecemos
                
        //Mezclamos
        Merge MRG = new Merge(slots,slots,slots);
        MRG.Mezcla();
        
        
        // Agregamos
        Aggregator AGG = new Aggregator();
        AGG.Aggregate(xslFilename);
        
        //Por ultimo generamos el archivo XML final con el conector SalidaBebidas
                
                
                
        //Cerramos la base de datos
        CBD.Desconexion();
        
        
        
        
    }
    
}
