package com.example.BirdSightingSystem.DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    static Connection connection = null;
    public static String jdbcURL = "jdbc:mysql://127.0.0.1:3306/mydb";

        public static Connection getConnection() {
            String username = "root";
            String password = "root";

            try {
                // Load MySQL JDBC Driver (optional in modern versions)
                Class.forName("com.mysql.cj.jdbc.Driver");

                // Establish Connection
                connection = DriverManager.getConnection(jdbcURL, username, password);
                System.out.println("Connected to MySQL database!");

            } catch (ClassNotFoundException e) {
                System.out.println("MySQL JDBC driver not found.");
                e.printStackTrace();
            } catch (SQLException e) {
                System.out.println("Connection failed.");
                e.printStackTrace();
            }
            return connection;
        }

        public static void releaseConnection(){
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Error in closing connection");
                throw new RuntimeException(e);
            }
        }
    }
