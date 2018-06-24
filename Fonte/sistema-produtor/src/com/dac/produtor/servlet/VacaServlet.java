package com.dac.produtor.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dac.produtor.beans.RacaBean;
import com.dac.produtor.beans.VacaBean;
import com.dac.produtor.dao.VacaDAO;

/**
 * Servlet implementation class VacaServlet2
 */
@WebServlet("/VacaServlet2")
public class VacaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public VacaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // LISTAR OU LER
        VacaDAO vacaDAO = new VacaDAO();
        VacaBean vacaBean = new VacaBean();
        RacaBean racaBean = new RacaBean();
        List<VacaBean> vacaBeanList = new ArrayList();

        try {
            vacaBean.setId(Integer.parseInt(request.getParameter("id")));
            if (vacaBean.getId() != null) {
                vacaBean = vacaDAO.buscarPorId(vacaBean);

                RequestDispatcher rd = getServletContext().getRequestDispatcher("/index2.jsp");
                rd.forward(request, response);
                return;
            } else {
                vacaBean.setNome(request.getParameter("nome"));
                vacaBean.setDataNascimento(
                        new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("data_nascimento")));
                vacaBean.setPeso(Float.parseFloat(request.getParameter("peso")));
                vacaBean.setDoente(Boolean.parseBoolean(request.getParameter("doente")));
                vacaBean.setPrenha(Boolean.parseBoolean(request.getParameter("prenha")));
                vacaBean.setObservacao(request.getParameter("observacao"));
                racaBean.setId(Integer.parseInt(request.getParameter("id_raca")));
                vacaBean.setRaca(racaBean);

                vacaBeanList = vacaDAO.listar(vacaBean);

                RequestDispatcher rd = getServletContext().getRequestDispatcher("/index2.jsp");
                rd.forward(request, response);
                return;
            }
        } catch (ParseException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // ALTERAR
        VacaDAO vacaDAO = new VacaDAO();
        VacaBean vacaBean = new VacaBean();
        RacaBean racaBean = new RacaBean();

        try {
            vacaBean.setId(Integer.parseInt(request.getParameter("id")));
            vacaBean.setNome(request.getParameter("nome"));
            vacaBean.setDataNascimento(
                    new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("data_nascimento")));
            vacaBean.setPeso(Float.parseFloat(request.getParameter("peso")));
            vacaBean.setDoente(Boolean.parseBoolean(request.getParameter("doente")));
            vacaBean.setPrenha(Boolean.parseBoolean(request.getParameter("prenha")));
            vacaBean.setObservacao(request.getParameter("observacao"));
            racaBean.setId(Integer.parseInt(request.getParameter("id_raca")));
            vacaBean.setRaca(racaBean);

            vacaDAO.alterar(vacaBean);
        } catch (ParseException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // INSERIR
        VacaDAO vacaDAO = new VacaDAO();
        VacaBean vacaBean = new VacaBean();
        RacaBean racaBean = new RacaBean();

        try {
            vacaBean.setNome(request.getParameter("nome"));
            vacaBean.setDataNascimento(
                    new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("data_nascimento")));
            vacaBean.setPeso(Float.parseFloat(request.getParameter("peso")));
            vacaBean.setDoente(Boolean.parseBoolean(request.getParameter("doente")));
            vacaBean.setPrenha(Boolean.parseBoolean(request.getParameter("prenha")));
            vacaBean.setObservacao(request.getParameter("observacao"));
            racaBean.setId(Integer.parseInt(request.getParameter("id_raca")));
            vacaBean.setRaca(racaBean);

            vacaDAO.inserir(vacaBean);
        } catch (ParseException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // DELETAR
        VacaDAO vacaDAO = new VacaDAO();
        VacaBean vacaBean = new VacaBean();

        try {
            vacaBean.setId(Integer.parseInt(request.getParameter("id")));

            vacaDAO.deletar(vacaBean);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}