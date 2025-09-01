/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emp;
import java.sql.*;
import java.util.*;
/**
 *
 * @author ex604_8
 */
public class employeeDao {

    static List<employee> getAllEmployees;
    public static Connection getConnection(){
        Connection con = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
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
    
    /**
     *
     */
    public static List<employee> getAllEmployee(){
       List<employee> list=new ArrayList<employee>();
        try{
            Connection con = employeeDao.getConnection();
            String sql = "select * from employee";
            
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
             employee e= new employee();
             e.setId(rs.getInt(1));
             e.setName(rs.getString(2));
             e.setEmail(rs.getString(3));
             e.setPassword(rs.getString(4));
             list.add(e);
            }
            
          
        }catch(Exception ex){
            ex.printStackTrace();
        }
          return list;
    }   
    
    public static int delete(int id) {
        int status=0;
        
        try {
            Connection con=employeeDao.getConnection();
            PreparedStatement ps=con.prepareStatement("delete from emp where id=?");
            ps.setInt(1, id);
            status=ps.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
    
}
