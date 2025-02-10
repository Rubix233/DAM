
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
                }//Fin Si
            }//Fin Para
        }//Fin Si

        return primo;
    }//Fin Funcion

    public static void primosEntre(int a, int b) {
        int i = a;

        if (a % 2 == 0) {
            i++;
        }//Fin Si
        for (; i <= b; i = i + 2) {
            if (esPrimo(i)) {
                System.out.println(i);
            }//Fin Si
        }//Fin Para
    }//Fin Funcion

    public static int anexoDelante(int numero, byte digito) {
        int numeroFinal;

        numeroFinal = numero +
                (digito*(int) Math.pow(10, Utilidades.cifras(numero)));

        return numeroFinal;
    }//Fin Funcion

    public static int anexoDetras(int numero, byte digito) {
        int numeroFinal;

        numeroFinal = (numero * 10) + digito;

        return numeroFinal;
    }//Fin Funcion

    public static void main(String[] args) {
        // TODO code application logic here
        byte digitoIntro;
        int numeroIntro;
        boolean continuar;

        do {
            System.out.print("Introduzca numero: ");
            numeroIntro = Leer.datoInt();

            System.out.print("Introduzca digito para anexar:");
            digitoIntro = UtilidadesAndy.datoByte();

            if (anexoDelante(numeroIntro, digitoIntro)
                    < anexoDetras(numeroIntro, digitoIntro)) {

                primosEntre(anexoDelante(numeroIntro, digitoIntro),
                        anexoDetras(numeroIntro, digitoIntro));
            } else {
                if(anexoDelante(numeroIntro, digitoIntro)
                    > anexoDetras(numeroIntro, digitoIntro)){
                   primosEntre(anexoDetras(numeroIntro, digitoIntro),
                        anexoDelante(numeroIntro, digitoIntro)); 
                } else {
                    System.out.println("Son el mismo numero");
                }//Fin Si
                
                
            }//Fin Si

            continuar = Utilidades.continuar();
        } while (continuar);//Fin Mientras

    }//Fin Programa
}