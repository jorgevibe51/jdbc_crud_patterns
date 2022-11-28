/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdbc_crud_pattern.config;

import java.sql.*;

/**
 *
 * @author Jorge
 */
public class DBManager {

    //private static Connection connection = null;
    private static DBManager instance;
    
    private DBManager(){
    }
    
    //singleton
    public static DBManager getInstance(){
        if (instance == null)
            instance = new DBManager();
        return instance;
    }

    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost/fiap";
            String username = "root";
            String password = "root";
            connection = DriverManager.getConnection(url, username, password);

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();

        }
        return connection;
    }
}
