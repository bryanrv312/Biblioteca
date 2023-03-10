/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import bean.Categoria;
import conexion.Conexion;
import dao.CategoriaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ListaCat extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    Conexion cnx = new Conexion();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ListaCat</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ListaCat at " + request.getContextPath() + "</h1>");
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
        response.setContentType("text/html;charset=UTF-8");  
         
        PrintWriter out = response.getWriter();
        
        out.print("<tr>");
        out.print("<th class='thvis'>" + "Categor??a" + "</th>");
        out.print("<th class='thvis'>" + "Descripci??n" + "</th>");   
        out.print("</tr>");
        
        String buscador = request.getParameter("nombre");
        
        CategoriaDAO cadao = new CategoriaDAO();
        
        for(Categoria cat:cadao.CategoriaBusqueda(buscador)){
            out.print("<tr>");
            out.print("<th class='tabofi2'>" + cat.getCategory_name() + "</th>");
            out.print("<th class='tabofi2'>" + cat.getProfile() + "</th>");
            out.print("</tr>");
        }
            
                  
        
/*      try (PrintWriter out = response.getWriter()) {
                    out.print("<tr>");
                    out.print("<th class='thvis'>" + "Categor??a" + "</th>");
                    out.print("<th class='thvis'>" + "Descripci??n" + "</th>");   
                    out.print("</tr>");
                try {
                //processRequest(request, response);
                String buscador= request.getParameter("nombre");
                Op op = new Op();
                ResultSet rs= op.getDatos("SELECT * FROM categoria WHERE category_name LIKE'%"+buscador+"%'");
                while (rs.next()) {
                    out.print("<tr>");
                    out.print("<th class='tabofi2'>" + rs.getString("category_name") + "</th>");
                    out.print("<th class='tabofi2'>" + rs.getString("profile") + "</th>");
                    out.print("</tr>");
 
                }
                    Conexion cnx = new Conexion();
                    cnx.closeConexion();
                    rs.close();
                } catch (SQLException ex) {
                out.println("<label class='error'> " + ex.getMessage()+  "</label>");
                }  
        }*/

        

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
