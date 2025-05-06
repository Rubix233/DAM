

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andy Jan
 */
import Ud13Act1.*;

public class Agenda {
    
    static byte bIntro;
    static String sIntro = "";
    static String nombre, direccion;
    static long tlf = 0;
    static int pos = 0;
    static ListaTelefonos2 agenda = new ListaTelefonos2();
    static Persona pIntro;
    
    public static byte datoByte() {
        //Entorno
        byte dato;
        short numero;

        //Algoritmo
        numero = Leer.datoShort();

        while (numero < 1 || numero > 5) {
            System.out.print("Opcion incorrecta, introduzca otro: ");
            numero = Leer.datoShort();
        }//Fin Mientras

        dato = (byte) numero;
        return dato;
    }

    private static void mostrarMenu() {
        System.out.println("========================");
        System.out.println("1.-Buscar.");
        System.out.println("2.-Buscar Siguiente");
        System.out.println("3.-Añadir.");
        System.out.println("4.-Eliminar.");
        System.out.println("5.-Salir.");
        System.out.println("========================");
        System.out.print("\t Opción: ");
    }

    private static int buscar(ListaTelefonos agenda, String sIntro, int pos) {
        //Buscar

        if (agenda.longitud() != 0) {
            if (agenda.buscar(sIntro, pos) != -1) {
                pos = agenda.buscar(sIntro, pos);
                System.out.println("**********************");
                System.out.println("Nombre: "+agenda.valorEn(pos).obtenerNombre());
                System.out.println("Direccion: "+agenda.valorEn(pos).obtenerDireccion());
                System.out.println("Tlf: "+agenda.valorEn(pos).obtenerTelefono());
                System.out.println("**********************");
                
            } else {
                System.out.println("No hay datos");
            }//Fin Si
        } else {
            System.out.println("Agenda Vacía");
        }//Fin Si
        return pos;
    }
    
    private static void operar(byte bIntro){
        switch (bIntro) {
                case 1:
                    pos = 0;
                    sIntro = "";
                    if (agenda.longitud() != 0) {
                        System.out.println("Quien buscas?");
                        sIntro = Leer.dato();
                        pos = buscar(agenda, sIntro, pos)+1;
                    } else {
                        System.out.println("Agenda Vacía");
                    }//Fin Si
                    break;
                case 2:
                    if (!sIntro.isEmpty()) {
                        pos = buscar(agenda, sIntro, pos)+1;
                    } else {
                        System.out.println("No hay datos");
                    }//Fin Si
                    break;
                case 3:
                    System.out.print("Introduzca nombre: ");
                    nombre = Leer.dato();
                    System.out.print("Introduzca direccion: ");
                    direccion = Leer.dato();
                    do {
                        System.out.print("Introduzca nº Tlf: ");
                        tlf = Leer.datoLong();
                    } while (tlf < 0);//Fin Mientras
                    pIntro = new Persona(nombre, direccion, tlf);
                    agenda.aniadir(pIntro);
                    break;
                case 4:

                    if (agenda.longitud() != 0) {
                        System.out.print("Introduzca Tlf a eliminar: ");
                        tlf = Leer.datoLong();

                        if (agenda.eliminar(tlf)) {
                            System.out.println("Registro eliminado");
                        } else {
                            System.out.println("Teléfono no encontrado");
                        }//Fin Si

                    } else {
                        System.out.println("Agenda vacía");
                    }//Fin Si
            }//Fin segun sea
    }

    public static void main(String[] args) {

        do {
            mostrarMenu();
            bIntro = datoByte();
            operar(bIntro);

        } while (bIntro != 5);//Fin Repetir
        
        /*
        byte bIntro;
        String sIntro = "";
        String nombre, direccion;
        long tlf = 0;
        int pos = 0;
        ListaTelefonos agenda = new ListaTelefonos();
        Persona pIntro;
        
        do {
            mostrarMenu();
            bIntro = datoByte();
            switch (bIntro) {
                case 1:
                    pos = 0;
                    sIntro = "";
                    if (agenda.longitud() != 0) {
                        System.out.println("Quien buscas?");
                        sIntro = Leer.dato();
                        pos = buscar(agenda, sIntro, pos) + 1;
                    } else {
                        System.out.println("Agenda Vacía");
                    }//Fin Si
                    break;
                case 2:
                    if (!sIntro.isEmpty()) {
                        pos = buscar(agenda, sIntro, pos) + 1;
                    } else {
                        System.out.println("No hay datos");
                    }//Fin Si
                    break;
                case 3:
                    System.out.print("Introduzca nombre: ");
                    nombre = Leer.dato();
                    System.out.print("Introduzca direccion: ");
                    direccion = Leer.dato();
                    do {
                        System.out.print("Introduzca nº Tlf: ");
                        tlf = Leer.datoLong();
                    } while (tlf < 0);//Fin Mientras
                    pIntro = new Persona(nombre, direccion, tlf);
                    agenda.aniadir(pIntro);
                    break;
                case 4:

                    if (agenda.longitud() != 0) {
                        System.out.print("Introduzca Tlf a eliminar: ");
                        tlf = Leer.datoLong();

                        if (agenda.eliminar(tlf)) {
                            System.out.println("Registro eliminado");
                        } else {
                            System.out.println("Teléfono no encontrado");
                        }//Fin Si

                    } else {
                        System.out.println("Agenda vacía");
                    }//Fin Si
            }//Fin Segun Sea

        } while (bIntro != 5);//Fin Repetir
        */

    }//Fin Programa
}
