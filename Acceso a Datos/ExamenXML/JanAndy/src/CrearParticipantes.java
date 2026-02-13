/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.File;
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
/**
 *
 * @author andy jan
 */
public class CrearParticipantes {
    public static void main(String[] args) {
        try{
            //La fabrica
            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer();
            
            //parametros para luego transoformar
            DOMSource source;
            StreamResult result;
            File salida = new File("ArchivosOutput/participantes.xml");
            
            
            //El DOM
            Document documento = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
            Element raizParticipantes;

            //El contexto del JAXB
            JAXBContext contexto = JAXBContext.newInstance(Competiciones.Competiciones.class);
            Unmarshaller unmarshall = contexto.createUnmarshaller();
            
            //Volcamos el xml usando el jaxb para crear los objetos
            Competiciones.Competiciones raizCompeticiones = (Competiciones.Competiciones) unmarshall.unmarshal(new File("ContenidoProporcionado/competiciones.xml"));
            
            
            //Creamos nodo raiz para el nuevo xml
            raizParticipantes = documento.createElement("participantes");
            documento.appendChild(raizParticipantes);
            
            for(Competiciones.TipoCompeticion competicion: raizCompeticiones.getCompeticion()){
             
                Element participante = creaElementoVacio(documento,"participante",raizParticipantes);
                
                String nombre = competicion.getParticipante().getNombre() + " " + competicion.getParticipante().getApellidos();
                
                creaElementoLleno(documento,"nombre",nombre,participante);
                
                int pruebas = 0;
                float media = 0;
                
                for(Competiciones.TipoPruebas.Prueba prueba: competicion.getPruebas().getPrueba()){
                    media += prueba.getPuntuacion();
                    pruebas++;     
                }
                
                media = media/pruebas;
                
                creaElementoLleno(documento,"totalPruebas",String.valueOf(pruebas),participante);
                creaElementoLleno(documento,"puntuacionMedia",String.valueOf(media),participante);
                
            }
            
            //Establecemos los parametros para transformar luego
            source = new DOMSource(documento);
            result = new StreamResult(salida);

            transformer.setOutputProperty(javax.xml.transform.OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            transformer.transform(source, result);
            
            
            
            
            
            
            
            
            
            
            
            
            
        } catch (JAXBException ex) {
            Logger.getLogger(CrearParticipantes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(CrearParticipantes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(CrearParticipantes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(CrearParticipantes.class.getName()).log(Level.SEVERE, null, ex);
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
}
