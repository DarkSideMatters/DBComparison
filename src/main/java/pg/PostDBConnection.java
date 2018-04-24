/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author darkSideMatters
 */
public class PostDBConnection {
    
    private static Connection con;
    private static String url = "jdbc:postgresql://127.0.0.1:5432";
    private static String username = "appdev";
    private static String password = "";

    public static Connection getConnection() {
        if (con == null) {
            try {
                Class.forName("org.postgresql.Driver");
                con = DriverManager.getConnection(url, username, password);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(PostDBConnection.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(PostDBConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        return con;
    }

    public static void closeConnection() {
        try {
            con.close();
            con = null;
        } catch (SQLException ex) {
            Logger.getLogger(PostDBConnection.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
}
