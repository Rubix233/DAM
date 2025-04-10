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
    
    public FrequenciaPalabra(){
        listaPalabras = new Palabra[0];
    }
    
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
        int pos = -1;
        int i = 0;
        if (this.listaPalabras.length > 0) {
            while (i < this.listaPalabras.length - 1 && !cad.equals(this.listaPalabras[i].obtenerPalabra())) {
                i++; ;
            }
            if (this.listaPalabras[i].obtenerPalabra().equals(cad)) {
                pos = i;
            }
        }
        
        return pos;
    }
    public Palabra obtenerObjPalabra(int pos){
        return this.listaPalabras[pos];
    }
    public int obtenerNumPalabras(){
        return this.listaPalabras.length;
    }
    public void cuentaPalabra(String cad){
        if(buscarPalabra(cad) != -1){
            this.listaPalabras[buscarPalabra(cad)].incrementaFrecuencia();
        } else {
            Palabra p;
            p = new Palabra(cad);
            this.insertarPalabra(p);
        }
    }
}
