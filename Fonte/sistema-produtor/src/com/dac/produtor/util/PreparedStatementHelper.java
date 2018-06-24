package com.dac.produtor.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class PreparedStatementHelper {

    private final List<String> clauses = new LinkedList<>();
    
    private final List<Object> values = new LinkedList<>();
    
    private final String sql;
    
    private final int startWith;
    
    public PreparedStatementHelper(String sql) {
        this.sql = sql;
        this.startWith = 1;
    }
    
    public PreparedStatementHelper(String sql, int startWith) {
        this.sql = sql;
        this.startWith = startWith;
    }
    
    public PreparedStatementHelper setParameter(String clause, Object value) {
        this.clauses.add(clause);
        this.values.add(value);
        return this;
    }
    
    public PreparedStatement prepareStatement(Connection connection) throws SQLException {
        String sql = this.sql;

        // Adicionar todas as clausulas ao SQL original
        for (String clause : this.clauses) {
            sql += " " + clause + " ";
        }
        
        // Cria o preparedStatement com as cláusulas adicionadas
        PreparedStatement ps = connection.prepareStatement(sql);
        
        // Adiciona os parâmetros na ordem que foram adicionados se baseando no startWith
        for (int i = 0; i < this.values.size(); i++) {
            Object value = this.values.get(i);

            if (value instanceof Date) {
                ps.setTimestamp(i + startWith, new Timestamp(((Date) value).getTime()));
            }
            else if (value instanceof Integer) {
                ps.setInt(i + startWith, (Integer) value);
            }
            else if (value instanceof Long) {
                ps.setLong(i + startWith, (Long) value);
            }
            else if (value instanceof Double) {
                ps.setDouble(i + startWith, (Double) value);
            }
            else if (value instanceof Float) {
                ps.setFloat(i + startWith, (Float) value);
            }
            else {
                ps.setString(i + startWith, (String) value);
            }
        }
        
        return ps;
    }
}
