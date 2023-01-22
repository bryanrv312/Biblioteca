/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.CategoriaDAO;
import dao.EstudianteDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AddEstudiante extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        PrintWriter out = response.getWriter();
         

            String student_name=request.getParameter("student_name");
            String student_app=request.getParameter("student_app");
            String nivel=request.getParameter("seccion");
            String grado=request.getParameter("grade");
            String seccion=request.getParameter("section");
            String book_name=request.getParameter("book_name");
            String tprest=request.getParameter("tprest");
            String estado=request.getParameter("estado");
            
            String msg="Categoría agregada con éxito";
            
            EstudianteDAO est=new EstudianteDAO();
            
            if(est.addestu(student_name, student_app, nivel, grado, seccion, book_name, tprest,estado)){
            response.sendRedirect("jsp/estudiante/addestu.jsp");
            }
            else{
            response.sendRedirect("jsp/estudiante/addestu.jsp");
            }
    }

    
}
