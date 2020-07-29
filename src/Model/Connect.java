/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class Connect {
    private static Connection con = null;
    
    public static void close(){
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Connection getConnect() {
          try {
            String url = "jdbc:sqlserver://DESKTOP-7I9IDAI\\HIEU:55047;databaseName=DUANMAU";
            String user = "sa";
            String pass = "sa";
            con = DriverManager.getConnection(url, user, pass);
            return con;
        } catch (SQLException ex) {
            System.out.println("Kết nối database thất bại");
            ex.printStackTrace();
            return null;
        }
    }
}
