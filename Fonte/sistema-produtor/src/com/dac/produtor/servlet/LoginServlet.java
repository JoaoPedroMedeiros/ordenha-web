
package com.dac.produtor.servlet;

import com.dac.produtor.beans.UsuarioBean;
import com.dac.produtor.dao.UsuarioDAO;
import com.dac.produtor.util.ErrorHandler;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "Login", urlPatterns = { "/servlets/login" })
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NoSuchAlgorithmException {
        HttpSession session = request.getSession();
        session.setAttribute("usuario", null);
        session.setAttribute("mensagemLogin", null);

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        String login = request.getParameter("email");
        String senha = request.getParameter("password");

        try {
            if (senha == null || senha.isEmpty() || login == null || login.isEmpty()) {
                session.setAttribute("mensagemLogin", "Por favor, preencha os campos de login e senha");
                response.sendRedirect("/sistema-produtor/login/");

            }
            else {
                UsuarioBean usuario = usuarioDAO.validarLogin(login, senha);

                if (usuario == null) {
                    session.setAttribute("mensagemLogin", "Usuário ou senha inválidos");
                    response.sendRedirect("/sistema-produtor/login/");
                }
                else {
                    session.setAttribute("usuario", usuario);
                    response.sendRedirect("/sistema-produtor/servlets/movimento-tanque");
                }
            }
        } catch (SQLException ex) {
            ErrorHandler.handleException(request, ex);
        }
    }

    public static UsuarioBean getUsuario(HttpServletRequest request, HttpServletResponse response) throws IOException {
        UsuarioBean usuario = (UsuarioBean) request.getSession().getAttribute("usuario");
        
        if (usuario == null) {
            response.sendRedirect("/sistema-produtor/login/");
            throw new NullPointerException("Usuário não existe na sessão");
        }
        
        return usuario;
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