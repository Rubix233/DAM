package Yeti2;


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
    public Yeti (){
        
    }
    public Yeti(char color, boolean hambriento, char sexo, byte zona){
        this.color = color;
        this.hambriento = hambriento;
        if(sexo == 'h' ||sexo == 'H'){
            this.sexo = sexo;
        }
        Yeti.zona = zona;
    }
    public Yeti(char color, boolean hambriento, char sexo){
        this.color = color;
        this.hambriento = hambriento;
        if(sexo == 'h' ||sexo == 'H'){
            this.sexo = sexo;
        }
    }
    public Yeti(char color, boolean hambriento){
        this.color = color;
        this.hambriento = hambriento;
    }
    public Yeti(char color, char sexo){
        this.color = color;
        if(sexo == 'h' ||sexo == 'H'){
            this.sexo = sexo;
        }
    }
    public Yeti(boolean hambriento, char sexo){
        this.hambriento = hambriento;
        if(sexo == 'h' ||sexo == 'H'){
            this.sexo = sexo;
        }
    }
    public Yeti(boolean hambriento){
        this.hambriento = hambriento;
    }
    public Yeti(char sexo){
        if(sexo == 'h' ||sexo == 'H'){
            this.sexo = sexo;
        }
    }
    
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
