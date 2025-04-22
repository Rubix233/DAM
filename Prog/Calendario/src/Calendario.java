

import java.util.GregorianCalendar;

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
        String out = "";
        String[] meses = {"Enero","Febrero","Marzo","Abril","Mayo","Junio",
            "Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};

        //Pedimos datos
        do{
            System.out.print("Introduce año: ");
            anio = Leer.datoInt();
        } while (anio < 1583);
        
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
        
        
        //Rellenamos los dias vacios el principio del mes
        for (byte i = 1 ; i < primerDia; i++){
            out += "\t";
        }
        
        //Construimos el output
        j = primerDia;
        for (byte i = 1; i <= calendario.getActualMaximum(GregorianCalendar.DAY_OF_MONTH); i++) {
            out += i;
            if(j % 7 != 0){
                out += "\t";
            } else {
                out += "\n";
            }
            j++;
        }
        
        //Mostramos
        System.out.println("***************************************************");
        System.out.println("\t\t"+meses[calendario.get(GregorianCalendar.MONTH)]+" del "+ anio);
        System.out.println("***************************************************");
        System.out.println("Lun\tMar\tMie\tJue\tVie\tSab\tDom");
        System.out.println(out);        
    }
}
