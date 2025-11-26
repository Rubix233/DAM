
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrador
 */
public class MainApp {
    public static void main(String[] args) {
        
        
        try {
            FicheIndexDAO fid = new FicheIndexDAO();
            Empleado emple = new Empleado("9","García López Juan", Sexo.HOMBRE, 1500, new Fecha((short) 2015, (byte) 3, (byte) 15), Tipo.FIJO, Provincia.SEVILLA);
            fid.listarPorOrdenArchivo();
            fid.borrarEmpleado("3");
            fid.listarPorOrdenArchivo();
            System.out.println("------------------------------------------------------");
            fid.crearEmpleado(emple);
            System.out.println("------------------------------------------------------");
            fid.listarPorOrdenArchivo();
            fid.crearEmpleado(emple);
            System.out.println("------------------------------------------------------");
            fid.listarPorOrdenArchivo();
        } catch (IOException ex) {
            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
