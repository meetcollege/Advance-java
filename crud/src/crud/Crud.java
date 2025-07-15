/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author Administrator
 */
public class Crud {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // connection credentials
        String url = "jdbc:mysql://localhost:3309/firstp";
        String user = "root";
        String password = "";

        try {
            // driver loading
            Class.forName("com.mysql.cj.jdbc.Driver");

            // database connection
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement st = conn.createStatement();
            System.out.println("Database is connected");

            // switch case for different operation
            System.out.println("1. Insert\n2. Update\n3. Delete\n4. Retrive");
            System.out.print("Enter choice : ");
            int ch = sc.nextInt();

            String query = null;
            int id = 0;
            String name = null;
            String department = null;
            switch (ch) {
                case 1:
                    System.out.print("Enter emp id : ");
                    id = sc.nextInt();
                    System.out.print("Enter emp name : ");
                    name = sc.next();
                    System.out.print("ENter emp department : ");
                    department = sc.next();
                    query = "insert into emp (id,name,dept) values (" + id + ",'" + name + "','" + department + "')";
                    int rowsAffected = st.executeUpdate(query);
                    if (rowsAffected > 0) {
                        System.out.println("Employee inserted successfully");
                    }
                    break;
                case 2:
                    
                 
            }

        } catch (Exception e) {

        }
    }

}
