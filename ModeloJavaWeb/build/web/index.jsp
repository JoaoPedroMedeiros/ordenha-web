<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
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
    <div style="text-align: center; margin-bottom: 30px">
        <img style="text-align: center"src="UFPR_Logo.jpg" width="320">
    </div>
    <div style = "text-align: center">
        <body> 
            <%--   LABEL DO CAMPO DE LOGIN    --%>
            <div class="box-parent-login" style="width: 40%; margin: auto">
                <div class="well bg-white box-login" margin-top: 25px>
                     <form role="form" action="Login" method="POST" >
                        <div class="form-group ls-login-user">
                            <%--   LABEL DE LOGIN    --%>
                            <input for="userLogin" type="login" class="form-control ls-login-bg-user input-lg" id="login" name="login" type="text" aria-label="Usuário" placeholder="Digite seu usuário..." required autofocus>
                        </div>
                        <br>
                        <div class="form-group ls-login-password">
                            <%--   LABEL DE SENHA    --%>
                            <input for="userPassword" type="password" class="form-control ls-login-bg-password input-lg" id="senha" name="senha" type="password" aria-label="Senha" placeholder="Digite sua senha..." required autofocus>
                        </div>
                        <br>
                        <br>
                        <%--   LABEL DO BOTÃO ENTRAR    --%>
                        <input type="submit" value="Entrar" class="btn btn-primary btn-lg btn-block">
                    </form>
                </div>
            </div>
        </body>
    </div>
</html>

<%--   LABEL DE RODAPÉ    --%>
<div style="margin: center">
    <footer class="footer">
        <jsp:useBean id="configuracao" class="com.ufpr.tads.web2.beans.ConfigBean" scope="application" />
        Em caso de problemas, entre em contato com o administrador do sistema: <jsp:getProperty name="configuracao" property="email" />
    </footer>
</div>
