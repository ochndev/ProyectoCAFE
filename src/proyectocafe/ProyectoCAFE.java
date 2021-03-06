/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectocafe;

import Conectores.*;
import Tareas.*;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

/**
 *
 * @author Hannibal
 */
public class ProyectoCAFE {

    /**
     * @param args the command line arguments
     */
   
    public static void main(String[] args) {
        
        try {
            String xslFilename = "src/FicheroXSL/FicheroXSL.xsl";
            
            Slots[] slots = InicializarSlots();
            
            // Creamos el conector CamareroBebidasCalientes
            
            CamareroBebidasCalientes CBC = new CamareroBebidasCalientes();
            
            // Creamos el conector CamareroBebidasFrias
            
            CamareroBebidasFrias CBF = new CamareroBebidasFrias();
            
            // Creamos el conector EntradaBebidas
            EntradaBebidas EB = new EntradaBebidas();
            SalidaBebidas SB = new SalidaBebidas();
            
            // Leemos del documento
            
            EB.LeerComanda(slots[0]);
            
            
            //Creamos un Translator y traducimos
            Translator TSL1 = new Translator(slots[0],slots[1]);
            TSL1.Translate();
            
            //Creamos la tarea splitter
            // Dividimos con el splitter dependiendo si es bebida fria o caliente
            Splitter SP = new Splitter(slots[1], slots[2]);
            SP.Split();
            
            //Creamos la tarea distributos y distribuimos en dos ramas
            Distributor DIST;
            DIST = new Distributor(slots[2],slots[3],slots[4]);
            DIST.Distribute(slots[2], slots[3], slots[4]);
            
            
            //Creamos los replicators y replicamos las bebidas frias y calientes respectivamente
            Replicator REP1 = new Replicator();
            REP1.Replicar(slots[3], slots[5], slots[6]);
            
            Replicator REP2 = new Replicator();
            REP2.Replicar(slots[4], slots[7], slots[8]);
            
            //Traducimos para acceder a la base de datos
            TranslatorSQL TSL2 = new TranslatorSQL(slots[5],slots[9]);
            TSL2.translate();
            
            //Consultamos bebidas calientes
            CBC.EjecutarQuerys(slots[9], slots[11]);
            
            //Correlacionamos
            Correlator CRL1 = new Correlator(slots[5], slots[11],slots[13],slots[14]);
            CRL1.Correlate();
            
            //Enriquecemos
            ContextEnricher CEN1 = new ContextEnricher(slots[13],slots[14],slots[15]);
            CEN1.EnrichContext();
            
            
            //Traducimos para obtener acceder a BD de bebidas frias
            TranslatorSQL TSL3 = new TranslatorSQL(slots[7], slots[10]);
            TSL3.translate();
            
            //Consultamos bebidas frias
            CBF.EjecutarQuerys(slots[10],slots[16]);
            
            //Correlacionamos
            Correlator CRL2 = new Correlator(slots[7],slots[16],slots[17],slots[18]);
            CRL2.Correlate();
            
            //Enriquecemos
            ContextEnricher CEN = new ContextEnricher(slots[17],slots[18],slots[19]);
            CEN.EnrichContext();
            
            //Mezclamos
            Merger MRG = new Merger(slots[15],slots[19],slots[20]);
            MRG.Merge();
            
            
            // Agregamos utilizando un estilo
            Aggregator AGG = new Aggregator(slots[20],slots[21]);
            AGG.Aggregate(xslFilename);
            
            //Por ultimo generamos el archivo XML final con el conector SalidaBebidas
            SB.EscribirBebidasDisponibles(slots[21]);
            
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(ProyectoCAFE.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ProyectoCAFE.class.getName()).log(Level.SEVERE, null, ex);
        } catch (XPathExpressionException ex) {
            Logger.getLogger(ProyectoCAFE.class.getName()).log(Level.SEVERE, null, ex);
        }        
        
    }
    
    public static Slots[] InicializarSlots(){
                    //Creamos e inicializamos los slots
            Slots[] slots = new Slots[22];
            for (int i = 0; i < slots.length; i++) {
                slots[i] = new Slots();
            }
            
            return slots;
            
    }
    
}
