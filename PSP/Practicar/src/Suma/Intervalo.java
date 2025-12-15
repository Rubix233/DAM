/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Suma;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andy
 */
public class Intervalo {

    public static Process exec(Class clase, String a, String b) throws IOException {
        String javaHome = System.getProperty("java.home");
        String javaBin = javaHome + File.separator
                + "bin" + File.separator + "java";
        String classPath = System.getProperty("java.class.path");
        String className = clase.getCanonicalName();
        ProcessBuilder builder = new ProcessBuilder(javaBin, "-cp", classPath, className, a, b);
        return builder.start();
    }

    public static void main(String[] args) {
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        File erroresFile = new File("Errores.log");
        BufferedWriter errorLog = null;




        String in = "";
        String numero1 = "";
        String numero2 = "";
        int codigoSalida;
        try {


            do {
                System.out.println("Introduzca primer numero:");
                numero1 = teclado.readLine();
                System.out.println("Introduzca segundo numero:");
                numero2 = teclado.readLine();

                Process calcula = Intervalo.exec(Suma.class, numero1, numero2);

                BufferedReader salida, errores;

                salida = new BufferedReader(new InputStreamReader(calcula.getInputStream()));
                errores = new BufferedReader(new InputStreamReader(calcula.getErrorStream()));

                errorLog = new BufferedWriter(new FileWriter("errores.log", true));

                while ((in = errores.readLine()) != null) {
                    System.out.println(in);
                    errorLog.write(in);
                    errorLog.newLine();
                }
                while ((in = salida.readLine()) != null) {
                    System.out.println(in);
                }

                codigoSalida = calcula.waitFor();

                if (codigoSalida != -1) {
                    System.out.print("La suma es " + codigoSalida);

                    if (codigoSalida % 2 == 0) {
                        System.out.println(" (par)");
                    } else {
                        System.out.println(" (impar)");
                    }
                }
                //Cerramos el log. !!!!IMPORTANTE!!!!
                errorLog.close();

                //Preguntamos si quieren seguir
                do {
                    System.out.println("Desea seguir? S/N");
                } while (!(in = teclado.readLine()).matches("(?i)[sn]"));

            } while (in.equalsIgnoreCase("s"));


        } catch (InterruptedException ie) {
            System.err.println("Interrumpido");
        } catch (IOException ex) {
            Logger.getLogger(Intervalo.class.getName()).log(Level.SEVERE, null, ex);
        }


    }
}
