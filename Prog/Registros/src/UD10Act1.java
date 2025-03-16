/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andy Jan
 */
public class UD10Act1 {
        public static byte datoByte() {
        byte dato;
        short numero;

        //System.out.print("Introduzca numero: ");
        numero = Leer.datoShort();

        while (numero < -128 || numero > 127) {
            System.out.print("Dato incorrecto, introduzca otro: ");
            numero = Leer.datoShort();
        }

        dato = (byte) numero;
        return dato;
    }
    
    
    
    public static void main(String[] args){
        Empleado intro,max,min;
        
        max = new Empleado();
        min = new Empleado();
        intro = new Empleado();
        max.setSueldo(Float.MIN_VALUE);
        min.setSueldo(Float.MAX_VALUE);

        do {
            System.out.print("Introduzca nombre del empleado: ");
            intro.setNombre(Leer.dato());
            
            System.out.print("Introduzca apellidos del empleado: ");
            intro.setApellidos(Leer.dato());
            
            System.out.print("Introduzca departamento del empleado: ");
            intro.setDepart(Leer.datoShort());
            
            System.out.print("Introduzca seccion del empleado: ");
            intro.setSeccion(datoByte());
            
            System.out.print("Introduzca sueldo del empleado: ");
            intro.setSueldo(Leer.datoFloat());
            
            if (intro.getSueldo() > max.getSueldo()) {
                max.copia(intro);
            }//Fin Si
            if (intro.getSueldo() < min.getSueldo()) {
                min.copia(intro);
            }//Fin Si

        } while (Utilidades.continuar());//Fin mientras
        
        System.out.println("Max: " + max.mostrarDatos());
        System.out.println("Min: "+ min.mostrarDatos());

    }
}
