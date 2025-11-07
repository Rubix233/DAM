
import java.io.IOException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author AndyJan
 */
public class Traductor {
    public static void main(String[] args) throws IOException{
        ProcessBuilder trad = new ProcessBuilder("CMD", "/C", "start","", "https://translate.google.es/?sl=en&tl=es&text=how%20are%20you");
        
        trad.start();
    }
}
