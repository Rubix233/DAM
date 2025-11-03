/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.andy.login;

import com.andy.controller.LoginController;
import com.andy.model.LoginModel;
import com.andy.view.vistaLogin;
/**
 *
 * @author DAM2
 */
public class Login {

    public static void main(String[] args) {
        // 1. Crear las piezas
       LoginModel modelo = new LoginModel();
       vistaLogin vista = new vistaLogin();
      
       // 2. Crear el Controlador y conectar todo
       LoginController controlador = new LoginController(modelo, vista);
      
       // 3. Arrancar la aplicación
       javax.swing.SwingUtilities.invokeLater(() -> {
           controlador.iniciarVista();
       });

    }
}
