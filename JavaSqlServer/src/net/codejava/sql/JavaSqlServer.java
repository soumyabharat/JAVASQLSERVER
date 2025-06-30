package net.codejava.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JavaSqlServer {

    public static void main(String[] args) {
        String url = "jdbc:sqlserver://BHARAT;databaseName=DB1;encrypt=true;trustServerCertificate=true";
        String user = "sa";
        String password = "Soumya@123";

        Connection connection = null;
        Statement statement = null;

        try {
            connection = DriverManager.getConnection(url, user, password);
            String sql = "INSERT INTO tb4 (Name, Age) VALUES ('Supriya', .25)";
            statement = connection.createStatement();

            int rows = statement.executeUpdate(sql);
            if (rows > 0) {
                System.out.println("✅ Row inserted successfully!");
            }
        } catch (SQLException e) {
            System.out.println("❌ Connection or insertion failed:");
            e.printStackTrace();
        } finally {
            // Close resources in reverse order of creation
            try {
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException ex) {
                System.err.println("⚠️ Failed to close resources:");
                ex.printStackTrace();
            }
        }
    }
}