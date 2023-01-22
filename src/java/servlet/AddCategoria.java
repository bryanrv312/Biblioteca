/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.AutorDAO;
import dao.CategoriaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AddCategoria extends HttpServlet {

    
    

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {    
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
         

            String category_name = request.getParameter("category_name");
            String  profile= request.getParameter("profile");
            String added_on = request.getParameter("added_on");
            String msg="Categoría agregada con éxito";
            
            CategoriaDAO lb3=new CategoriaDAO();
            
            if(lb3.añcagetoria(category_name, profile, added_on)){
            response.sendRedirect("jsp/categoria/catvista.jsp");
            }
            else{
            response.sendRedirect("jsp/categoria/catvista.jsp");
            }
    }

    
    
}
