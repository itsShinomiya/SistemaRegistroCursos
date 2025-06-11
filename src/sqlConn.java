import java.sql.*;
import java.util.Properties;

public class sqlConn {
    String url = "jdbc:postgresql://ep-green-thunder-a85vly69-pooler.eastus2.azure.neon.tech/cursos?user=neondb_owner&password=npg_z7gNFDP5lJim&sslmode=require";
    Connection conn;

    public sqlConn() {
        try {
        conn = DriverManager.getConnection(url);
        System.out.println("Connected to the database successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return this.conn;
    }

    public void close() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
                System.out.println("Conexão com o banco de dados fechada.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
