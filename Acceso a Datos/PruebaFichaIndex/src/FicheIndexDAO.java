
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Andy Jan
 */
public class FicheIndexDAO {

    private String archivoRuta = "FicheIndex.dat";
    private String indiceRuta = "FicheIndex.idx";
    private final int tamEntrada = 91;
    private final int tamDNI = 9;
    private final int tamNombre = 30;
    private TreeMap<String, Integer> indice;
    private List<Integer> huecosLibres;

    public FicheIndexDAO() {
        File f = new File(indiceRuta);

        //miramos si existen ya el mapa y la lista
        if (f.exists()) {
            // cargar objetos
            leerObjetos();
        } else {
            // crear objetos vacios
            indice = new TreeMap<>();
            huecosLibres = new LinkedList<>();
        }
    }

    public FicheIndexDAO(String archivoRuta, String indiceRuta) {
        this.archivoRuta = archivoRuta;
        this.indiceRuta = indiceRuta;
        leerObjetos();
    }

    public boolean existeEmpleado(String dni) {
        return indice.containsKey(dni);
    }

    private void escribirEmpleado(Empleado emple, RandomAccessFile raf) throws IOException {
        //DNI nombre sexo y salario
        escribirStringFijo(emple.getDNI(), tamDNI, raf);
        escribirStringFijo(emple.getNomApe(), tamNombre, raf);
        raf.writeChar(emple.getSexo().getCodigo());
        raf.writeFloat(emple.getSalario());
        //fecha
        raf.writeShort(emple.getFechaIngreso().getAnio());
        raf.writeByte(emple.getFechaIngreso().getMes());
        raf.writeByte(emple.getFechaIngreso().getDia());
        //tipo y provincia
        raf.writeChar(emple.getTipo().getCodigo());
        raf.writeByte(emple.getProvincia().getCodigo());
    }

    public boolean modificarEmpleado(Empleado emple) throws IOException {
        if (!indice.containsKey(emple.getDNI())) {
            return false;
        }

        RandomAccessFile raf = null;
        //usamos try por si algo falla y asegurarnos de cerrar
        try {
            raf = new RandomAccessFile(archivoRuta, "rw");

            //buscamos posicion
            long posicion = indice.get(emple.getDNI());

            // movemos el cursor
            raf.seek(posicion);

            //reescribimos el empleado actualizado
            escribirEmpleado(emple, raf);

            return true;

        } finally {
            if (raf != null) {
                raf.close();
            }
        }

    }

    public void crearEmpleado(Empleado emple) throws IOException {
        RandomAccessFile raf = null;
        long posicion;

        //usamos try para poder cerrar con finally si ocurre algun error
        try {
            raf = new RandomAccessFile(archivoRuta, "rw");
            //Buscamos si hay hueco libre y asignamos posicion de puntero
            if (!huecosLibres.isEmpty()) {
                posicion = huecosLibres.remove(0);
                raf.seek(posicion);
            } else {
                posicion = raf.length();
                raf.seek(posicion);
            }
            //Escribimos el empleado
            escribirEmpleado(emple, raf);

            //actualizamos indice
            indice.put(emple.getDNI(), (int) (posicion));
            guardarObjetos();
        } finally {
            //cerramos archivo
            if (raf != null) {
                raf.close();
            }
        }
    }

    public boolean borrarEmpleado(String DNI) throws IOException {
        if (!indice.containsKey(DNI)) {
            return false;
        }
        RandomAccessFile raf = null;

        //usamos try and finally por si ocurre cualquier error asegurarnos de cerrar el archivo
        try {
            raf = new RandomAccessFile(archivoRuta, "rw");

            // Get position from Map
            long posicion = indice.get(DNI);

            // Go to that position
            raf.seek(posicion);

            //sobreescribimos con elementos vacios o negatvos
            escribirStringFijo("", tamDNI, raf);
            escribirStringFijo("", tamNombre, raf);
            raf.writeChar(' ');
            raf.writeFloat(-1);
            raf.writeShort(-1);
            raf.writeByte(-1);
            raf.writeByte(-1);
            raf.writeChar(' ');
            raf.writeByte(-1);

            // actualizamos huecos ibres
            huecosLibres.add((int) posicion);

            // quitamos del mapa
            indice.remove(DNI);
            guardarObjetos();

            return true;
        } finally {
            if (raf != null) {
                raf.close();
            }
        }

    }

    public void listarPorOrdenArchivo() throws IOException {
        RandomAccessFile raf = null;
        //Usamos try por si ocurre algun error y cerramos con finally
        try {
            raf = new RandomAccessFile(archivoRuta, "r");

            while (raf.getFilePointer() < raf.length()) {
                long currentPos = raf.getFilePointer();

                // miramos primero el DNI
                String dni = leerStringFijo(tamDNI, raf);

                // miramos si es un hueco vacio
                if (dni.trim().isEmpty()) {
                    //Si esta borrado nos saltamos el resto de la entrada
                    raf.skipBytes(tamEntrada - (tamDNI * 2));
                }

                // If not deleted, read the rest normally
                // (Note: we already read the passport, so we pass it to a helper)
                Empleado emple = leerRestoEmple(dni, raf);
                System.out.println(emple.toString());
            }
        } finally {
            if (raf != null) {
                raf.close();
            }
        }
    }

    private Empleado leerRestoEmple(String dni, RandomAccessFile raf) throws IOException {
        Empleado emple;
        Fecha fecha;
        // leemos el resto para construir objeto empleado
        String nombre = leerStringFijo(tamNombre, raf);
        char sexo = raf.readChar();
        float salario = raf.readFloat();
        short year = raf.readShort();
        byte month = raf.readByte();
        byte day = raf.readByte();
        char tipo = raf.readChar();
        byte prov = raf.readByte();

        //Construimos el empleado
        fecha = new Fecha(year, month, day);
        emple = new Empleado(dni, nombre, Sexo.fromCodigo(sexo), salario, fecha, Tipo.fromCodigo(tipo), Provincia.fromCodigo(prov));

        return emple;
    }

    private void escribirStringFijo(String str, int length, RandomAccessFile raf) throws IOException {
        StringBuffer sBuffer;
        if (str != null) {
            sBuffer = new StringBuffer(str);
        } else {
            sBuffer = new StringBuffer(length);
        }

        sBuffer.setLength(length);
        raf.writeChars(sBuffer.toString());
    }

    private String leerStringFijo(int length, RandomAccessFile raf) throws IOException {
        char[] chars = new char[length];
        for (int i = 0; i < length; i++) {
            chars[i] = raf.readChar();
        }
        return new String(chars).trim();
    }

    private void guardarObjetos() throws IOException, FileNotFoundException {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(indiceRuta);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(this.indice);
            oos.writeObject(this.huecosLibres);
        } finally {
            if (fos != null) {
                fos.close();
            }
        }
    }

    private void leerObjetos() {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(indiceRuta);
            ObjectInputStream ois = new ObjectInputStream(fis);

            this.indice = (TreeMap<String, Integer>) ois.readObject();
            this.huecosLibres = (List<Integer>) ois.readObject();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(FicheIndexDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FicheIndexDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FicheIndexDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fis.close();
            } catch (IOException ex) {
                Logger.getLogger(FicheIndexDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
