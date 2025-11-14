/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App;

import Vista.VistaLogin;

/**
 *
 * @author andyj
 */
public class App {
    public static void main(String[] args) {

        //Esta parte esta hecha con GPT porque no era capaz de arrancarlo de la otra manera
        try {
            javax.swing.UIManager.setLookAndFeel(
                javax.swing.UIManager.getSystemLookAndFeelClassName()
            );
        } catch (Exception e) {
            System.out.println("No se pudo aplicar el LookAndFeel");
        }
        javax.swing.SwingUtilities.invokeLater(() -> {
            new VistaLogin().setVisible(true);
        });
    }
}
