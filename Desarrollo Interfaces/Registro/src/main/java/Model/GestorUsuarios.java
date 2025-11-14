/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author andyj
 */
public class GestorUsuarios {

    private static final String ARCHIVO_USUARIOS = "Usuarios.txt";

    public static boolean registrarUsuario(String usuario, String clave) {

        // 1. Primero comprobamos si el usuario ya existe
        if (validarUsuario(usuario, clave)) {
            System.out.println("El usuario ya existe.");
            return false;
        }
        // 2. Si no existe, lo registramos
        try (FileWriter fw = new FileWriter(GestorUsuarios.ARCHIVO_USUARIOS, true); PrintWriter pw = new PrintWriter(fw)) {

            pw.println(usuario + "," + clave);
            return true;

        } catch (IOException e) {
            System.out.println("Error al registrar usuario: " + e.getMessage());
            return false;
        }
    }

    public static boolean validarUsuario(String usuario, String clave) {

        try (FileReader fr = new FileReader(ARCHIVO_USUARIOS); BufferedReader br = new BufferedReader(fr)) {

            String linea;

            while ((linea = br.readLine()) != null) {

                String[] partes = linea.split(",");

                // Comprobamos que tenga formato valido
                if (partes.length == 2
                        && partes[0].equals(usuario)
                        && partes[1].equals(clave)) {

                    return true;
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("Archivo de usuarios no encontrado. Aún no existen usuarios.");
        } catch (IOException e) {
            System.out.println("Error al leer el archivo de usuarios: " + e.getMessage());
        }

        return false; // No se encontró el usuario
    }

}
