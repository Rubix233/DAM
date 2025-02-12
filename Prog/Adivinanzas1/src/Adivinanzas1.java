
/**
 *
 * @author Andy Jan
 */
public class Adivinanzas1 {
    public static void main(String[] args){
        final byte MAX = 100;
        final byte MIN = 0;
        
        byte intentos = 8;
        byte numSecreto;
        byte introducido;
        
        //Pedir numero al jugador 1
        System.out.println("Jugador 1 introduzca numero: ");
        do{
            numSecreto = UtilidadesAndy.datoByte();
        } while (!UtilidadesAndy.numeroEnRango(numSecreto, MIN, MAX));
        //Limpiar consola
        for (int i = 0; i<=10;i++){
            System.out.println();
        }
        
        //Jugador 2
        System.out.println("Jugador 2. Tienes "+intentos+" intentos.");
        
        do {
            do {
                introducido = UtilidadesAndy.datoByte();
                if (!UtilidadesAndy.numeroEnRango(introducido, MIN, MAX)){
                    System.out.println("Ese numero no");
                }
            } while (!UtilidadesAndy.numeroEnRango(introducido, MIN, MAX));
           
            if (introducido < numSecreto) {
                System.out.println("El objetivo es mayor.");
                intentos--;
                System.out.println("Te quedan " + intentos + " intentos.");
            } else {
                if (introducido > numSecreto) {
                    System.out.println("El objetivo es menor.");
                    intentos--;
                    System.out.println("Te quedan " + intentos + " intentos.");
                }
            }
        } while (intentos > 0 && introducido != numSecreto);

        if (intentos > 0) {
            System.out.println("Enhorabuena maquina, has ganado!");
        } else {
            System.out.println("Espabila que este juego es facil");
        }
    }
}
