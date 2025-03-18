/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrador
 */
public class Main {
    public static void main(String[] args){
        System.out.println((int)Math.round(Math.random() * 1000000));
        
        String inco = "123456";
        String intento = "224466";
        String out= "";
        
        for(byte i = 0; i<inco.length();i++){
            if(inco.charAt(i) == intento.charAt(i)){
                out += inco.charAt(i);
            }else {
                out += "*";
            }
        }
        System.out.println(out);
    }
}
