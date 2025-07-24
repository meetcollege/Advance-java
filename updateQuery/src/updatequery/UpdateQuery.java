/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package updatequery;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.Scanner;
/**
 *
 * @author Administrator
 */
public class UpdateQuery {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        String url = "jdbc:mysql://localhost:3309/firstp";
        String user = "root";
        String password = "";
        
        String sql = "select name,dept from emp";
        
        try(Connection con = DriverManager.getConnection(url,user,password);
                Statement stmt = con.createStatement()){
            
            boolean hasResultSet = stmt.execute(sql);
            int resultSetCount = 0;
            
            do{
                if(hasResultSet){
                    ResultSet rs = stmt.getResultSet();
                    resultSetCount++;
                    System.out.println("ResultSet #"+resultSetCount+":");
                    while(rs.next()){
                        System.out.println("Name = "+rs.getString("name"));
                        System.out.println("Department = "+rs.getString("dept"));
                    }
                    rs.close();
                } else{
                    int updateCount = stmt.getUpdateCount();
                    if(updateCount==-1){
                        break;
                    }
                    System.out.println("Update count: "+updateCount);
                }
                hasResultSet = stmt.getMoreResults();
            }while(true);
            
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }

        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
    
}
