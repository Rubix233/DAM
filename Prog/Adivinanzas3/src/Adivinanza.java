
import java.util.Random;

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
    private Random rnd;
    /**
     * Constructor por defecto que crea un numero aleatorio
     */
    public Adivinanza(){
        //this.incognita = (int)Math.round(Math.random() * 1000000);
        rnd = new Random();
        this.incognita = rnd.nextInt(1000000)+1;
        if(this.incognita == 0){
            this.incognita++;
        }
        this.intentos = 10;
        this.cifrasIncognita = Adivinanza.cifras(this.incognita);
        //System.out.println("El numero a adivinar es: " +Adivinanza.meteAsteriscos(this.cifrasIncognita));
    }
    /**
     * 
     * @param num Comprueba si el numero introducido es el acertado y si no, muestra la pista.
     */
    public void juega(int num) {
        this.numeroPrueba = num;
        if (!haGanado()) {
            if (Adivinanza.cifras(this.numeroPrueba) <= 
                    Adivinanza.cifras(this.incognita)) {
                this.intentos--;
                if (getIntentos() > 0) {
                    System.out.println("---------------");
                    System.out.println("Pista: "+getPista());
                    System.out.println("---------------");
                    System.out.println("Le quedan "+getIntentos()+ " intentos.");
                }
            } else {
                System.out.println("Demasiadas cifras");
            }
        }  
    }
    /**
     * 
     * @return Si ha acertado al adivinar el numero
     */
    public boolean haGanado(){
        return this.numeroPrueba == this.incognita;
    }
    /**
     * 
     * @return Cantidad de cifras que tiene el numero a adivinar
     */
    public byte getCifrasIncognita(){
        return this.cifrasIncognita;
    }
    /**
     * 
     * @return La incognita
     */
    public int getIncognita(){
        return this.incognita;
    }
    /**
     * 
     * @return Construye una cadena mostrando los digitos acertados o asteriscos en caso contrario
     */
    public String getPista() {

        String inco = Integer.toString(this.incognita);
        String intento = Integer.toString(this.numeroPrueba);
        String out = "";
        if (this.intentos == 10) {
            out = Adivinanza.meteAsteriscos(this.cifrasIncognita);
        } else {
            while (inco.length() > intento.length()) {
                intento = "." + intento;
            }
            for (byte i = 0; i < inco.length(); i++) {
                if (inco.charAt(i) == intento.charAt(i)) {
                    out += inco.charAt(i);
                } else {
                    out += "*";
                }
            }
        }
        return out;
    }
    /**
     * 
     * @return Intentos restantes
     */
    public byte getIntentos(){
        return this.intentos;
    }
    /**
     * 
     * @param n Numero de asteriscos por meter
     * @return El numero a adivinar en formato asteriscos
     */
    private static String meteAsteriscos(byte n){
        String out="";
        for(byte i = 0; i<n;i++){
            out +="*";
        }
        return out;
    }
    /**
     * 
     * @param n Numero para ver sus cifras
     * @return El numero de cifras que tenga
     */
    private static byte cifras(int n){
        byte cifras = 1;
        while (n >= Math.pow(10, cifras)) {
            cifras++;
        };
        return cifras;
    }
}
