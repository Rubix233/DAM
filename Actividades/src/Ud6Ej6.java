/**
 *
 * @author Andy Jan
 */
public class Ud6Ej6 {
    public static void main(String[] args){
        final byte ALUMNOS = 35;
        float media = 0;
        byte aprobados = 0;
        byte suspensos;
        float porcentajeA;
        float porcentajeS;
        char charIntro;
        float numIntro = 0;

        for (byte i = 1; i <= ALUMNOS; i++) {
            do {
                System.out.print("Introduzca nota del alumno " + i + ": ");
                charIntro = Leer.datoChar();
            } while (charIntro != 's' && charIntro != 'S'
                    && charIntro != 'n' && charIntro != 'N'
                    && charIntro != 'b' && charIntro != 'B'
                    && charIntro != 'f' && charIntro != 'F'
                    && charIntro != 'i' && charIntro != 'I'
                    && charIntro != 'm' && charIntro != 'M'
                    && charIntro != ' ');

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
            }
            media += numIntro;
            if (numIntro >= 5) {
                aprobados++;
            }
        }
        //Calculos finales
        suspensos = (byte) (ALUMNOS - aprobados);
        //Porcentaje aprobados con 2 decimales
        porcentajeA = (float)aprobados / ALUMNOS * 100;
        porcentajeA = Math.round(porcentajeA * 100f) / 100f;
        //porcentaje suspensos
        porcentajeS = 100 - porcentajeA;
        //media
        media = media / ALUMNOS;

        //Mostrar por pantalla
        System.out.println("De los " + ALUMNOS + " ALUMNOS: ");
        System.out.println("Han aprobado " + aprobados + "(" + porcentajeA + "%)");
        System.out.println("Han suspendido " + suspensos + "(" + porcentajeS + "%)");
        System.out.println("La nota media del curso es de: " + media);
    }
}
