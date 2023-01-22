
package servlet;


import bean.Libro;
import conexion.Conexion;
import dao.LibroDAO2;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.catalina.connector.CoyoteWriter;

@WebServlet(name = "ListarLibro", urlPatterns = {"/ListarLibro"})
public class ListarLibro extends HttpServlet {

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
            out.println("<title>Servlet LibroControl</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LibroControl at " + request.getContextPath() + "</h1>");
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
        
        out.print("<tr id='primtabla'>");
        out.print("<th class='thvis'>" + "Título del Libro" + "</th>");
        out.print("<th class='thvis'>" + "Categoría" + "</th>");
        out.print("<th class='thvis'>" + "Autor" + "</th>");
        out.print("<th class='thvis'>" + "Editorial" + "</th>");
        out.print("<th class='thvis'>" + "ISBN" + "</th>");       
        out.print("</tr>");
        
        String buscador1 = request.getParameter("nombre");
        String buscador2 = request.getParameter("nombre2");
        
        LibroDAO2 lidao = new LibroDAO2();
               
        if(buscador1 != null){  
            for(Libro lib:lidao.LibroBusquedaTitulo(buscador1)){
                out.print("<tr>");
                out.print("<th class='tabofi2'>" + lib.getLibro_titulo() + "</th>");
                out.print("<th class='tabofi2'>" + lib.getCategoria_name() + "</th>");
                out.print("<th class='tabofi2'>" + lib.getAutor_name() + "</th>");
                out.print("<th class='tabofi2'>" + lib.getEdicion()+ "</th>");
                out.print("<th class='tabofi2'>" + lib.getIsbn() + "</th>");
                out.print("</tr>");
            }       
        }else{
            for(Libro lib:lidao.LibroBusquedaAutor(buscador2)){
                out.print("<tr>");
                out.print("<th class='tabofi2'>" + lib.getLibro_titulo() + "</th>");
                out.print("<th class='tabofi2'>" + lib.getCategoria_name() + "</th>");
                out.print("<th class='tabofi2'>" + lib.getAutor_name() + "</th>");
                out.print("<th class='tabofi2'>" + lib.getEdicion() + "</th>");
                out.print("<th class='tabofi2'>" + lib.getIsbn() + "</th>");
                out.print("</tr>");
            }   
        }
        
        
        
        
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
                //processRequest(request, response);
               String buscador= request.getParameter("nombre");
                Op op = new Op();
                ResultSet rs= op.getDatos("SELECT * FROM libros WHERE libro_titulo LIKE'%"+buscador+"%'");
                while (rs.next()) {
                    out.print("<tr>");
                    out.print("<th class='tabofi2'>" + rs.getString("libro_titulo") + "</th>");
                    out.print("<th class='tabofi2'>" + rs.getString("categoria_name") + "</th>");
                    out.print("<th class='tabofi2'>" + rs.getString("autor_name") + "</th>");
                    out.print("<th class='tabofi2'>" + rs.getString("editor_name") + "</th>");
                    out.print("<th class='tabofi2'>" + rs.getString("isbn") + "</th>");
                    out.print("</tr>");
 
                }
                    Conexion cnx = new Conexion();
                    cnx.closeConexion();
                    rs.close();
                } catch (SQLException ex) {
                out.println("<label class='error'> " + ex.getMessage()+  "</label>");
                }  
        }
       */
       
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
 

}
