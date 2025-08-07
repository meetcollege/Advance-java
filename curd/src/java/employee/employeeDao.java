/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employee;
import java.sql.*;
import java.util.*;
/**
 *
 * @author ex604_8
 */
public class employeeDao {
    public static Connection getConnection(){
        Connection con = null;
        try{
            Class.forName("jdbc.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3309/emp","root","");
        }catch(Exception e){
            System.out.print(e);
        }
        return con;
    }
    
    public static int save(employee e){
        int status=0;
        try{
            Connection con = employeeDao.getConnection();
            String sqlInsert = "insert into employee (name,password,email,country) values (?, ?, ?, ?)";
            
            PreparedStatement ps = con.prepareStatement(sqlInsert);
            
            ps.setString(1, e.getName());
            ps.setString(2, e.getPassword());
            ps.setString(3, e.getEmail());
            ps.setString(4, e.getCountry());
            
            status = ps.executeUpdate();
            
            con.close();
                    
        }catch(Exception ex){
           
            ex.printStackTrace();
        }
        return status;
    }
    
}
