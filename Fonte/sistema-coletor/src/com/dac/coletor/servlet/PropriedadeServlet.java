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
            if (request.getParameter("id") != null) {
                propriedadeBean.setId(Integer.parseInt(request.getParameter("id")));
                propriedadeBean = propriedadeDAO.buscarPorId(propriedadeBean);

                RequestDispatcher rd = getServletContext().getRequestDispatcher("/cadastrar-propriedade.jsp");
                request.setAttribute("propriedadeBean", propriedadeBean);
                rd.forward(request, response);
                return;
            } else {
                if (request.getParameter("cnpj") != null) {
                    propriedadeBean.setCnpj(request.getParameter("cnpj"));
                }
                if (request.getParameter("nome") != null) {
                    propriedadeBean.setCnpj(request.getParameter("nome"));
                }
                if (request.getParameter("endereco") != null) {
                    propriedadeBean.setCnpj(request.getParameter("endereco"));
                }
                if (request.getParameter("bairro") != null) {
                    propriedadeBean.setCnpj(request.getParameter("bairro"));
                }
                if (request.getParameter("numero") != null) {
                    propriedadeBean.setCnpj(request.getParameter("numero"));
                }
                if (request.getParameter("complemento") != null) {
                    propriedadeBean.setCnpj(request.getParameter("complemento"));
                }
                if (request.getParameter("telefone") != null) {
                    propriedadeBean.setCnpj(request.getParameter("telefone"));
                }
                if (request.getParameter("proprietario") != null) {
                    propriedadeBean.setCnpj(request.getParameter("proprietario"));
                }
                if (request.getParameter("email") != null) {
                    propriedadeBean.setCnpj(request.getParameter("email"));
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
                    estadoBean.setNome(request.getParameter("sigla"));
                }
                
                if (request.getParameter("id_cidade") != null) {
                    cidadeBean.setId(Integer.parseInt(request.getParameter("id_cidade")));
                }
                if (request.getParameter("nome_cidade") != null) {
                    cidadeBean.setNome(request.getParameter("nome_cidade"));
                }
                cidadeBean.setEstado(estadoBean);

                propriedadeBean.setCidade(cidadeBean);

                propriedadeBeanList = propriedadeDAO.listar(propriedadeBean);

                RequestDispatcher rd = getServletContext().getRequestDispatcher("/gerenciar-propriedades.jsp");
                request.setAttribute("propriedadeBeanList", propriedadeBeanList);
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
            if (request.getParameter("id") != null) {
                propriedadeBean.setId(Integer.parseInt(request.getParameter("id")));
            }
            if (request.getParameter("cnpj") != null) {
                propriedadeBean.setCnpj(request.getParameter("cnpj"));
            }
            if (request.getParameter("nome") != null) {
                propriedadeBean.setCnpj(request.getParameter("nome"));
            }
            if (request.getParameter("endereco") != null) {
                propriedadeBean.setCnpj(request.getParameter("endereco"));
            }
            if (request.getParameter("bairro") != null) {
                propriedadeBean.setCnpj(request.getParameter("bairro"));
            }
            if (request.getParameter("numero") != null) {
                propriedadeBean.setCnpj(request.getParameter("numero"));
            }
            if (request.getParameter("complemento") != null) {
                propriedadeBean.setCnpj(request.getParameter("complemento"));
            }
            if (request.getParameter("telefone") != null) {
                propriedadeBean.setCnpj(request.getParameter("telefone"));
            }
            if (request.getParameter("proprietario") != null) {
                propriedadeBean.setCnpj(request.getParameter("proprietario"));
            }
            if (request.getParameter("email") != null) {
                propriedadeBean.setCnpj(request.getParameter("email"));
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
                estadoBean.setNome(request.getParameter("sigla"));
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
            if (request.getParameter("cnpj") != null) {
                propriedadeBean.setCnpj(request.getParameter("cnpj"));
            }
            if (request.getParameter("nome") != null) {
                propriedadeBean.setCnpj(request.getParameter("nome"));
            }
            if (request.getParameter("endereco") != null) {
                propriedadeBean.setCnpj(request.getParameter("endereco"));
            }
            if (request.getParameter("bairro") != null) {
                propriedadeBean.setCnpj(request.getParameter("bairro"));
            }
            if (request.getParameter("numero") != null) {
                propriedadeBean.setCnpj(request.getParameter("numero"));
            }
            if (request.getParameter("complemento") != null) {
                propriedadeBean.setCnpj(request.getParameter("complemento"));
            }
            if (request.getParameter("telefone") != null) {
                propriedadeBean.setCnpj(request.getParameter("telefone"));
            }
            if (request.getParameter("proprietario") != null) {
                propriedadeBean.setCnpj(request.getParameter("proprietario"));
            }
            if (request.getParameter("email") != null) {
                propriedadeBean.setCnpj(request.getParameter("email"));
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
                estadoBean.setNome(request.getParameter("sigla"));
            }
            
            if (request.getParameter("id_cidade") != null) {
                cidadeBean.setId(Integer.parseInt(request.getParameter("id_cidade")));
            }
            if (request.getParameter("nome_cidade") != null) {
                cidadeBean.setNome(request.getParameter("nome_cidade"));
            }
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
            if (request.getParameter("id") != null) {
                propriedadeBean.setId(Integer.parseInt(request.getParameter("id")));
            }

            propriedadeDAO.deletar(propriedadeBean);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
