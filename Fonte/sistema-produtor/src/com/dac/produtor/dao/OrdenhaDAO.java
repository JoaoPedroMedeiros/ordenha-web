package com.dac.produtor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.dac.produtor.beans.OrdenhaBean;
import com.dac.produtor.beans.RacaBean;
import com.dac.produtor.beans.UsuarioBean;
import com.dac.produtor.beans.VacaBean;
import com.dac.produtor.beans.VacaOrdenhadaBean;

public class OrdenhaDAO implements CrudDAO<OrdenhaBean> {

    private Integer idPropriedade;
    
    public OrdenhaDAO(Integer idPropriedade) {
        this.idPropriedade = idPropriedade;
    }
    
    @Override
    public void inserir(OrdenhaBean objeto) throws SQLException {
        
    }

    @Override
    public void alterar(OrdenhaBean objeto) throws SQLException {
        
    }

    @Override
    public void deletar(OrdenhaBean objeto) throws SQLException {
        
    }

    @Override
    public OrdenhaBean buscarPorId(OrdenhaBean objeto) throws SQLException {
        return null;
    }

    @Override
    public List<OrdenhaBean> listar(OrdenhaBean filtro) throws SQLException {
        return null;
    }

    public List<OrdenhaBean> listarPorMes(Integer ano, Integer mes) throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.conectar();
        
        try {
            PreparedStatement statement = connection.prepareStatement(
                "SELECT                                          \r\n" + 
                "  o.id id,                                      \r\n" + 
                "  data_hora,                                    \r\n" + 
                "  id_usuario,                                   \r\n" +
                "  u.nome                                        \r\n" +
                "FROM                                            \r\n" + 
                "  Ordenhas o                                    \r\n" + 
                "  INNER JOIN Usuarios u ON o.id_usuario = u.id  \r\n" + 
                "WHERE                                           \r\n" + 
                "    o.id_propriedade = ?                        \r\n" + 
                "AND year(data_hora)  = ?                        \r\n" + 
                "AND month(data_hora) = ?"
            );

            statement.setInt(1, this.idPropriedade);
            statement.setInt(2, ano);
            statement.setInt(3, mes);
            
            ResultSet rs = statement.executeQuery();
            
            List<OrdenhaBean> ordenhas = new ArrayList<>();
            
            while (rs.next()) {
                OrdenhaBean ordenha = new OrdenhaBean();
                
                ordenha.setId(rs.getInt("id"));
                ordenha.setDataHora(new Date(rs.getTimestamp("data_hora").getTime()));
                
                UsuarioBean usuario = new UsuarioBean();
                usuario.setId(rs.getInt("id_usuario"));
                usuario.setNome(rs.getString("nome"));
                ordenha.setUsuario(usuario);
                
                ordenhas.add(ordenha);
            }
            
            for (OrdenhaBean ordenha : ordenhas) {
                PreparedStatement stsVacaOrdenhada = connection.prepareStatement(
                    "SELECT                                  \r\n" + 
                    "  vo.id,                                \r\n" + 
                    "  vo.id_vaca id_vaca,                    \r\n" + 
                    "  id_ordenha,                           \r\n" + 
                    "  quantidade_leite,                     \r\n" + 
                    "  v.nome nomeVaca,                      \r\n" + 
                    "  peso,                                 \r\n" + 
                    "  id_raca,                              \r\n" + 
                    "  observacao,                           \r\n" + 
                    "  data_nascimento,                      \r\n" + 
                    "  doente,                               \r\n" + 
                    "  prenha,                               \r\n" +
                    "  r.nome nomeRaca                       \r\n" +
                    "FROM                                    \r\n" + 
                    "  VacasOrdenhadas vo                    \r\n" + 
                    "  INNER JOIN Vacas v ON vo.id_vaca = v.id  \r\n" +
                    "  INNER JOIN Racas r ON v.id_raca = r.id  \r\n" +
                    "WHERE                                   \r\n" + 
                    "  id_ordenha = ?                        \r\n"
                );
                stsVacaOrdenhada.setInt(1, ordenha.getId());
                
                List<VacaOrdenhadaBean> vacasOrdenhadas = new ArrayList<>();
                
                ResultSet rsVacas = stsVacaOrdenhada.executeQuery();
                
                while (rsVacas.next()) {
                    VacaOrdenhadaBean vacaOrdenhada = new VacaOrdenhadaBean();
                    vacaOrdenhada.setId(rsVacas.getInt("id"));
                    vacaOrdenhada.setQuantidadeLeite(rsVacas.getFloat("quantidade_leite"));
                    vacaOrdenhada.setOrdenha(ordenha);
                    
                    VacaBean vaca = new VacaBean();
                    vaca.setId(rsVacas.getInt("id_vaca"));
                    vaca.setNome(rsVacas.getString("nomeVaca"));
                    vaca.setPeso(rsVacas.getFloat("peso"));
                    vaca.setObservacao(rsVacas.getString("observacao"));
                    vaca.setDataNascimento(new Date(rsVacas.getDate("data_nascimento").getTime()));
                    vaca.setDoente(rsVacas.getBoolean("doente"));
                    vaca.setPrenha(rsVacas.getBoolean("prenha"));
                    
                    RacaBean raca = new RacaBean();
                    raca.setId(rsVacas.getInt("id_raca"));
                    raca.setDescricao(rsVacas.getString("nomeRaca"));
                    vaca.setRaca(raca);
                    
                    vacaOrdenhada.setVaca(vaca);
                    
                    vacasOrdenhadas.add(vacaOrdenhada);
                }

                ordenha.setVacas(vacasOrdenhadas);
            }
            
            return ordenhas;
        }
        finally {
            connectionFactory.Desconectar(connection);
        }
    }
}
