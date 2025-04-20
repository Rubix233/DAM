/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio2;

/**
 *
 * @author Andy Jan
 */
public abstract class Electrodomestico {
    //COLORES
    private final String BLANCO = "BLANCO";
    private final String NEGRO = "NEGRO";
    private final String ROJO = "ROJO";
    private final String AZUL = "AZUL";
    private final String GRIS = "GRIS";
    
    private final String[] COLORES = {BLANCO, NEGRO, ROJO, AZUL, GRIS};
    
    //CONSUMO
    private final char A = 'A';
    private final char B = 'B';
    private final char C = 'C';
    private final char D = 'D';
    private final char E = 'E';
    private final char F = 'F';
    
    private final String CONSUMO = "ABCDEF";
    
    
    private float precioBase = 100;
    private float peso = 5;
    private String color = BLANCO;
    private char consumoEnergetico = F; //A-F
    
    
    public Electrodomestico(){
        
    }
    public Electrodomestico(float precio, float peso){
        this.precioBase = precio;
        this.peso = peso;
    }
    public Electrodomestico(float precio, float peso,String color, char consumo){
        this.precioBase = precio;
        this.peso = peso;
        if(comprobarColor(color)){
            this.color = color;
        }
        if(comprobarConsumoEnergetico(consumo)){
            this.consumoEnergetico = consumo;
        }
        
    }
    
    public float getPrecio(){
        return this.precioBase;
    }
    public float getPeso(){
        return this.peso;
    }
    public String getColor(){
        return this.color;
    }
    public char getConsumo(){
        return this.consumoEnergetico;
    }
    
    private boolean comprobarConsumoEnergetico(char letra){
        return CONSUMO.indexOf(letra) != -1;
    }
    private boolean comprobarColor(String color){
        boolean valido = false;
        byte i = 0;
        
        while(i < COLORES.length && !valido){
            if(color.equals(COLORES[i])){
                valido = true;
            }
            i++;
        }
        return valido;
    }
    public float precioFinal(){
        float precio = getPrecio();
        
        //Precio por consumo
        switch(this.consumoEnergetico){
            case 'A':
                precio += 100;
                break;
            case 'B':
                precio += 80;
                break;
            case 'C':
                precio += 60;
                break;
            case 'D':
                precio += 50;
                break;
            case 'E':
                precio += 30;
                break;
            case 'F':
                precio += 10;
        }
        
        //Precio por peso
        precio += 10;
        
        if(this.peso > 20){
            precio += 40;
        }
        if(this.peso > 50){
            precio += 30;
        }
        if(this.peso > 80){
            precio += 20;
        }
        
        return precio;
    }
    
}
