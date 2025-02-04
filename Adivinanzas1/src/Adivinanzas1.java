
/**
 *
 * @author Andy Jan
 */
public class Adivinanzas1 {
    public static void main(String[] args){
        byte intentos = 8;
        boolean ganado = false;
        byte objetivo;
        byte introducido;
        byte max = 100;
        byte min = 0;
        
        System.out.println("Jugador 1");
        do{
            objetivo = Utilidades.datoByte();
        } while (!Utilidades.numeroEnRango(objetivo, min, max));

        System.out.println("Jugador 2. Tienes "+intentos+" intentos.");
        
        do {
            do{
               introducido = Utilidades.datoByte(); 
            }while (!Utilidades.numeroEnRango(introducido, min, max));
            
            if (introducido < objetivo){
                System.out.println("El objetivo es mayor.");
                intentos--;
                System.out.println("Te quedan "+intentos+" intentos.");
            } else{
                if(introducido > objetivo){
                    System.out.println("El objetivo es menor.");
                    intentos--;
                    System.out.println("Te quedan "+intentos+" intentos.");
                } else {
                    ganado = true;
                }
            }            
        }while (intentos > 0 && !ganado);
        
        //falta si gana o pierde
        if (ganado){
            System.out.println("Enhorabuena maquina, has ganado!");
        } else {
            System.out.println("Espabila que este juego es facil");
        }
        
    }
}
