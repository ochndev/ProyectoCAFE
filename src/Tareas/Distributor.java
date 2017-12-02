/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tareas;

import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;

/**
 *
 * @author Hannibal
 */
public class Distributor extends Router {

    private String condicion;
    private Slots in, out1, out2;
    private Document doc;

    public Distributor() {

    }

    public Distributor(Slots in, Slots out1, Slots out2) throws ParserConfigurationException {


        
        this.in = in;
        this.out1 = out1;
        this.out2 = out2;
        
    }

    public void Distribuir(Slots entrada, Slots salida1, Slots salida2) throws ParserConfigurationException {
        
        for(int i = 0 ; i < entrada.tamanyo(); i++){
            
            doc = entrada.getDocument(i);
        
            String compara = doc.getElementsByTagName("type").item(0).getTextContent();
            
            if("cold".equals(compara)){
                salida1.setDocument(doc);
            }
            else{
                salida2.setDocument(doc);
            }
        }
        
        
//      try {
//            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
//            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
//            Docfiltrado = dBuilder.newDocument();
//            Docfiltrado2 = dBuilder.newDocument();
//            //Preparacion para crear el nuevo documento con los datos filtrados
//            //Elemento raiz cafe_order
//            Element rootElement = Docfiltrado.createElement("cafe_order");
//            Docfiltrado.appendChild(rootElement);
//
//            //Elemento order_id
//            Element order_id = Docfiltrado.createElement("order_id");
//            order_id.appendChild(Docfiltrado.createTextNode("2"));
//            rootElement.appendChild(order_id);
//
//            //Elemento drinks
//            Element drinksElement = Docfiltrado.createElement("drinks");
//            rootElement.appendChild(drinksElement);
//            
//            Docfiltrado2 = Docfiltrado;
//            
//            //Carga los nodos del documento doc para recorrerlo
//            doc.getDocumentElement().normalize();
//            NodeList nList = doc.getElementsByTagName("drink");
//
//            System.out.println("----------------------------");
//
//            //Recorremos la lista de nodo con la etiqueta drink del xml
//            for (int temp = 0; temp < nList.getLength(); temp++) {
//                Node nNode = nList.item(temp);
//
//                //Borrar despues
//                System.out.println("\nSiguiente elemento: ");
//                System.out.println(nNode.getNodeName());
//                //-------------------------------------
//
//                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
//                    Element eElement = (Element) nNode;
//
//                    //Obtenemos el nodo name del xml
//                    NodeList nameList = eElement.getElementsByTagName("name");
//
//                    Node node1 = nameList.item(0);
//
//                    Element bebida = null;
//
//                    if (node1.getNodeType() == node1.ELEMENT_NODE) {
//                        bebida = (Element) node1;
//                        System.out.print("Bebidas: ");
//                        System.out.println(bebida.getTextContent());
//                    }
//
//                    //Obtenemos el nodo type del xml
//                    NodeList typeList = eElement.getElementsByTagName("type");
//
//                    Node nodetype = typeList.item(0);
//
//                    if (nodetype.getNodeType() == nodetype.ELEMENT_NODE) {
//                        Element bebidaTipo = (Element) nodetype;
//                        System.out.print("Tipo: ");
//                        System.out.println(bebidaTipo.getTextContent());
//
//                        compara = bebidaTipo.getTextContent().substring(1,bebidaTipo.getTextContent().length()-1);
//                        //compara = compara. .substring(1); //Para quitar el espacio en blanco del principio
//
//                        //Compruebo el tipo si es igual al filtrado
//                        if (condicion.compareTo(compara) != 0) {
//                            //Elemento drink
//                            Element drinkElement = Docfiltrado.createElement("drink");
//                            drinksElement.appendChild(drinkElement);
//
//                            //Elemento name
//                            Element nameElement = Docfiltrado.createElement("name");
//                            nameElement.appendChild(Docfiltrado.createTextNode(bebida.getTextContent()));
//                            drinkElement.appendChild(nameElement);
//
//                            //Elemento type
//                            Element typeElement = Docfiltrado.createElement("type");
//                            typeElement.appendChild(Docfiltrado.createTextNode(bebidaTipo.getTextContent()));
//                            drinkElement.appendChild(typeElement);
//                        }
//                    }
//
//                }
//            }
//
//            //Comprobacion
//            TransformerFactory transformerFactory = TransformerFactory.newInstance();
//            Transformer transformer = transformerFactory.newTransformer();
//            DOMSource source = new DOMSource(Docfiltrado);
//
//            //Testing por fichero
//            StreamResult Result = new StreamResult(new File("src/FicheroSalida/FicherodePrueba.xml"));
//            transformer.transform(source, Result);
//
//        } catch (ParserConfigurationException ex) {
//            Logger.getLogger(Distributor.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (TransformerConfigurationException ex) {
//            Logger.getLogger(Distributor.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (TransformerException ex) {
//            Logger.getLogger(Distributor.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
        

    }

    public Slots getIn() {
        return in;
    }

    public void setIn(Slots in) {
        this.in = in;
    }

    public Slots getOut() {
        return out1;
    }

    public void setOut(Slots out) {
        this.out1 = out;
    }

    public Document getDoc() {
        return doc;
    }

    public void setDoc(Document doc) {
        this.doc = doc;
    }

}
