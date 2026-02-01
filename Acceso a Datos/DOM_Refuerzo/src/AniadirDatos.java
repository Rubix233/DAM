
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Andy
 */
public class AniadirDatos {

    public static void main(String[] args) {
        BufferedReader teclado;
        int id;
        String apellidos, departamento;
        Float salario;

        Document documento;
        Transformer transformer;
        NodeList empleados;
        Text texto;
        Element raiz, emple, ape, depart, sueldo;
        
        DOMSource dom;
        Result xml;

        try {
            documento = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse("empleados.xml");
            teclado = new BufferedReader(new InputStreamReader(System.in));

            //Lista de empleados
            empleados = documento.getElementsByTagName("empleado");

            //Id del ultimo
            id = Integer.parseInt(((Element) empleados.item(empleados.getLength() - 1)).getAttribute("id"));
            //Raiz
            raiz = documento.getDocumentElement();

            for (int i = 0; i < 2; i++) {
                do {
                    System.out.println("Introduce apellidos: ");
                    apellidos = teclado.readLine();
                } while (apellidos.isEmpty());

                do {
                    System.out.println("Introduce departamento: ");
                    departamento = teclado.readLine();
                } while (departamento.isEmpty());

                do {
                    salario = -1f;
                    try {
                        System.out.println("introduce salario:");
                        salario = Float.parseFloat(teclado.readLine());
                    } catch (NumberFormatException nfe) {
                        System.out.println("dato invalido, teclee otro.");
                    }
                } while (salario < 0);
                
                //Crear nuevo empleado
                emple = documento.createElement("empleado");
                emple.setAttribute("id", Integer.toString(id++));
                
                ape = documento.createElement("apellidos");
                texto = documento.createTextNode(apellidos);
                ape.appendChild(texto);
                emple.appendChild(ape);
                
                depart = documento.createElement("departamento");
                texto = documento.createTextNode(departamento);
                depart.appendChild(texto);
                emple.appendChild(depart);
                
                sueldo = documento.createElement("salario");
                texto = documento.createTextNode(Float.toString(salario));
                sueldo.appendChild(texto);
                emple.appendChild(sueldo);
                
                raiz.appendChild(emple);
            }

            transformer = TransformerFactory.newInstance().newTransformer();
            
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            
            dom = new DOMSource(documento);
            xml = new StreamResult(new File("empleados.xml"));
            
            transformer.transform(dom, xml);

        } catch (ParserConfigurationException | SAXException | IOException | TransformerConfigurationException ex) {
            Logger.getLogger(AniadirDatos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(AniadirDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
