<%-- 
    Document   : erro
    Created on : 23/03/2018, 20:53:39
    Author     : Kevin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Erro JSP</title>
    </head>
    <body>
        <h1><%=(String)request.getAttribute("msg")%></h1>
        <a href="<%=(String)request.getAttribute("page")%>"><%=(String)request.getAttribute("page")%></a>
    </body>
</html>
<footer>
    <jsp:useBean id="configuracao" class="com.ufpr.tads.web2.beans.ConfigBean" scope="application" />
    Em caso de problemas contactar o administrador: <jsp:getProperty name="configuracao" property="email" />
</footer>
