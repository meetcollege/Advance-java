/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employee;
import static java.lang.System.out;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class EmployeeDao {
    
    public static Connection getConnection(){
        Connection con=null;
        try{
             Class.forName("com.mysql.cj.jdbc.Driver");
             con=DriverManager.getConnection("jdbc:mysql://localhost:3309/empdetails","root","");
                    
        }catch(Exception e){
           System.out.println(e.getMessage());
        }
        return con;
    }
    
    public static int save(employee e){
         int status=0;
         
         try{
             Connection con=EmployeeDao.getConnection();
             String query="insert into emp(name,password,email,country) values(?,?,?,?)";
              PreparedStatement ps=con.prepareStatement(query);
              ps.setString(1, e.getName()); // e. name first catch
               ps.setString(2, e.getPassword());
                ps.setString(3, e.getEmail());
                 ps.setString(4, e.getCountry());
               status =ps.executeUpdate();
                con.close();
         
         }catch(Exception ex){ ex.printStackTrace();  }
        return status ;
    }
    
    public static List<employee> getAllEmployee(){
       List<employee> list=new ArrayList<employee>();
        try{
            Connection con=EmployeeDao.getConnection();
            String Selectquery="SELECT * from emp";
            PreparedStatement ps=con.prepareStatement(Selectquery);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                 employee e=new employee();
                 e.setId(rs.getInt(1));
                 e.setName(rs.getString(2));
                 e.setPassword(rs.getString(3));
                 e.setEmail(rs.getString(4));
                 e.setCountry(rs.getString(5));
                 list.add(e);    
            }
    
        }catch(Exception ex) {ex.printStackTrace();}
                return list;
    }
    
    public static int delete(int id)
    {       int status=0;
         try{
            Connection con=EmployeeDao.getConnection();
            String query="delete from emp where id=?";
            PreparedStatement ps=con.prepareStatement(query);
          ps.setInt(1,id);
          status=ps.executeUpdate();
              
               
        }catch(Exception ex) {ex.printStackTrace();}
                return status;
        
    }
    
    
    
}




// employee folder -> create java class -> EmployeeDao