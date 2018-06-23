
package com.ufpr.tads.web2.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
      public Connection conectar(){
        Connection conn = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaweb", "root", "");
            System.out.println("Connection");
        }catch (ClassNotFoundException ex){
            ex.printStackTrace();
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return conn;  
    }
    public void Desconectar (Connection conn){
        if (conn != null){
            try{
                conn.close();
                System.out.println ("Desconectado");
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }
    }
    
    
}
