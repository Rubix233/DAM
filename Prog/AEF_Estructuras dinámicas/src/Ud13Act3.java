
import java.util.LinkedList;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andy Jan
 */
public class Ud13Act3 {
    public static void main(String[] args){
        String intro;
        LinkedList <Character> miPila;
        boolean correcto = true;
        int i = 0;
        
        miPila = new LinkedList<Character>();
        
        System.out.println("Introduzca su algoritmo: ");
        intro = Leer.dato();
        
        
        while (i < intro.length() && correcto){
            if(intro.charAt(i) == '('){
                miPila.push('(');
            } else {
                if(intro.charAt(i) == ')'){
                    if(!miPila.isEmpty()){
                        miPila.pop();
                    } else {
                        correcto = false;
                    }
                }
            }
            i++;
        }    
        
        if(correcto && !miPila.isEmpty()){
            correcto = false;
        }
        
        System.out.println("La expresion es correcta: " + correcto);
    }
}
