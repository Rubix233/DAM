/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andy Jan
 */
public class TablaAlumnos {
    public static void main(String[] args){
        //Entorno
        Alumno[] alumnos;
        
        
        //Algoritmo
        alumnos = new Alumno[8];
        
        
        for(int i = 0; i<alumnos.length; i++){
            float nota;
            int codigo;
            System.out.println("Introduzca el codigo del alumno"+(i+1));
            codigo = Leer.datoInt();
            System.out.println("Introduzca la nota del alumno"+(i+1));
            nota = Leer.datoFloat();
            
            alumnos[i] = new Alumno(codigo, nota);
        }
        
        
        
    }
}
