/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andy Jan
 */
public class FrequenciaPalabra {
    private Palabra[] listaPalabras;
    private int numPalabras;
    
    private void unaPalabraMas(Palabra[] listaActual){
        this.listaPalabras = new Palabra[listaActual.length+1];
        for(int i = 0;i<listaActual.length;i++){
            this.listaPalabras[i] = listaActual[i];
        }
        this.numPalabras = this.listaPalabras.length;
    }
    private void insertarPalabra(Palabra p){
        unaPalabraMas(this.listaPalabras);
        this.listaPalabras[this.numPalabras-1] = p;
    }
    private int buscarPalabra(String cad){
        
    }
    public Palabra obtenerObjPalabra(int pos){
        
    }
    public int obtenerNumPalabras(){
        
    }
    public void cuentaPalabra(String cad){
        
    }
}
