/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

import controller.LoginController;
import controller.RegistroController;
import model.LoginModel;
import model.RegistroModel;
import view.LoginView;
import view.RegistroView;

/**
 *
 * @author Andy Jan
 */
public class MainApp {
    public static void main(String[] args) {
        // 1. Crear las piezas
       LoginModel modeloLogin = new LoginModel();
       RegistroModel modeloRegistro = new RegistroModel();
       
       
       LoginView loginView = new LoginView();
       RegistroView registroView = new RegistroView();
      
       // 2. Crear el Controlador y conectar todo
       LoginController controlador = new LoginController(modeloLogin, loginView, this );
       RegistroController controladorRegistro = new RegistroController(modeloRegistro, registroView);
      
       // 3. Arrancar la aplicación
       javax.swing.SwingUtilities.invokeLater(() -> {
           controlador.iniciarVista();
       });

    }
    
    public void vistaRegistrar(){
        
    }
    public void vistaLogin(){
        
    }
}
