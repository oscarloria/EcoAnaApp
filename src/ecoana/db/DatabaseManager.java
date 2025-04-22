
package ecoana.db;

import ecoana.model.SolicitudReserva;
import ecoana.model.Cliente;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types; // Para manejar posibles nulos



public class DatabaseManager {
    
    private static final String DB_URL = "jdbc:ucanaccess://C:/ECOANA/EcoAnaApp/EcoAnaDB.accdb";
    
    // Método para guardar la solicitud
    public boolean guardarSolicitud(SolicitudReserva solicitud) {
        // SQL con nombres de columna exactos de la tabla Access
        String sql = "INSERT INTO SolicitudesReserva (NombreCliente, PrimerApellido, SegundoApellido, " +
                     "CedulaID, Telefono, CorreoElectronico, FechaNacimiento, FechaIngreso, FechaSalida, " +
                     "CantidadPersonas, TipoPago, TerminosAceptados, EstadoSolicitud, FechaSolicitud) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"; // 14 parámetros

        // Usamos try-with-resources para asegurar que la conexión se cierre
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            Cliente cliente = solicitud.getCliente(); // Obtenemos el cliente de la solicitud

            // Asignamos valores a los parámetros (?)
            pstmt.setString(1, cliente.getNombre());
            pstmt.setString(2, cliente.getPrimerApellido());
            pstmt.setString(3, cliente.getSegundoApellido());
            pstmt.setString(4, cliente.getCedula());
            pstmt.setString(5, cliente.getTelefono());
            pstmt.setString(6, cliente.getCorreo());

            // Convertir java.util.Date a java.sql.Date para JDBC
            if (cliente.getFechaNacimiento() != null) {
                pstmt.setDate(7, new java.sql.Date(cliente.getFechaNacimiento().getTime()));
            } else {
                pstmt.setNull(7, Types.DATE); // Permitir nulo si es posible
            }

            if (solicitud.getFechaIngreso() != null) {
                 pstmt.setDate(8, new java.sql.Date(solicitud.getFechaIngreso().getTime()));
            } else {
                 pstmt.setNull(8, Types.DATE); // Manejar nulo si es necesario
            }
             if (solicitud.getFechaSalida() != null) {
                 pstmt.setDate(9, new java.sql.Date(solicitud.getFechaSalida().getTime()));
             } else {
                 pstmt.setNull(9, Types.DATE); // Manejar nulo si es necesario
             }

            pstmt.setInt(10, solicitud.getCantidadPersonas());
            pstmt.setString(11, solicitud.getTipoPago());
            pstmt.setBoolean(12, solicitud.isTerminosAceptados());
            pstmt.setString(13, "Pendiente"); // Valor predeterminado para el estado
            pstmt.setTimestamp(14, new java.sql.Timestamp(new java.util.Date().getTime())); // Fecha/hora actual para FechaSolicitud

            // Ejecutar la inserción
            int affectedRows = pstmt.executeUpdate();

            return affectedRows > 0; // Verdadero si se insertó al menos 1 fila

        } catch (SQLException e) {
            // Imprimir el error en la consola es útil para depurar
            System.err.println("Error al guardar en la base de datos: " + e.getMessage());
            e.printStackTrace(); // Muestra más detalles del error
            return false; // Falso si hubo un error
        }
    }
}
