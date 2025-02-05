
/**
 *
 * @author Andy Jan
 */
public class Ud6Ej6 {

    public static void main(String[] args) {
        final byte ALUMNOS = 5;
        float media = 0;
        byte aprobados = 0;
        byte suspensos;
        float porcentajeA;
        float porcentajeS;
        char charIntro;
        float numIntro = 11;

        for (byte i = 1; i <= ALUMNOS; i++) {
            do {
                System.out.print("Introduzca nota del alumno " + i + ": ");
                charIntro = Leer.datoChar();
                switch (charIntro) {
                    case 's':
                    case 'S':
                        numIntro = 9.5f;
                        break;
                    case 'n':
                    case 'N':
                        numIntro = 7.5f;
                        break;
                    case 'b':
                    case 'B':
                        numIntro = 6f;
                        break;
                    case 'f':
                    case 'F':
                        numIntro = 5f;
                        break;
                    case 'i':
                    case 'I':
                        numIntro = 4f;
                        break;
                    case 'm':
                    case 'M':
                        numIntro = 2.5f;
                        break;
                    case ' ':
                        numIntro = 0f;
                        break;
                    default:
                        numIntro = 11;
                }
            } while (numIntro > 10);


            media += numIntro;
            if (numIntro >= 5) {
                aprobados++;
            }
        }//Fin Para
        //Calculos finales
        suspensos = (byte) (ALUMNOS - aprobados);
        //Porcentaje aprobados con 2 decimales
        porcentajeA = (float) aprobados / ALUMNOS * 100;
        //porcentaje suspensos
        porcentajeS = 100 - porcentajeA;
        //media
        media = media / ALUMNOS;

        //Mostrar por pantalla
        System.out.println("De los " + ALUMNOS + " ALUMNOS: ");
        System.out.println("Han aprobado " + aprobados + "(" + porcentajeA + "%)");
        System.out.println("Han suspendido " + suspensos + "(" + porcentajeS + "%)");
        System.out.println("La nota media del curso es de: " + media);
    }//Fin programa
}
