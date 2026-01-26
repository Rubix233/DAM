
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andy
 */
public class Main {
    public static void main(String[] args) {
        String nombreDriver = "org.apache.derby.jdbc.ClientDriver";
        String url = "jdbc:derby://localhost:1527/PRUEBA";
        try {
            Class.forName(nombreDriver);
            Connection conexion = DriverManager.getConnection(url, "DAM2", "DAM2");
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}
