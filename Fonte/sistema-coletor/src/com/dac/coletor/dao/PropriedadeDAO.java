package com.dac.coletor.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dac.coletor.beans.CidadeBean;
import com.dac.coletor.beans.EstadoBean;
import com.dac.coletor.beans.PropriedadeBean;
import com.dac.coletor.dao.ConnectionFactory;

public class PropriedadeDAO implements CrudDAO<PropriedadeBean>{

    @Override
    public void inserir(PropriedadeBean objeto) throws SQLException {
        ConnectionFactory conexao = new ConnectionFactory();
        Connection conn = conexao.conectar();

        try {
            String sql = "INSERT INTO propriedades (id, id_cidade, cnpj, nome, endereco, bairro, numero, complemento, telefone, proprietario, email, periodicidade) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1, objeto.getId());
            stm.setInt(2, objeto.getCidade().getId());
            stm.setString(3, objeto.getCnpj());
            stm.setString(4, objeto.getNome());
            stm.setString(5, objeto.getEndereco());
            stm.setString(6, objeto.getBairro());
            stm.setString(7, objeto.getNumero());
            stm.setString(8, objeto.getComplemento());
            stm.setString(9, objeto.getTelefone());
            stm.setString(10, objeto.getProprietario());
            stm.setString(11, objeto.getEmail());
            stm.setInt(12, objeto.getPeriodicidade());
            stm.execute();
        } finally {
            conexao.Desconectar(conn);
        }
    }

    @Override
    public void alterar(PropriedadeBean objeto) throws SQLException {
        ConnectionFactory conexao = new ConnectionFactory();
        Connection conn = conexao.conectar();

        try {
            String sql = "UPDATE propriedades SET "
                    + "id_cidade = ?, "
                    + "cnpj = ?, "
                    + "nome = ?, "
                    + "endereco = ?, "
                    + "bairro = ?, "
                    + "numero = ?, "
                    + "complemento = ?, "
                    + "telefone = ?, "
                    + "proprietario = ?, "
                    + "email = ?, "
                    + "periodicidade = ? " 
                    + "WHERE id = ?";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1, objeto.getCidade().getId());
            stm.setString(2, objeto.getCnpj());
            stm.setString(3, objeto.getNome());
            stm.setString(4, objeto.getEndereco());
            stm.setString(5, objeto.getBairro());
            stm.setString(6, objeto.getNumero());
            stm.setString(7, objeto.getComplemento());
            stm.setString(8, objeto.getTelefone());
            stm.setString(9, objeto.getProprietario());
            stm.setString(10, objeto.getEmail());
            stm.setInt(11, objeto.getPeriodicidade());
            stm.setInt(12, objeto.getId());
            stm.executeUpdate();
        } finally {
            conexao.Desconectar(conn);
        }
    }

    @Override
    public void deletar(PropriedadeBean objeto) throws SQLException {
        ConnectionFactory conexao = new ConnectionFactory();
        Connection conn = conexao.conectar();

        try {
            String sql = "DELETE FROM propriedades WHERE id = ?";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1, objeto.getId());
            stm.execute();
        } finally {
            conexao.Desconectar(conn);
        }
    }

    @Override
    public PropriedadeBean buscarPorId(PropriedadeBean objeto) throws SQLException {
        ConnectionFactory conexao = new ConnectionFactory();
        Connection conn = conexao.conectar();

        try {
            String sql = "SELECT p.*, c.id AS id_cidade, c.nome AS nm_cidade, e.id AS id_estado, e.nome AS nm_estado, e.sigla FROM propriedades p "
                    + "INNER JOIN cidades c ON c.id = p.id_cidade "
                    + "INNER JOIN estados e ON e.id = c.id_estado"
                    + "WHERE p.id = ?";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1, objeto.getId());
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                PropriedadeBean propriedadeBean = new PropriedadeBean();
                CidadeBean cidadeBean = new CidadeBean();
                EstadoBean estadoBean = new EstadoBean();
                
                propriedadeBean.setId(rs.getInt("id"));
                propriedadeBean.setCnpj(rs.getString("cnpj"));
                propriedadeBean.setNome(rs.getString("nome"));
                propriedadeBean.setEndereco(rs.getString("endereco"));
                propriedadeBean.setBairro(rs.getString("bairro"));
                propriedadeBean.setNumero(rs.getString("numero"));
                propriedadeBean.setComplemento(rs.getString("complemento"));
                propriedadeBean.setTelefone(rs.getString("telefone"));
                propriedadeBean.setProprietario(rs.getString("proprietario"));
                propriedadeBean.setPeriodicidade(rs.getInt("periodicidade"));
                
                estadoBean.setId(rs.getInt("id_estado"));
                estadoBean.setNome(rs.getString("nm_estado"));
                estadoBean.setSigla(rs.getString("sigla"));
                
                cidadeBean.setId(rs.getInt("id_cidade"));
                cidadeBean.setNome(rs.getString("nm_cidade"));
                cidadeBean.setEstado(estadoBean);
                
                propriedadeBean.setCidade(cidadeBean);
                
                return propriedadeBean;
            }
        } finally {
            conexao.Desconectar(conn);
        }
        return null;
    }

    @Override
    public List<PropriedadeBean> listar(PropriedadeBean objeto) throws SQLException {
        ConnectionFactory conexao = new ConnectionFactory();
        Connection conn = conexao.conectar();
        List<PropriedadeBean> propriedadeBeanList = new ArrayList();

        try {
            String sql = "SELECT v.*, r.id AS id_raca, r.nome AS nm_raca FROM vacas v "
                    + "INNER JOIN racas r ON r.id = v.id_raca "
                    + "WHERE 1=1 ";
            PreparedStatement stm = conn.prepareStatement(sql);
                
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                PropriedadeBean propriedadeBean = new PropriedadeBean();
                CidadeBean cidadeBean = new CidadeBean();
                EstadoBean estadoBean = new EstadoBean();
                
                propriedadeBean.setId(rs.getInt("id"));
                propriedadeBean.setCnpj(rs.getString("cnpj"));
                propriedadeBean.setNome(rs.getString("nome"));
                propriedadeBean.setEndereco(rs.getString("endereco"));
                propriedadeBean.setBairro(rs.getString("bairro"));
                propriedadeBean.setNumero(rs.getString("numero"));
                propriedadeBean.setComplemento(rs.getString("complemento"));
                propriedadeBean.setTelefone(rs.getString("telefone"));
                propriedadeBean.setProprietario(rs.getString("proprietario"));
                propriedadeBean.setPeriodicidade(rs.getInt("periodicidade"));
                
                estadoBean.setId(rs.getInt("id_estado"));
                estadoBean.setNome(rs.getString("nm_estado"));
                estadoBean.setSigla(rs.getString("sigla"));
                
                cidadeBean.setId(rs.getInt("id_cidade"));
                cidadeBean.setNome(rs.getString("nm_cidade"));
                cidadeBean.setEstado(estadoBean);
                
                propriedadeBean.setCidade(cidadeBean);
                
                propriedadeBeanList.add(propriedadeBean);
            }
        } finally {
            conexao.Desconectar(conn);
        }
        return propriedadeBeanList;
    }

}
