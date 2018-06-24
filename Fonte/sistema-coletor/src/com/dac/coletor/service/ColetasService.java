package com.dac.coletor.service;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.dac.coletor.beans.ColetaBean;
import com.dac.coletor.dao.ColetaDAO;

@Path("/coletas")
public class ColetasService {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response consultarColetas(
            @QueryParam("cnpj") String cnpj, 
            @QueryParam("ano") Integer ano, 
            @QueryParam("mes") Integer mes) {

        // Valida se o CNPJ foi preenchido
        // Valida se o ano foi preenchido
        // Valida se o mes foi preenchido
        // Valida se o ano está entre 2000 e o ano atual
        // Valida se o mês está entre 1 e 12 atual
        if (cnpj == null 
           || ano == null 
           || mes == null 
           || (ano < 2000 || ano > Calendar.getInstance().get(Calendar.YEAR))
           || (mes < 1 || mes > 12))

            // Se algum dos parâmetros estiver inválido, retorna Bad request
            return Response.status(Status.BAD_REQUEST).build();
        
        // Cria a DAO para consulta das coletas
        ColetaDAO coletaDAO = new ColetaDAO(null);
        
        try {
            // Realiza a listagem resumida das coletas
            List<ColetaBean> coletas = coletaDAO.listarResumido(cnpj, ano, mes);

            // Retorna um status Ok com as coletas no formato JSON
            return Response.ok(ColetasRespose.get(coletas), MediaType.APPLICATION_JSON).build();
        }
        catch (SQLException e) {
            // Se acontecer algum erro, retorna erro 500 (Server error)
            return Response.serverError().build();
        }
    }
    
    public static class ColetasRespose {
        
        private List<ColetaBean> coletas;

        public ColetasRespose(List<ColetaBean> coletas) {
            this.coletas = coletas;
        }
        
        public List<ColetaBean> getColetas() {
            return coletas;
        }

        public void setColetas(List<ColetaBean> coletas) {
            this.coletas = coletas;
        }
        
        public static ColetasRespose get(List<ColetaBean> coletas) {
            return new ColetasRespose(coletas); 
        }
    }
}
