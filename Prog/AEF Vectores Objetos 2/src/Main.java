/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andy Jan
 */
public class Main {
    private static void contarPalabras(String texto){
        
    }
    
    
    public static void main(String[] args){
        FrequenciaPalabra lista;
        String texto;
        
        texto = "hola que tal la ola y hola la ola";
        lista = new FrequenciaPalabra();
        
        
        int pos = 0;
        
        while(pos != -1 && pos < texto.length()){
            if(texto.indexOf(" ", pos) != -1){
                lista.cuentaPalabra(texto.substring(pos, texto.indexOf(" ", pos)));
            }else {
                lista.cuentaPalabra(texto.substring(pos));
            }
            pos = texto.indexOf(" ", pos);
            if(pos != -1){
                pos++;
            }
        }
        
        for (int i = 0; i< lista.obtenerNumPalabras();i++){
            System.out.print(lista.obtenerObjPalabra(i).obtenerPalabra() + " ");
            System.out.println(lista.obtenerObjPalabra(i).obtenerFrecuencia());
            
        }
        
    }
}
