
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andy Jan
 */
public class Calendario {
    public static byte datoByte() {
        //Entorno
        byte dato;
        short numero;

        //Algoritmo
        numero = Leer.datoShort();

        while (numero < 1 || numero > 12) {
            System.out.print("Mes incorrecto, introduzca otro: ");
            numero = Leer.datoShort();
        }//Fin Mientras

        dato = (byte) numero;
        return dato;
    }
    
    
    
    public static void main(String[] args){
        GregorianCalendar calendario;
        int primerDia, anio;
        byte mes;
        
        System.out.print("Introduce año: ");
        anio = Leer.datoInt();
        System.out.print("Introduce mes: ");
        mes = datoByte();
        mes--;
        
        calendario = new GregorianCalendar(anio,mes,1);
        
        if(calendario.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY){
            primerDia = 7;
        } else {
            primerDia = calendario.get(Calendar.DAY_OF_WEEK) -1;
        }

        System.out.println(calendario.getActualMaximum(Calendar.DAY_OF_MONTH));
        System.out.println(calendario.get(Calendar.DAY_OF_WEEK));
        System.out.println(primerDia);

        
        //System.out.println(Locale.getDefault());
        
    }
}
