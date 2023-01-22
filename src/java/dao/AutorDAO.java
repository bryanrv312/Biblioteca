/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Autor;
import bean.Categoria;
import conexion.Conexion;
import static conexion.Conexion.conectar;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import static jdk.nashorn.internal.objects.NativeError.printStackTrace;


public class AutorDAO extends Conexion{
    
    public boolean agregar (String autor_name, String perfil, String added_on){
        
    PreparedStatement pst =null;
        
        try {
            String consulta ="INSERT INTO autor (autor_name , perfil , added_on) VALUES (?, ?, ?)";
            pst=conectar().prepareStatement(consulta);
            pst.setString(1, autor_name);
            pst.setString(2, perfil);
            pst.setString(3, added_on);
            
            if(pst.executeUpdate()==1){
            return true;
            
            }
        } catch (Exception e) {
            System.err.println("Error"+e);
        }
        finally{
            try {
                if(conectar()!=null)conectar().close();
                if(pst!=null)pst.close();
            } catch (Exception e) {
                System.out.println("Error"+e);
            }
        }
    
     return false;
    }
    
    
    public ArrayList<Autor> AutorBusqueda(String buscador){
        
        try {
            String SQL = "select * from autor where autor_name LIKE'%"+buscador+"%'";
            Connection conn = Conexion.conectar();
            Statement st = conn.createStatement();
            //ps.setString(1, buscador);
            ResultSet rst = st.executeQuery(SQL);
            
            ArrayList<Autor> lista = new ArrayList<>();
            Autor aut;
            
            while (rst.next()) {                
                aut = new Autor();
                aut.setSl_no(rst.getString("sl_no"));
                aut.setAutor_name(rst.getString("autor_name"));
                aut.setPerfil(rst.getString("perfil"));
                aut.setAdded_on(rst.getString("added_on"));
                lista.add(aut);
            }  
            return lista;
            
        } catch (SQLException ex) {
            System.out.println(ex);
            printStackTrace(ex);
            return null;
        }
        
    }
    
    
    public ArrayList<Autor> ListarAutores(){
        
        try {
            String SQL = "select * from autor";
            Connection conn = Conexion.conectar();
            PreparedStatement pst = conn.prepareStatement(SQL);
            //Statement st = conn.createStatement();
            //ps.setString(1, buscador);
            ResultSet rst = pst.executeQuery();
            
            ArrayList<Autor> lista = new ArrayList<>();
            Autor aut;
            
            while (rst.next()) {                
                aut = new Autor();
                aut.setSl_no(rst.getString("sl_no"));
                aut.setAutor_name(rst.getString("autor_name"));
                aut.setPerfil(rst.getString("perfil"));
                aut.setAdded_on(rst.getString("added_on"));
                lista.add(aut);
            }  
            return lista;
            
        } catch (SQLException ex) {
            System.out.println(ex);
            printStackTrace(ex);
            return null;
        }
        
    }
    
    
    /*
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Autor au=new Autor();
    public List listar(){
    
    ArrayList<Autor>list=new ArrayList<>();
    String sql="SELECT * FROM `autor`";
    
        try {
            con=cn.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            
            while(rs.next()){
            
            Autor lir = new Autor();
            lir.setAutor_name(rs.getString("autor_name"));
            list.add(lir);
            }
            
        } catch (Exception e) {
        }
    
    return list;
}*/
    
    
    public static void main(String[] args) {
        
        AutorDAO ada = new AutorDAO();
        
        for(Autor au:ada.ListarAutores()){
           System.out.println(au.getAutor_name());
        }
        
    }
    
    }

