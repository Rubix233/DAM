/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementacionjava;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Andy Jan
 */
// 2. Clase Pedido que almacena varios productos y calcula el total del pedido.
public class Pedido {
    private ArrayList<Producto> productos;
    private ArrayList<Integer> cantidades;

    public Pedido() {
        productos = new ArrayList<>();
        cantidades = new ArrayList<>();
    }

    // Añadir producto y cantidad al pedido
    public void agregarProducto(Producto producto, int cantidad) {
        productos.add(producto);
        cantidades.add(cantidad);
    }

    // Calcular el total del pedido
    public double calcularTotal() {
        double total = 0;
        for (int i = 0; i < productos.size(); i++) {
            total += productos.get(i).getPrecio() * cantidades.get(i);
        }
        return total;
    }
}