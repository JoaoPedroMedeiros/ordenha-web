package com.dac.produtor.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

import com.dac.coletor.beans.ColetaBean;
import com.dac.coletor.service.ColetasService.ColetasRespose;
import com.dac.produtor.beans.MovimentoColetaBean;
import com.dac.produtor.beans.MovimentoOrdenhaBean;
import com.dac.produtor.beans.MovimentoTanqueBean;
import com.dac.produtor.beans.OrdenhaBean;
import com.dac.produtor.dao.OrdenhaDAO;

@WebServlet(name = "Ordenha", urlPatterns = {"/Ordenha"})
public class MovimentoTanqueServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ano = req.getParameter("ano");
        String mes = req.getParameter("mes");
        
        if (ano == null || mes == null) {
            resp.sendError(400, "Ano e mês precisam ser preenchidos");
            return;
        }
            
        List<OrdenhaBean> ordenhas;
        try {
            ordenhas = new OrdenhaDAO(1).listarPorMes(Integer.valueOf(ano), Integer.valueOf(mes));
        }
        catch (NumberFormatException e) {
            resp.setStatus(400);
            resp.sendError(400, "Ano/mês não numéricos");
            return;
        } 
        catch (SQLException e) {
            e.printStackTrace();
            resp.setStatus(500);
            resp.sendError(500, "Erro ao consultar ordenhas");
            return;
        }
        
        List<MovimentoTanqueBean> movimentos = new ArrayList<>();

        for (OrdenhaBean ordenha : ordenhas) {
            MovimentoOrdenhaBean movimentoOrdenha = new MovimentoOrdenhaBean();
            movimentoOrdenha.setOrdenha(ordenha);
            movimentos.add(movimentoOrdenha);
        }
        
        try {
            Client client = ClientBuilder.newClient();
    
            ColetasRespose coletasResponse = 
                client
                    .target("http://localhost:8080/sistema-coletor/rest/coletas?cnpj=12345&ano=2018&mes=6")
                    .request(MediaType.APPLICATION_JSON)
                    .get(ColetasRespose.class);
            
            if (coletasResponse != null && coletasResponse.getColetas() != null)
                movimentos.addAll(coletasResponse.getColetas());
        }
        catch (Exception e) {
            e.printStackTrace();
            resp.setStatus(500);
            resp.sendError(500, "Erro ao consultar coletas no webservice");
            return;
        }
        
        System.out.println(movimentos);
    }
    
    public static class ColetasRespose {
        
        private List<MovimentoColetaBean> coletas;

        public ColetasRespose() {
        }
        
        public ColetasRespose(List<MovimentoColetaBean> coletas) {
            this.coletas = coletas;
        }
        
        public List<MovimentoColetaBean> getColetas() {
            return coletas;
        }

        public void setColetas(List<MovimentoColetaBean> coletas) {
            this.coletas = coletas;
        }
        
        public static ColetasRespose get(List<MovimentoColetaBean> coletas) {
            return new ColetasRespose(coletas); 
        }
    }
}
