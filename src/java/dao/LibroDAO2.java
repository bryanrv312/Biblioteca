/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Libro;
import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class LibroDAO2 extends Conexion{
    
    public boolean agregar(String libro_titulo, String categoria_name,String autor_name,String editor_name,String edicion,String volumen,String isbn,String precio,String idioma,String descripcion)
    {
        PreparedStatement pst =null;
        
        try {
            String consulta ="INSERT INTO libros (libro_titulo, categoria_name, autor_name, editor_name, edicion, volumen, isbn, precio, idioma, descripcion) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            pst=conectar().prepareStatement(consulta);
            pst.setString(1,libro_titulo);
            pst.setString(2,categoria_name);
            pst.setString(3,autor_name);
            pst.setString(4,editor_name);
            pst.setString(5,edicion);
            pst.setString(6,volumen);
            pst.setString(7,isbn);
            pst.setString(8,precio);
            pst.setString(9,idioma);
            pst.setString(10,descripcion);
            
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
    
    
    public ArrayList<Libro> LibroBusquedaTitulo(String buscador){
        
        try {
            String SQL = "select * from libros where libro_titulo like '%"+buscador+"%'";
            Connection con = Conexion.conectar();
            Statement sta = con.createStatement();
            ResultSet res = sta.executeQuery(SQL);
            
            ArrayList<Libro> lista = new ArrayList<>();
            Libro libro;
            
            while(res.next()){
                
                libro = new Libro();
                libro.setLibro_titulo(res.getString("libro_titulo"));
                libro.setCategoria_name(res.getString("categoria_name"));
                libro.setAutor_name(res.getString("autor_name"));
                libro.setEdicion(res.getString("editor_name"));
                libro.setIsbn(res.getString("isbn"));
                lista.add(libro);
            }            
            return lista;
            
        } catch (SQLException e) {
            return null;
        }        
    }
    
    
    public ArrayList<Libro> LibroBusquedaAutor(String buscador){
        
        try {
            String SQL = "select * from libros where autor_name like '%"+buscador+"%'";
            Connection con = Conexion.conectar();   
            Statement sta = con.createStatement();
            ResultSet res = sta.executeQuery(SQL);
            
            ArrayList<Libro> lista = new ArrayList<>();
            Libro libro;
            
            while(res.next()){
                
                libro = new Libro();
                libro.setLibro_titulo(res.getString("libro_titulo"));
                libro.setCategoria_name(res.getString("categoria_name"));
                libro.setAutor_name(res.getString("autor_name"));
                libro.setEdicion(res.getString("editor_name"));
                libro.setIsbn(res.getString("isbn"));
                lista.add(libro);
            }            
            return lista;
            
        } catch (SQLException e) {
            return null;
        }        
    }
    
    
    public ArrayList<Libro> ListarLibros(){
        
        try {
            String SQL = "select * from libros";
            Connection con = Conexion.conectar();
            PreparedStatement pst = con.prepareStatement(SQL);
            //Statement sta = con.createStatement();
            ResultSet res = pst.executeQuery();
            
            ArrayList<Libro> lista = new ArrayList<>();
            Libro libro;
            
            while(res.next()){
                
                libro = new Libro();
                libro.setLibro_titulo(res.getString("libro_titulo"));
                libro.setCategoria_name(res.getString("categoria_name"));
                libro.setAutor_name(res.getString("autor_name"));
                libro.setEdicion(res.getString("editor_name"));
                libro.setIsbn(res.getString("isbn"));
                lista.add(libro);
            }            
            return lista;
            
        } catch (SQLException e) {
            return null;
        }        
    }
    
    
    /*
    
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Libro li=new Libro();
    
    public List listar(){
    
    ArrayList<Libro>list=new ArrayList<>();
    String sql="SELECT * FROM `libros`";
    
        try {
            con=cn.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            
            while(rs.next()){
            
            Libro lir = new Libro();
            lir.setLibro_titulo(rs.getString("libro_titulo"));
            list.add(lir);
            }
            
        } catch (Exception e) {
        }
    
    return list;
}
    
    */
    
    
    /*
    public static void main(String[] args) {
        
        LibroDAO2 lidao = new LibroDAO2();
        
        for(Libro li:lidao.ListarLibros()){
            
            System.out.println(li.getLibro_titulo());
            System.out.println(li.getCategoria_name());
            System.out.println(li.getAutor_name());
            System.out.println(li.getEdicion());
            System.out.println(li.getIsbn());
        }
        
    }*/
   
}
