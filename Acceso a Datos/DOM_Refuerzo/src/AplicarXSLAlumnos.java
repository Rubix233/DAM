
import java.io.File;
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
 * @author Administrador
 */
public class AplicarXSLAlumnos {
    public static void main(String[] args) {
        TransformerFactory factory;
        Source xslt,xml;
        Transformer transformer;
        Result html;
        File htmlFile;
        
        try{
            //factory
            factory = TransformerFactory.newInstance();
            
            //hoja de estilos que le pasamos al transformer
            xslt = new StreamSource(new File("Alumnos.xsl"));
            transformer = factory.newTransformer(xslt);
            
            //archivo xml
            xml = new StreamSource(new File("Alumnos.xml"));
            
            //Archivo html
            htmlFile = new File("Alumnos.html");
            html = new StreamResult(htmlFile);
            
            //Transformacion del xml al html
            transformer.transform(xml, html);
            System.out.println("Creado: "+ htmlFile.getAbsolutePath());
            
            
        }catch (TransformerConfigurationException ex) {
            System.out.println("Error al configurar la transformacion");
        } catch (TransformerException ex) {
            System.out.println("Error en la tranformacion");
        }
    }
}
