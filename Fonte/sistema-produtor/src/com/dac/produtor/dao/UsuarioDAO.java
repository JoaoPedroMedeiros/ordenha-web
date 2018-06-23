package com.dac.produtor.dao;

import com.dac.produtor.beans.UsuarioBean;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import javax.xml.bind.DatatypeConverter;
 
public class UsuarioDAO {
  public UsuarioBean validarLogin(String login, String senha) throws SQLException, NoSuchAlgorithmException{
    ConnectionFactory conexao = new ConnectionFactory();
    Connection conn = conexao.conectar();

    MessageDigest md = MessageDigest.getInstance("MD5");
    md.update(senha.getBytes());
    byte[] digest = md.digest();
    String myHash = DatatypeConverter.printHexBinary(digest);

    try{
      String consulta = "SELECT * FROM usuarios WHERE login = ? AND upper(senha) = ?";
      PreparedStatement stm = conn.prepareStatement(consulta);
      stm.setString(1, login);
      stm.setString(2, myHash.toUpperCase());
      ResultSet rs = stm.executeQuery();
      while(rs.next()){
        UsuarioBean usuario = new UsuarioBean();
        usuario.setId(rs.getInt("id"));
        usuario.setLogin(rs.getString("login"));
        usuario.setNome(rs.getString("nome"));
        usuario.setSenha(rs.getString("senha"));
        return usuario;
      }
    } finally {
      conexao.Desconectar(conn);
    }
    return null;
  }
}
