/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.*;

/**
 *
 * @author Andy
 */
public class CrearDOM {

    public static void main(String[] args) {
        DocumentBuilderFactory factory;
        DocumentBuilder builder;
        Document documento;
        Node raiz, alumno, nombre, id, nota;
        Text texto;
        try {
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
            //Mostrar DOM
            NodeList lista;
            Node alumnoAMostrar;

            lista = documento.getElementsByTagName("alumno");
            System.out.println("<alumnos>");

            for (int i = 0; i < lista.getLength(); i++) {
                alumnoAMostrar = lista.item(i);
                System.out.println("\t <alumno>");
                
                if(alumnoAMostrar.getNodeType() == Node.ELEMENT_NODE){
                    Element elemento = (Element) alumnoAMostrar;
                    
                    String nombreAlumno = elemento.getElementsByTagName("nombre").item(0).getTextContent();
                    String idAlumno = elemento.getElementsByTagName("id").item(0).getTextContent();
                    String notaAlumno = elemento.getElementsByTagName("nota").item(0).getTextContent();
                    
                    System.out.println("\t\t<nombre>: " + nombreAlumno + "</nombre>");
                    System.out.println("\t\t<id>: " + idAlumno + "</id>");
                    System.out.println("\t\t<nota>: " + notaAlumno + "</nota>");
                    System.out.println("\t</alumno>");
                }  
            }
            System.out.println("</alumnos>");

        } catch (ParserConfigurationException ex) {
            System.out.println("Error parseando documentoo");
        }
    }
}
