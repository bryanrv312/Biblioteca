
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Conexion {
    
    
    public static Connection conectar(){
        //mysql-connector-java-5.1.15-bin.jar
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/sgbe","root","");
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
    
  /*  private static Connection conn=null;
    private String server="localhost";
    private String bd="sgbe";
    private String port="3306";
    private String user="root";
    private String passw="";

    */
    
    //public Conexion() {  
        
        
        
        
        
        /*
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:mysql://"+server+"/"+bd;           
            conn= DriverManager.getConnection(url,user,passw);
            
        }catch(SQLException | ClassNotFoundException ex){
            System.out.println(ex);
        }   */
    //}
    
    /*  
    public static Connection conectar(){
        return conn;
    }*/
  
  /*
  public Connection closeConexion(){
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        conn=null;
        return conn;
  }   
  */
    
    
    /*
    public static void main(String[] args) {
        
        if(conectar() != null){
            System.out.println("CORRECTO");
        }else{
            System.out.println("MALO");
        }
        
    }*/
  
}
