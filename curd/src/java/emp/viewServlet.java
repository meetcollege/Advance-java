/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrator
 */
public class viewServlet extends HttpServlet {

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
            out.println("<title>Servlet viewServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet viewServlet at " + request.getContextPath() + "</h1>");
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
       // processRequest(request, response);
    
    
    response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        List<employee> list=employeeDao.getAllEmployee();
        
        out.print("<table border='1' width='100% '>");
        out.print("<tr><td>id</td><td>Name</td><td>password</td><td>email</td><td>EDIT</td><td>DELETE</td></tr>");

         for(employee e:list)
         {
             out.print("<tr><td>");
             out.print(e.getId()+"</td><td>");
             out.print(e.getName()+"</td><td>");
             out.print(e.getPassword()+"</td><td>");
             out.print(e.getEmail()+"</td><td></tr>");
             out.print("<a href='EditServlet?id="+e.getId()+"'>Edit</a></td><td>");
                   
                     
             out.print("<a href='deletServlet?id="+e.getId()+"'>Delete</a></td>");
                     out.print("</tr>");
                     
         }
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
       // processRequest(request, response);
   
           
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
