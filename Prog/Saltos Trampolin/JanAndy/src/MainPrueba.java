
import java.util.GregorianCalendar;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrador
 */
public class MainPrueba {
    public static void main(String[] args){
        GregorianCalendar ultimoSalto;
        
        Saltador a = new Saltador(10,"Andy","Bulgaria",'M');
        
        System.out.println(a.getFecha());
        
    }
}
