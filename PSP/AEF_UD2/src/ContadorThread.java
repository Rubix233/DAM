/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author andyj
 */
public class ContadorThread extends Thread{
    
    
    @Override
    public void run(){
        for(int i = 1; i <= 100; i++){
            System.out.println("A"+i);
        }
    }
}
