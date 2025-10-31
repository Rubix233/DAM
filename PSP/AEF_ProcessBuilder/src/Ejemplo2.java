
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**Realizar aplicación Java UnSaludo que muestra el saludo proporcionado como
argumento en la llamada. Realizar una aplicación Ejemplo2 que lance el proceso
anterior pasándole como argumento Hola mundo!!! mostrando entorno de
ejecución, lista de argumentos y ejecución de la siguiente forma:
Variables de entorno
Propiedad: NOMBRE --> VALOR
...
Comando:
las cadenas que componen el comando, una por línea.
Mostrar la salida de la ejecución del comando.
 *
 * @author Andy Jan
 */
public class Ejemplo2 {

    public static void main(String[] args) {
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

        Map<String, String> mapaEntorno;
        String lineaPorTeclado, lineaPrograma;

        try {
            System.out.println("Introduzca tu saludo: ");
            lineaPorTeclado = teclado.readLine();

            ProcessBuilder constructorProceso = new ProcessBuilder("java", "-cp", "E:\\DAM\\PSP\\AEF_ProcessBuilder\\build\\classes", "UnSaludo", lineaPorTeclado);

            Process unSaludo = constructorProceso.start();
            BufferedReader outputSaludo = new BufferedReader(new InputStreamReader(unSaludo.getInputStream()));
            mapaEntorno = constructorProceso.environment();

            System.out.println("Variables de entorno:");

            for (Map.Entry<String, String> entry : mapaEntorno.entrySet()) {
                System.out.println("Propiedad: " + entry.getKey() + " -> " + entry.getValue());
            }

            //Me he quedado aqui, tengo que sacar la lista de parametros.
            System.out.println("Comando:");
            for (String argumento : constructorProceso.command()) {
                System.out.println(argumento);
            }

            while ((lineaPrograma = outputSaludo.readLine()) != null) {
                System.out.println(lineaPrograma);
            }

        } catch (IOException io) {
            System.out.println("Err");
        }


    }
}
