

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
        int anio;
        byte mes,j,primerDia;

        //Pedimos datos
        System.out.print("Introduce año: ");
        anio = Leer.datoInt();
        System.out.print("Introduce mes: ");
        mes = datoByte();
        mes--;

        calendario = new GregorianCalendar(anio,mes,1);
        
        //Establecemos el primer dia del mes
        if(calendario.get(GregorianCalendar.DAY_OF_WEEK) == GregorianCalendar.SUNDAY){
            primerDia = 7;
        } else {
            primerDia = (byte) (calendario.get(GregorianCalendar.DAY_OF_WEEK) -1);
        }
        
        System.out.println("Mon\tTue\tWed\tThu\tFri\tSat\tSun");
        
        //Rellenamos los dias vacios el principio del mes
        for (byte i = 1 ; i < primerDia; i++){
            System.out.print("\t");
        }
        
        //Construimos el output
        j=primerDia;
        for (byte i = 1; i <= calendario.getActualMaximum(GregorianCalendar.DAY_OF_MONTH); i++) {
            System.out.print(i);
            if(j % 7 != 0){
                System.out.print("\t");
            } else {
                System.out.print("\n");
            }
            j++;
        }
        /*
        System.out.println(calendario.getActualMaximum(Calendar.DAY_OF_MONTH));
        System.out.println(calendario.get(Calendar.DAY_OF_WEEK));
        System.out.println(primerDia);

        */
        //System.out.println(Locale.getDefault());
        
    }
}
