/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import app.MainApp;
import model.LoginModel;
import view.LoginView;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author DAM2
 */
public class LoginController implements ActionListener{
    private LoginModel modelo;
    private LoginView vista;
    private MainApp app;
    private JLabel mensaje;
    private JTextField usuario, password;

    public LoginController(LoginModel modelo, LoginView vista, MainApp app) {
        this.modelo = modelo;
        this.vista = vista;
        this.app = app;
        this.mensaje = this.vista.getMensaje();
        this.usuario = this.vista.getUsuario();
        this.password = this.vista.getPassword();

        this.vista.getBtnRegistrar().addActionListener(this);
        this.vista.getBtnLogin().addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(this.vista.getBtnLogin())) {
            String usuarioValido = modelo.validarUsuario(usuario.getText(), password.getText());
            if (usuarioValido == null) {
                usuario.setText("");
                password.setText("");
                mensaje.setText("Usuario logueado");
                mensaje.setForeground(Color.green);

            } else {
                mensaje.setText(usuarioValido);
                mensaje.setForeground(Color.red);
            }

        }
        if (e.getSource().equals(this.vista.getBtnRegistrar())) {
            app.vistaRegistrar();   
        }
    }

    public void iniciarVista() {
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }
    public void esconderVista(){
        vista.setVisible(false);
    }
}
