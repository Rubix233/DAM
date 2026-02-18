/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Andy
 */
public class Prueba {

    //  private
    private String driver;
    Connection conexion;
    private String url;
    private String usuario;
    private String password;

    public Prueba(String driver, String url, String usuario, String password) {
        this.driver = driver;
        this.url = url;
        this.usuario = usuario;
        this.password = password;
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException("Driver no encontrado: " + driver, ex);
        }
        try {
            conexion = DriverManager.getConnection(url, usuario, password);
            System.out.println("Conexión exitosa");
        } catch (SQLException ex) {
            throw new RuntimeException("No se pudo conectar: " + ex.getMessage(), ex);
        }
    }

    public Connection getConexion() {
        return conexion;
    }

    public void insertarDepartamento(int idDepart, String nombreDepart) {
        try {
            String sql = "INSERT INTO departamento (id_depart, nombre_depart) VALUES (?, ?)";

            PreparedStatement pStatement = conexion.prepareStatement(sql);
            pStatement.setInt(1, idDepart);
            pStatement.setString(2, nombreDepart);

            int filasInsertadas = pStatement.executeUpdate();

            if (filasInsertadas > 0) {
                System.out.println("Departamento insertado: " + nombreDepart);
            }

            pStatement.close();

        } catch (SQLException e) {
            System.out.println("Error al insertar departamento: " + e.getMessage());
        }
    }

    public void insertarEmpleado(int idEmple, String nombre, String apellido,
            int idDepart, Integer idJefe, String puesto) {
        try {
            String sql = "INSERT INTO empleado "
                    + "(id_emple, nombre, apellido, id_depart, id_jefe, puesto) "
                    + "VALUES (?, ?, ?, ?, ?, ?)";

            PreparedStatement pStatement = conexion.prepareStatement(sql);

            pStatement.setInt(1, idEmple);

            pStatement.setString(2, nombre);

            pStatement.setString(3, apellido);

            pStatement.setInt(4, idDepart);

            if (idJefe != null) {
                pStatement.setInt(5, idJefe);
            } else {
                pStatement.setNull(5, java.sql.Types.INTEGER);
            }

            pStatement.setString(6, puesto);

            int filasInsertadas = pStatement.executeUpdate();

            if (filasInsertadas > 0) {
                System.out.println("Empleado insertado: " + nombre + " " + apellido);
            }

            pStatement.close();

        } catch (SQLException e) {
            System.out.println("Error al insertar empleado: " + e.getMessage());
        }
    }

    public void actualizarEmpleado(int idEmple, String nuevoNombre,
            String nuevoApellido, String nuevoPuesto,
            Integer nuevoIdJefe) {
        try {
            String sql = "UPDATE empleado "
                    + "SET nombre = ?, apellido = ?, puesto = ?, id_jefe = ? "
                    + "WHERE id_emple = ?";

            PreparedStatement pStatement = conexion.prepareStatement(sql);

            pStatement.setString(1, nuevoNombre);

            pStatement.setString(2, nuevoApellido);

            pStatement.setString(3, nuevoPuesto);

            if (nuevoIdJefe != null) {
                pStatement.setInt(4, nuevoIdJefe);
            } else {
                pStatement.setNull(4, java.sql.Types.INTEGER);
            }

            pStatement.setInt(5, idEmple);

            int filasActualizadas = pStatement.executeUpdate();

            if (filasActualizadas > 0) {
                System.out.println("Empleado actualizado: " + nuevoNombre);
            } else {
                System.out.println("No se encontró empleado con ID: " + idEmple);
            }

            pStatement.close();

        } catch (SQLException e) {
            System.out.println("Error al actualizar: " + e.getMessage());
        }
    }

    public void actualizarDepartamento(int idDepart, String nuevoNombre) {
        try {
            String sql = "UPDATE departamento SET nombre_depart = ? WHERE id_depart = ?";

            PreparedStatement pStatement = conexion.prepareStatement(sql);
            pStatement.setString(1, nuevoNombre);
            pStatement.setInt(2, idDepart);

            int filasActualizadas = pStatement.executeUpdate();

            if (filasActualizadas > 0) {
                System.out.println("Departamento actualizado: " + nuevoNombre);
            } else {
                System.out.println("No se encontró departamento con ID: " + idDepart);
            }

            pStatement.close();

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void eliminarDepartamento(int idDepart) {
        try {

            String verificarSQL = "SELECT COUNT(*) as cantidad FROM empleado "
                    + "WHERE id_depart = ?";
            PreparedStatement pStatmentVer = conexion.prepareStatement(verificarSQL);
            pStatmentVer.setInt(1, idDepart);
            ResultSet rs = pStatmentVer.executeQuery();

            rs.next();
            int cantidad = rs.getInt("cantidad");

            if (cantidad > 0) {
                System.out.println("No se puede eliminar: hay " + cantidad
                        + " empleados en este departamento");
                rs.close();
                pStatmentVer.close();
                return;
            }

            String sql = "DELETE FROM departamento WHERE id_depart = ?";
            PreparedStatement pStatement = conexion.prepareStatement(sql);
            pStatement.setInt(1, idDepart);

            int filasEliminadas = pStatement.executeUpdate();

            if (filasEliminadas > 0) {
                System.out.println("Departamento eliminado");
            } else {
                System.out.println("No se encontró departamento con ID: " + idDepart);
            }

            rs.close();
            pStatmentVer.close();
            pStatement.close();

        } catch (SQLException e) {
            System.out.println("Error al eliminar: " + e.getMessage());
        }
    }

    public void eliminarEmpleado(int idEmple) {
        try {
            String verificarSQL = "SELECT COUNT(*) as cantidad FROM empleado "
                    + "WHERE id_jefe = ?";
            PreparedStatement pStatmentVer = conexion.prepareStatement(verificarSQL);
            pStatmentVer.setInt(1, idEmple);
            ResultSet rs = pStatmentVer.executeQuery();

            rs.next();
            int cantidad = rs.getInt("cantidad");

            if (cantidad > 0) {
                System.out.println("No se puede eliminar: tiene " + cantidad
                        + " subordinados");
                rs.close();
                pStatmentVer.close();
                return;
            }

            String sqlObtener = "SELECT nombre, apellido FROM empleado WHERE id_emple = ?";
            PreparedStatement pStatmentObtener = conexion.prepareStatement(sqlObtener);
            pStatmentObtener.setInt(1, idEmple);
            ResultSet rsObtenido = pStatmentObtener.executeQuery();

            String nombreEmpleado = "";
            if (rsObtenido.next()) {
                nombreEmpleado = rsObtenido.getString("nombre") + " " + rsObtenido.getString("apellido");
            }

            String sql = "DELETE FROM empleado WHERE id_emple = ?";
            PreparedStatement pStatement = conexion.prepareStatement(sql);
            pStatement.setInt(1, idEmple);

            int filasEliminadas = pStatement.executeUpdate();

            if (filasEliminadas > 0) {
                System.out.println("Empleado eliminado: " + nombreEmpleado);
            } else {
                System.out.println("No se encontró empleado con ID: " + idEmple);
            }

            rs.close();
            pStatmentVer.close();
            rsObtenido.close();
            pStatmentObtener.close();
            pStatement.close();

        } catch (SQLException e) {
            System.out.println("Error al eliminar: " + e.getMessage());
        }
    }

    public boolean existeEmpleado(int idEmple) {
        try {
            String sql = "SELECT COUNT(*) as cantidad FROM empleado WHERE id_emple = ?";
            PreparedStatement pStatement = conexion.prepareStatement(sql);
            pStatement.setInt(1, idEmple);

            ResultSet rs = pStatement.executeQuery();
            rs.next();
            int cantidad = rs.getInt("cantidad");

            rs.close();
            pStatement.close();

            return cantidad > 0;

        } catch (SQLException e) {
            System.out.println("Error al validar empleado: " + e.getMessage());
            return false;
        }
    }

    public boolean existeDepartamento(int idDepart) {
        try {
            String sql = "SELECT COUNT(*) as cantidad FROM departamento WHERE id_depart = ?";
            PreparedStatement pStatement = conexion.prepareStatement(sql);
            pStatement.setInt(1, idDepart);

            ResultSet rs = pStatement.executeQuery();
            rs.next();
            int cantidad = rs.getInt("cantidad");

            rs.close();
            pStatement.close();

            return cantidad > 0;

        } catch (SQLException e) {
            System.out.println("Error al validar departamento: " + e.getMessage());
            return false;
        }
    }

    public String obtenerNombreDepartamento(int idDepart) {
        try {
            String sql = "SELECT nombre_depart FROM departamento WHERE id_depart = ?";
            PreparedStatement pStatement = conexion.prepareStatement(sql);
            pStatement.setInt(1, idDepart);

            ResultSet rs = pStatement.executeQuery();

            if (rs.next()) {
                String nombre = rs.getString("nombre_depart");
                rs.close();
                pStatement.close();
                return nombre;
            }

            rs.close();
            pStatement.close();
            return null;

        } catch (SQLException e) {
            System.out.println("Error al obtener nombre de departamento: " + e.getMessage());
            return null;
        }
    }

    public String obtenerNombreEmpleado(int idEmple) {
        try {
            String sql = "SELECT nombre, apellido FROM empleado WHERE id_emple = ?";
            PreparedStatement pStatement = conexion.prepareStatement(sql);
            pStatement.setInt(1, idEmple);

            ResultSet rs = pStatement.executeQuery();

            if (rs.next()) {
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                rs.close();
                pStatement.close();
                return nombre + " " + apellido;
            }

            rs.close();
            pStatement.close();
            return null;

        } catch (SQLException e) {
            System.out.println("Error al obtener nombre de empleado: " + e.getMessage());
            return null;
        }
    }

    public void cerrar() {
        try {
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
                System.out.println("\nConexión cerrada.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
