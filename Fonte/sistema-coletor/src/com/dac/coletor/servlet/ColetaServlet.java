package com.dac.coletor.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dac.coletor.beans.ColetaBean;
import com.dac.coletor.beans.PropriedadeBean;
import com.dac.coletor.dao.ColetaDAO;
import com.dac.coletor.dao.PropriedadeDAO;

/**
 * Servlet implementation class ColetaServlet
 */
@WebServlet(name = "Coleta", urlPatterns = {"/servlets/coleta"})
public class ColetaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ColetaServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

		try {
		    List<ColetaBean> coletas = new ColetaDAO().listar(null);
		    List<PropriedadeBean> propriedades = new PropriedadeDAO().listar(null);
		    
	        request.setAttribute("coletas", coletas);
	        request.setAttribute("propriedades", propriedades);
            getServletContext().getRequestDispatcher("/registro-coleta.jsp").forward(request, response);
        }
		catch(SQLException ex){
		      ex.printStackTrace();
	     }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String action = request.getParameter("action");

    	if (action.equals("inserir")) {
    		
    	    // Validação dos campos
    	    if (request.getParameter("idPropriedade") == null || request.getParameter("idPropriedade").isEmpty()) {
    	        request.setAttribute("msgValidacao", "Selecione uma propriedade");
    	        doGet(request, response);
    	        return;
    	    }
    	    
    	    if (request.getParameter("quantidade") == null || request.getParameter("quantidade").isEmpty()) {
                request.setAttribute("msgValidacao", "Preencha a quantidade");
                doGet(request, response);
                return;
            }
    	    
    	    if (request.getParameter("dataHora") == null || request.getParameter("dataHora").isEmpty()) {
                request.setAttribute("msgValidacao", "Preencha a data e a hora");
                doGet(request, response);
                return;
            }
    	    
	     	ColetaBean coletaBean = new ColetaBean();

 		    PropriedadeBean propriedade = new PropriedadeBean();
            propriedade.setId(Integer.parseInt(request.getParameter("idPropriedade")));
            coletaBean.setPropriedade(propriedade);
     		
            coletaBean.setQuantidade(Float.valueOf(request.getParameter("quantidade")));
             
            try {
                coletaBean.setDataHora(new SimpleDateFormat("yyyy-MM-ddhh:mm").parse(request.getParameter("dataHora").replace("T", "")));
            }
            catch (ParseException e) {
                e.printStackTrace();
                response.sendError(500, "Erro ao convertar a data");
                return;
            }
	         
            ColetaDAO coletaDao = new ColetaDAO();
            try {
                coletaDao.inserir(coletaBean);
            }
            catch (SQLException e) {
                e.printStackTrace();
                response.sendError(500, "Erro ao registrar a coleta. " + e.getMessage());
                return;
            }
            
	     	doGet(request, response);
            
         }	else if (action.equals("excluir")) {
    	
        	 ColetaDAO coletaDAO = new ColetaDAO();
        	 ColetaBean coletaBean = new ColetaBean();
        	 
             
        	 if (request.getParameter("id") == null) {
                 doGet(request, response);
                 return;
             }
        	 
        	 coletaBean.setId(Integer.valueOf(request.getParameter("id")));
             
             try {
                 coletaDAO.deletar(coletaBean);

             } catch (SQLException ex) {
                 ex.printStackTrace();
                 response.sendError(500, "Erro ao excluir a coleta. " + ex.getMessage());
                 return;
             }
             
             doGet(request, response);
         }
         else {
             doGet(request, response);
         }
	}
}
