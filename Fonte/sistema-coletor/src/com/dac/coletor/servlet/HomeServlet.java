package com.dac.coletor.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dac.coletor.dao.ColetaDAO;
import com.dac.coletor.dao.PropriedadeDAO;

@WebServlet(name = "Home", urlPatterns = "/servlets/home")
public class HomeServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int totalColetas = new ColetaDAO().coletasHoje();
            int totalPropriedades = new PropriedadeDAO().totalPropriedades();
            
            req.setAttribute("totalColetas", totalColetas);
            req.setAttribute("totalPropriedades", totalPropriedades);
            
            req.getRequestDispatcher("/home.jsp").forward(req, resp);

        } catch (SQLException e) {
            resp.sendError(500, "Erro ao contar informações");
        }
    }
}
