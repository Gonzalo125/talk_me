/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion.Conectbd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class Conexion {

    private static Connection connection= null;
    public static Connection obtener(){
        if(connection==null){
            String connectionString =  
                    "jdbc:sqlserver://USER-PC\\SQLEXPRESS;"  
                    + "database=TALK_2_ME;"  
                    + "user=sa;"  
                    + "password=123;";  

                // Declare the JDBC objects.  
                 connection = null;  

                try {  
                    connection = DriverManager.getConnection(connectionString);  

                }  
                catch (Exception e) {  
                    e.printStackTrace();  
                }  
        }
    
      return connection;
    }
    public static void Cerrar(){
        // if (connection != null) try { connection.close(); } catch(Exception e) {}
        
    }
}
    

