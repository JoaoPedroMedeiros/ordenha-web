package com.dac.coletor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.dac.coletor.beans.ColetaBean;
import com.dac.coletor.beans.PropriedadeBean;
import com.dac.coletor.util.PreparedStatementHelper;

public class ColetaDAO implements CrudDAO<ColetaBean> {

    public ColetaDAO() {
    }
    
    public int coletasHoje() throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.conectar();
        
        try {
            PreparedStatement statement = connection.prepareStatement(
                "SELECT count(*) total FROM coletas WHERE year(data_hora) = year(now()) and month(data_hora) = month(now()) and day(data_hora) = day(now())"
            );
            ResultSet rs = statement.executeQuery();
            return rs.first() ? rs.getInt("total") : 0;
        }
        finally {
            connectionFactory.Desconectar(connection);
        }
    }
    
    @Override
    public void inserir(ColetaBean objeto) throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.conectar();
        
        try {
            PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO Coletas ( \r\n" + 
                "  id_propriedade,     \r\n" + 
                "  quantidade    ,     \r\n" + 
                "  data_hora           \r\n" + 
                ")                     \r\n" + 
                "VALUES (              \r\n" + 
                "  ?,                  \r\n" + 
                "  ?,                  \r\n" + 
                "  ?                   \r\n" + 
                ")                     "
            );
            statement.setInt(1, objeto.getPropriedade().getId());
            statement.setFloat(2, objeto.getQuantidade());
            statement.setTimestamp(3, new Timestamp(objeto.getDataHora().getTime()));
            statement.executeUpdate();
        }
        finally {
            connectionFactory.Desconectar(connection);
        }
    }

    @Override
    public void alterar(ColetaBean objeto) throws SQLException {
        
    }

    @Override
    public void deletar(ColetaBean objeto) throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.conectar();
        
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "DELETE FROM Coletas WHERE Coletas.id = ?"
              );
            
            statement.setInt(1, objeto.getId());
            statement.executeUpdate();
        }
        catch (Exception e) {
            connectionFactory.Desconectar(connection);
        }
    }

    @Override
    public ColetaBean buscarPorId(ColetaBean objeto) throws SQLException {
        return null;
    }

    @Override
    public List<ColetaBean> listar(ColetaBean filtro) throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.conectar();
        
        try {
            PreparedStatement statement = connection.prepareStatement(
                  "SELECT " +
                    "c.id id, " +
                    "quantidade, " + 
                    "data_hora , " + 
                    "id_propriedade," +
                    "p.nome nome " +
                  "FROM " + 
                    "Coletas c " +
                    "INNER JOIN Propriedades p ON c.id_propriedade = p.id " +
                  "ORDER BY data_hora DESC"
            );
            ResultSet rs = statement.executeQuery();
            
            List<ColetaBean> coletas = new ArrayList<>();
            
            while (rs.next()) {
                ColetaBean coleta = new ColetaBean();
                coleta.setId(rs.getInt("id"));
                coleta.setQuantidade(rs.getFloat("quantidade"));
                coleta.setDataHora(new Date(rs.getTimestamp("data_hora").getTime()));
                
                PropriedadeBean propriedade = new PropriedadeBean();
                propriedade.setId(rs.getInt("id_propriedade"));
                propriedade.setNome(rs.getString("nome"));
                coleta.setPropriedade(propriedade);
                
                coletas.add(coleta);
            }
            
            return coletas;
        }
        finally {
            connectionFactory.Desconectar(connection);
        }
    }
    
    public List<ColetaBean> listarResumido(String cnpj, Integer ano, Integer mes) throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.conectar();
        
        try {
            PreparedStatementHelper statementHelper = new PreparedStatementHelper(
                "SELECT " +
                  "quantidade, " + 
                  "data_hora " + 
                "FROM " + 
                  "Coletas c " + 
                  "INNER JOIN Propriedades p ON c.id_propriedade = p.id " +
                "WHERE 1 = 1");
            
            statementHelper.setParameter("AND p.cnpj = ?", cnpj);
            statementHelper.setParameter("AND YEAR(data_hora) = ?", ano);
            statementHelper.setParameter("AND MONTH(data_hora) = ?", mes);
            
            PreparedStatement statement = statementHelper.prepareStatement(connection);
            
            ResultSet rs = statement.executeQuery();
            
            List<ColetaBean> coletas = new ArrayList<>();
            
            while (rs.next()) {
                ColetaBean coleta = new ColetaBean();
                coleta.setQuantidade(rs.getFloat("quantidade"));
                coleta.setDataHora(new Date(rs.getTimestamp("data_hora").getTime()));
                coletas.add(coleta);
            }
            
            return coletas;
        }
        finally {
            connectionFactory.Desconectar(connection);
        }
    }
}
