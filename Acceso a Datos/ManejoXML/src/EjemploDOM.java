
import org.w3c.dom.Document;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andy Jan
 */
import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class EjemploDOM {
    
    // Objeto Document que almacena el DOM del XML seleccionado
    Document doc; 
    
    // Nombre del archivo XML para guardar los cambios
    private static final String NOMBRE_ARCHIVO = "libros.xml";

    // --- Función para Abrir y Cargar el XML en DOM ---
    
    /**
     * Carga el archivo XML en un objeto Document (DOM).
     * @param fichero El archivo XML a abrir.
     * @return 0 si la operación es exitosa, -1 si hay un error.
     */
    public int abrir_XML_DOM(File fichero){
        doc = null; // Inicializa el objeto Document
        try {
            // 1. Crear una instancia de DocumentBuilderFactory.
            // Es la clase que permite obtener un DocumentBuilder.
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            
            // 2. Crear un DocumentBuilder.
            // Es la clase que realmente lee y construye el DOM a partir del XML.
            DocumentBuilder builder = factory.newDocumentBuilder();
            
            // 3. Parsear (analizar) el archivo y construir el Document (el DOM).
            doc = builder.parse(fichero);
            
            // 4. Normalizar el Document. 
            // Esto combina nodos de texto adyacentes y elimina nodos vacíos, 
            // lo que facilita el recorrido y la manipulación.
            doc.getDocumentElement().normalize();
            
            System.out.println("Archivo XML cargado en DOM correctamente.");
            return 0; // Éxito
            
        } catch (ParserConfigurationException pce) {
            // Error en la configuración del DocumentBuilder.
            System.err.println("Error de configuración del parser: " + pce.getMessage());
            return -1;
        } catch (SAXException se) {
            // Error durante el parseo del XML.
            System.err.println("Error de parseo (SAX): " + se.getMessage());
            return -1;
        } catch (IOException ioe) {
            // Error de entrada/salida (e.g., archivo no encontrado).
            System.err.println("Error de I/O: " + ioe.getMessage());
            return -1;
        }
    }

    // --- Función para Recorrer el DOM y Mostrar Contenido ---

    /**
     * Recorre el árbol DOM e imprime la información de cada libro.
     * @return Una cadena con la información de todos los libros.
     */
    public String recorrerDOMyMostrar(){
        String datosNodo = ""; // Acumula la información de los libros.
        String[] datosLibro = null; // Almacena Título, Autor y Año.
        
        // Verifica si el Document ha sido cargado.
        if (doc == null) {
            return "Error: Documento XML no cargado.";
        }
        
        // Obtiene una lista de todos los nodos con la etiqueta <Libro>.
        NodeList listaLibros = doc.getElementsByTagName("Libro");
        
        // Itera sobre cada nodo <Libro> de la lista.
        for (int i = 0; i < listaLibros.getLength(); i++) {
            Node nodoLibro = listaLibros.item(i); // Obtiene el nodo <Libro> actual.
            
            // Un nodo puede ser un Elemento (<Libro>), un Texto, etc. 
            // Solo procesamos nodos que son Elementos.
            if (nodoLibro.getNodeType() == Node.ELEMENT_NODE) {
                // Llama a la función auxiliar para extraer los datos del libro.
                datosLibro = procesarLibro(nodoLibro);
                
                // Formatea la información para la salida.
                datosNodo += "Título: " + datosLibro[0] + 
                             " | Autor: " + datosLibro[1] + 
                             " | Año: " + datosLibro[2] + "\n";
            }
        }
        
        return datosNodo.isEmpty() ? "No se encontraron libros en el XML." : datosNodo;
    }

    // --- Función Auxiliar para Procesar un Nodo Libro ---
    
    /**
     * Procesa un nodo <Libro> y extrae su Título, Autor y el atributo publicado_en.
     * @param n El nodo <Libro> a procesar.
     * @return Un array de String con [Título, Autor, publicado_en].
     */
    protected String[] procesarLibro(Node n){
        String[] datos = new String[3]; // [Titulo, Autor, Año]
        Element libroElemento = (Element) n; // Castea el Node a Element para acceder a atributos.
        
        // 1. Obtener el atributo 'publicado_en' del elemento <Libro>.
        // El atributo es el año en este caso.
        datos[2] = libroElemento.getAttribute("publicado_en");
        
        // 2. Obtener el nodo <Titulo> (hijo del <Libro>).
        // getElementsByTagName(tag) busca hijos directos e indirectos, 
        // pero en este contexto simple, el primer item es el correcto.
        NodeList nodoTitulo = libroElemento.getElementsByTagName("Titulo");
        // Obtiene el contenido de texto (primer y único hijo de <Titulo>).
        datos[0] = nodoTitulo.item(0).getTextContent();
        
        // 3. Obtener el nodo <Autor> (hijo del <Libro>).
        NodeList nodoAutor = libroElemento.getElementsByTagName("Autor");
        // Obtiene el contenido de texto (primer y único hijo de <Autor>).
        datos[1] = nodoAutor.item(0).getTextContent();
        
        return datos;
    }

    // --- Función para Añadir un Nuevo Libro al DOM ---
    
    /**
     * Añade un nuevo elemento <Libro> al DOM y lo guarda en el archivo.
     * @param titulo El título del nuevo libro.
     * @param autor El autor del nuevo libro.
     * @param anno El año de publicación (se convierte en atributo).
     * @return 0 si la adición y guardado son exitosos, -1 si hay un error.
     */
    public int aniadirDOM(String titulo, String autor, String anno){
        if (doc == null) {
            System.err.println("Error: Documento XML no cargado.");
            return -1;
        }

        try {
            // 1. Crear el elemento raíz (Libro) y su atributo.
            Element nuevoLibro = doc.createElement("Libro");
            
            // Crear y añadir el atributo "publicado_en".
            Attr attrAnno = doc.createAttribute("publicado_en");
            attrAnno.setValue(anno); // Establecer el valor del atributo.
            nuevoLibro.setAttributeNode(attrAnno); // Asignar el atributo al elemento <Libro>.
            
            // 2. Crear y añadir los elementos hijos (<Titulo> y <Autor>).
            
            // Crear el elemento <Titulo>.
            Element nodoTitulo = doc.createElement("Titulo");
            // Crear el nodo de texto con el título y asignarlo a <Titulo>.
            Node textoTitulo = doc.createTextNode(titulo);
            nodoTitulo.appendChild(textoTitulo); // <Titulo>text</Titulo>
            
            // Crear el elemento <Autor>.
            Element nodoAutor = doc.createElement("Autor");
            // Crear el nodo de texto con el autor y asignarlo a <Autor>.
            Node textoAutor = doc.createTextNode(autor);
            nodoAutor.appendChild(textoAutor); // <Autor>text</Autor>
            
            // 3. Ensamblar el <Libro>.
            nuevoLibro.appendChild(nodoTitulo);
            nuevoLibro.appendChild(nodoAutor);
            
            // 4. Obtener el nodo raíz (<Libros>) y añadir el nuevo <Libro> al final.
            Node raiz = doc.getDocumentElement();
            raiz.appendChild(nuevoLibro);
            
            // 5. Guardar el DOM modificado en el archivo XML.
            return guardarDOMEnArchivo(NOMBRE_ARCHIVO);
            
        } catch (Exception e) {
            System.err.println("Error al añadir o guardar el DOM: " + e.getMessage());
            return -1;
        }
    }
    
    /**
     * Guarda el Document (DOM) actual en un archivo XML.
     * @param nombreArchivo El nombre del archivo donde guardar.
     * @return 0 si es exitoso, -1 si hay error.
     */
    private int guardarDOMEnArchivo(String nombreArchivo) {
        try {
            // 1. Crear una instancia de TransformerFactory.
            TransformerFactory factory = TransformerFactory.newInstance();
            // 2. Crear un Transformer.
            // Es la clase que toma el DOM y lo serializa (convierte a XML de texto).
            Transformer transformer = factory.newTransformer();
            
            // 3. Crear el origen (Source) y el resultado (Result).
            Source source = new DOMSource(doc); // El origen es el DOM (nuestro objeto 'doc').
            Result result = new StreamResult(new File(nombreArchivo)); // El destino es el archivo.
            
            // 4. Realizar la transformación (escritura).
            transformer.transform(source, result);
            
            System.out.println("Documento guardado en " + nombreArchivo + " correctamente.");
            return 0; // Éxito
        } catch (TransformerException te) {
            System.err.println("Error al transformar/guardar el DOM: " + te.getMessage());
            return -1;
        }
    }

    // --- Función Main para la Ejecución de Ejemplo ---
    
    public static void main(String[] args) {
        EjemploDOM gestor = new EjemploDOM();
        File archivo = new File(NOMBRE_ARCHIVO);

        System.out.println("--- 1. CARGA DEL XML ---");
        // 1. Abrir el XML y cargarlo en el Document (DOM).
        if (gestor.abrir_XML_DOM(archivo) == 0) {
            
            System.out.println("\n--- 2. RECORRIDO Y LECTURA DEL DOM INICIAL ---");
            // 2. Recorrer el DOM y mostrar su contenido.
            String contenidoInicial = gestor.recorrerDOMyMostrar();
            System.out.println(contenidoInicial);
            
            System.out.println("----------------------------------------------");
            
            // 3. Añadir un nuevo libro al DOM y guardar los cambios.
            System.out.println("\n--- 3. AÑADIR NUEVO LIBRO Y GUARDAR ---");
            String nuevoTitulo = "Cien años de soledad";
            String nuevoAutor = "Gabriel García Márquez";
            String nuevoAnno = "1967";
            
            System.out.println("Intentando añadir: " + nuevoTitulo + " (" + nuevoAnno + ")");
            if (gestor.aniadirDOM(nuevoTitulo, nuevoAutor, nuevoAnno) == 0) {
                System.out.println("Nuevo libro añadido y cambios guardados.");
            } else {
                System.err.println("Falló la adición/guardado del nuevo libro.");
            }

            // 4. Volver a cargar el archivo (opcional, pero demuestra que se guardó).
            System.out.println("\n--- 4. VOLVER A CARGAR Y MOSTRAR (Tras la adición) ---");
            if (gestor.abrir_XML_DOM(archivo) == 0) {
                 String contenidoFinal = gestor.recorrerDOMyMostrar();
                 System.out.println(contenidoFinal);
            }
            
        } else {
            System.err.println("No se pudo cargar el archivo XML. Verifica que '" + NOMBRE_ARCHIVO + "' existe.");
        }
    }
}
