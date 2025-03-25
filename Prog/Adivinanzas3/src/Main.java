/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andy Jan
 */
public class Main {
    public static void main(String[] args){
        Adivinanza game;
        int intro;
        
        game = new Adivinanza();
        //System.out.println(game.getIncognita());
        do{
            do{
                System.out.print("-------------------------- "
                    + "\nIntroduzca su intento: ");
            intro = Leer.datoInt();
            }while(!(intro > 0));
            game.juega(intro);
            
        }while(!game.haGanado() && game.getIntentos() > 0);
        
        if(game.haGanado()){
            System.out.println("Has ganado!");
        } else {
            System.out.println("Has perdido, el numero secreto era: "+
                    game.getIncognita());
        }
    }
}
