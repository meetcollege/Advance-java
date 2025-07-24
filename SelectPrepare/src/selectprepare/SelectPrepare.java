/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selectprepare;
import java.sql.*;
import java.util.Scanner;
/**
 *
 * @author ex604_8
 */
public class SelectPrepare {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3309/firstp", "root", "");
            System.out.println("Connection established");
            
            String selectQuery = "select * from emp where id=?";
            
            Scanner sc= new Scanner(System.in);
            
            System.out.print("Enter Id: ");
            int idl = sc.nextInt();
            
            PreparedStatement ps = con.prepareStatement(selectQuery);
            ps.setInt(1, idl);
            
            ResultSet rs = ps.executeQuery();
            
            rs.next();
            System.out.println("Id = " + rs.getInt(1));
            System.out.println("Name = " + rs.getString(2));
            System.out.println("Dept = " + rs.getString(3));
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
}
