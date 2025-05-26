
import java.util.GregorianCalendar;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Andy Jan
 */
public class Saltador implements Comparable<Saltador> {

    private int dorsal;
    private String nombre;
    private String pais;
    private char sexo;
    private double puntos;
    private int numeroSaltos;
    private GregorianCalendar ultimoSalto;

    public Saltador(int dorsal, String nombre, String pais, char sexo) {
        this.dorsal = dorsal;
        this.nombre = nombre;
        this.pais = pais;
        this.sexo = sexo;
    }

    public int getDorsal() {
        return this.dorsal;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getPais() {
        return this.pais;
    }

    public char getSexo() {
        return this.sexo;
    }

    public double getPuntos() {
        return this.puntos;
    }

    public int getSaltos() {
        return this.numeroSaltos;
    }

    public String getFecha() {
        int dia;
        int mes;
        int anio;
        String fechaString;

        try {
            dia = ultimoSalto.get(GregorianCalendar.DAY_OF_MONTH);
            mes = ultimoSalto.get(GregorianCalendar.MONTH) + 1;
            anio = ultimoSalto.get(GregorianCalendar.YEAR);
            fechaString = "Fecha del ultimo salto: " + dia + "/" + mes + "/" + anio;
        } catch (NullPointerException npe) {
            fechaString = "Este saltador aun no ha saltado.";
        }


        return fechaString;
    }

    public boolean anotarSalto(double[] juez) {
        double mediaPuntos = 0;
        //Por si en algun momento hay mas jueces
        int puntuacionesValidas = juez.length - 2;
        int limite = juez.length - 1;

        //Intercambio sort
        for (int i = 0; i < limite; i++) {
            int pos = i;
            for (int j = i + 1; j <= limite; j++) {
                if (juez[j] < juez[pos]) {
                    pos = j;
                }
            }
            double aux = juez[pos];
            juez[pos] = juez[i];
            juez[i] = aux;
        }
        //Sumamos los puntos validos obviando el mas grande y el mas chico
        for (int i = 1; i < limite; i++) {
            mediaPuntos += juez[i];
        }
        //Sacamos la media
        mediaPuntos = mediaPuntos / puntuacionesValidas;
        //Miramos si es mayor a los puntos que ya tiene
        if (this.puntos < mediaPuntos) {
            this.puntos = mediaPuntos;
        }
        //Sumamos al numero de saltos
        this.numeroSaltos++;
        this.ultimoSalto = new GregorianCalendar();
        return this.numeroSaltos < 3;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Saltador && ((Saltador) obj).getDorsal() == this.dorsal;
    }

    @Override
    public String toString() {
        String datosDelSaltador = "";

        datosDelSaltador += this.dorsal + " * " 
                + this.nombre.substring(0, 1).toUpperCase()+this.nombre.substring(1).toLowerCase()
                + " * "
                + this.pais.substring(0, 1).toUpperCase()+this.pais.substring(1).toLowerCase()
                + " * " + this.sexo + " * "
                + "Saltos: " + this.numeroSaltos + " * "
                + "Puntos: " + this.puntos + " * " + getFecha();

        return datosDelSaltador;
    }

    @Override
    public int compareTo(Saltador otro) {
        int resultado = 0;

        //Pasamos todo a lower case para que notenga en cuenta mayusculas
        String paisThis = this.pais.toLowerCase();
        String paisOtro = otro.pais.toLowerCase();

        String nombreThis = this.nombre.toLowerCase();
        String nombreOtro = otro.nombre.toLowerCase();

        //Primero miramos si los paises son iguales
        if (paisThis.equals(paisOtro)) {

            //Miramos si los nombres son iguales
            if (nombreThis.equals(nombreOtro)) {
                resultado = 0;
            } else {
                //Miramos si el nombre de THIS viene antes o despues del pasado por parametro
                if (nombreThis.compareTo(nombreOtro) < 0) {
                    resultado = -1;//Si viene antes
                } else {
                    resultado = 1;//Si viene despues
                }
            }
        } else {
            //Miramos si el pais de THIS viene antes o despues del pasado por parametro
            if (paisThis.compareTo(paisOtro) < 0) {
                resultado = -1;//Si viene antes
            } else {
                resultado = 1;//Si viene despues
            }
        }
        return resultado;
    }
}
