
package servlet;

import conexion.Conexion;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "BLXAutor", urlPatterns = {"/BLXAutor"})
public class BLXAutor extends HttpServlet {


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
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                response.setContentType("text/html;charset=UTF-8");
      /*
                try (PrintWriter out = response.getWriter()) {
                    out.print("<tr id='primtabla'>");
                    out.print("<th class='thvis'>" + "Título del Libro" + "</th>");
                    out.print("<th class='thvis'>" + "Categoría" + "</th>");
                    out.print("<th class='thvis'>" + "Autor" + "</th>");
                    out.print("<th class='thvis'>" + "Editorial" + "</th>");
                    out.print("<th class='thvis'>" + "ISBN" + "</th>");       
                    out.print("</tr>");
                try {
                
               String buscador= request.getParameter("nombre2");
                Op op2 = new Op();
                ResultSet rs= op2.getDatos("SELECT * FROM libros WHERE autor_name LIKE'%"+buscador+"%'");
                while (rs.next()) {
                    out.print("<tr>");
                    out.print("<th class='tabofi2'>" + rs.getString("libro_titulo") + "</th>");
                    out.print("<th class='tabofi2'>" + rs.getString("categoria_name") + "</th>");
                    out.print("<th class='tabofi2'>" + rs.getString("autor_name") + "</th>");
                    out.print("<th class='tabofi2'>" + rs.getString("editor_name") + "</th>");
                    out.print("<th class='tabofi2'>" + rs.getString("isbn") + "</th>");
                    out.print("</tr>");
 */
                }
                   /* Conexion cnx = new Conexion();
                    cnx.closeConexion();
                    rs.close();*/
           /*     } catch (SQLException ex) {
                out.println("<label class='error'> " + ex.getMessage()+  "</label>");
                }  
        }
       
        
        
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
