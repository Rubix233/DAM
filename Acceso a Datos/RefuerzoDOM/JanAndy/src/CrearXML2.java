
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.Text;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andy
 */
public class CrearXML2 {
    public static void main(String[] args) {
        File archivo;
        
        DocumentBuilderFactory factory;
        DocumentBuilder builder;
        Document documento;
        Node raiz,alumno,nombre,id,nota;
        Text texto;
        
        
        try{
            factory = DocumentBuilderFactory.newInstance();
            builder = factory.newDocumentBuilder();
            documento = builder.newDocument();
            
            raiz = documento.createElement("alumnos");
            documento.appendChild(raiz);
            
            //Aggregar al DOM
            for (int i = 0; i < 3; i++) {
                alumno = documento.createElement("alumno");
                raiz.appendChild(alumno);

                //Nombre
                nombre = documento.createElement("nombre");
                texto = documento.createTextNode("Alumno" + i);
                nombre.appendChild(texto);
                alumno.appendChild(nombre);

                //ID
                id = documento.createElement("id");
                texto = documento.createTextNode("" + (i + 1));
                id.appendChild(texto);
                alumno.appendChild(id);

                //Nota
                nota = documento.createElement("nota");
                texto = documento.createTextNode("" + (i * 2));
                nota.appendChild(texto);
                alumno.appendChild(nota);
            }
            archivo = new File("Alumnos.xml");
            
            //Transformador
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            
            //fuente y resultado
            Source fuente = new DOMSource(documento);
            
            Result resultado = new StreamResult(System.out); //AQUI ES LO QUE SE TIENE QUE CAMBIAR PARA QUE SALGA POR CONSOLA
            
            transformer.transform(fuente, resultado);
            
        } catch (ParserConfigurationException ex) {
            System.out.println("Error parseando documento");
        }catch (TransformerConfigurationException ex) {
            System.out.println("Error en la configuracion del transformador");
        } catch (TransformerException ex) {
            System.out.println("Error al transformar");
        }
        
        
    }
}
