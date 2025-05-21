/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrador
 */
// Aplicamos encapsulamiento
public class FacturaRef {
    private final double DESCUENTO_PREFERENTE = 0.10; //Uso de constante para numero magico
    private String cliente;
    private double[] productos;
    private TipoCliente tipo; // Reemplazo de tipo cliente por Enum

    
    public FacturaRef(String cliente, double[] productos, TipoCliente tipo) {
        this.cliente = cliente;
        this.productos = productos;
        this.tipo = tipo;
    }

    public void imprimirFactura() {
        double total;
        
        System.out.println("*******************");
        System.out.println("Factura de " + cliente);
        total = calcularTotal();
        total = aplicarDescuento(total);
        System.out.println("Total final: " + total);
        System.out.println("*******************");
    }

    private double calcularTotal() {
        double total = 0;
        for (double precio : productos) {
            total += precio;
        }
        System.out.println("Total: " + total);
        return total;
    }

    private double aplicarDescuento(double total) {
        double descuento = 0;
        if (tipo == TipoCliente.PREFERENTE) {
            descuento = total * DESCUENTO_PREFERENTE;
            System.out.println("Descuento preferente: " + descuento);
            return total - descuento;
        } else {
            System.out.println("No tiene descuento");
        }
        return total;
    }

}

