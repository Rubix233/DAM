/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
/**
 *
 * @author Jaime Martín
 */
public class Campeonato {
     public static void main(String[] args) {
         Saltador creado;
         Clasificacion clasificacion;
         int opcion;
         int dorsal=0;
         String nombre= "";
         String pais="";
         char sexo = 'H';
         double[] juez;
         BufferedReader reader;
         boolean valido;
         clasificacion = new Clasificacion();
         reader = new BufferedReader(new InputStreamReader(System.in));
         
        do {
            System.out.println("1. Inscribir saltador.");
            System.out.println("2. Eliminar saltador.");
            System.out.println("3. Nuevo salto.");
            System.out.println("4. Puntos país.");
            System.out.println("5. Mostrar saltador");
            System.out.println("6. Mostrar todos");
            System.out.println("7. Salir");
            System.out.print("\n    Opción: ");
            
            valido = false;
            opcion = 0;
            while(!valido){
               try {
                  String linea = reader.readLine();
                  opcion = Integer.parseInt(linea);
                  valido = true;
                } catch (IOException ioe) {
                   System.out.println("Error al leer la entrada.");
                } catch (NumberFormatException nfe) {
                   System.out.println("No se ha introducido un número válido.");
                }
            }

            switch (opcion) {
                case 1:
                    //Leer dorsal
                    System.out.print("Dorsal:");
                    valido = false;
                    while(!valido){
                        try {
                            String linea = reader.readLine();
                            dorsal = Integer.parseInt(linea);
                            valido = true;
                        } catch (IOException ioe) {
                            System.out.println("Error al leer la entrada.");
                        } catch (NumberFormatException nfe) {
                            System.out.println("No se ha introducido un número válido.");
                        }
                    }
                    //Leer nombre
                    System.out.println();
                    System.out.print("Nombre:");
                    System.out.flush();
                    valido = false;
                    while(!valido){
                        try {
                            nombre = reader.readLine();
                            valido = true;
                        } catch (IOException ioe) {
                            System.out.println("Error al leer la entrada.");
                        }
                    }
                    //Leer Pais
                    System.out.println();
                    System.out.print("Pais:");
                    System.out.flush();
                    valido = false;
                    while(!valido){
                        try {
                            pais = reader.readLine();
                            valido = true;
                        } catch (IOException ioe) {
                            System.out.println("Error al leer la entrada.");
                        }
                    }
                    //Leer Sexo
                    System.out.println();
                    System.out.print("Sexo (H/M):");
                    valido = false;
                    while(!valido){
                        try {
                            String linea = reader.readLine();
                            if(linea.length()== 1 && linea.charAt(0) =='H' || linea.charAt(0) =='M'){
                                sexo = linea.charAt(0);
                                valido = true;
                            }else{
                                    System.out.println("Has introducido un dato invalido");
                            }
                        } catch (IOException ioe) {
                            System.out.println("Error al leer la entrada.");
                        }
                    }
                    //Crear el saltador
                    creado = new Saltador(dorsal,nombre,pais,sexo);
                    if(clasificacion.aniadir(creado)){
                        System.out.println("Saltador inscrito");
                    }else{
                        System.out.println("Saltador ya estaba inscrito");
                    };
                    break;
                case 2:
                    System.out.print("Dorsal:");
                    valido = false;
                    while(!valido){
                        try {
                            String linea = reader.readLine();
                            dorsal = Integer.parseInt(linea);
                            valido = true;
                        } catch (IOException ioe) {
                            System.out.println("Error al leer la entrada.");
                        } catch (NumberFormatException nfe) {
                            System.out.println("No se ha introducido un número válido.");
                        }
                    }
                    if(clasificacion.borrar(dorsal)){
                        System.out.println("Saltador borrado");
                    }else{
                        System.out.println("Saltador no encontrado");
                    }
                    break;
                case 3:
                    juez = new double[5];
                    System.out.println("Introduce el dorsal");
                    valido = false;
                    while(!valido){
                        try {
                            String linea = reader.readLine();
                            dorsal = Integer.parseInt(linea);
                            valido = true;
                        } catch (IOException ioe) {
                            System.out.println("Error al leer la entrada.");
                        } catch (NumberFormatException nfe) {
                            System.out.println("No se ha introducido un número válido.");
                        }
                    }
                    if(clasificacion.buscar(dorsal)!=null){
                        for(int i = 0 ; i<5; i++){
                            System.out.println("Introduce los puntos del salto nº"+i);
                            valido = false;
                            while(!valido){
                                try {
                                    String linea = reader.readLine();
                                    juez[i] = Double.parseDouble(linea);
                                    valido = true;
                                } catch (IOException ioe) {
                                    System.out.println("Error al leer la entrada.");
                                } catch (NumberFormatException nfe) {
                                    System.out.println("No se ha introducido un número válido.");
                                }
                            }
                        }
                     clasificacion.buscar(dorsal).anotarSalto(juez);
                    }else{
                        System.out.println("No existe el saltador");
                    }
                    break;
                case 4:
                    // Código para puntos país
                    break;
                case 5:
                    System.out.print("Dorsal:");
                    valido = false;
                    while(!valido){
                        try {
                            String linea = reader.readLine();
                            dorsal = Integer.parseInt(linea);
                            valido = true;
                        } catch (IOException ioe) {
                            System.out.println("Error al leer la entrada.");
                        } catch (NumberFormatException nfe) {
                            System.out.println("No se ha introducido un número válido.");
                        }
                    }
                    if(clasificacion.buscar(dorsal)!=null){
                        System.out.println("***********************");
                        System.out.println(clasificacion.buscar(dorsal).toString());
                        System.out.println("***********************");
                    }else{
                        System.out.println("Saltador no encontrado");
                    }
                    break;
                case 6:
                    // Mostrar todos
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
                    break;
            }

        } while (opcion != 7);
    }
}
