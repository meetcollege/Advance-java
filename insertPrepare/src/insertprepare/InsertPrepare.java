/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insertprepare;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
/**
 *
 * @author Administrator
 */
public class InsertPrepare {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String url = "jdbc:mysql://localhost:3309/firstp";
        String user = "root";
        String password = "";
        
        Connection con =null;
        PreparedStatement pstmt = null;
        Scanner sc = new Scanner(System.in);
        
        try{
            
            System.out.println()
            
        }
        catch(Exception e){
            
        }
    }
    
}
