
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andy Jan
 */
public class RecorridoSAX {
    public static void main(String[] args){
        try{
            XMLReader procesadorXML = XMLReaderFactory.createXMLReader();
            GestorContenido gestor = new GestorContenido();
            procesadorXML.setContentHandler(gestor);
            InputSource fileXML = new InputSource("libros.xml".replace('/', File.separatorChar));
            procesadorXML.parse(fileXML);
        } catch (FileNotFoundException fnf){
            System.out.println("Fich no encontrado");
        } catch (SAXException ex) {
            Logger.getLogger(RecorridoSAX.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(RecorridoSAX.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
