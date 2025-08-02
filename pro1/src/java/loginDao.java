/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrator
 */
import java.sql.*;
import javax.sql.*;


public class loginDao {
    public static boolean validate(String username, String password) {
        boolean status = false;
        String url = "jdbc:mysql://localhost:3309/firstp";
        String dbUser = "root";
        String dbPass = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection conn = DriverManager.getConnection(url, dbUser, dbPass);
                 PreparedStatement pst = conn.prepareStatement(
                   "SELECT * FROM login WHERE username = ? AND password = ?")) {

                pst.setString(1, username);
                pst.setString(2, password);

                try (ResultSet rs = pst.executeQuery()) {
                    status = rs.next();
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return status;
    }
}

