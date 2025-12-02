
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Andy Jan
 */
public class GestorContenido extends DefaultHandler {

    int elementsOpened = 0;
    
    public GestorContenido() {
        super();
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Comienzo del documento XML");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("Final del documento XML");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        //super.startElement(uri, localName, qName, attributes); //To change body of generated methods, choose Tools | Templates.
        String outputTabs = "\t";
        for(int i = 0; i < elementsOpened; i++){
            outputTabs += "\t";
        }
        elementsOpened++;
        System.out.println(outputTabs + "Principio elemento: " + localName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        //super.endElement(uri, localName, qName); //To change body of generated methods, choose Tools | Templates.
        String outputTabs = "\t";
        elementsOpened--;
        for(int i = 0; i < elementsOpened; i++){
            outputTabs += "\t";
        }
        
        System.out.println(outputTabs +"Fin elemento: " + localName);
    }

    @Override
    @SuppressWarnings("empty-statement")
    public void characters(char[] ch, int start, int length) throws SAXException {
        //super.characters(ch, start, length); //To change body of generated methods, choose Tools | Templates.
        
        String outputTabs = "\t\t";
        for(int i = 0; i < elementsOpened; i++){
            outputTabs += "\t";
        }
        String caracteres = new String(ch,start,length);

        if (!caracteres.trim().equals("")) {
            System.out.println(outputTabs + "Caracteres: " + caracteres);
        }

    }
}
