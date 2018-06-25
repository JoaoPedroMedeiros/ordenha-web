package com.dac.coletor.servlet;

import java.io.IOException;
import java.sql.SQLException;
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

import com.dac.coletor.beans.ColetaBean;
import com.dac.coletor.beans.PropriedadeBean;
import com.dac.coletor.dao.ColetaDAO;
import com.dac.coletor.dao.PropriedadeDAO;

/**
 * Servlet implementation class ColetaServlet
 */
@WebServlet("/ColetaServlet")
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
		//Listar Coletas
		ColetaDAO coletaDAO = new ColetaDAO(null);
		ColetaBean coletaBean = new ColetaBean();
		PropriedadeBean propriedadeBean = new PropriedadeBean();
		List<ColetaBean> coletaBeanList = new ArrayList();
		
		try {
            if (request.getParameter("id") != null) {
                coletaBean.setId(Integer.parseInt(request.getParameter("id")));
                coletaBean = coletaDAO.buscarPorId(coletaBean);
                
                RequestDispatcher rd = getServletContext().getRequestDispatcher("?");
                rd.forward(request, response);
                return;
            } else {
            	if (request.getParameter("quantidade") != null) {
	                coletaBean.setQuantidade(Float.valueOf(request.getParameter("quantidade")));
	            }
		        if (request.getParameter("dataHora") != null) {
		                coletaBean.setDataHora(request.getParameter("dataHora"));
		        }
		        coletaBean.setPropriedade(propriedadeBean);
		        coletaBeanList = coletaDAO.listar(coletaBean);
		        
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/sistema-coletor/registro-coleta.jsp");
                rd.forward(request, response);
                return;
              }
        }catch(SQLException ex){
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
    		
    		//Inserir Coleta
	     	ColetaDAO coletaDAO = new ColetaDAO(null);
	     	ColetaBean coletaBean = new ColetaBean();
	     	PropriedadeBean propriedadeBean = new PropriedadeBean();
	     
	     	try {
	     		if (request.getParameter("id") != null) {
	                propriedadeBean.setId(Integer.parseInt(request.getParameter("id")));
	     		}
	     		
	            if (request.getParameter("quantidade") != null) {
	                coletaBean.setQuantidade(Float.valueOf(request.getParameter("quantidade")));
	            } 
		        if (request.getParameter("dataHora") != null) {
		            coletaBean.setDataHora(new SimpleDateFormat(request.getParameter("dataHora")));
		        } 
	     	 }catch (SQLException ex) {
	                ex.printStackTrace();
	              }
	            
	     	RequestDispatcher rd = getServletContext().getRequestDispatcher("/sistema-coletor/registro-coleta.jsp");
            rd.forward(request, response);
            
         }	else if (action.equals("excluir")) {
    	
        	 ColetaDAO coletaDAO = new ColetaDAO(null);
        	 ColetaBean coletaBean = new ColetaBean();
             
             try {
                 if (request.getParameter("id") != null) {
                     coletaBean.setId(Integer.parseInt(request.getParameter("id")));
                 }

                 coletaDAO.deletar(coletaBean);
             } catch (SQLException ex) {
                 ex.printStackTrace();
             }
             
             RequestDispatcher rd = getServletContext().getRequestDispatcher("/sistema-coletor/registro-coleta.jsp");
             rd.forward(request, response);
}
         else {
        	 RequestDispatcher rd = getServletContext().getRequestDispatcher("/sistema-coletor/erro.jsp");
             rd.forward(request, response);
         }
}
}
