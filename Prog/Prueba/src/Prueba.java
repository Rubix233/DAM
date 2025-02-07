/**
 *
 * @author Andy Jan
 */
public class Prueba {
    public static boolean esPrimo(int num) {
        boolean primo = true;
        if (num % 2 == 0) {
            primo = false;
        } else {
            for (int i = 3; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    primo = false;
                }
            }
        }

        return primo;
    }
    
    public static void primosEntre(int a, int b){
        int i = a;
        int j = b;
        
        if (a %2 == 0){
            i++;
        }
        if ( b%2 == 0){
            j--;
        }
        for (; i<=b; i = i+2){
            if (esPrimo(i)){
                System.out.println(i);
            }
        }
    }
    public static int anexoDelante(int numero, byte digito){
        int numeroFinal;
        
        numeroFinal = numero + (digito * (int)Math.pow(10, Utilidades.cifras(numero)));
        
        return numeroFinal;
    }
    
    public static int anexoDetras(int numero, byte digito){
        int numeroFinal;
        
        numeroFinal = (numero * 10) + digito;
        
        return numeroFinal;
    }

    public static void main(String[] args) {
        // TODO code application logic here
        byte digitoIntro;
        int numeroIntro;
        boolean continuar;
        
        System.out.print("Introduzca numero: ");
        numeroIntro = Leer.datoInt();
        
        System.out.print("Introduzca digito para anexar:");
        digitoIntro = UtilidadesAndy.datoByte();
        
        do {
            if (anexoDelante(numeroIntro, digitoIntro)
                    < anexoDetras(numeroIntro, digitoIntro)) {

                primosEntre(anexoDelante(numeroIntro, digitoIntro),
                        anexoDetras(numeroIntro, digitoIntro));
            } else {
                primosEntre(anexoDetras(numeroIntro, digitoIntro),
                        anexoDelante(numeroIntro, digitoIntro));
            }
            
            continuar = Utilidades.continuar();
        } while (continuar);
        
    }
}