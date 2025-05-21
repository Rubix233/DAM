/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Profesor Carlos
 */
public class Factura {

    public String cliente;
    public double[] productos;
    public int tipo; // 1 = Estándar, 2 = Preferente
    public void imprimirFactura() {
        System.out.println("*******************");
        System.out.println("Factura de " + cliente);
        double total = 0;
        for (int i = 0; i < productos.length; i++) {
            total = total + productos[i];
        }
        System.out.println("Total: " + total);
        if (tipo == 2) {
            double descuento = total * 0.1;
            System.out.println("Descuento preferente: " + descuento);
            total = total - descuento;
        }
        System.out.println("Total final: " + total);
        System.out.println("*******************");
    }
}
