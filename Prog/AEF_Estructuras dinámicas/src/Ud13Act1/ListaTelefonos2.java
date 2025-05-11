/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ud13Act1;

import java.util.LinkedList;

/**
 *
 * @author Andy Jan
 */
public class ListaTelefonos2 {
    private LinkedList<Persona> listaTelefonos;
    private int nElementos;
    
    public ListaTelefonos2(){
        this.listaTelefonos = new LinkedList<Persona>();
        this.nElementos = 0;
    }
    public void aniadir(Persona p){
        this.listaTelefonos.add(p);
        this.nElementos++;
    }
    public boolean eliminar(long tel){
        int i = 0;
        boolean removido;
        
        while(this.listaTelefonos.get(i).obtenerTelefono() != tel){
            i++;
        }
        removido = this.listaTelefonos.remove(this.listaTelefonos.get(i));
        if (removido){
            this.nElementos--;
        }
        return removido;
    }
    public int buscar(String str, int pos){
        int encontrado = -1;
        
        while(pos < this.nElementos && encontrado == -1){
            if(this.listaTelefonos.get(pos).obtenerNombre().indexOf(str) != -1){
                encontrado = pos;
            }
            pos++;
        }
        
        return encontrado;
    }
    public int longitud(){
        return this.nElementos;
    }
    
    public Persona valorEn(int pos){
        Persona buscada = null;
        if(pos > this.nElementos){
            System.out.println("Indice fuera de rango");
        } else {
            buscada = this.listaTelefonos.get(pos);
        }//Fin Si
        return buscada;
    }
}
