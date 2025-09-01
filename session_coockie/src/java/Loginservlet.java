/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ex604_8
 */
public class Loginservlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Loginservlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Loginservlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String user = request.getParameter("username");
        String password = request.getParameter("password");
        try{
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3309/emp","root","");
            //out.print("connected");
            
            PreparedStatement ps = con.prepareStatement("Select * from employee where name=? and password=?");
            ps.setString(1,user);
            ps.setString(2,password);
            
            ps.executeQuery();
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                
                out.print("<h2>Data match</h2>");
                HttpSession session = request.getSession();
                session.setAttribute("username",user);
                out.print("Session<br/>");
                out.print("<a href='ProfileServlet'>view profile</a>");
                
                Cookie c = new Cookie("username", user);
                c.getMaxAge(600);
                
                
            }else{
                
            }
            
        }catch(Exception e){
            out.print(e);
        }
    }
   
    
    
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
