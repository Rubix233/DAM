/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andy Jan
 */
public class Adivinanza {
    private int incognita;
    private int numeroPrueba;
    private byte intentos;
    private byte cifrasIncognita;
    
    public Adivinanza(){
        this.incognita = (int)Math.round(Math.random() * 1000000);
        this.intentos = 10;
        this.cifrasIncognita = Adivinanza.cifras(this.incognita);
    }
    
    public void juega(int num){
        
    }
    public boolean haGanado(){
        return this.numeroPrueba == this.incognita;
    }
    public byte getCifrasIncognita(){
        return this.cifrasIncognita;
    }
    public int getIncognita(){
        return this.incognita;
    }
    public String getPista(){
        String inco = Integer.toString(this.incognita);
        String intento = Integer.toString(this.numeroPrueba);
        String out= "";
        
        for(byte i = 0; i<inco.length();i++){
            if(inco.charAt(i) == intento.charAt(i)){
                out += inco.charAt(i);
            }else {
                out += "*";
            }
        }
        
        return out;
    }
    public byte getIntentos(){
        return this.intentos;
    }
    private static String meteAsteriscos(byte n){
        String out="";
        for(byte i = 0; i<n;i++){
            out +="*";
        }
        return out;
    }
    private static byte cifras(int n){
        byte cifras = 1;
        while (n >= Math.pow(10, cifras)) {
            cifras++;
        };
        return cifras;
    }
}
