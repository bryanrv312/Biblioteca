/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Estudiante;
import bean.Libro;
import conexion.Conexion;
import static conexion.Conexion.conectar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class EstudianteDAO extends Conexion {
    
    public boolean addestu(String student_name,String student_app, String nivel, String grado,String seccion, String book_name , String tprest,String estado){
    PreparedStatement pst =null;
        
        try {
            String consulta ="INSERT INTO estudiantes (student_name, student_app , nivel,grado,seccion,book_name,tprest,estado) VALUES (?, ?, ?,?,?,?,?,?)";
            pst=conectar().prepareStatement(consulta);
            pst.setString(1, student_name);
            pst.setString(2, student_app);
            pst.setString(3, nivel);
            pst.setString(4, grado);
            pst.setString(5, seccion);
            pst.setString(6, book_name);
            pst.setString(7, tprest);
            pst.setString(8, estado);
            
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
    
    
    public ArrayList<Estudiante> EstudianteBusquedaApellido(String buscador){
        
        try {
            String SQL = "select * from estudiantes where student_app like '%"+buscador+"%'";
            Connection con = Conexion.conectar();
            Statement sta = con.createStatement();
            //PreparedStatement pst = con.prepareStatement(SQL);
            ResultSet res = sta.executeQuery(SQL);
            
            ArrayList<Estudiante> lista = new ArrayList<>();
            Estudiante est;
            
            while (res.next()) {                
                est = new Estudiante();
                est.setStudent_id(res.getString("student_id"));
                est.setStudent_name(res.getString("student_name"));
                est.setStudent_app(res.getString("student_app"));
                est.setNivel(res.getString("nivel"));
                est.setGrado(res.getString("grado"));
                est.setSeccion(res.getString("seccion"));
                est.setBook_name(res.getString("book_name"));
                est.setTprest(res.getString("tprest"));
                est.setEstado(res.getString("estado"));
                lista.add(est);
            }
            return lista;
            
        } catch (Exception e) {
            return null;
        }
        
    }
    
    public Estudiante getStudentt(String cod){
        try {
            String sql = "select * from estudiantes where student_id=?";
            Connection con = conexion.Conexion.conectar();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,cod);
            ResultSet res = pst.executeQuery();
            
            Estudiante est = null;
            
            while(res.next()){
                est = new Estudiante();
                est.setStudent_id(res.getString("student_id"));
                est.setStudent_name(res.getString("student_name"));
                est.setStudent_app(res.getString("student_app"));
                est.setNivel(res.getString("nivel"));
                est.setGrado(res.getString("grado"));
                est.setSeccion(res.getString("seccion"));
                est.setBook_name(res.getString("book_name"));
                est.setTprest(res.getString("tprest"));
                est.setEstado(res.getString("estado"));
            }
            return est;
            
        } catch (SQLException ex) {
            return null;
        }
    }
    
    
    public ArrayList<Estudiante> ListarEstudiantes(){
        
        try {
            String SQL = "select * from estudiantes";
            Connection con = Conexion.conectar();
            PreparedStatement pst = con.prepareStatement(SQL);
            ResultSet res = pst.executeQuery();
            
            ArrayList<Estudiante> lista = new ArrayList<>();
            Estudiante est;
            
            while (res.next()) {                
                est = new Estudiante();
                est.setStudent_id(res.getString("student_id"));
                est.setStudent_name(res.getString("student_name"));
                est.setStudent_app(res.getString("student_app"));
                est.setNivel(res.getString("nivel"));
                est.setGrado(res.getString("grado"));
                est.setSeccion(res.getString("seccion"));
                est.setBook_name(res.getString("book_name"));
                est.setTprest(res.getString("tprest"));
                est.setEstado(res.getString("estado"));
                lista.add(est);
            }
            return lista;
            
        } catch (SQLException e) {
            return null;
        }
        
    }
    
    
    public boolean EliminarRegistro(String cod){
        
        try {
            String SQL ="delete from estudiantes where student_id = ?";
            Connection con = Conexion.conectar();
            PreparedStatement pst = con.prepareStatement(SQL);
            pst.setString(1,cod);
            
            if(pst.executeUpdate() > 0){
                return true;
            }else{
                return false;
            }
            
        } catch (SQLException ex) {
            return false;
        }
        
    }
    
    public boolean ModificarRegistro(String estado, String cod){
        
        try {
            String SQL = "update estudiantes set estado=? where student_id=?";
            Connection con = conexion.Conexion.conectar();
            PreparedStatement pst = con.prepareStatement(SQL);
            pst.setString(1,estado);
            pst.setString(2,cod);
            
            if(pst.executeUpdate() > 0 ){
                return true;
            }else{
                return false;
            }
            
        } catch (SQLException ex) {
            System.out.println("ERROR! EstudianteDao.ModificarRegitro(): "+ex.getMessage());
            return false;
        }
    }
    
    
    /*
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Estudiante li=new Estudiante();
    
    public List listar(){
    
    ArrayList<Estudiante>list=new ArrayList<>();
    String sql="SELECT * FROM `estudiantes`";
    
        try {
            con=cn.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            
            while(rs.next()){
            
            Estudiante lir = new Estudiante();
            lir.setStudent_id(rs.getString("student_id"));
            lir.setStudent_name(rs.getString("student_name"));
            lir.setStudent_app(rs.getString("student_app"));
            lir.setNivel(rs.getString("nivel"));
            lir.setGrado(rs.getString("grado"));
            lir.setSeccion(rs.getString("seccion"));
            lir.setBook_name(rs.getString("book_name"));
            lir.setTprest(rs.getString("tprest"));
            lir.setEstado(rs.getString("estado"));
            list.add(lir);
            }
            
        } catch (Exception e) {
        }
    
    return list;
}
*/
    
    /*public static void main(String[] args) {
        EstudianteDAO edao = new EstudianteDAO();
        
        for(Estudiante e:edao.EstudianteBusquedaApellido("o")){
            System.out.println(e.getStudent_app());
        }
    }*/

    public static void main(String[] args) {
        
        EstudianteDAO edao = new EstudianteDAO();
        Estudiante e = edao.getStudentt("36");
        
        
        System.out.println(e.getStudent_name());

        
    }
    
    
}
