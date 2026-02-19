import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Prueba {

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

    // ─── DEPART ───────────────────────────────────────────────────────────────

    public void insertarDepartamento(int idDepart, String nombreDepart, String loc) {
        try {
            String sql = "INSERT INTO DEPART (DEPT_NO, DNOMBRE, LOC) VALUES (?, ?, ?)";
            PreparedStatement pStatement = conexion.prepareStatement(sql);
            pStatement.setInt(1, idDepart);
            pStatement.setString(2, nombreDepart);
            pStatement.setString(3, loc);

            int filasInsertadas = pStatement.executeUpdate();
            if (filasInsertadas > 0) {
                System.out.println("Departamento insertado: " + nombreDepart);
            }
            pStatement.close();
        } catch (SQLException e) {
            System.out.println("Error al insertar DEPART: " + e.getMessage());
        }
    }

    public void actualizarDepartamento(int idDepart, String nuevoNombre, String nuevaLoc) {
        try {
            String sql = "UPDATE DEPART SET DNOMBRE = ?, LOC = ? WHERE DEPT_NO = ?";
            PreparedStatement pStatement = conexion.prepareStatement(sql);
            pStatement.setString(1, nuevoNombre);
            pStatement.setString(2, nuevaLoc);
            pStatement.setInt(3, idDepart);

            int filasActualizadas = pStatement.executeUpdate();
            if (filasActualizadas > 0) {
                System.out.println("Departamento actualizado: " + nuevoNombre);
            } else {
                System.out.println("No se encontró DEPART con ID: " + idDepart);
            }
            pStatement.close();
        } catch (SQLException e) {
            System.out.println("Error al actualizar DEPART: " + e.getMessage());
        }
    }

    public void eliminarDepartamento(int idDepart) {
        try {
            String verificarSQL = "SELECT COUNT(*) as cantidad FROM EMPLE WHERE DEPT_NO = ?";
            PreparedStatement pStatmentVer = conexion.prepareStatement(verificarSQL);
            pStatmentVer.setInt(1, idDepart);
            ResultSet rs = pStatmentVer.executeQuery();
            rs.next();
            int cantidad = rs.getInt("cantidad");

            if (cantidad > 0) {
                System.out.println("No se puede eliminar: hay " + cantidad + " empleados en este departamento");
                rs.close();
                pStatmentVer.close();
                return;
            }

            String sql = "DELETE FROM DEPART WHERE DEPT_NO = ?";
            PreparedStatement pStatement = conexion.prepareStatement(sql);
            pStatement.setInt(1, idDepart);

            int filasEliminadas = pStatement.executeUpdate();
            if (filasEliminadas > 0) {
                System.out.println("Departamento eliminado");
            } else {
                System.out.println("No se encontró DEPART con ID: " + idDepart);
            }

            rs.close();
            pStatmentVer.close();
            pStatement.close();
        } catch (SQLException e) {
            System.out.println("Error al eliminar DEPART: " + e.getMessage());
        }
    }

    // ─── EMPLE ────────────────────────────────────────────────────────────────

    public void insertarEmpleado(int idEmple, String apellido, String oficio,
            double salario, int idDepart, Integer idJefe) {
        try {
            String sql = "INSERT INTO EMPLE (EMP_NO, APELLIDO, OFICIO, SALARIO, DEPT_NO, JEFE_ID) "
                       + "VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement pStatement = conexion.prepareStatement(sql);
            pStatement.setInt(1, idEmple);
            pStatement.setString(2, apellido);
            pStatement.setString(3, oficio);
            pStatement.setDouble(4, salario);
            pStatement.setInt(5, idDepart);
            if (idJefe != null) {
                pStatement.setInt(6, idJefe);
            } else {
                pStatement.setNull(6, java.sql.Types.INTEGER);
            }

            int filasInsertadas = pStatement.executeUpdate();
            if (filasInsertadas > 0) {
                System.out.println("Empleado insertado: " + apellido);
            }
            pStatement.close();
        } catch (SQLException e) {
            System.out.println("Error al insertar EMPLE: " + e.getMessage());
        }
    }

    public void actualizarEmpleado(int idEmple, String nuevoApellido, String nuevoOficio,
            double nuevoSalario, Integer nuevoIdJefe) {
        try {
            String sql = "UPDATE EMPLE SET APELLIDO = ?, OFICIO = ?, SALARIO = ?, JEFE_ID = ? "
                       + "WHERE EMP_NO = ?";
            PreparedStatement pStatement = conexion.prepareStatement(sql);
            pStatement.setString(1, nuevoApellido);
            pStatement.setString(2, nuevoOficio);
            pStatement.setDouble(3, nuevoSalario);
            if (nuevoIdJefe != null) {
                pStatement.setInt(4, nuevoIdJefe);
            } else {
                pStatement.setNull(4, java.sql.Types.INTEGER);
            }
            pStatement.setInt(5, idEmple);

            int filasActualizadas = pStatement.executeUpdate();
            if (filasActualizadas > 0) {
                System.out.println("Empleado actualizado: " + nuevoApellido);
            } else {
                System.out.println("No se encontró EMPLE con ID: " + idEmple);
            }
            pStatement.close();
        } catch (SQLException e) {
            System.out.println("Error al actualizar EMPLE: " + e.getMessage());
        }
    }

    public void eliminarEmpleado(int idEmple) {
        try {
            // Verificar si tiene subordinados (otros empleados con este como jefe)
            String verificarSQL = "SELECT COUNT(*) as cantidad FROM EMPLE WHERE JEFE_ID = ?";
            PreparedStatement pStatmentVer = conexion.prepareStatement(verificarSQL);
            pStatmentVer.setInt(1, idEmple);
            ResultSet rs = pStatmentVer.executeQuery();
            rs.next();
            int cantidad = rs.getInt("cantidad");

            if (cantidad > 0) {
                System.out.println("No se puede eliminar: tiene " + cantidad + " subordinados");
                rs.close();
                pStatmentVer.close();
                return;
            }

            String apellido = obtenerApellidoEmpleado(idEmple);

            String sql = "DELETE FROM EMPLE WHERE EMP_NO = ?";
            PreparedStatement pStatement = conexion.prepareStatement(sql);
            pStatement.setInt(1, idEmple);

            int filasEliminadas = pStatement.executeUpdate();
            if (filasEliminadas > 0) {
                System.out.println("Empleado eliminado: " + apellido);
            } else {
                System.out.println("No se encontró EMPLE con ID: " + idEmple);
            }

            rs.close();
            pStatmentVer.close();
            pStatement.close();
        } catch (SQLException e) {
            System.out.println("Error al eliminar EMPLE: " + e.getMessage());
        }
    }

    // ─── UTILIDADES ───────────────────────────────────────────────────────────

    public boolean existeEmpleado(int idEmple) {
        try {
            String sql = "SELECT COUNT(*) as cantidad FROM EMPLE WHERE EMP_NO = ?";
            PreparedStatement pStatement = conexion.prepareStatement(sql);
            pStatement.setInt(1, idEmple);
            ResultSet rs = pStatement.executeQuery();
            rs.next();
            int cantidad = rs.getInt("cantidad");
            rs.close();
            pStatement.close();
            return cantidad > 0;
        } catch (SQLException e) {
            System.out.println("Error al validar EMPLE: " + e.getMessage());
            return false;
        }
    }

    public boolean existeDepartamento(int idDepart) {
        try {
            String sql = "SELECT COUNT(*) as cantidad FROM DEPART WHERE DEPT_NO = ?";
            PreparedStatement pStatement = conexion.prepareStatement(sql);
            pStatement.setInt(1, idDepart);
            ResultSet rs = pStatement.executeQuery();
            rs.next();
            int cantidad = rs.getInt("cantidad");
            rs.close();
            pStatement.close();
            return cantidad > 0;
        } catch (SQLException e) {
            System.out.println("Error al validar DEPART: " + e.getMessage());
            return false;
        }
    }

    public String obtenerNombreDepartamento(int idDepart) {
        try {
            String sql = "SELECT DNOMBRE FROM DEPART WHERE DEPT_NO = ?";
            PreparedStatement pStatement = conexion.prepareStatement(sql);
            pStatement.setInt(1, idDepart);
            ResultSet rs = pStatement.executeQuery();
            if (rs.next()) {
                String nombre = rs.getString("DNOMBRE");
                rs.close();
                pStatement.close();
                return nombre;
            }
            rs.close();
            pStatement.close();
            return null;
        } catch (SQLException e) {
            System.out.println("Error al obtener nombre de DEPART: " + e.getMessage());
            return null;
        }
    }

    public String obtenerApellidoEmpleado(int idEmple) {
        try {
            String sql = "SELECT APELLIDO FROM EMPLE WHERE EMP_NO = ?";
            PreparedStatement pStatement = conexion.prepareStatement(sql);
            pStatement.setInt(1, idEmple);
            ResultSet rs = pStatement.executeQuery();
            if (rs.next()) {
                String apellido = rs.getString("APELLIDO");
                rs.close();
                pStatement.close();
                return apellido;
            }
            rs.close();
            pStatement.close();
            return null;
        } catch (SQLException e) {
            System.out.println("Error al obtener APELLIDO de EMPLE: " + e.getMessage());
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