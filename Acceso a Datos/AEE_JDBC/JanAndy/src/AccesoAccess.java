
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andy
 */
public class AccesoAccess {
    
    public static void main(String[] args) {
        Random random;
        Prueba gestor;
        /*
        String nombreDriver = "sun.jdbc.odbc.JdbcOdbcDriver";
        String urlConexion = "jdbc:odbc:PRUEBAACCESS";
        String usuario = "Admin";
        String contra = "DAM2";
        */
        Properties propiedades = new Properties();
         try {
            propiedades.load(new FileInputStream("src/Access.properties"));
        } catch (IOException e) {
            System.out.println("Error al cargar archivo de propiedades: " + e.getMessage());
            return;
        }
        
        String nombreDriver = propiedades.getProperty("driver");
        String urlConexion = propiedades.getProperty("url");
        String usuario = propiedades.getProperty("usuario");
        String contra = propiedades.getProperty("password");

        gestor = new Prueba(nombreDriver, urlConexion, usuario, contra);
        random = random = new Random();

        try {
            // 1. Crear y actualizar DEPART
            int idDep = random.nextInt(100) + 1;
            String nomDep = "DEP_" + idDep;

            System.out.println("\n[DEP] Insertando: " + nomDep);
            gestor.insertarDepartamento(idDep, nomDep,"sevilla");

            System.out.println("[DEP] Actualizando nombre...");
            gestor.actualizarDepartamento(idDep, nomDep + "_MOD","sevilla");

            // 2. Crear y actualizar EMPLE
            int idEmp = random.nextInt(1000) + 1;
            String nombre = "Empleado" + idEmp;
            String apellido = "Apellido" + idEmp;
            String oficio = "Tester";

            System.out.println("\n[EMP] Insertando empleado: " + nombre);
            gestor.insertarEmpleado(idEmp,apellido,oficio, 2000, idDep, null);

            System.out.println("[EMP] Modificando puesto...");
            gestor.actualizarEmpleado(idEmp, apellido, "Senior Tester",3000, null);

            // 3. Borrado
            System.out.println("\n--- FINALIZANDO PRUEBAS Y LIMPIANDO ---");
            gestor.eliminarEmpleado(idEmp);
            gestor.eliminarDepartamento(idDep);

        } catch (Exception e) {
            System.err.println("Error durante la ejecución automática: " + e.getMessage());
        } finally {
            gestor.cerrar();
            System.out.println("Conexión cerrada.");
        }
    }
}
