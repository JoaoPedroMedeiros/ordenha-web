package com.dac.produtor.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dac.produtor.beans.RacaBean;
import com.dac.produtor.beans.UsuarioBean;
import com.dac.produtor.beans.VacaBean;
import com.dac.produtor.util.PreparedStatementHelper;

public class VacaDAO implements CrudDAO<VacaBean> {

    @Override
    public void inserir(VacaBean objeto) throws SQLException {
        ConnectionFactory conexao = new ConnectionFactory();
        Connection conn = conexao.conectar();

        try {
            String sql = "INSERT INTO vacas (id, id_raca, nome, data_nascimento, peso, doente, prenha, observacao) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1, objeto.getId());
            stm.setInt(2, objeto.getRaca().getId());
            stm.setString(3, objeto.getNome());
            stm.setDate(4, (Date) objeto.getDataNascimento());
            stm.setFloat(5, objeto.getPeso());
            stm.setBoolean(6, objeto.isDoente());
            stm.setBoolean(7, objeto.isPrenha());
            stm.setString(8, objeto.getObservacao());
            stm.execute();
        } finally {
            conexao.Desconectar(conn);
        }
    }

    @Override
    public void alterar(VacaBean objeto) throws SQLException {
        ConnectionFactory conexao = new ConnectionFactory();
        Connection conn = conexao.conectar();

        try {
            String sql = "UPDATE vacas SET "
                    + "id_raca = ?, "
                    + "nome = ?, "
                    + "data_nascimento = ?, "
                    + "peso = ?, "
                    + "doente = ?, " 
                    + "prenha = ?, " 
                    + "observacao = ? " 
                    + "WHERE id = ?";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1, objeto.getRaca().getId());
            stm.setString(2, objeto.getNome());
            stm.setDate(3, (Date) objeto.getDataNascimento());
            stm.setFloat(4, objeto.getPeso());
            stm.setBoolean(5, objeto.isDoente());
            stm.setBoolean(6, objeto.isPrenha());
            stm.setString(7, objeto.getObservacao());
            stm.setInt(8, objeto.getId());
            stm.executeUpdate();
        } finally {
            conexao.Desconectar(conn);
        }
    }

    @Override
    public void deletar(VacaBean objeto) throws SQLException {
        ConnectionFactory conexao = new ConnectionFactory();
        Connection conn = conexao.conectar();

        try {
            String sql = "DELETE FROM vacas WHERE id = ?";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1, objeto.getId());
            stm.execute();
        } finally {
            conexao.Desconectar(conn);
        }
    }

    @Override
    public VacaBean buscarPorId(VacaBean objeto) throws SQLException {
        ConnectionFactory conexao = new ConnectionFactory();
        Connection conn = conexao.conectar();

        try {
            String sql = "SELECT v.*, r.id AS id_raca, r.nome AS nm_raca FROM vacas v "
                    + "INNER JOIN racas r ON r.id = v.id_raca "
                    + "WHERE v.id = ?";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1, objeto.getId());
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                VacaBean vacaBean = new VacaBean();
                RacaBean racaBean = new RacaBean();
                
                vacaBean.setId(rs.getInt("id"));
                vacaBean.setNome(rs.getString("nome"));
                vacaBean.setDataNascimento(rs.getDate("data_nascimento"));
                vacaBean.setPeso(rs.getFloat("peso"));
                vacaBean.setDoente(rs.getBoolean("doente"));
                vacaBean.setPrenha(rs.getBoolean("prenha"));
                
                racaBean.setId(rs.getInt("id_raca"));
                racaBean.setDescricao(rs.getString("nm_raca"));
                vacaBean.setRaca(racaBean);
                
                return vacaBean;
            }
        } finally {
            conexao.Desconectar(conn);
        }
        return null;
    }

    @Override
    public List<VacaBean> listar(VacaBean objeto) throws SQLException {
        ConnectionFactory conexao = new ConnectionFactory();
        Connection conn = conexao.conectar();
        List<VacaBean> vacaBeanList = new ArrayList(); 

        try {
            PreparedStatementHelper statementHelper = new PreparedStatementHelper(
                    "SELECT v.*, r.id AS id_raca, r.nome AS nm_raca FROM vacas v "
                    + "INNER JOIN racas r ON r.id = v.id_raca "
                    + "WHERE 1=1 ");
            if(objeto.getId() != null) {
                statementHelper.setParameter("AND v.id = ?", objeto.getId());
            }
            if(objeto.getNome() != null) {
                statementHelper.setParameter("AND upper(v.nome) = ?", objeto.getNome().toUpperCase());
            }
            if(objeto.getDataNascimento() != null) {
                statementHelper.setParameter("AND v.data_nascimento = ?", objeto.getDataNascimento());
            }
            if(objeto.getRaca().getId() != null) {
                statementHelper.setParameter("AND r.id = ?", objeto.getRaca().getId());
            }
            
            PreparedStatement stm = statementHelper.prepareStatement(conn);   
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                VacaBean vacaBean = new VacaBean();
                RacaBean racaBean = new RacaBean();
                
                vacaBean.setId(rs.getInt("id"));
                vacaBean.setNome(rs.getString("nome"));
                vacaBean.setDataNascimento(rs.getDate("data_nascimento"));
                vacaBean.setPeso(rs.getFloat("peso"));
                vacaBean.setDoente(rs.getBoolean("doente"));
                vacaBean.setPrenha(rs.getBoolean("prenha"));
                
                racaBean.setId(rs.getInt("id_raca"));
                racaBean.setDescricao(rs.getString("nm_raca"));
                vacaBean.setRaca(racaBean);
                
                vacaBeanList.add(vacaBean);
            }
        } finally {
            conexao.Desconectar(conn);
        }
        return vacaBeanList;
    }

}
