/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrador
 */
public class Adivinanza3 {
    public static int pideNum(){
        int num;
        System.out.print("Introduce un número: ");
        num=Leer.datoInt();
        return num;
    }
    public static void main(String[] args){
        //Entorno:
            Adivinanza adivinanza3;
        //Algoritmo:
            adivinanza3=new Adivinanza();
            System.out.println(adivinanza3.getPista());
            adivinanza3.juega(pideNum());
            while(adivinanza3.getIntentos()>=1 && !adivinanza3.haGanado()){
                System.out.println(adivinanza3.getPista());
                adivinanza3.juega(pideNum());
            }
            if(adivinanza3.haGanado()){
                if(adivinanza3.getIntentos()!=1){
                System.out.println("¡Felicidades has ganado con " 
                        + adivinanza3.getIntentos() + " intentos restantes!");
                } else {
                    System.out.println("¡Felicidades has ganado con " 
                        + adivinanza3.getIntentos() + " intento restante!");
                }
            } else {
                System.out.println("Has perdido, el numero secreto era "+ adivinanza3.getIncognita());
            }
    }
}
