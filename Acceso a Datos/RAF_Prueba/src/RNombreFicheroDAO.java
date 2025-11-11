
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author AndyJan
 */
public class RNombreFicheroDAO {

    private final byte TAM = 58;
    boolean eof;
    private RandomAccessFile rndFichero;
    private String modo;

    public RNombreFicheroDAO(String fichero, String modoApertura) throws FileNotFoundException, IllegalArgumentException {
        this.modo = modoApertura;
        this.rndFichero = new RandomAccessFile(fichero, modoApertura);


    }

    private String leeCaracteres(int longitud) throws IOException, EOFException {
        String leido = null;
        try {
            leido = "";
            for (int i = 0; i < longitud; i++) {
                leido += rndFichero.readChar();
            }
            rndFichero.seek(rndFichero.getFilePointer() - longitud);
        } catch (IOException io) {
            System.out.println("Error al leer");
        }

        return leido;
    }

    private String cadenaFija(String str, int longitud) {
        StringBuilder cadenaFija = new StringBuilder(str);
        if (str.length() <= longitud) {
            cadenaFija.setLength(longitud);
            return cadenaFija.toString();
        }
        return null;
    }

    public void irAlPrincipio() throws IOException {

        rndFichero.seek(0);

    }

    public NombreRegistro leer() throws IOException {
        int id;
        String nombre = "";
        String apellido = "";
        float sueldo;

        id = rndFichero.readInt();
        for (int i = 0; i < 10; i++) {
            nombre += rndFichero.readChar();
        }
        for (int i = 0; i < 15; i++) {
            apellido += rndFichero.readChar();
        }
        sueldo = rndFichero.readFloat();

        return new NombreRegistro(nombre, apellido, sueldo);
    }

    public NombreRegistro leer(long posicion) throws IOException {
        if (existe(posicion)) {
            return leer();
        }
        return null;
    }

    public boolean existe(long posicion) throws IOException {
        int id = 0;
        rndFichero.seek(posicion);
        id = rndFichero.readInt();
        rndFichero.seek(rndFichero.getFilePointer() - 4);

        return id != 0;
    }

    public void escribir(NombreRegistro reg, long posicion) throws IOException {
        if (!existe(posicion)) {
            int id = (int) (posicion / TAM) + 1;

            rndFichero.writeInt(id);
            rndFichero.writeChars(cadenaFija(reg.getNombre(), 10));
            rndFichero.writeChars(cadenaFija(reg.getApellido(), 15));
            rndFichero.writeFloat(reg.getSueldo());

        }
    }

    public void reescribir(NombreRegistro reg) throws IOException {

        boolean encontrado = false;
        irAlPrincipio();
        do {
            if (leer().equals(reg)) {
                rndFichero.seek(rndFichero.getFilePointer() - TAM);
                int id = (int) (rndFichero.getFilePointer() / TAM) + 1;
                rndFichero.writeInt(id);
                rndFichero.writeChars(cadenaFija(reg.getNombre(), 10));
                rndFichero.writeChars(cadenaFija(reg.getApellido(), 15));
                rndFichero.writeFloat(reg.getSueldo());
                encontrado = true;
            }
        } while (!encontrado);



    }

    public void borrar() throws IOException {

        rndFichero.seek(rndFichero.getFilePointer() - TAM);
        rndFichero.writeInt(0);
        rndFichero.writeChars(cadenaFija("", 10));
        rndFichero.writeChars(cadenaFija("", 15));
        rndFichero.writeFloat(0);

    }

    public void close() throws IOException {
        if (rndFichero != null) {
            rndFichero.close();
            System.out.println("Archivo cerrado correctamente.");

        }
    }
}
