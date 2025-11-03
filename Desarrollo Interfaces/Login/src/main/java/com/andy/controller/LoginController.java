/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.andy.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.andy.model.LoginModel;
import com.andy.view.vistaLogin;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author DAM2
 */
public class LoginController implements ActionListener {

    private LoginModel modelo;
    private vistaLogin vista;
    private JLabel mensaje;
    private JTextField usuario, password;

    public LoginController(LoginModel modelo, vistaLogin vista) {
        this.modelo = modelo;
        this.vista = vista;
        this.mensaje = this.vista.getMensaje();
        this.usuario = this.vista.getUsuario();
        this.password = this.vista.getPassword();

        this.vista.getBtnRegistrar().addActionListener(this);
        this.vista.getBtnLimpiar().addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(this.vista.getBtnRegistrar())) {
            String usuarioValido = modelo.validarUsuario(usuario.getText(), password.getText());
            if (usuarioValido == null) {
                usuario.setText("");
                password.setText("");
                mensaje.setText("Usuario registrado");
                mensaje.setForeground(Color.green);

            } else {
                mensaje.setText(usuarioValido);
                mensaje.setForeground(Color.red);
            }

        }
        if (e.getSource().equals(this.vista.getBtnLimpiar())) {
            usuario.setText("");
            password.setText("");
            mensaje.setText("");
        }
    }

    public void iniciarVista() {
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }

}
