/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.Serializable;
/**
 *
 * @author Andy
 */
public class Usuario implements Serializable {
    private String nombre;
    private String password;
    private String ip;
    
    public Usuario(String nombre, String password, String ip){
        this.nombre = nombre;
        this.password = password;
        this.ip = ip;
    }
    public String getNombre(){
        return this.nombre;
    }
    public String getPassword(){
        return this.password;
    }
    public String getIP(){
        return this.ip;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public void setIP(String ip){
        this.ip = ip;
    }
    
    @Override
    public String toString() {
        return "Usuario [Nombre=" + nombre + ", Pass=" + password + ", IP=" + ip + "]";
    }
}
