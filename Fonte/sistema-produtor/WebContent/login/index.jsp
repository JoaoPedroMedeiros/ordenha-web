<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
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
                <h2>Ordenha WEB</h2>
                <p>Promovendo confiança e produtividade em cada ordenha!</p>
            </div>
        </div>
        <div class="side-right">
            <img src="images/cow_bonitona.png" alt="Logo" class="img-rounded"><spam class="welcome"> Seja Bem-Vindo(a)!</spam>
            <h1>Login</h1>
            <div class="container">
            <form action="/sistema-produtor/servlets/login" method="post" class="col-sm-4 col-md-4">
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
                  <!--  <input name="remember" value="1" id="lembrar" type="checkbox"><label for="lembrar" class="checkbox">Lembrar</label>-->
                    <br>
                    <input class="btn blue entrar" value="Entrar" type="submit">
                </div>
                <div class="pull-right">
                    <a href="/recuperar-senha" class="forget-pass">Esqueceu a senha?</a>
                    <br>
                </div>
            </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>