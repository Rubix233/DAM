
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Andy
 * deberian de ser dos tipos de datos distintos y sacar mensaje en condiciones cuando se mete un dato no valido
 */
public class Ejercicio {

    public static int leerDato(BufferedReader teclado) throws IOException {
        int numero = 0;
        boolean valido = false;

        do {
            try {
                numero = Integer.parseInt(teclado.readLine());
                valido = true;
            } catch (NumberFormatException a) {
                System.out.println("Numero no valido");
            }
        } while (!valido);

        return numero;
    }

    public static void main(String[] args) {
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        int repeticiones;
        int numeroRepetido;
        try {
            do {
                System.out.println("Introduce repeticiones entre 1 y 10: ");
                repeticiones = leerDato(teclado);
            } while (repeticiones < 1 || repeticiones > 10);

            System.out.println("Introduce numero a repetir: ");
            numeroRepetido = leerDato(teclado);

            for (int i = 0; i < repeticiones; i++) {
                System.out.println(numeroRepetido);
            }
        } catch (IOException e) {
            System.out.println("Error con el teclado");
        }


    }
}
