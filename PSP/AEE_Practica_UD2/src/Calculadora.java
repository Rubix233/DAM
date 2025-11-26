/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Andy Jan
 */
public class Calculadora {
    
    
    
    public static List<Integer> calcularDivisores(int n) {
        List<Integer> divisores = new ArrayList<Integer>();

        for (int i = 1; i <= n/2; i++) {
            if ((n % i == 0) && (i != n)) {
                divisores.add(i);
            }
        }

        return divisores;
    }
    
    public static int sumarDivisores(List<Integer> lista){
        int resultado = 0;
        
        for(int i = 0; i < lista.size(); i++){
            resultado += lista.get(i);
        }
        
        return resultado;
    }
    
    public static int sonAmigos(int n1){
        int n2 = sumarDivisores(calcularDivisores(n1));
        if (Calculadora.sumarDivisores(Calculadora.calcularDivisores(n2)) == n1){
            return n2;
        }
        return -1;
    }
}
