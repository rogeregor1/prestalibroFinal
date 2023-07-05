/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author familiahurtado
 */

public class Conexion {

    public static Connection con;
    //private final String jdbc = "com.mysql.cj.jdbc.Driver";
    //private final String puerto = "3306";

    //String urlConexion = "jdbc:mysql://localhost:3306/bd_presta";
    //String usu = "root";
    //String pas = "12345678";

/*       
     public  Conexion() {
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");// Driver depende de la BD
            //establece la conexión
            con = DriverManager.getConnection(url, usu, pas);
        
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            //System.out.println("Error: " + e.getMessage());
        }
       
    }
    
 public Connection getConnection(){
     return con;
 }   
    
*/ 

    public static Connection getConnection(String usu, String pas, String urlConexion) {
        //Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");// Driver depende de la BD
            //establece la conexión
            con = (Connection) DriverManager.getConnection(urlConexion,usu,pas);
        } catch (SQLException e) {
            System.out.println("errorSQL: " + e.getMessage());

        } catch (ClassNotFoundException ex) {
            System.out.println("Error: " + ex.getMessage());
            //System.out.println("Error: " + e.getMessage());
        }
        //catch (Exception e)
        //JOptionPane.showMessageDialog(null, e.getMessage());
        //System.out.println("Error: " + e.getMessage());
        return con;
    }

    public static void cerrar_conexion() {
        
        try {
            con.close();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

}
