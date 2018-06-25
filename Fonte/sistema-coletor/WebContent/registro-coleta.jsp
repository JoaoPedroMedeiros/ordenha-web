<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<jsp:include page="common/dependencies.jsp" />
<link rel="stylesheet"
    href="https://use.fontawesome.com/releases/v5.1.0/css/all.css"
    integrity="sha384-lKuwvrZot6UHsBSfcMvOkWwlCMgc0TaWr+30HWe3a4ltaBwTZhyTEggF5tJv8tbt"
    crossorigin="anonymous">
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<title>Registrar Coletas</title>
</head>
<body>
    <jsp:include page="common/menu.jsp" />

    <div class="body">

        <form class="form-inline" action="/sistema-coletor/servlets/coleta?action=inserir" method="POST">
            <fieldset>
                <!-- Form Name -->
                <legend>Dados da Coleta</legend>
                <div class="form-group"> 
                    <select id="idPropriedade" name="idPropriedade" class="col-md-4 form-control">
                        <c:forEach items="${ requestScope.propriedades }" var="propriedade">
                            <option value="${ propriedade.id }"><c:out value="${propriedade.nome}"></c:out></option>
                        </c:forEach>
                    </select>
                </div>

                <!-- Text input-->
                <div class="form-group">
                    <input id="quantidade" name="quantidade" type="text" placeholder="Quantidade (Litros de leite)" class="form-control input-md" required>
                </div>

                <div class="form-group">
                    <input type="datetime-local" class="form-control" id="dataHora" placeholder="2018-06-12T19:30" name="dataHora">
                </div>

                <!-- Button -->
                <div class="form-group">
                    <button id="registrarColeta" name="registrarColeta" class="btn btn-info">Registrar :)</button>
                </div>
            </fieldset>
        </form>
        <span style="color: red;"><c:out value="${ requestScope.msgValidacao }"></c:out></span>

        <br/>
        <br/>
        <div class="container" style="margin-left: 0px; padding-left: 0px; width: 100%">
            <h3>Últimas Coletas registradas</h3>
            <div class="table-striped">
                <table class="table">
                    <thead>
                        <tr>
                            <th style="width: 40%">Nome</th>
                            <th style="width: 27%;">Litros Coletados</th>
                            <th style="width: 27%;">Horário</th>
                            <th style="width: 6%;">Ação</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${requestScope.coletas}" var="coleta">
                            <tr>
                                <td><c:out value="${coleta.propriedade.nome}"></c:out></td>
     							<td><c:out value="${coleta.quantidade}"></c:out></td>
     							<td><fmt:formatDate pattern="dd/MM/yyyy hh:mm:ss" value="${coleta.dataHora}" /></td>
     							<form method="post" action="/sistema-coletor/servlets/coleta?action=excluir&id=${ coleta.id }">
                                    <td><button style="width: 40px" class="btn-default"><i class="fas fa-trash"></i></button></td>
                                </form>
 						    </tr>
                        </c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>

</body>
</html>
