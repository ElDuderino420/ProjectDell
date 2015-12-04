package DataSource;

import java.sql.Connection;
import java.sql.DriverManager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author butwhole
 */
public class DatabaseCon {

    private static String driver = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/DellCampaigns";
    private static String user = "DellHost";
    private static String password = "pass1234";
    private Connection con;

    //-- Singleton ---- 
    private static DatabaseCon instance;

    
    // Singleton Database connection manager, creates a connection to the database
    private DatabaseCon() {
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);   // The connection will be released upon program 
            // termination by the garbage collector	
        } catch (Exception e) {
            System.out.println("\n*** Remember to insert your Oracle ID and PW in the DBConnector class! ***\n");
            System.out.println("error in DBConnector.getConnection()");
            System.out.println(e);
        }
    }

    
    // return the instance of the database connector
    public static DatabaseCon getInstance() {
        if (instance == null) {
            instance = new DatabaseCon();
        }
        return instance;
    }
    //------------------

    // getConnection returns the connection to the database
    public Connection getConnection() {
        return con;
    }
}
