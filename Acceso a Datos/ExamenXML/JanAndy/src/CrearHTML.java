
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Andy Jan
 */
public class CrearHTML {

    public static void main(String[] args) {
        try {

            Source xsl = new StreamSource(new File("ContenidoProporcionado/participantes.xsl"));
            Source xml = new StreamSource(new File("ArchivosOutput/participantes.xml"));
            Result html = new StreamResult(new File("ArchivosOutput/listadoOficial.html"));

            Transformer trans = TransformerFactory.newInstance().newTransformer(xsl);
            trans.transform(xml, html);





        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(CrearHTML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(CrearHTML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
