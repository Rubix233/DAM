/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andy Jan
 */
public class Act7Cad {
    public static void parejas(String intro){
        intro = intro.trim().toLowerCase();
        String intro2;
        int length = intro.length()-2;
        int i;
        int count;
        int pos;
        
        for (i = 0; i <= length; i++){
            count = 0;
            intro2 = intro;
            
            //Se puede reemplazar y contar la diferencia, se necesita un string auxiliar para ir guardando la combinacion que se han mirado
            while (intro2.indexOf(intro.substring(i, i + 2)) >= i
                    && intro.substring(i, i + 2).matches("[a-z]{2}")) {
                
                while (intro2.indexOf(intro.substring(i, i + 2)) != -1) {
                    count++;
                    pos = intro2.indexOf(intro.substring(i, i + 2)) + 1;
                    intro2 = intro2.substring(pos);
                }//Fin Mientras
                System.out.println("La combinacion de " 
                        + intro.substring(i, i + 2) 
                        + " aparece " + count + " veces.");
            }//Fin Mientras
        }//Fin Para
    }
    
    
    public static void main(String[] args){
        parejas("Hola que tal la ola");

    }
}
