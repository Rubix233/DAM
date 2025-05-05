package Ud13Act1;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andy Jan
 */
public class ListaTelefonos {
    private Persona[] listaTelefonos;
    private int nElementos;
    
    
    public ListaTelefonos(){
        listaTelefonos = new Persona[0];
        nElementos = 0;
    }
    
    //Cambiar el uso de variable aux por listaActual
    private void unElementoMas(Persona[] listaActual){
        //Entorno
        this.nElementos++;
        this.listaTelefonos = new Persona[this.nElementos];
        
        //Algoritmo
        for(int i=0;i < listaActual.length; i++){
            this.listaTelefonos[i] = listaActual[i];
        }//Fin Para
    }
    private void unElementoMenos(Persona[] listaActual) {
        if (listaActual.length > 0) {
            this.nElementos--;
            this.listaTelefonos = new Persona[this.nElementos];
            int iViejo;
            int iNuevo = 0;

            for (iViejo = 0; iViejo < listaActual.length; iViejo++) {
                if (listaActual[iViejo] != null) {
                    this.listaTelefonos[iNuevo] = listaActual[iViejo];
                    iNuevo++;
                }//Fin Si
            }//Fin Para
        }//Fin Si


    }
    public void ponerValorEn(int pos, Persona p){
        if(pos >= this.nElementos){
            System.out.println("Indice fuera de rango");
        } else {
            this.listaTelefonos[pos] = p;
        }//Fin Si
    }
    public Persona valorEn(int pos){
        Persona buscada = null;
        if(pos > this.nElementos){
            System.out.println("Indice fuera de rango");
        } else {
            buscada = this.listaTelefonos[pos];
        }//Fin Si
        return buscada;
    }
    public int longitud(){
        return this.nElementos;
    }
    public void aniadir(Persona p){
        unElementoMas(this.listaTelefonos);
        this.listaTelefonos[this.nElementos-1] = p;
    }
    public boolean eliminar(long tel){
        boolean eliminado = false;
        for (int i = 0; i < this.nElementos;i++){
            if(this.listaTelefonos[i].obtenerTelefono() == tel){
                this.listaTelefonos[i] = null;
                unElementoMenos(this.listaTelefonos);
                eliminado = true;
            }//Fin Si
        }//Fin Para
        return eliminado;
    }
    public int buscar(String str, int pos){
        int encontrado = -1;
        
        
        while(pos < this.nElementos && encontrado == -1){
            if(this.listaTelefonos[pos].obtenerNombre().indexOf(str) != -1){
                encontrado = pos;
            }//Fin Si
            pos++;
        }//Fin Mientras
        return encontrado;
        
    }
}
