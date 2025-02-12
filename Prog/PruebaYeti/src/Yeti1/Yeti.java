package Yeti1;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andy Jan
 */
public class Yeti {
    //Atributos
    private char color = 'B';
    private char sexo = 'M';
    private boolean hambriento = false;
    private static byte zona = 1;
    
    //Constructor

    
    //Metodos
    public void alimentarYeti(){
        if (!this.hambriento){
            this.hambriento = true;
        } else {
            System.out.println("No tiene hambre");
        }
    }
    public void mostrarAtributos(){
        System.out.println("Color: " +this.color);
        System.out.println("Sexo: " +this.sexo);
        System.out.println("Hambriento: " +this.hambriento);
        System.out.println("Zona: " +this.zona);
        
    }
    
}
