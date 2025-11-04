
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

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

    public RNombreFicheroDAO(String fichero, String modoApertura) {
        this.modo = modoApertura;
        try {
            this.rndFichero = new RandomAccessFile(fichero, modoApertura);
        } catch (FileNotFoundException fnf) {
            System.out.println("No se ha encontrado el archivo");
        }

    }

    private String leeCaracteres(int longitud) {
        String leido = null;
        try {
            leido = "";
            for (int i = 0; i < longitud; i++) {
                leido += rndFichero.readChar();
            }
        } catch (IOException io) {
            System.out.println("Error al leer");
        }

        return leido;
    }

    private String cadenaFija(String str, int longitud) {
        StringBuilder cadenaFija;
        cadenaFija.setLength(longitud);
        
        
        return null;
    }

    public void irAlPrincipio() {
    }

    public NombreRegistro leer() {
        return null;
    }

    public NombreRegistro leer(long posicion) {
        return null;
    }

    public boolean existe(long posicion) {
        return false;
    }

    public void escribir(NombreRegistro reg, long posicion) {
    }

    public void reescribir(NombreRegistro reg) {
    }

    public void borrar() {
    }

    public void close() {
    }
}
