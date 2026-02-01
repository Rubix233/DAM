
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
 * @author Andy
 */
public class TransformarXML {
    public static void main(String[] args) {
        Transformer transformer;
        Source xslt,xml;
        Result html;
        
        try{
            xslt = new StreamSource(new File("empleados.xsl"));
            transformer = TransformerFactory.newInstance().newTransformer(xslt);
            xml = new StreamSource(new File("empleados.xml")); 
            html = new StreamResult(new File("empleados.html"));
            
            transformer.transform(xml, html);
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(TransformarXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(TransformarXML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
