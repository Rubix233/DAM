package amigos;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Andy Jan
 */
public class HiloAmigos extends Thread {

    int min, max;
    List<Integer> vistos = new ArrayList<Integer>();

    public HiloAmigos(String name, int min, int max) {
        this.setName(name);
        this.min = min;
        this.max = max;
    }

    @Override
    public void run() {
        for (int i = min; i <= max; i++) {
            int n2 = Calculadora.sonAmigos(i);
            if( n2 != -1 && i != n2 && !vistos.contains(n2)){
                vistos.add(i);
                System.out.println("" + i + " es amigo de " + n2);
            }
        }
    }
}