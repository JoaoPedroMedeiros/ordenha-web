<%-- 
    Document   : portal
    Created on : 23/03/2018, 20:52:39
    Author     : Kevin
--%>

<%
    if (session.getAttribute("usuario") == null) {
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
        request.setAttribute("msg", "Usuário ou senha não encontrados");
        request.setAttribute("page", "index.jsp");
        rd.forward(request, response);
        return;
    }
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <meta charset="UTF8">
    <title>Desenvolvimento Web II</title>
    <head>
        <link rel="stylesheet" type="text/css" href="custom.css">
    </head>
    <%--   LABEL DA LOGO UFPR    --%>
    <img src="UFPR_Logo.jpg" width="120">
    <div style = "text-align: center">
        <body>
            <jsp:useBean id="usuario" class="com.ufpr.tads.web2.beans.LoginBean" scope="session" />
            <h1><jsp:getProperty name="usuario" property="nome" /></h1>
            <a href="/JavaWeb/LogoutServlet">LogoutServlet</a>
        </body>
</html>

<%--   LABEL DE RODAPÉ    --%>
<div style="margin: center">
    <footer class="footer">
        <jsp:useBean id="configuracao" class="com.ufpr.tads.web2.beans.ConfigBean" scope="application" />
        Em caso de problemas, entre em contato com o administrador do sistema: <jsp:getProperty name="configuracao" property="email" />
    </footer>
</div>

<%-- ******************************* 


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:useBean id="usuario" class="com.ufpr.tads.web2.beans.LoginBean" scope="session" />
        <h1><jsp:getProperty name="usuario" property="nome" /></h1>
        <a href="/JavaWeb/LogoutServlet">LogoutServlet</a>
    </body>
</html>
<footer>
    <jsp:useBean id="configuracao" class="com.ufpr.tads.web2.beans.ConfigBean" scope="application" />
    Em caso de problemas contactar o administrador: <jsp:getProperty name="configuracao" property="email" />
</footer>


--%>