/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import bean.Autor;
import dao.AutorDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


    @WebServlet(name = "Lautor", urlPatterns = {"/Lautor"})
    
public class Lautor extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        PrintWriter out = response.getWriter();

        out.print("<tr id='primtabla'>");
        out.print("<th class='thvis'>" + "ID" + "</th>"); 
        out.print("<th class='thvis'>" + "Autor" + "</th>");    
        out.print("<th class='thvis'>" + "Perfil" + "</th>");    
        out.print("<th class='thvis'>" + "Añadido el: " + "</th>");    
        out.print("</tr>");

        String buscador2= request.getParameter("nombre");

        AutorDAO autdao = new AutorDAO();

        for(Autor aut : autdao.AutorBusqueda(buscador2)){
            out.print("<tr>");
            out.print("<th class='tabofi2'>" + aut.getSl_no() + "</th>");
            out.print("<th class='tabofi2'>" + aut.getAutor_name() + "</th>");
            out.print("<th class='tabofi2'>" + aut.getPerfil() + "</th>");
            out.print("<th class='tabofi2'>" + aut.getAdded_on() + "</th>");
            out.print("</tr>");
        }            
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {  
    
           
try (PrintWriter out = response.getWriter()) {
    /* out.print("<tr id='primtabla'>");
                    out.print("<th class='thvis'> </th>");
                    out.print("<th class='thvis'> </th>");      
                    out.print("</tr>");*/
     
                try {
                //processRequest(request, response);
                String buscador2= request.getParameter("n");
                Op op = new Op();
                /*ResultSet rsz = opx.getDatos("SELECT * FROM autor WHERE autor_name LIKE'%"+buscador+"%'");*/
                    ResultSet rs= op.getDatos2("SELECT * FROM autor WHERE autor_name LIKE'%"+buscador2+"%'");
             
               out.print( rs.getString("autor_name"));
                while (rs.next()) {
                    out.print( rs.getString("autor_name"));
                    out.print("<tr>");
                    out.print("<th class='tabofi2'>" + rs.getString("autor_name") + "</th>");
                    out.print("<th class='tabofi2'>" + rs.getString("perfil") + "</th>");
                    out.print("</tr>");
 
                }
                } catch (SQLException ex) {
                out.println("<label class='error'> " + ex.getMessage()+  "</label>");
                }  
        }
    }

    
}
