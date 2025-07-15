/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package first;
import java.sql.*;
import java.sql.DriverManager;

/**
 *
 * @author Administrator
 */
public class First {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3309/firstp","root","");
            System.out.println(con);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from emp");
            while(rs.next()){
                System.out.println("Id = "+rs.getInt("id")+", Name = "+rs.getString("name")+", Dept = "+rs.getString("dept"));
            }
        } 
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    }
    
}
