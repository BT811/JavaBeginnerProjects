package com.EducationProject.Helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
    private Connection connection = null;
    public Connection connectionDB(){
        try {
            this.connection = DriverManager.getConnection(Config.DB_URL,Config.DB_USER,Config.DB_PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return this.connection;
    }

    public static Connection getInstance(){
        DBConnector db = new DBConnector();
        return  db.connectionDB();
    }
}
