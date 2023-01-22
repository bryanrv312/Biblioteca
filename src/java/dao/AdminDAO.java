/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.AdminBean;
import conexion.Conexion;
import static conexion.Conexion.conectar;
import consultas.login.loginsql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class AdminDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    AdminBean au = new AdminBean();

    public List listar() {

        ArrayList<AdminBean> list = new ArrayList<>();
        String sql = "SELECT * FROM `usuarios`";

        try {
            con = cn.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                AdminBean lir = new AdminBean();
                lir.setUser(rs.getString("user"));
                list.add(lir);
            }

        } catch (SQLException e) {
            System.out.println("Error en AdminDao: " + e.getMessage());
        }

        return list;
    }
    
    
    public AdminBean getUsuario(String usuario, String contraseña){
        
        try {
            String consulta = "select * from usuarios where user=? and pass=?";
            PreparedStatement pst = conectar().prepareStatement(consulta);
            pst.setString(1, usuario);
            pst.setString(2, contraseña);
            ResultSet rs = pst.executeQuery();
            
            AdminBean admin = new AdminBean();
            
            while (rs.next()) {  
                admin.setUser(rs.getString("user"));
                admin.setPassword(rs.getString("pass"));
            }
            return admin;
            
        } catch (SQLException e) {
            System.out.println("Error al obtener Usuario: " + e.getMessage());
            return null;
        }
        
        
    }
    
    public static void main(String[] args) {
        
        AdminDAO adao = new AdminDAO();
        AdminBean adm = adao.getUsuario("bryan", "12345");
        
        System.out.println(adm.getUser());
    }

}
