/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import bean.Estudiante;
import dao.EstudianteDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


    @WebServlet(name = "ListaTotal", urlPatterns = {"/ListaTotal"})
    
public class ListaTotal extends HttpServlet {

        
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        
        PrintWriter out = response.getWriter();
        
        out.print("<tr id='primtabla'>");
        out.print("<th class='thvis'>" + "ID" + "</th>");    
        out.print("<th class='thvis'>" + "Nombre" + "</th>");    
        out.print("<th class='thvis'>" + "Apellido" + "</th>");    
        out.print("<th class='thvis'>" + "Nivel" + "</th>");    
        out.print("<th class='thvis'>" + "Grado" + "</th>");    
        out.print("<th class='thvis'>" + "Sección" + "</th>");    
        out.print("<th class='thvis'>" + "Nombre del Libro" + "</th>");    
        out.print("<th class='thvis'>" + "Préstamo" + "</th>");    
        out.print("<th class='thvis'>" + "Estado" + "</th>");    
        out.print("<th class='thvis'>" + "Acción" + "</th>");    
        out.print("</tr>");
        
        
        String busqueda = request.getParameter("search");
        EstudianteDAO edao = new EstudianteDAO();
        
        for(Estudiante e:edao.EstudianteBusquedaApellido(busqueda)){
            response.setContentType("text/html;charset=UTF-8");
            out.print("<tr>");
            out.print("<th class='tabofi2'>" + e.getStudent_id() + "</th>");
            out.print("<th class='tabofi2'>" + e.getStudent_name() + "</th>");
            out.print("<th class='tabofi2'>" + e.getStudent_app() + "</th>");
            out.print("<th class='tabofi2'>" + e.getNivel() + "</th>");
            out.print("<th class='tabofi2'>" + e.getGrado() + "</th>");
            out.print("<th class='tabofi2'>" + e.getSeccion() + "</th>");
            out.print("<th class='tabofi2'>" + e.getBook_name() + "</th>");
            out.print("<th class='tabofi2'>" + e.getTprest() + "</th>");
            out.print("<th class='tabofi2'>" + e.getEstado() + "</th>");
            out.print("<th class='tabofi2'>" +"<a id='btnA' href='editar.jsp?cod=<%=lir.getStudent_id()%>'>Modificar</a>"+"||"+
                                              "<a id='btnA' href='editar.jsp?cod=<%=lir.getStudent_id()%>'>Eliminar</a>"+
                                              "</th>");
            out.print("</tr>");
        }
        
        
 /*
        try (PrintWriter out = response.getWriter()) {
                  out.print("<tr id='primtabla'>");
                  out.print("<th class='thvis'>" + "ID" + "</th>");    
                  out.print("<th class='thvis'>" + "Nombre" + "</th>");    
                  out.print("<th class='thvis'>" + "Apellido" + "</th>");    
                  out.print("<th class='thvis'>" + "Nivel" + "</th>");    
                  out.print("<th class='thvis'>" + "Grado" + "</th>");    
                  out.print("<th class='thvis'>" + "Sección" + "</th>");    
                  out.print("<th class='thvis'>" + "Nombre del Libro" + "</th>");    
                  out.print("<th class='thvis'>" + "Préstamo" + "</th>");    
                  out.print("<th class='thvis'>" + "Estado" + "</th>");    
                  out.print("<th class='thvis'>" + "Acción" + "</th>");    
                     
                    out.print("</tr>");
     
                try {
                String buscador2= request.getParameter("search");
                Op opx = new Op();
                    ResultSet rs1=null;
                 rs1= opx.getDatos2("SELECT * FROM estudiantes WHERE student_app LIKE'%"+buscador2+"%'");

                while (rs1.next()) {
                    response.setContentType("text/html;charset=UTF-8");
                    out.print("<tr>");
                    out.print("<th class='tabofi2'>" + rs1.getString("student_id") + "</th>");
                    out.print("<th class='tabofi2'>" + rs1.getString("student_name") + "</th>");
                    out.print("<th class='tabofi2'>" + rs1.getString("student_app") + "</th>");
                    out.print("<th class='tabofi2'>" + rs1.getString("nivel") + "</th>");
                    out.print("<th class='tabofi2'>" + rs1.getString("grado") + "</th>");
                    out.print("<th class='tabofi2'>" + rs1.getString("seccion") + "</th>");
                    out.print("<th class='tabofi2'>" + rs1.getString("book_name") + "</th>");
                    out.print("<th class='tabofi2'>" + rs1.getString("tprest") + "</th>");
                    out.print("<th class='tabofi2'>" + rs1.getString("estado") + "</th>");
                    out.print("<th class='tabofi2'>" +"<a id='btnA' href='editar.jsp?cod=<%=lir.getStudent_id()%>'>Editar</a>"+"</th>");
                    out.print("</tr>");
 
                }
                rs1.close();
                } catch (SQLException ex) {
                out.println("<label class='error'> " + ex.getMessage()+  "</label>");
                }  
        }
        */
    }

    
  

}
