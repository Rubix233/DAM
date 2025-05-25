/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.LinkedList;
import java.util.List;
import java.util.Iterator;
import java.util.Collections;
/**
 *
 * @author Jaime Martín
 */
public class Clasificacion implements Iterable<Saltador>{
    //Atributos
    private List<Saltador> lista;
    //Constructores
    public Clasificacion(){
        lista = new LinkedList();
    }
    //Metodos
    public boolean haySaltador(){
        if(!lista.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
    public Saltador buscar(int dorsal){
        Iterator<Saltador> 
        it = this.iterator();
        while (it.hasNext()) {
            Saltador j = it.next();
            if (j.getDorsal() == dorsal) {
                return j;
            }
        }
        return null;
    }
    public boolean aniadir(Saltador s) {
            Iterator<Saltador> it = this.iterator();
            while (it.hasNext()) {
                Saltador existente = it.next();
                if (existente.getDorsal() == s.getDorsal()) {
                    return false;  
                }
            }
        lista.add(s);
        return true;
    }
    public boolean borrar(int dorsal) {
        Iterator<Saltador> it;
        it = lista.iterator();
        while (it.hasNext()) {
            Saltador s = it.next();
            if (s.getDorsal() == dorsal) {
                it.remove();
                return true;
            }
        }
        return false;
    }
    public double getPuntosPais(String pais,char sexo){
        double puntos;
        int personas = 0;
        puntos = 0;
        Iterator<Saltador> it;
        Saltador s;
        it = this.iterator();
        while (it.hasNext()) {
            s = it.next();
            if (s.getPais().equals(pais) && s.getSexo() == sexo) {
                puntos = puntos + s.getPuntos();
                personas++;
            }
        }
        return puntos/personas;
    }
    public void ordena(){
        //Collections.sort(lista);
        List<Saltador> listaOrdenada = new LinkedList<Saltador>();
           while (!lista.isEmpty()) {
               Iterator<Saltador> it = lista.iterator();
               Saltador menor = it.next();

               while (it.hasNext()) {
                   Saltador actual = it.next();
                   if (actual.compareTo(menor) < 0) {
                       menor = actual;
                   }
               }

               listaOrdenada.add(menor);
               // Eliminamos el menor de la lista original
               Iterator<Saltador> borrarIt = lista.iterator();
               while (borrarIt.hasNext() && !borrarIt.next().equals(menor)) {
                       
            }
            borrarIt.remove();
    }

    // Reasignamos la lista ordenada
    lista = listaOrdenada;
    }
    @Override
    public Iterator<Saltador> iterator() {
        return lista.iterator();
    }
}
