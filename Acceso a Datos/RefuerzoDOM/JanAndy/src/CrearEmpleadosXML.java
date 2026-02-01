
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
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
import org.w3c.dom.Element;
import org.w3c.dom.Text;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Andy
 */
public class CrearEmpleadosXML {

    public static void main(String[] args) {
        final byte TAM = 10;
        String[] empleData;
        DocumentBuilderFactory factory;
        DocumentBuilder builder;
        Document documento;
        Element raiz, emple, apellidos, depart, salario;
        Text texto;

        TransformerFactory tFactory;
        Transformer transformer;
        Source dat;
        Result xml;

        try {
            factory = DocumentBuilderFactory.newInstance();
            builder = factory.newDocumentBuilder();
            documento = builder.newDocument();

            raiz = documento.createElement("empleados");
            documento.appendChild(raiz);

            for (byte i = 0; i < TAM; i++) {
                empleData = leerEmple(i);

                if (empleData != null) {
                    //elemento empleado
                    emple = documento.createElement("empleado");

                    //id no es necesario que sea otro nodo ya que solo se pide como atributo de emple
                    texto = documento.createTextNode(empleData[0]);
                    emple.setAttribute("id", texto.getTextContent());

                    //apellidos
                    apellidos = documento.createElement("apellidos");
                    texto = documento.createTextNode(empleData[1]);
                    apellidos.appendChild(texto);
                    emple.appendChild(apellidos);

                    //Cdepartamento
                    depart = documento.createElement("departamento");
                    texto = documento.createTextNode(empleData[2]);
                    depart.appendChild(texto);
                    emple.appendChild(depart);

                    //salario
                    salario = documento.createElement("salario");
                    texto = documento.createTextNode(empleData[3]);
                    salario.appendChild(texto);
                    emple.appendChild(salario);


                    //Agregar empleado a la raiz
                    raiz.appendChild(emple);
                }

            }

            tFactory = TransformerFactory.newInstance();
            transformer = tFactory.newTransformer();

            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

            dat = new DOMSource(documento);
            xml = new StreamResult(new File("empleados.xml"));

            transformer.transform(dat, xml);


        } catch (ParserConfigurationException ex) {
            System.out.println("Error de parseo de documento XML");
        } catch (TransformerConfigurationException ex) {
            System.out.println("Error en la configuracion del transformador");
        } catch (FileNotFoundException ex) {
            System.out.println("Fichero REmple.dat no encontrado");
        } catch (IOException ex) {
            System.out.println("Error de entrada salida en fichero REmple.dat");
        } catch (TransformerException ex) {
            System.out.println("Error al transformar documento");
        }




    }

    public static String[] leerEmple(byte numRegistro) throws FileNotFoundException, IOException {
        String[] salida = null;
        if (numRegistro >= 0) {
            RandomAccessFile raf = new RandomAccessFile("REmple.dat", "r");
            String departamento, apellidos;
            Integer id;
            Float sueldo;
            long posicion = numRegistro * 78L;

            //Comienza lectura de un registro
            raf.seek(posicion);

            id = raf.readInt(); //Leer Id


            // Leer apellidos (15 caracteres)
            StringBuilder ape = new StringBuilder();
            for (int i = 0; i < 15; i++) {
                ape.append(raf.readChar());
            }
            apellidos = ape.toString().trim();

            // Leer departamento (20 caracteres)
            StringBuilder depart = new StringBuilder();
            for (int i = 0; i < 20; i++) {
                depart.append(raf.readChar());
            }
            departamento = depart.toString().trim();
            sueldo = raf.readFloat();

            //Construir la salida de la funcion y devolver un array
            salida = new String[4];
            salida[0] = id.toString();
            salida[1] = apellidos;
            salida[2] = departamento;
            salida[3] = sueldo.toString();

        }
        return salida;
    }
}
