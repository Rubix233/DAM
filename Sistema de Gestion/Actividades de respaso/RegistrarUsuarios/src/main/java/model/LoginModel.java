/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Andy Jan
 */
public class LoginModel {
    Map<String, String> users = new HashMap<>();
    String filePath = "usuarios.txt";
    
    public LoginModel(){
         try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split("-");
                if (parts.length >= 2) {
                    String key = parts[0];
                    String value = parts[1];
                    this.users.put(key, value);
                } else {
                    System.out.println("Skipping invalid line: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
         for (Map.Entry<String, String> entry : users.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
    
    
    public String validarUsuario(String usuario, String password){

        if(users.containsKey(usuario)){
            if(users.get(usuario).equals(password)){
                return null;
            } else {
                return "contraseña no valida";
            }
        } else{
            return "usuario no valido";
        }
    }
}
