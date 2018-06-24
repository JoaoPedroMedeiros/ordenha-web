package com.dac.produtor.dao;

import java.sql.SQLException;
import java.util.List;

public interface CrudDAO<T> {

    void inserir(T objeto) throws SQLException;
    
    void alterar(T objeto) throws SQLException;
    
    void deletar(T objeto) throws SQLException;
    
    T buscarPorId(T objeto) throws SQLException;
    
    List<T> listar(T objeto) throws SQLException;
}
