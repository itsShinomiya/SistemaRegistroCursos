import java.sql.*;
import java.util.Properties;

public class sqlConn {
    String url = "jdbc:postgresql://ep-green-thunder-a85vly69-pooler.eastus2.azure.neon.tech/neondb?user=neondb_owner&password=npg_z7gNFDP5lJim&sslmode=require";
    Connection conn;

    public sqlConn() {
        try {
        conn = DriverManager.getConnection(url);
        System.out.println("Connected to the database successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
