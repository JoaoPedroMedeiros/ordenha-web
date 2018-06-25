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

import com.dac.produtor.beans.RacaBean;
import com.dac.produtor.beans.VacaBean;
import com.dac.produtor.dao.VacaDAO;

/**
 * Servlet implementation class PropriedadeServlet
 */
@WebServlet(name = "Propriedade", urlPatterns = { "/servlets/propriedade" })
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    if (request.getParameter("acao") != null) {
            String acao = request.getParameter("acao");
            
            PropriedadeDAO propriedadeDAO = new Propriedade();
            PropriedadeBean propriedadeBean = new PropriedadeBean();
            CidadeBean cidadeBean = new CidadeBean();
            EstadoBean estadoBean = new EstadoBean();
            List<PropriedadeBean> propriedadeBeanList = new ArrayList();
            List<CidadeBean> cidadeBeanList = new ArrayList();
            List<EstadoBean> estadoBeanList = new ArrayList();
            
            switch (acao) {
                case "listar":
                    try {
                        if (request.getParameter("nome") != null) {
                            propriedadeBean.setNome(request.getParameter("nome"));
                        }
                        if (request.getParameter("cnpj") != null) {
                            propriedadeBean.setCnpj(request.getParameter("cnpj"));
                        }
                        if (request.getParameter("telefone") != null) {
                            propriedadeBean.setCnpj(request.getParameter("telefone"));
                        }
                        if (request.getParameter("proprietario") != null) {
                            propriedadeBean.setCnpj(request.getParameter("proprietario"));
                        }
                        if (request.getParameter("id_estado") != null) {
                            estadoBean.setId(Integer.parseInt(request.getParameter("id_estado")));
                        }
                        if (request.getParameter("id_cidade") != null) {
                            cidadeBean.setId(Integer.parseInt(request.getParameter("id_cidade")));
                        }
                        cidadeBean.setEstado(estadoBean)
                        propriedadeBean.setCidade(cidadeBean);
    
                        propriedadeBeanList = propriedadeDAO.listar(propriedadeBean);
    
                        RequestDispatcher rd = getServletContext().getRequestDispatcher("/gerenciar-propriedades.jsp");
                        request.setAttribute("propriedadeBeanList", propriedadeBeanList);
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        if (request.getParameter("acao") != null) {
	            String acao = request.getParameter("acao");
	            
	            PropriedadeDAO propriedadeDAO = new Propriedade();
	            PropriedadeBean propriedadeBean = new PropriedadeBean();
	            CidadeBean cidadeBean = new CidadeBean();
	            EstadoBean estadoBean = new EstadoBean();
	            List<PropriedadeBean> propriedadeBeanList = new ArrayList();
	            List<CidadeBean> cidadeBeanList = new ArrayList();
	            List<EstadoBean> estadoBeanList = new ArrayList();
	            
	            switch (acao) {
	                case "inserir":
	                    try {
                            if (request.getParameter("cnpj") != null) {
                                propriedadeBean.setCnpj(request.getParameter("cnpj"));
                            }
                            if (request.getParameter("nome") != null) {
                                propriedadeBean.setNome(request.getParameter("nome"));
                            }
                            if (request.getParameter("endereco") != null) {
                                propriedadeBean.setEndereco(request.getParameter("endereco"));
                            }
                            if (request.getParameter("bairro") != null) {
                                propriedadeBean.setBairro(request.getParameter("bairro"));
                            }
                            if (request.getParameter("numero") != null) {
                                propriedadeBean.setNumero(request.getParameter("numero"));
                            }
                            if (request.getParameter("complemento") != null) {
                                propriedadeBean.setComplemento(request.getParameter("complemento"));
                            }
                            if (request.getParameter("telefone") != null) {
                                propriedadeBean.setTelefone(request.getParameter("telefone"));
                            }
                            if (request.getParameter("proprietario") != null) {
                                propriedadeBean.setProprietario(request.getParameter("proprietario"));
                            }
                            if (request.getParameter("periodicidade") != null) {
                                propriedadeBean.setPeriodicidade(Integer.parseInt(request.getParameter("periodicidade")));
                            }
                            if (request.getParameter("id_estado") != null) {
                                estadoBean.setId(Integer.parseInt(request.getParameter("id_estado")));
                            }
                            if (request.getParameter("nome_estado") != null) {
                                estadoBean.setNome(request.getParameter("nome_estado"));
                            }
                            if (request.getParameter("sigla") != null) {
                                estadoBean.setSigla(request.getParameter("sigla"));
                            }
                            if (request.getParameter("id_cidade") != null) {
                                cidadeBean.setId(Integer.parseInt(request.getParameter("id_cidade")));
                            }
                            if (request.getParameter("nome_cidade") != null) {
                                cidadeBean.setNome(request.getParameter("nome_cidade"));
                            }
                            cidadeBean.setEstado(estadoBean);
                            
                            propriedadeBean.setCidade(cidadeBean);

                            propriedadeDAO.alterar(propriedadeBean);
	                        
	                        PropriedadeBean propriedadeBeanInserir = new PropriedadeBean();
                            CidadeBean cidadeBeanInserir = new CidadeBean();
                            EstadoBean estadoBeanInserir = new EstadoBean();
                            cidadeBeanInserir.setEstado(estadoBeanInserir);
                            propriedadeBeanInserir.setCidade(cidadeBeanInserir);
                            propriedadeBeanList = propriedadeDAO.listar(propriedadeBeanInserir);

                            RequestDispatcher rd = getServletContext().getRequestDispatcher("/gerenciar-propriedades.jsp");
                            request.setAttribute("propriedadeBeanList", propriedadeBeanList);
                            rd.forward(request, response);
	                    } catch (ParseException ex) {
	                        ex.printStackTrace();
	                    } catch (SQLException ex) {
	                        ex.printStackTrace();
	                    }
	                    break;
	                case "alterar":
	                    try {
	                        if (request.getParameter("id") != null) {
	                            propriedadeBean.setId(Integer.parseInt(request.getParameter("id")));
	                        }
	                        if (request.getParameter("cnpj") != null) {
                                propriedadeBean.setCnpj(request.getParameter("cnpj"));
                            }
	                        if (request.getParameter("nome") != null) {
                                propriedadeBean.setNome(request.getParameter("nome"));
                            }
	                        if (request.getParameter("endereco") != null) {
                                propriedadeBean.setEndereco(request.getParameter("endereco"));
                            }
	                        if (request.getParameter("bairro") != null) {
                                propriedadeBean.setBairro(request.getParameter("bairro"));
                            }
	                        if (request.getParameter("numero") != null) {
                                propriedadeBean.setNumero(request.getParameter("numero"));
                            }
	                        if (request.getParameter("complemento") != null) {
                                propriedadeBean.setComplemento(request.getParameter("complemento"));
                            }
	                        if (request.getParameter("telefone") != null) {
                                propriedadeBean.setTelefone(request.getParameter("telefone"));
                            }
	                        if (request.getParameter("proprietario") != null) {
                                propriedadeBean.setProprietario(request.getParameter("proprietario"));
                            }
	                        if (request.getParameter("periodicidade") != null) {
                                propriedadeBean.setPeriodicidade(Integer.parseInt(request.getParameter("periodicidade")));
                            }
	                        if (request.getParameter("id_estado") != null) {
	                            estadoBean.setId(Integer.parseInt(request.getParameter("id_estado")));
                            }
	                        if (request.getParameter("nome_estado") != null) {
                                estadoBean.setNome(request.getParameter("nome_estado"));
                            }
	                        if (request.getParameter("sigla") != null) {
                                estadoBean.setSigla(request.getParameter("sigla"));
                            }
	                        if (request.getParameter("id_cidade") != null) {
	                            cidadeBean.setId(Integer.parseInt(request.getParameter("id_cidade")));
                            }
	                        if (request.getParameter("nome_cidade") != null) {
	                            cidadeBean.setNome(request.getParameter("nome_cidade"));
                            }
	                        cidadeBean.setEstado(estadoBean);
	                        
	                        propriedadeBean.setCidade(cidadeBean);

	                        propriedadeDAO.alterar(propriedadeBean);
	                        
	                        PropriedadeBean propriedadeBeanAlterar = new PropriedadeBean();
	                        CidadeBean cidadeBeanAlterar = new CidadeBean();
	                        EstadoBean estadoBeanAlterar = new EstadoBean();
	                        cidadeBeanAlterar.setEstado(estadoBeanAlterar);
	                        propriedadeBeanAlterar.setCidade(cidadeBeanAlterar);
	                        propriedadeBeanList = propriedadeDAO.listar(propriedadeBeanAlterar);

	                        RequestDispatcher rd = getServletContext().getRequestDispatcher("/gerenciar-propriedades.jsp");
	                        request.setAttribute("propriedadeBeanList", propriedadeBeanList);
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
                                propriedadeBean.setId(Integer.parseInt(request.getParameter("id")));
                            }

	                        vacaDAO.deletar(vacaBean);
	                        
	                        PropriedadeBean propriedadeBeanDeletar = new PropriedadeBean();
                            CidadeBean cidadeBeanDeletar = new CidadeBean();
                            EstadoBean estadoBeanDeletar = new EstadoBean();
                            cidadeBeanDeletar.setEstado(estadoBeanDeletar);
                            propriedadeBeanDeletar.setCidade(cidadeBeanDeletar);
                            propriedadeBeanList = propriedadeDAO.listar(propriedadeBeanDeletar);

                            RequestDispatcher rd = getServletContext().getRequestDispatcher("/gerenciar-propriedades.jsp");
                            request.setAttribute("propriedadeBeanList", propriedadeBeanList);
                            rd.forward(request, response);
                            return;
	                    } catch (SQLException ex) {
	                        ex.printStackTrace();
	                    }
	                    break;
	                case "ler":
	                    try {
	                        if (request.getParameter("id") != null) {
                                propriedadeBean.setId(Integer.parseInt(request.getParameter("id")));
                                propriedadeBean = propriedadeDAO.buscarPorId(propriedadeBean);
                            }
	                        
	                        cidadeBeanList = propriedadeDAO.listarCidades(cidadeBean);

	                        RequestDispatcher rd = getServletContext().getRequestDispatcher("/cadastrar-propriedade.jsp");
	                        request.setAttribute("vacaBean", vacaBean);
	                        request.setAttribute("cidadeBeanList", cidadeBeanList);
	                        rd.forward(request, response);
	                        return;
	                    } catch (SQLException ex) {
	                        ex.printStackTrace();
	                    }
	                    break;
	                default:
	                    break;
	            }
	        }
	    }

}
