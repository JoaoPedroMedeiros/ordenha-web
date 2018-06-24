package com.dac.produtor.dao;

import com.dac.produtor.beans.PropriedadeBean;
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
      String consulta = "SELECT u.*, p.id AS id_propriedade, p.cnpj AS cnpj_propriedade, p.nome AS nm_propriedade "
              + "FROM usuarios u "
              + "INNER JOIN propriedades p ON p.id = u.id_propriedade "
              + "WHERE u.login = ? AND upper(u.senha) = ?";
      PreparedStatement stm = conn.prepareStatement(consulta);
      stm.setString(1, login);
      stm.setString(2, myHash.toUpperCase());
      ResultSet rs = stm.executeQuery();
      while(rs.next()){
        UsuarioBean usuario = new UsuarioBean();
        PropriedadeBean propriedade = new PropriedadeBean();
        usuario.setId(rs.getInt("id"));
        usuario.setLogin(rs.getString("login"));
        usuario.setNome(rs.getString("nome"));
        usuario.setSenha(rs.getString("senha"));
        
        propriedade.setId(rs.getInt("id_propriedade"));
        propriedade.setCnpj(rs.getString("cnpj_propriedade"));
        propriedade.setNome(rs.getString("nm_propriedade"));
        
        usuario.setPropriedade(propriedade);
        return usuario;
      }
    } finally {
      conexao.Desconectar(conn);
    }
    return null;
  }
}
