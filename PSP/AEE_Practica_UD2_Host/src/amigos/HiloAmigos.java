package amigos;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Andy Jan
 */
public class HiloAmigos extends Thread {

    int min, max, salto;

    public HiloAmigos(String name, int min, int max, int salto) {
        this.setName(name);
        this.min = min;
        this.max = max;
        this.salto = salto;
    }

    @Override
    public void run() {
        for (int i = min; i <= max; i += salto) {
            int n2 = Calculadora.sonAmigos(i);
            if (n2 != -1 && n2 > i){
                System.out.println("" + i + " es amigo de " + n2);
            }
        }
    }
}