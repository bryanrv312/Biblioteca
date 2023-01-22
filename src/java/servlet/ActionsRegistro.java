
package servlet;

import dao.EstudianteDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ActionsRegistro extends HttpServlet {

    
    

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        
        String action = request.getParameter("accion");
        PrintWriter out = response.getWriter();
        String id = request.getParameter("cod");
        String estado = request.getParameter("estado");
        
        EstudianteDAO edao = new EstudianteDAO();
        
        if(action.equalsIgnoreCase("eliminar")){
            if(edao.EliminarRegistro(id)){
                request.setAttribute("msj", "ELIMINACION CORRECTA");
                response.sendRedirect("jsp/registro/registro.jsp");
                //out.print("<span>SI SE ELIMINO</span>");               
            }else{
                request.setAttribute("msj", "ELIMINACION INCORRECTA");
                response.sendRedirect("jsp/registro/registro.jsp");
            }
            
        }else if(action.equalsIgnoreCase("modificar")){
            if(edao.ModificarRegistro(estado,id)){
                request.setAttribute("msj", "ACTUALIZACION CORRECTA");
                response.sendRedirect("jsp/registro/registro.jsp");
            }
        }
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    
    }

}
