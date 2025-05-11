
import java.util.LinkedList;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andy Jan
 */
public class Ud13Act4 {
    public static void main(String[] args){
        LinkedList <String> primeraTanda = new LinkedList<String>();
        LinkedList<String> segundaTanda = new LinkedList<String>();
        int intro1;
        int intro2; 
        int repes = 0;
        int nuevos = 0;
        //Tomamos datos de primera tanda
        intro1 = Leer.datoInt();
        
        for(int i = 0; i < intro1; i++){
            primeraTanda.add(Leer.dato());
        }
        //Tomamos datos de segunda tanda
        intro2 = Leer.datoInt();
        for(int i = 0; i < intro2; i++){
            segundaTanda.add(Leer.dato());
        }
        
        //Contamos cuantos no se repiten
        for(String nombre : primeraTanda){
            if (segundaTanda.indexOf(nombre) == -1){
                repes++;
            }
        }
        System.out.println(repes);
        //Mostramos los que no se repiten
        for(String nombre : primeraTanda){
            if (segundaTanda.indexOf(nombre) == -1){
                System.out.println(nombre);
            }
        }
        //Contamos los nuevos
        for(String nombre : segundaTanda){
            if(primeraTanda.indexOf(nombre) == -1){
                nuevos++;
            }
        }
        System.out.println(nuevos);
        //Mostramos los nuevos
        for(String nombre : segundaTanda){
            if (primeraTanda.indexOf(nombre) == -1){
                System.out.println(nombre);
            }
        }
        
    }
}
