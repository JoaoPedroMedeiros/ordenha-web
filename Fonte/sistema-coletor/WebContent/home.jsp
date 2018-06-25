<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <jsp:include page="common/dependencies.jsp" />
    <title>Menu</title>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
</head>
<body>
    <jsp:include page="common/menu.jsp" />
    <jsp:useBean id="usuario" class="com.dac.coletor.beans.UsuarioBean" scope="session"/>
    
    <div>
        <h1 class="body">
            <div class="row">
                <span>Bem vindo, 
                    <%
                       out.print(usuario != null ? usuario.getNome() : "Sem fazenda");
                    %>!
                </span>
            </div>
            <br/>
            <br/>
            <div class="row">
                <div class="col-md-5">
                    <div style="height: 160px; width:320px; opacity: 0.5; background-color: blue; margin-right: 10px;">
                        <div class="row" style="margin-left: 10px;">
                            <span style="color: white; margin-top: 5px; font-size: 27px">Coletas hoje</span>
                        </div>
                        <div class="row" style="margin-left: 10px;">
                            <div class="col-md-12">
                                <p style="color: white; width: 80%; font-size: 107px; text-align: right;"><c:out value="${requestScope.totalColetas}"></c:out></p>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-5">
                    <div style="height: 160px; width:320px; opacity: 0.5; background-color: blue;">
                        <div class="row" style="margin-left: 10px;">
                            <span style="color: white; margin-top: 5px; font-size: 27px">Total de Propriedades</span>
                        </div>
                        <div class="row" style="margin-left: 10px;">
                            <div class="col-md-12">
                                <p style="color: white; width: 80%; font-size: 107px; text-align: right;"><c:out value="${requestScope.totalPropriedades}"></c:out></p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        
        </h1>
    </div>
</body>
</html>
