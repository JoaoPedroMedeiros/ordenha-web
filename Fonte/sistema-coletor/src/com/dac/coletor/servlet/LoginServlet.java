
package com.dac.coletor.servlet;

import com.dac.coletor.beans.UsuarioBean;
import com.dac.coletor.dao.UsuarioDAO;
import com.dac.coletor.util.ErrorHandler;

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

@WebServlet(name = "Login", urlPatterns = { "/servlets/login" })
public class LoginServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NoSuchAlgorithmException {
        HttpSession session = request.getSession();
        session.setAttribute("usuario", null);

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        String login = request.getParameter("email");
        String senha = request.getParameter("password");

        try {
            if (senha == null || senha.isEmpty() || login == null || login.isEmpty()) {
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/login");
                if (login != null && !login.isEmpty()) {
                    request.setAttribute("email", login);
                    request.setAttribute("msg", "Preencha o campo Password");
                }
                rd.forward(request, response);

            } else {
                UsuarioBean usuario = usuarioDAO.validarLogin(login, senha);

                if (usuario == null) {
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/login");
                    request.setAttribute("msg", "Usuário/Senha inválidos");
                    request.setAttribute("email", login);
                    rd.forward(request, response);

                } else {
                    session.setAttribute("usuario", usuario);
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/home.jsp");
                    rd.forward(request, response);
                }
            }
        } catch (SQLException ex) {
            ErrorHandler.handleException(request, ex);
        }
    }

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
