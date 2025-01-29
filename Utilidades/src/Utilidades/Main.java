
/**
 *
 * @author Administrador
 */
public class Main {
    public static void main(String[] args){
        byte elDato;
        boolean prueba;
        
        byte dia = 29;
        byte mes = 2;
        short ano = 2024;
        
        prueba = Utilidades.esFechaValida(dia, mes, ano);
        System.out.println(prueba);
        
       
        
    }
}
