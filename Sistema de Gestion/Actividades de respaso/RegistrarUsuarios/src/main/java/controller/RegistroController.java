/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JTextField;
import model.RegistroModel;
import view.LoginView;
import view.RegistroView;

/**
 *
 * @author DAM2
 */
public class RegistroController implements ActionListener{
    private RegistroModel modelo;
    private RegistroView vista;
    private LoginController login;
    private JLabel mensaje;
    private JTextField usuario, password1, password2;

    public RegistroController(RegistroModel modelo, RegistroView vista) {
        this.modelo = modelo;
        this.vista = vista;
        this.login = login;
        this.mensaje = this.vista.getMensaje();
        this.usuario = this.vista.getUsuario();
        this.password1 = this.vista.getPassword1();
        this.password2 = this.vista.getPassword2();

        this.vista.getBtnRegistrar().addActionListener(this);
        this.vista.getBtnVolver().addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(this.vista.getBtnRegistrar())) {
            String usuarioValido = modelo.validarUsuario(usuario.getText(), password1.getText(), password2.getText());
            if (usuarioValido == null) {
                usuario.setText("");
                password1.setText("");
                password2.setText("");
                mensaje.setText("Usuario Registrado");
                mensaje.setForeground(Color.green);

            } else {
                mensaje.setText(usuarioValido);
                mensaje.setForeground(Color.red);
            }

        }
        if (e.getSource().equals(this.vista.getBtnVolver())) {
            this.esconderVista();
            login.iniciarVista();
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
