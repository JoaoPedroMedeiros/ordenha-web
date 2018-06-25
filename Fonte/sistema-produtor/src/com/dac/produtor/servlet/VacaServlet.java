package com.dac.produtor.servlet;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
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
@WebServlet(name = "Vaca", urlPatterns = { "/servlets/vaca" })
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
        if (request.getParameter("acao") != null) {
            String acao = request.getParameter("acao");
            
            VacaDAO vacaDAO = new VacaDAO();
            VacaBean vacaBean = new VacaBean();
            RacaBean racaBean = new RacaBean();
            List<VacaBean> vacaBeanList = new ArrayList();
            List<RacaBean> racaBeanList = new ArrayList();
            
            switch (acao) {
                case "listar":
                    try {
                        if (request.getParameter("nome") != null) {
                            vacaBean.setNome(request.getParameter("nome"));
                        }
                        if (request.getParameter("data_nascimento") != null) {
                            vacaBean.setDataNascimento(
                                    new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("data_nascimento")));
                        }
                        if (request.getParameter("peso") != null) {
                            vacaBean.setPeso(Float.parseFloat(request.getParameter("peso")));
                        }
                        if (request.getParameter("doente") != null) {
                            vacaBean.setDoente(Boolean.parseBoolean(request.getParameter("doente")));
                        }
                        if (request.getParameter("prenha") != null) {
                            vacaBean.setPrenha(Boolean.parseBoolean(request.getParameter("prenha")));
                        }
                        if (request.getParameter("observaca") != null) {
                            vacaBean.setObservacao(request.getParameter("observacao"));
                        }
                        if (request.getParameter("id_raca") != null) {
                            racaBean.setId(Integer.parseInt(request.getParameter("id_raca")));
                        }
                        vacaBean.setRaca(racaBean);
    
                        vacaBeanList = vacaDAO.listar(vacaBean);
    
                        RequestDispatcher rd = getServletContext().getRequestDispatcher("/gerenciar-vacas.jsp");
                        request.setAttribute("vacaBeanList", vacaBeanList);
                        rd.forward(request, response);
                        return;
                    } catch (ParseException ex) {
                        ex.printStackTrace();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                    break;
                default:
                    break;
            }
        }
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("acao") != null) {
            String acao = request.getParameter("acao");
            
            VacaDAO vacaDAO = new VacaDAO();
            VacaBean vacaBean = new VacaBean();
            RacaBean racaBean = new RacaBean();
            List<VacaBean> vacaBeanList = new ArrayList();
            List<RacaBean> racaBeanList = new ArrayList();
            
            switch (acao) {
                case "inserir":
                    try {
                        if (request.getParameter("nome") != null) {
                            vacaBean.setNome(request.getParameter("nome"));
                        }
                        if (request.getParameter("data_nascimento") != null) {
                            vacaBean.setDataNascimento(
                                    new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("data_nascimento")));
                        }
                        if (request.getParameter("peso") != null) {
                            vacaBean.setPeso(Float.parseFloat(request.getParameter("peso")));
                        }
                        if (request.getParameter("doente") != null) {
                            vacaBean.setDoente(Boolean.parseBoolean(request.getParameter("doente")));
                        }
                        if (request.getParameter("prenha") != null) {
                            vacaBean.setPrenha(Boolean.parseBoolean(request.getParameter("prenha")));
                        }
                        if (request.getParameter("observacao") != null) {
                            vacaBean.setObservacao(request.getParameter("observacao"));
                        }
                        if (request.getParameter("id_raca") != null) {
                            racaBean.setId(Integer.parseInt(request.getParameter("id_raca")));
                        }
                        vacaBean.setRaca(racaBean);

                        vacaDAO.inserir(vacaBean);
                        
                        VacaBean vacaBeanInserir = new VacaBean();
                        RacaBean racaBeanInserir = new RacaBean();
                        vacaBeanInserir.setRaca(racaBeanInserir);
                        vacaBeanList = vacaDAO.listar(vacaBeanInserir);

                        RequestDispatcher rd = getServletContext().getRequestDispatcher("/gerenciar-vacas.jsp");
                        request.setAttribute("vacaBeanList", vacaBeanList);
                        rd.forward(request, response);
                        return;
                    } catch (ParseException ex) {
                        ex.printStackTrace();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                    break;
                case "alterar":
                    try {
                        if (request.getParameter("id") != null) {
                            vacaBean.setId(Integer.parseInt(request.getParameter("id")));
                        }
                        if (request.getParameter("nome") != null) {
                            vacaBean.setNome(request.getParameter("nome"));
                        }
                        if (request.getParameter("data_nascimento") != null) {
                            vacaBean.setDataNascimento(
                                    new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("data_nascimento")));
                        }
                        if (request.getParameter("peso") != null) {
                            vacaBean.setPeso(Float.parseFloat(request.getParameter("peso")));
                        }
                        if (request.getParameter("doente") != null) {
                            vacaBean.setDoente(Boolean.parseBoolean(request.getParameter("doente")));
                        }
                        if (request.getParameter("prenha") != null) {
                            vacaBean.setPrenha(Boolean.parseBoolean(request.getParameter("prenha")));
                        }
                        if (request.getParameter("observacao") != null) {
                            vacaBean.setObservacao(request.getParameter("observacao"));
                        }
                        if (request.getParameter("id_raca") != null) {
                            racaBean.setId(Integer.parseInt(request.getParameter("id_raca")));
                        }
                        vacaBean.setRaca(racaBean);

                        vacaDAO.alterar(vacaBean);
                        
                        VacaBean vacaBeanAlterar = new VacaBean();
                        RacaBean racaBeanAlterar = new RacaBean();
                        vacaBeanAlterar.setRaca(racaBeanAlterar);
                        vacaBeanList = vacaDAO.listar(vacaBeanAlterar);

                        RequestDispatcher rd = getServletContext().getRequestDispatcher("/gerenciar-vacas.jsp");
                        request.setAttribute("vacaBeanList", vacaBeanList);
                        rd.forward(request, response);
                        return;
                    } catch (ParseException ex) {
                        ex.printStackTrace();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                    break;
                case "deletar":
                    try {
                        if (request.getParameter("id") != null) {
                            vacaBean.setId(Integer.parseInt(request.getParameter("id")));
                        }

                        vacaDAO.deletar(vacaBean);
                        
                        VacaBean vacaBeanDelete = new VacaBean();
                        RacaBean racaBeanDelete = new RacaBean();
                        vacaBeanDelete.setRaca(racaBeanDelete);
                        vacaBeanList = vacaDAO.listar(vacaBeanDelete);

                        RequestDispatcher rd = getServletContext().getRequestDispatcher("/gerenciar-vacas.jsp");
                        request.setAttribute("vacaBeanList", vacaBeanList);
                        rd.forward(request, response);
                        return;
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                    break;
                case "ler":
                    try {
                        if (request.getParameter("id") != null) {
                            vacaBean.setId(Integer.parseInt(request.getParameter("id")));
                            vacaBean = vacaDAO.buscarPorId(vacaBean);
                        }
                        
                        racaBeanList = vacaDAO.listarRacas(racaBean);

                        RequestDispatcher rd = getServletContext().getRequestDispatcher("/cadastrar-vaca.jsp");
                        request.setAttribute("vacaBean", vacaBean);
                        request.setAttribute("racaBeanList", racaBeanList);
                        rd.forward(request, response);
                        return;
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                    break;
                case "listar":
                    try {
                        if (request.getParameter("nome") != null) {
                            vacaBean.setNome(request.getParameter("nome"));
                        }
                        if (request.getParameter("data_nascimento") != null) {
                            vacaBean.setDataNascimento(
                                    new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("data_nascimento")));
                        }
                        if (request.getParameter("peso") != null) {
                            vacaBean.setPeso(Float.parseFloat(request.getParameter("peso")));
                        }
                        if (request.getParameter("doente") != null) {
                            vacaBean.setDoente(Boolean.parseBoolean(request.getParameter("doente")));
                        }
                        if (request.getParameter("prenha") != null) {
                            vacaBean.setPrenha(Boolean.parseBoolean(request.getParameter("prenha")));
                        }
                        if (request.getParameter("observaca") != null) {
                            vacaBean.setObservacao(request.getParameter("observacao"));
                        }
                        if (request.getParameter("id_raca") != null) {
                            racaBean.setId(Integer.parseInt(request.getParameter("id_raca")));
                        }
                        vacaBean.setRaca(racaBean);
    
                        vacaBeanList = vacaDAO.listar(vacaBean);
    
                        RequestDispatcher rd = getServletContext().getRequestDispatcher("/gerenciar-vacas.jsp");
                        request.setAttribute("vacaBeanList", vacaBeanList);
                        rd.forward(request, response);
                        return;
                    } catch (ParseException ex) {
                        ex.printStackTrace();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */

}
