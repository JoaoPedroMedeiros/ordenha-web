
package com.dac.coletor.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
      public Connection conectar() throws SQLException {
        Connection conn = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd-coletor?useTimezone=true&serverTimezone=UTC", "root", "");
            System.out.println("Connection");
        }catch (ClassNotFoundException ex){
        	throw new RuntimeException(ex);
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
