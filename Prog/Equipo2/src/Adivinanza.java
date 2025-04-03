
import java.util.Random;

/**
 * 
 * @author Alvaro Perez, Andy Jan, Miguel Angel Busatori, David Valdivia, Alejandra Garzón
 */
/*
 * Clase que constituye un juego de adivinanzas donde un usuario introduce un
 * numero e intenta adivinar un numero aleatorio N entre 1 y 1.000.000. 
 * En diez oportunidades una persona tiene que adivinar el número N. 
 * El juego dirá si se ha acertado o si no, mostrará qué dígitos están bien colocados.
 */
public class Adivinanza {
    private int incognita; //Numero aleatorio
    private int numeroPrueba; //Numero introducido por el usuario
    private byte intentos=10; 
    private byte cifrasIncognita;
    private Random random;
    
    
    public Adivinanza(){
        random = new Random();
        this.incognita = random.nextInt(1000000)+1;
        if(this.incognita == 0){
            this.incognita++;
        } //Fin Si
        this.cifrasIncognita = Adivinanza.cifras(this.incognita);
    }
    /**
     * 
     * @param num 
     */
    public void juega(int num) {
        //Algoritmo:
        while(num <= 0 || cifras(num)>cifrasIncognita){
            System.out.print("Introduce un número que tenga entre 1 y "+cifrasIncognita+ " cifras: ");
            num = Leer.datoInt();
        }//Fin Mientras
        this.numeroPrueba = num;
        this.intentos--;  
    } 
    /**
     * 
     * @return devuelve true si ha acertado el numero
     */
    public boolean haGanado(){
        return this.numeroPrueba == this.incognita;
    } 
    /**
     * 
     * @return las cifras que tiene el numero aleatorio 
     */
    public byte getCifrasIncognita(){
        return this.cifrasIncognita;
    }
    /**
     * 
     * @return el numero aleatorio
     */
    public int getIncognita(){
        return this.incognita;
    }
    /**
     * 
     * @return una cadena mostrando las cifras que se han acertado y las que no
     * como asteriscos
     */
    public String getPista() {

        String inco = Integer.toString(this.incognita);
        String intento = Integer.toString(this.numeroPrueba);
        String out = "";
        if (this.numeroPrueba == 0) {
            out = Adivinanza.meteAsteriscos(this.cifrasIncognita);
        } else {
            while (inco.length() > intento.length()) {
                intento = "." + intento;
            } //Fin Mientras
            for (byte i = 0; i < inco.length(); i++) {
                if (inco.charAt(i) == intento.charAt(i)) {
                    out += inco.charAt(i);
                } else {
                    out += "*";
                } //Fin Si
            }//Fin Para
        }//Fin Si
        return out;
    }
    /**
     * 
     * @return devuelve los intentos que quedan
     */
    public byte getIntentos(){
        return this.intentos;
    }
    /**
     * 
     * @param n
     * @return una cadena llena de asteriscos de la longitud introducida por parametro 
     */
    private static String meteAsteriscos(byte n){
        String out="";
        for(byte i = 0; i<n;i++){
            out +="*";
        }//Fin Para
        return out;
    }
    /**
     * 
     * @param n
     * @return el numero de cifras del numero introducido por parametro
     */
    private static byte cifras(int n){
        return (byte) Integer.toString(n).length();
    }
}