/**
 * Esta clase proporciona funcionalidades basicas de una calculadora
 */

/**
 *
 * @author Andy Jan
 */
public class Calculadora {

    private double resultado;

    /**
     * Constructor por defecto iniciando el atributo a 0
     */
    public Calculadora() {
        resultado = 0;
    }
    
    /**
     * Suma de dos numeros
     * @param a primer numero
     * @param b segundo numero
     * @return la suma de a y b
     */
    public double sumar(double a, double b) {
        return a + b;
    }

    /**
     * Resta dos numeros
     * @param a primer numero
     * @param b segundo numero
     * @return la diferencia entre a y b
     */
    public double restar(double a, double b) {
        return a - b;
    }

    /**
     * Multiplica dos numeros
     * @param a primer numero
     * @param b segundo numero
     * @return el producto de a y b
     */
    public double multiplicar(double a, double b) {
        return a * b;
    }

    /**
     * Divide dos numeros
     * @param a dividendo
     * @param b divisor
     * @return division entre a y b
     */
    public double dividir(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("No se puede dividir por cero.");
        }
        return a / b;
    }

    /**
     * Obtener resultado
     * @return valor del atributo resultado
     */
    public double getResultado() {
        return resultado;
    }

    /**
     * Establece el atributo resultado al valor deseado
     * @param resultado valor deseado
     */
    public void setResultado(double resultado) {
        this.resultado = resultado;
    }

    /**
     * Resetea el atributo resultado a 0
     * @return  void
     */
    public void resetear() {
        resultado = 0;
    }
}
