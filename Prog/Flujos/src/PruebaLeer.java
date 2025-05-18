
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andy Jan
 */
public class PruebaLeer {
    public static void main(String[] args){
        byte finalByte = 0;
        short finalShort = 0;
        int finalInt = 0;
        long finalLong = 0;
        float finalFloat = 0.0f;
        double finalDouble = 0.0;

        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

        finalByte = Leer.datoByte(teclado);
        System.out.println("Valor byte: " + finalByte);

        finalShort = Leer.datoShort(teclado);
        System.out.println("Valor short: " + finalShort);

        finalInt = Leer.datoInt(teclado);
        System.out.println("Valor int: " + finalInt);

        finalLong = Leer.datoLong(teclado);
        System.out.println("Valor long: " + finalLong);

        finalFloat = Leer.datoFloat(teclado);
        System.out.println("Valor float: " + finalFloat);

        finalDouble = Leer.datoDouble(teclado);
        System.out.println("Valor double: " + finalDouble);

        //No se si meter el cerrado del teclado ya que aqui se acaba el programa.
        
    }
}
