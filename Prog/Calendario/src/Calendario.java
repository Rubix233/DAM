
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
    public static void main(String[] args){
        GregorianCalendar calendario;
        int primerDia;
        
        calendario = new GregorianCalendar(2025,3,1);
        
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
