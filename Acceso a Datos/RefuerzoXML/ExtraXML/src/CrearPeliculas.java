
import java.io.File;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Node;


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
        try {
            //La fabrica
            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer();

            //Para guardar las pelis que hemos visto. Era esto o un xpath para hacer el conteo
            HashMap<String, Element> pelisProcesadas = new HashMap<String, Element>();

            //parametros para luego transoformar
            DOMSource source;
            StreamResult result;
            File salida = new File("Archivos/Peliculas.xml");

            //El DOM
            Document documento = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
            Element raizPelis;

            //El contexto del JAXB
            JAXBContext contexto = JAXBContext.newInstance(javaPeliculas.Facturas.class);
            Unmarshaller unmarshall = contexto.createUnmarshaller();


            //Volcamos el xml usando el jaxb para crear los objetos
            javaPeliculas.Facturas raizFacturas = (javaPeliculas.Facturas) unmarshall.unmarshal(new File("Archivos/XMLSchemaAvanzados05_videoclub.xml"));
            
            //Creamos nodo raiz para el nuevo xml
            raizPelis = documento.createElement("peliculas");
            documento.appendChild(raizPelis);

            //Miramos cada factura
            for (javaPeliculas.Factura factura : raizFacturas.getFactura()) {
                //Si la factura tiene alquileres
                if (factura.getDatosFactura().getAlquileres() != null) {
                    //Miramos cada pelicula de la factura
                    for (javaPeliculas.Pelicula pelicula : factura.getDatosFactura().getAlquileres().getPeliculas().getPelicula()) {
                        //Si no se ha procesado ya
                        if (!pelisProcesadas.containsKey(pelicula.getTitulo())) {

                            //Se crea elemento peli y se va rellenando
                            Element peli = creaElementoVacio(documento, "pelicula", raizPelis);
                            peli.setAttribute("id", pelicula.getIdPelicula());

                            creaElementoLleno(documento, "titulo", pelicula.getTitulo(), peli);
                            creaElementoLleno(documento, "duracion", pelicula.getDuracion().toString(), peli);
                            creaElementoLleno(documento, "veces", "1", peli);

                            //Se registra en nuestro hashmap
                            pelisProcesadas.put(pelicula.getTitulo(), peli);
                        } else {
                            //Si ya la hemos procesado, obtenemos el nodo "veces" y le sumamos 1
                            Node veces = pelisProcesadas.get(pelicula.getTitulo()).getElementsByTagName("veces").item(0);
                            int conteo = Integer.parseInt(veces.getTextContent());
                            veces.setTextContent(String.valueOf(conteo + 1));
                        }
                    }
                }

            }
            //Establecemos los parametros para transformar luego
            source = new DOMSource(documento);
            result = new StreamResult(salida);

            transformer.setOutputProperty(javax.xml.transform.OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            transformer.transform(source, result);

        } catch (JAXBException ex) {
            Logger.getLogger(CrearPeliculas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(CrearPeliculas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(CrearPeliculas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(CrearPeliculas.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

    public static org.w3c.dom.Element creaElementoVacio(Document dom, String nombreElemento, org.w3c.dom.Element padre) {
        org.w3c.dom.Element creado;


        creado = dom.createElement(nombreElemento);
        padre.appendChild(creado);
        return creado;
    }

    public static org.w3c.dom.Element creaElementoLleno(Document dom, String nombreElemento, String contenido, org.w3c.dom.Element padre) {
        org.w3c.dom.Element creado;

        creado = dom.createElement(nombreElemento);
        creado.setTextContent(contenido);
        padre.appendChild(creado);
        return creado;
    }
    
    /*
     *  Source xsl = new StreamSource(new File("PeliculasMas120.xsl"));
        Source xml = new StreamSource(new File("Archivos/Peliculas.xml"));
        Result html = new StreamResult(new File("PeliculasMas120.html"));

        Transformer trans = TransformerFactory.newInstance().newTransformer(xsl);
        trans.transform(xml, html);
     */
}
