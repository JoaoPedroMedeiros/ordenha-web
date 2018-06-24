
package com.dac.produtor.servlet;

import com.dac.produtor.beans.UsuarioBean;
import com.dac.produtor.dao.UsuarioDAO;
import com.dac.produtor.util.ErrorHandler;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "Login", urlPatterns = { "/Login" })
public class LoginServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NoSuchAlgorithmException {
        HttpSession session = request.getSession();
        session.setAttribute("usuario", null);

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        String login = request.getParameter("email");
        String senha = request.getParameter("password");
        try {
            if (senha == null || login == null) {
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/index2.jsp");
                request.setAttribute("msg", "Usuário/Senha inválidos.");
                request.setAttribute("page", "index.jsp");
                rd.forward(request, response);
                return;
            }
            UsuarioBean usuario = usuarioDAO.validarLogin(login, senha);
            if (usuario == null) {
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/index2.jsp");
                request.setAttribute("msg", "Usuário/Senha inválidos.");
                request.setAttribute("page", "index.jsp");
                rd.forward(request, response);
                return;
            } else {
                session.setAttribute("usuario", usuario);
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
                rd.forward(request, response);
                return;
            }
        } catch (SQLException ex) {
            ErrorHandler.handleException(request, ex);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the
    // + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request
     *            servlet request
     * @param response
     *            servlet response
     * @throws ServletException
     *             if a servlet-specific error occurs
     * @throws IOException
     *             if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}