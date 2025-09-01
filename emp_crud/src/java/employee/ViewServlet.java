/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employee;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrator
 */
@WebServlet(name = "ViewServlet", urlPatterns = {"/ViewServlet"})
public class ViewServlet extends HttpServlet {

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
            out.println("<title>Servlet ViewServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ViewServlet at " + request.getContextPath() + "</h1>");
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
       response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        List<employee> list = EmployeeDao.getAllEmployee();  // EmployeeDao or ViewServlet 
      out.print("<table border='1' width='100%' >");
        out.print("<tr> "
                + "<th> Id </th> <th> Name </th>  <th> Password </th> <th> Email </th> <th> Country </th> <th> Edite </th> <th> Delete </th> "
                + "</tr> ");
        for(employee e:list){
            out.print("<tr>");
              out.print("<td>"+e.getId()+"</td>");
            
//            out.print(e.getId()+"</td><td>");
//            out.print(e.getName()+"</td><td>");
//            out.print(e.getPassword()+"</td><td>");
//            out.print(e.getEmail()+"</td><td>");
//            out.print(e.getCountry()+"</td><td>");
//            out.print( "<a href='EditServlet?id="+e.getId()+"'>Edit</a></td><td>");
//            out.print( "<a href='DeleteServlet?id="+e.getId()+"'>Delete</a></td>");
            
            out.print("</tr>");
        }
        out.print("</table>");
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
           
    //  action-dopost
    // link - doget
        
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

