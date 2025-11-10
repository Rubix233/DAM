
import java.io.Serializable;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Andy Jan
 */
public class Persona implements Serializable {

    int edad;
    String nombre;
    String coche;

    public Persona(int edad, String nombre, String coche) {
        this.edad = edad;
        this.nombre = nombre;
        this.coche = coche;
    }

    public int getEdad() {
        return edad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCoche() {
        return coche;
    }
}
