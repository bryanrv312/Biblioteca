/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servletlogin;

import bean.AdminBean;
import consultas.login.loginsql;
import dao.AdminDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;




@WebServlet(name = "iniciosesion", urlPatterns = {"/iniciosesion"})
public class iniciosesion extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {   
    }
   
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession sesion = request.getSession();
           
        try {  
            
            String usuario = request.getParameter("un");
            String contraseña = request.getParameter("pw");
           

            loginsql ul = new loginsql();
            
            if(ul.validarUsuario(usuario, contraseña)){
                AdminDAO adao = new AdminDAO();
                AdminBean useradmin = adao.getUsuario(usuario, contraseña);
                sesion.setAttribute("useradmin", useradmin.getUser());
                response.sendRedirect("home.jsp");
            }else{
                sesion.setAttribute("msg", "Usuario y/o pawsword incorrecto...!");
                response.sendRedirect("login.jsp");  
            }
           
        } catch (IOException e) {
            System.out.println("Error en servlet iniciosesion" + e.getMessage());
        }
     
    }

    

}
