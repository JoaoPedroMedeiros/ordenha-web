package com.dac.produtor.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dac.produtor.beans.OrdenhaBean;
import com.dac.produtor.beans.UsuarioBean;
import com.dac.produtor.beans.VacaBean;
import com.dac.produtor.beans.VacaOrdenhadaBean;
import com.dac.produtor.dao.OrdenhaDAO;
import com.dac.produtor.dao.VacaDAO;

@WebServlet(name = "Ordenha", urlPatterns = {"/servlets/ordenha"})
public class OrdenhaServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<VacaBean> vacas;
        try {
            vacas = new VacaDAO(LoginServlet.getUsuario(req, resp)).listar(null);
        }
        catch (SQLException e) {
            e.printStackTrace();
            resp.sendError(500, "Erro ao consultar vacas. " + e.getMessage());
            return;
        } 
        
        req.setAttribute("vacas", vacas);
        req.getRequestDispatcher("/cadastro-ordenha.jsp").forward(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        
        if ("inserir".equals(action)) {
            
            if (req.getParameter("dataHora") == null || req.getParameter("dataHora").isEmpty()) {
                req.setAttribute("msgValidacao", "Preencha a data e a hora");
                doGet(req, resp);
                return;
            }
            OrdenhaBean ordenha = new OrdenhaBean();
            try {
                ordenha.setDataHora(new SimpleDateFormat("yyyy-MM-ddhh:mm").parse(req.getParameter("dataHora").replace("T", "")));
            }
            catch (ParseException e1) {
                e1.printStackTrace();
                resp.sendError(500, "Erro ao ler a data. " + e1.getMessage());
                return;
            }
            ordenha.setVacas(new ArrayList<>());
            
            for (Entry<String, String[]> entry : req.getParameterMap().entrySet()) {
                String nome = entry.getKey();
                if (nome.contains("quantidade")) {
                    Float quantidade;
                    try {
                        quantidade = Float.valueOf(entry.getValue()[0]);
                    }
                    catch (NumberFormatException e) {
                        quantidade = null;
                    }
                    
                    if (quantidade != null && quantidade > 0) {
                        Integer idVaca = Integer.valueOf(nome.replaceAll("quantidade(\\d+)", "$1"));
                        
                        VacaOrdenhadaBean vacaOrdenhada = new VacaOrdenhadaBean();
                        VacaBean vaca = new VacaBean();
                        vaca.setId(idVaca);

                        vacaOrdenhada.setVaca(vaca);
                        vacaOrdenhada.setQuantidadeLeite(quantidade);
                        vacaOrdenhada.setOrdenha(ordenha);

                        ordenha.getVacas().add(vacaOrdenhada);
                    }                    
                }
            }
            
            if (ordenha.getVacas().isEmpty()) {
                req.setAttribute("msgValidacao", "Digite a quantidade pelo menos de uma vaca");
                doGet(req, resp);
                return;
            }
            
            try {
                new OrdenhaDAO(LoginServlet.getUsuario(req, resp)).inserir(ordenha);
            }
            catch (SQLException e) {
                e.printStackTrace();
                resp.sendError(500, "Erro cadastrar a ordenha. " + e.getMessage());
                return;
            }
            
            doGet(req, resp);
        }
        else if ("excluir".equals(action)) {
            
        }
        else {
            doGet(req, resp);
        }
    }
}
