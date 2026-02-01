/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andy
 */
import datos.libros.Libros; // Asegúrate de que este sea el paquete de tus clases generadas
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class CrearLibrosEditorial {

    public static void main(String[] args) {
        // Configuramos el lector de consola al principio
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            // Instanciar el contexto de JAXB con el paquete generado
            JAXBContext jc = JAXBContext.newInstance("datos.libros");

            // UNMARSHALLING: Leer el XML original (libros.xml)
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            File original = new File("libros.xml");

            if (!original.exists()) {
                System.out.println("Error: No se encuentra el archivo libros.xml");
                return;
            }

            Libros misLibros = (Libros) unmarshaller.unmarshal(original);

            // MODIFICAR LOS OBJETOS
            List<Libros.Libro> lista = misLibros.getLibro();
            for (Libros.Libro l : lista) {
                System.out.print("Introduce el nombre de la Editorial para los libros: ");
                String nombreEditorial = br.readLine();
                l.setEditorial(nombreEditorial);
            }

            // MARSHALLING: Guardar el nuevo XML validado
            Marshaller marshaller = jc.createMarshaller();

            // Indentación para que el archivo sea legible
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            // Definir la codificación
            marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");

            File archivoDestino = new File("LibrosXMLEditorial.xml");
            marshaller.marshal(misLibros, archivoDestino);

            System.out.println("\nProceso completado con éxito.");
            System.out.println("Archivo generado: " + archivoDestino.getAbsolutePath());

        } catch (Exception e) {
            System.err.println("Ocurrió un error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Cerramos el buffer de lectura
            try {
                if (br != null) {
                    br.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
