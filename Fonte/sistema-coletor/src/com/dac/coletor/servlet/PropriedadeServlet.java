package com.dac.coletor.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dac.coletor.beans.CidadeBean;
import com.dac.coletor.beans.EstadoBean;
import com.dac.coletor.beans.PropriedadeBean;
import com.dac.coletor.dao.PropriedadeDAO;

/**
 * Servlet implementation class PropriedadeServlet
 */
@WebServlet("/PropriedadeServlet")
public class PropriedadeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public PropriedadeServlet() {
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
        PropriedadeDAO propriedadeDAO = new PropriedadeDAO();
        PropriedadeBean propriedadeBean = new PropriedadeBean();
        CidadeBean cidadeBean = new CidadeBean();
        EstadoBean estadoBean = new EstadoBean();
        List<PropriedadeBean> propriedadeBeanList = new ArrayList();

        try {
            propriedadeBean.setId(Integer.parseInt(request.getParameter("id")));
            if (propriedadeBean.getId() != null) {
                propriedadeBean = propriedadeDAO.buscarPorId(propriedadeBean);

                RequestDispatcher rd = getServletContext().getRequestDispatcher("/index2.jsp");
                rd.forward(request, response);
                return;
            } else {
                propriedadeBean.setCnpj(request.getParameter("cnpj"));
                propriedadeBean.setNome(request.getParameter("nome"));
                propriedadeBean.setEndereco(request.getParameter("endereco"));
                propriedadeBean.setBairro(request.getParameter("bairro"));
                propriedadeBean.setNumero(request.getParameter("numero"));
                propriedadeBean.setComplemento(request.getParameter("complemento"));
                propriedadeBean.setTelefone(request.getParameter("telefone"));
                propriedadeBean.setProprietario(request.getParameter("proprietario"));
                propriedadeBean.setEmail(request.getParameter("email"));
                propriedadeBean.setPeriodicidade(Integer.parseInt(request.getParameter("periodicidade")));

                estadoBean.setId(Integer.parseInt(request.getParameter("id_estado")));
                estadoBean.setNome(request.getParameter("nome_estado"));
                estadoBean.setSigla(request.getParameter("sigla"));

                cidadeBean.setId(Integer.parseInt(request.getParameter("id_cidade")));
                cidadeBean.setNome(request.getParameter("nome_cidade"));
                cidadeBean.setEstado(estadoBean);

                propriedadeBean.setCidade(cidadeBean);

                propriedadeBeanList = propriedadeDAO.listar(propriedadeBean);

                RequestDispatcher rd = getServletContext().getRequestDispatcher("/index2.jsp");
                rd.forward(request, response);
                return;
            }
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
        PropriedadeDAO propriedadeDAO = new PropriedadeDAO();
        PropriedadeBean propriedadeBean = new PropriedadeBean();
        CidadeBean cidadeBean = new CidadeBean();
        EstadoBean estadoBean = new EstadoBean();

        try {
            propriedadeBean.setId(Integer.parseInt(request.getParameter("id")));
            propriedadeBean.setCnpj(request.getParameter("cnpj"));
            propriedadeBean.setNome(request.getParameter("nome"));
            propriedadeBean.setEndereco(request.getParameter("endereco"));
            propriedadeBean.setBairro(request.getParameter("bairro"));
            propriedadeBean.setNumero(request.getParameter("numero"));
            propriedadeBean.setComplemento(request.getParameter("complemento"));
            propriedadeBean.setTelefone(request.getParameter("telefone"));
            propriedadeBean.setProprietario(request.getParameter("proprietario"));
            propriedadeBean.setEmail(request.getParameter("email"));
            propriedadeBean.setPeriodicidade(Integer.parseInt(request.getParameter("periodicidade")));

            estadoBean.setId(Integer.parseInt(request.getParameter("id_estado")));
            estadoBean.setNome(request.getParameter("nome_estado"));
            estadoBean.setSigla(request.getParameter("sigla"));

            cidadeBean.setId(Integer.parseInt(request.getParameter("id_cidade")));
            cidadeBean.setNome(request.getParameter("nome_cidade"));
            cidadeBean.setEstado(estadoBean);

            propriedadeBean.setCidade(cidadeBean);

            propriedadeDAO.alterar(propriedadeBean);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // INSERIR
        PropriedadeDAO propriedadeDAO = new PropriedadeDAO();
        PropriedadeBean propriedadeBean = new PropriedadeBean();
        CidadeBean cidadeBean = new CidadeBean();
        EstadoBean estadoBean = new EstadoBean();

        try {
            propriedadeBean.setCnpj(request.getParameter("cnpj"));
            propriedadeBean.setNome(request.getParameter("nome"));
            propriedadeBean.setEndereco(request.getParameter("endereco"));
            propriedadeBean.setBairro(request.getParameter("bairro"));
            propriedadeBean.setNumero(request.getParameter("numero"));
            propriedadeBean.setComplemento(request.getParameter("complemento"));
            propriedadeBean.setTelefone(request.getParameter("telefone"));
            propriedadeBean.setProprietario(request.getParameter("proprietario"));
            propriedadeBean.setEmail(request.getParameter("email"));
            propriedadeBean.setPeriodicidade(Integer.parseInt(request.getParameter("periodicidade")));

            estadoBean.setId(Integer.parseInt(request.getParameter("id_estado")));
            estadoBean.setNome(request.getParameter("nome_estado"));
            estadoBean.setSigla(request.getParameter("sigla"));

            cidadeBean.setId(Integer.parseInt(request.getParameter("id_cidade")));
            cidadeBean.setNome(request.getParameter("nome_cidade"));
            cidadeBean.setEstado(estadoBean);

            propriedadeBean.setCidade(cidadeBean);

            propriedadeDAO.inserir(propriedadeBean);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // DELETAR
        PropriedadeDAO propriedadeDAO = new PropriedadeDAO();
        PropriedadeBean propriedadeBean = new PropriedadeBean();
        
        try {
            propriedadeBean.setId(Integer.parseInt(request.getParameter("id")));

            propriedadeDAO.deletar(propriedadeBean);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
