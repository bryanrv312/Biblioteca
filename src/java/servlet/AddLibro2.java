/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.LibroDAO2;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "AddLibro2", urlPatterns = {"/AddLibro2"})

public class AddLibro2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {    
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        PrintWriter out = response.getWriter();
         
         String titulo = request.getParameter("book_title");
            String categoria = request.getParameter("category_name");
            String autor = request.getParameter("autor");
            String editorial = request.getParameter("editorial");
            String edicion = request.getParameter("edicion");
            String volumen = request.getParameter("volumen");
            String isbn = request.getParameter("isbn");
            String precio = request.getParameter("precio");
            String idioma = request.getParameter("idioma");
            String descripcion = request.getParameter("descrip");
            
            LibroDAO2 lb=new LibroDAO2();
            
            if(lb.agregar(titulo, categoria, autor, editorial, edicion, volumen, isbn, precio, idioma, descripcion)){
            response.sendRedirect("jsp/libros/addlibro.jsp");
            }
            else{
            response.sendRedirect("jsp/libros/addlibro.jsp");
            }
        
        
    }

   

}
