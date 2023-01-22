/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Categoria;
import bean.Libro;
import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class CategoriaDAO extends Conexion {

    public boolean añcagetoria(String category_name, String profile, String added_on) {
        PreparedStatement pst = null;

        try {
            String consulta = "INSERT INTO categoria (category_name, profile , added_on) VALUES (?, ?, ?)";
            pst = conectar().prepareStatement(consulta);
            pst.setString(1, category_name);
            pst.setString(2, profile);
            pst.setString(3, added_on);

            if (pst.executeUpdate() == 1) {
                return true;

            }
        } catch (Exception e) {
            System.err.println("Error" + e);
        } finally {
            try {
                if (conectar() != null) {
                    conectar().close();
                }
                if (pst != null) {
                    pst.close();
                }
            } catch (Exception e) {
                System.out.println("Error" + e);
            }
        }

        return false;
    }

    public ArrayList<Categoria> CategoriaBusqueda(String buscador) {

        try {
            String SQL = "select * from categoria where category_name like '%" + buscador + "%' ";
            Connection con = Conexion.conectar();
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(SQL);

            ArrayList lista = new ArrayList();
            Categoria cat;

            while (res.next()) {
                cat = new Categoria();
                cat.setCategory_name(res.getString("category_name"));
                cat.setProfile(res.getString("profile"));
                lista.add(cat);
            }

            return lista;

        } catch (Exception e) {
            return null;
        }

    }
    
    
    public ArrayList<Categoria> ListarCategoria() {

        try {
            String SQL = "select * from categoria";
            Connection con = Conexion.conectar();
            PreparedStatement pst = con.prepareStatement(SQL);
            //Statement st = con.createStatement();
            ResultSet res = pst.executeQuery();

            ArrayList lista = new ArrayList();
            Categoria cat;

            while (res.next()) {
                cat = new Categoria();
                cat.setCategory_name(res.getString("category_name"));
                cat.setProfile(res.getString("profile"));
                lista.add(cat);
            }

            return lista;

        } catch (Exception e) {
            return null;
        }

    }
    

    /*
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Categoria cat=new Categoria();
    
    
    public List listar(){
            
        ArrayList<Categoria>list=new ArrayList<>();
        String sql="SELECT * FROM `categoria`";

            try {
                con=cn.conectar();
                ps=con.prepareStatement(sql);
                rs=ps.executeQuery();

                while(rs.next()){
                    Categoria lir = new Categoria();
                    lir.setCategory_name(rs.getString("category_name"));
                    list.add(lir);
                }

            } catch (Exception e) {
            }

        return list;
    }
    
     */
    
    
    public static void main(String[] args) {

        CategoriaDAO cadao = new CategoriaDAO();

        for (Categoria cat : cadao.ListarCategoria()) {
            System.out.println(cat.getCategory_name());
            System.out.println(cat.getProfile());
        }

    }

}
