

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andy
 */
public class MostrarDatos {

    public static void main(String[] args){
        Document documento;
        NodeList empleados;
        Element emple;
        String apellidos,depart;
        
        try{
            documento = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse("empleados.xml");
            
            empleados = documento.getElementsByTagName("empleado");
            
            for(int i = 0; i < empleados.getLength(); i++){
                emple = (Element) empleados.item(i);
                
                apellidos = obtenerValorElemento(emple, "apellidos");
                depart = obtenerValorElemento(emple, "departamento");
                
                System.out.println(apellidos + "\t" + depart);
            }
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(MostrarDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public static String obtenerValorElemento(Element elementoPadre, String nombreEtiqueta) {
        String salida = "";
        NodeList listaNodos;
        listaNodos = elementoPadre.getElementsByTagName(nombreEtiqueta);

        if (listaNodos.getLength() < 0) {
            System.out.println("No hay nodos");
        } else {
            salida = listaNodos.item(0).getTextContent();
        }
        return salida;
    }
}
