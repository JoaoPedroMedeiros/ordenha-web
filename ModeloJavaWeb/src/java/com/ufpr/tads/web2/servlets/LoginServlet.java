
package com.ufpr.tads.web2.servlets;

import com.ufpr.tads.web2.beans.LoginBean;
import com.ufpr.tads.web2.beans.User;
import com.ufpr.tads.web2.dao.UsuarioDAO;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.DatatypeConverter;

@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class LoginServlet extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, NoSuchAlgorithmException {
            
        HttpSession session = request.getSession();

        if(session.getAttribute("usuario") != null){
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/portal.jsp");
            rd.forward(request, response);
            return;
        } else {
            String senha = request.getParameter("senha");
            String login = request.getParameter("login");

            
            User usuario = obterUsuario(login);
            
            if(usuario.getLogin() == null){
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
                request.setAttribute("msg", "Usuário/Senha inválidos.");
                request.setAttribute("page", "index.jsp");
                rd.forward(request, response);
                return; 
            } else {
                Boolean fl_senha = verificarSenha(usuario.getSenha(), senha);
                if(fl_senha){
                    LoginBean userLogin = new LoginBean();
                    userLogin.setId(usuario.getId());
                    userLogin.setNome(usuario.getNome());
                    
                    session.setAttribute("usuario", userLogin);
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/portal.jsp");
                    rd.forward(request, response);
                    return;
                }else{
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
                    request.setAttribute("msg", "Usuário/Senha inválidos.");
                    request.setAttribute("page", "index.jsp");
                    rd.forward(request, response);
                    return;
                }  
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

    private boolean verificarSenha(String senhaDB, String senha) throws NoSuchAlgorithmException{
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(senha.getBytes());
        byte[] digest = md.digest();
        String myHash = DatatypeConverter.printHexBinary(digest);
        senhaDB = senhaDB.toUpperCase();
        
        if(myHash.equals(senhaDB))
            return true;
        else
            return false;
    }

    private User obterUsuario(String login) {
        User usuario = new User();
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        
        usuario = usuarioDAO.Pesquisar(login);
        
        return usuario;
    }
}
