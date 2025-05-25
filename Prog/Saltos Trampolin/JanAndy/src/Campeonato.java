/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Locale;

/**
 *
 * @author Jaime Martín && Andy Jan
 */
public class Campeonato {

    public static void main(String[] args)throws UnsupportedEncodingException {
        Saltador creado;
        Clasificacion clasificacion;
        int opcion;
        int dorsal = 0;
        String nombre = "";
        String pais = "";
        char sexo = 'H';
        double[] juez;
        BufferedReader reader;
        FileWriter fWriter = null;
        GregorianCalendar fechaHoraLog;
        boolean valido;
        clasificacion = new Clasificacion();
        reader = new BufferedReader(new InputStreamReader(System.in,"UTF-8"));

        do {
            System.out.println("1. Inscribir saltador");
            System.out.println("2. Eliminar saltador");
            System.out.println("3. Nuevo salto");
            System.out.println("4. Puntos país");
            System.out.println("5. Mostrar saltador");
            System.out.println("6. Mostrar todos");
            System.out.println("7. Salir");
            System.out.print("\n    Opción: ");

            valido = false;
            opcion = 0;
            while (!valido) {
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
                    while (!valido) {
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
                    while (!valido) {
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
                    while (!valido) {
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
                    while (!valido) {
                        try {
                            String linea = reader.readLine().trim().toUpperCase();
                            if (linea.length() == 1 && linea.charAt(0) == 'H' || linea.charAt(0) == 'M') {
                                sexo = linea.charAt(0);
                                valido = true;
                            } else {
                                System.out.println("Has introducido un dato invalido");
                            }
                        } catch (IOException ioe) {
                            System.out.println("Error al leer la entrada.");
                        }
                    }
                    //Crear el saltador
                    creado = new Saltador(dorsal, nombre, pais, sexo);
                    if (clasificacion.aniadir(creado)) {
                        System.out.println("Saltador inscrito");
                    } else {
                        System.out.println("Saltador ya estaba inscrito");
                    }
                    ;
                    break;
                case 2:
                    System.out.print("Dorsal:");
                    valido = false;
                    while (!valido) {
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
                    if (clasificacion.borrar(dorsal)) {
                        System.out.println("Saltador borrado");
                    } else {
                        System.out.println("Saltador no encontrado");
                    }
                    break;
                case 3:
                    juez = new double[5];
                    System.out.println("Introduce el dorsal");
                    valido = false;
                    while (!valido) {
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
                    if (clasificacion.buscar(dorsal) != null) {
                        for (int i = 0; i < 5; i++) {
                            System.out.println("Introduce los puntos del salto nº" + i);
                            valido = false;
                            while (!valido) {
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
                    } else {
                        System.out.println("No existe el saltador");
                    }
                    break;
                case 4:
                    // Código para puntos país
                    String paisConsulta = "";
                    char sexoConsulta = 'H';
                    double puntosPais = 0;

                    // Leer país
                    System.out.print("Introduce el país: ");
                    valido = false;
                    while (!valido) {
                        try {
                            paisConsulta = reader.readLine().trim();
                            valido = true;
                        } catch (IOException ioe) {
                            System.out.println("Error al leer el país.");
                        }
                    }

                    // Leer sexo
                    System.out.print("Introduce el sexo (H/M): ");
                    valido = false;
                    while (!valido) {
                        try {
                            String linea = reader.readLine().trim().toUpperCase();
                            if (linea.length() == 1 && (linea.charAt(0) == 'H' || linea.charAt(0) == 'M')) {
                                sexoConsulta = linea.charAt(0);
                                valido = true;
                            } else {
                                System.out.println("Sexo inválido. Debe ser H o M.");
                            }
                        } catch (IOException a) {
                            System.out.println("Error al leer el sexo.");
                        }
                    }
                    puntosPais = clasificacion.getPuntosPais(paisConsulta, sexoConsulta);
                    if (Double.isNaN(puntosPais)) {
                        System.out.println("No existen saltadores de este Pais con ese sexo");
                    } else {
                        System.out.printf("La media es: %.2f\n", puntosPais);
                    }



                    break;
                case 5:
                    System.out.print("Dorsal:");
                    valido = false;
                    while (!valido) {
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
                    if (clasificacion.buscar(dorsal) != null) {
                        System.out.println("***********************");
                        System.out.println(clasificacion.buscar(dorsal).toString());
                        System.out.println("***********************");
                    } else {
                        System.out.println("Saltador no encontrado");
                    }
                    break;
                case 6:
                    // Mostrar todos
                    if (clasificacion.haySaltador()) {
                        fechaHoraLog = new GregorianCalendar();
                        //Establecemos archivo
                        if (fWriter == null) {
                            try {
                                try {
                                    fWriter = new FileWriter("Ficheros/Saltadores.txt", true);
                                    
                                    int hora = fechaHoraLog.get(GregorianCalendar.HOUR);
                                    if (hora == 0) {
                                        hora = 12; // Para que no aparezca "0" a las 12 en punto
                                    }
                                    int minuto = fechaHoraLog.get(GregorianCalendar.MINUTE);
                                    String ampm = "";
                                    if(fechaHoraLog.get(GregorianCalendar.AM_PM) == GregorianCalendar.AM){
                                        ampm = "AM";
                                    }else{
                                        ampm = "PM";
                                    }

                                    fWriter.write("Fecha y hora del log: "
                                            + fechaHoraLog.get(GregorianCalendar.DAY_OF_MONTH) + "/"
                                            + (fechaHoraLog.get(GregorianCalendar.MONTH) + 1) + "/"
                                            + fechaHoraLog.get(GregorianCalendar.YEAR) + "\t"
                                            + String.format("%d:%02d", hora, minuto) + " " + ampm + "\n\r");
                                } catch (FileNotFoundException a) {
                                    System.out.println("Error al buscar ruta");
                                }
                            } catch (IOException b) {
                            }
                        }
                        //Ordenamos
                        clasificacion.ordena();
                        //Iteramos
                        if (clasificacion.haySaltador()) {
                            for (Saltador s : clasificacion) {
                                try {
                                    fWriter.write(s.toString() + "\n\r");
                                    System.out.println(s.toString());
                                } catch (IOException a) {
                                    System.out.println("Error E/S al escribir");
                                }
                            }
                        }
                        //Cerramos archivo
                        if (fWriter != null) {
                            try {
                                fWriter.write("****************************************************************************************\n\r");
                                fWriter.close();
                            } catch (IOException b) {
                                System.out.println("Error E/S al cerrar");
                            }
                        }
                    } else {
                        System.out.println("No hay saltadores.");
                    }
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
