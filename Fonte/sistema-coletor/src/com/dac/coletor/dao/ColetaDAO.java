package com.dac.coletor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.dac.coletor.beans.ColetaBean;
import com.dac.coletor.util.PreparedStatementHelper;

public class ColetaDAO implements CrudDAO<ColetaBean> {

    private Integer idPropriedade;
    
    public ColetaDAO(Integer idPropriedade) {
        this.idPropriedade = idPropriedade;
    }
    
    @Override
    public void inserir(ColetaBean objeto) throws SQLException {
        
    }

    @Override
    public void alterar(ColetaBean objeto) throws SQLException {
        
    }

    @Override
    public void deletar(ColetaBean objeto) throws SQLException {
        
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
                    "data_hora " + 
                  "FROM " + 
                    "Coletas c " +
                  "WHERE id_propriedade = ? "
            );
            statement.setInt(1, idPropriedade);
            
            ResultSet rs = statement.executeQuery();
            
            List<ColetaBean> coletas = new ArrayList<>();
            
            while (rs.next()) {
                ColetaBean coleta = new ColetaBean();
                coleta.setId(rs.getInt("id"));
                coleta.setQuantidade(rs.getFloat("quantidade"));
                coleta.setDataHora(rs.getDate("data_hora"));
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
