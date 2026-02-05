
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
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
import org.w3c.dom.Node;
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
public class CrearPeliculas {

    public static void main(String[] args) {
        DocumentBuilderFactory factory;
        DocumentBuilder builderOrigin, builderDestino;
        Document documentoOrigin, documentoDestino;

        Node raiz, titulo, duracion, veces;

        NodeList peliculas;
        Map<String, Integer> mapaPeliculas = new HashMap<String, Integer>();
        Map<String, Element> datosPeliculas = new HashMap<String, Element>();


        try {
            factory = DocumentBuilderFactory.newInstance();
            factory.setNamespaceAware(true);
            //Archivo original
            builderOrigin = factory.newDocumentBuilder();
            documentoOrigin = builderOrigin.parse("XMLSchemaAvanzados05_videoclub.xml");
            //DOM nuevo
            builderDestino = factory.newDocumentBuilder();
            documentoDestino = builderDestino.newDocument();

            peliculas = documentoOrigin.getElementsByTagNameNS("*", "pelicula");
            //Guardamos el numero de veces de una peli
            for (int i = 0; i < peliculas.getLength(); i++) {
                Element peli = (Element) peliculas.item(i);
                String id = peli.getAttribute("id_pelicula");

                if (mapaPeliculas.containsKey(id)) {
                    mapaPeliculas.put(id, mapaPeliculas.get(id) + 1);
                } else {
                    mapaPeliculas.put(id, 1);
                    datosPeliculas.put(id, peli);
                }
            }

            raiz = documentoDestino.createElement("peliculas");
            documentoDestino.appendChild(raiz);

            for (String id : mapaPeliculas.keySet()) {
                // 1. Crear el contenedor principal <Pelicula>
                Element nuevaPeli = documentoDestino.createElement("Pelicula");
                raiz.appendChild(nuevaPeli);

                // 2. Extraer info del mapa y del elemento original
                Element peliActual = datosPeliculas.get(id);
                String tituloStr = peliActual.getElementsByTagNameNS("*", "titulo").item(0).getTextContent();
                String duracionStr = peliActual.getElementsByTagNameNS("*", "duracion").item(0).getTextContent();
                int vecesInt = mapaPeliculas.get(id);

                // 3. Crear el elemento <Id> 
                Element elId = documentoDestino.createElement("Id");
                elId.appendChild(documentoDestino.createTextNode(id));
                nuevaPeli.appendChild(elId);

                // 4. Crear el elemento <Titulo>
                Element elTitulo = documentoDestino.createElement("Titulo");
                elTitulo.appendChild(documentoDestino.createTextNode(tituloStr));
                nuevaPeli.appendChild(elTitulo);

                // 5. Crear el elemento <Duracion>
                Element elDuracion = documentoDestino.createElement("Duracion");
                elDuracion.appendChild(documentoDestino.createTextNode(duracionStr));
                nuevaPeli.appendChild(elDuracion);

                // 6. Crear el elemento <Veces>
                Element elVeces = documentoDestino.createElement("Veces");
                elVeces.appendChild(documentoDestino.createTextNode(String.valueOf(vecesInt)));
                nuevaPeli.appendChild(elVeces);
            }

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(CrearPeliculas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(CrearPeliculas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CrearPeliculas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
