package com.ufpr.tads.web2.dao;

import com.ufpr.tads.web2.beans.User;
import java.sql.*;
 
public class UsuarioDAO {

    public User Pesquisar(String login){        
        User usuario = new User();
        ConnectionFactory conexao = new ConnectionFactory();
        Connection conn = conexao.conectar();
        
        try{
            String consulta = "SELECT * FROM tb_usuario WHERE login_usuario = ?";
            PreparedStatement stm = conn.prepareStatement(consulta);
            stm.setString(1, login);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                usuario.setId(rs.getInt("id_usuario"));
                usuario.setLogin(rs.getString("login_usuario"));
                usuario.setNome(rs.getString("nome_usuario"));
                usuario.setSenha(rs.getString("senha_usuario"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            conexao.Desconectar(conn);
        }
        return usuario;
    }
}
