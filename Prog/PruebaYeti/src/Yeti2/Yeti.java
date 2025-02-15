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
    public Yeti(Yeti j){
        this.color = j.color;
        this.sexo = j.sexo;
        this.hambriento = j.hambriento;
    }
    public Yeti(char sexo){
        if(sexo == 'h' ||sexo == 'H'){
            this.sexo = sexo;
        }
    }
    public Yeti(boolean hambriento){
        this.hambriento = hambriento;
    }
    public Yeti(char color, char sexo){
        this.color = color;
        if(sexo == 'h' ||sexo == 'H'){
            this.sexo = sexo;
        }
    }
    public Yeti(char color, char sexo, boolean hambriento, byte zona){
        this.color = color;
        this.hambriento = hambriento;
        if(sexo == 'h' ||sexo == 'H'){
            this.sexo = sexo;
        }
        Yeti.zona = zona;
    }
    public Yeti(char sexo, boolean hambriento){
        this.hambriento = hambriento;
        if(sexo == 'h' ||sexo == 'H'){
            this.sexo = sexo;
        }
    }
    public Yeti(char color, char sexo, boolean hambriento){
        this.color = color;
        this.hambriento = hambriento;
        if(sexo == 'h' ||sexo == 'H'){
            this.sexo = sexo;
        }
    }
    //Getters
    public char getColor(){
        return this.color;
    }
    public char getSexo(){
        return this.sexo;
    }
    public boolean getHambriento(){
        return this.hambriento;
    }
    public static byte getZona(){
        return Yeti.zona;
    }
    //Setters
    public void setColor(char color){
        this.color = color;
    }
    public void setSexo(char sexo){
        if(sexo == 'h' ||sexo == 'H'){
            this.sexo = sexo;
        }
    }
    public void setHambriento(boolean hambriento){
        this.hambriento = hambriento;
    }
    public static void setZona(byte zona){
        Yeti.zona = zona;
    }

    //Metodos
    public void alimentarYeti(){
        if (this.hambriento){
            this.hambriento = false;
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
    
    //Clonar
    public void copia(Yeti original){
        this.color = original.color;
        this.sexo = original.sexo;
        this.hambriento = original.hambriento;
    }
    public Yeti copia(){
        Yeti j = new Yeti(this.color,this.sexo,this.hambriento);
        
        return j;
    }
    public static void copia(Yeti original, Yeti distinto){
        distinto.color = original.color;
        distinto.sexo = original.sexo;
        distinto.hambriento = original.hambriento;
    }
}
