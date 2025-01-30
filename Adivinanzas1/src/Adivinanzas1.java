
/**
 *
 * @author Administrador
 */
public class Adivinanzas1 {
    public static void main(String[] args){
        byte intentos = 8;
        boolean ganado = false;
        byte objetivo;
        byte introducido;
        
        objetivo = Utilidades.datoByte();
        
        do {
            introducido = Utilidades.datoByte();
            if (introducido < objetivo){
                System.out.println("El objetivo es mayor.");
                intentos--;
            } else{
                if(introducido > objetivo){
                    System.out.println("El objetivo es menor.");
                    intentos--;
                } else {
                    ganado = true;
                }
            }
            
            
        }while (intentos > 0 || !ganado);
        
        //falta si gana o pierde
        
        
    }
}
