/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 *
 * @author DAM2
 */
public class RegistroModel {
    public String validarUsuario(String usuario, String password1, String password2){
        if(usuario.length() < 1) return "El usuario esta vacio";
        if(password1.length() < 6) return "Contraseña debe ser al menos 6 caracteres";
        if(!password1.equals(password2)) return "Las contraseñas no coinciden";
        
        try{
            File usuarios = new File("usuarios.txt");
            PrintStream escritor = new PrintStream(new FileOutputStream(usuarios,true));
            
            escritor.println(usuario + "-" + password1);
            
        } catch (FileNotFoundException ex) {
            System.getLogger(RegistroModel.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            return "no se ha podido registrar";
        }
        
        return null;
    }
}
