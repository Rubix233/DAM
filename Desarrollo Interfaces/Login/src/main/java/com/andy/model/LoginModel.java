package com.andy.model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author DAM2
 */
public class LoginModel {
    public String validarUsuario(String usuario, String password){
        if(usuario.length() < 1) return "El usuario esta vacio";
        if(password.length() < 6) return "Contraseña debe ser al menos 6 caracteres";
        return null;
    }
}
