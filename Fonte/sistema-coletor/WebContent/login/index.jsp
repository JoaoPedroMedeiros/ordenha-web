<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <meta charset="utf-8">
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="styles/styleLogin.css" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
    <div class="login-page">
        <div class="login-box">
            <div class="side-left">
                <div class="conteudo">
                    <h2>Milk Colector</h2>
                    <p> Deixandos seu dia mais fresco desde 1920!</p>
                </div>
            </div>
            <div class="side-right">
                <img src="images/caminhao.png" alt="Logo" class="img-circle"><spam class="welcome"> Seja Bem-Vindo(a)!</spam>
                <h1>Login</h1>
                <form action="/sistema-coletor/servlets/login" method="post">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                        <input id="email" type="text" class="form-control" name="email" placeholder="Email">
                    </div>
                    <div class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                        <input id="password" type="password" class="form-control" name="password" placeholder="Password">
                    </div>
                    <p style="color: red;"><%= session.getAttribute("mensagemLogin") != null ? session.getAttribute("mensagemLogin") : "" %></p>
                    <div class="pull-left">
                        <br/>
                        <br/>
                        <input class="btn blue entrar" value="Entrar" type="submit">
                    </div>
<!--                     <div class="pull-right"> -->
<!--                         <a href="/recuperar-senha" class="forget-pass">Esqueceu a senha?</a> -->
<!--                         <br> -->
<!--                     </div> -->
                </form>
            </div>
        </div>
    </div>
</body>
</html>
