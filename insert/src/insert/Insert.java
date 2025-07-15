/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insert;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.Scanner;
/**
 *
 * @author Administrator
 */
public class Insert {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter emp id : ");
        int id = sc.nextInt();
        System.out.print("Enter emp name : ");
        String name = sc.next();
        System.out.print("ENter emp department : ");
        String department = sc.next();
        
        // database details
        String url = "jdbc:mysql://localhost:3309/firstp";
        String user = "root";
        String password = "";
          
        
        try{
            // load jdbc driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // connect to databse
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement st = conn.createStatement();
            System.out.println("Connected to database");
            
            // Static employee data
//            int id=6;
//            String name="Esha";
//            String department = "Marketing";
            
            // sql insertion query using static data
            String query = "INSERT INTO emp(id,name,dept) VALUES ("+id+",'"+name+"','"+department+"')";
            
            //execute the insert
            int rowsInserted = st.executeUpdate(query);
            if(rowsInserted>0){
                System.out.println("Employee inserted successfully");
            }
        }
        catch(Exception e){
               System.out.println(e.getMessage());
        }
    }
    
}
