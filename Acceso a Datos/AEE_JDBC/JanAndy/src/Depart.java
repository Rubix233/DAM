/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andy
 */
public class Depart {
    
    private int idDepart;
    private String nombreDepart;

    public Depart(int idDepart, String nombreDepart) {
        this.idDepart = idDepart;
        this.nombreDepart = nombreDepart;
    }

    public int getIdDepart() {
        return idDepart;
    }

    public String getNombreDepart() {
        return nombreDepart;
    }

    public void setIdDepart(int idDepart) {
        this.idDepart = idDepart;
    }

    public void setNombreDepart(String nombreDepart) {
        this.nombreDepart = nombreDepart;
    }

    public boolean esValido() {
        if (nombreDepart == null || nombreDepart.isEmpty()) {
            System.out.println("Error: El nombre del departamento no puede estar vacío");
            return false;
        }

        if (idDepart <= 0) {
            System.out.println("Error: El ID del departamento debe ser mayor a 0");
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return "ID: " + idDepart + " | Nombre: " + nombreDepart;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Depart) {
            Depart otro = (Depart) obj;
            return this.idDepart == otro.idDepart;
        }
        return false;
    }
}
