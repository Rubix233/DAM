package implementacionjava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ImplementacionJava {

    public static void main(String[] args) throws IOException {
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        
        List<Producto> productos = new ArrayList<>();
        
        boolean existe = false;
        double precio;
        int stockInicial;
        int cantidadVender;
        String nombre;

        System.out.print("Introduce el nombre del producto: ");
        nombre = teclado.readLine();

        // Comprobar si el producto ya existe en la lista
        for (Producto p : productos) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                existe = true;
                break;
            }
        }
        if (!existe) {
            System.out.print("Introduce el precio del producto: ");
            precio = Double.parseDouble(teclado.readLine());
            
            System.out.print("Introduce el stock inicial del producto: ");
            stockInicial = Integer.parseInt(teclado.readLine());

            Producto producto = new Producto(nombre, precio, stockInicial);
            productos.add(producto);

            System.out.print("¿Cuántas unidades deseas vender?: ");
            cantidadVender = Integer.parseInt(teclado.readLine());

            if (producto.vender(cantidadVender)) {
                System.out.println("Venta realizada. Stock restante: " + producto.getStock());
                Pedido pedido = new Pedido();
                pedido.agregarProducto(producto, cantidadVender);
                System.out.println("Total del pedido: " + pedido.calcularTotal() + " €");
            } else {
                System.out.println("Error: No hay suficiente stock. Stock disponible: " + producto.getStock());
            }

        } else {
            System.out.println("Error: El producto ya existe.");
        }

        // Casos prácticos adicionales
        Producto p2 = new Producto("Teclado", 25.0, 10);
        productos.add(p2);
        Pedido pedido2 = new Pedido();
        pedido2.agregarProducto(p2, 3);
        if (p2.vender(3)) {
            System.out.println("Venta de 3 teclados realizada. Stock restante: " + p2.getStock());
            System.out.println("Total del pedido 2: " + pedido2.calcularTotal() + " €");
        } else {
            System.out.println("No hay suficiente stock de teclados.");
        }
    }
}
