/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author andyj
 */
public class PainterThread extends Thread{
    String mensaje;
    
    public PainterThread(String mensaje){
        this.mensaje = mensaje;
    }
    
    
    @Override
    public void run() {
        for(int i = 0; i < 1000;i++){
            System.out.println(mensaje);
        }
    }
}
