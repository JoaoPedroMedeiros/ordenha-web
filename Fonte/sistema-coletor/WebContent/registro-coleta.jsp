<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<jsp:include page="common/dependencies.jsp" />
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.1.0/css/all.css" integrity="sha384-lKuwvrZot6UHsBSfcMvOkWwlCMgc0TaWr+30HWe3a4ltaBwTZhyTEggF5tJv8tbt" crossorigin="anonymous">

<title>Registrar Coletas</title>
</head>
<body>
	<jsp:include page="common/menu.jsp" />

	<div class="body">

		<form class="form-inline" action="ColetaServlet?action=inserir" method="POST">
			<fieldset>
				<!-- Form Name -->
				<legend>Dados da Coleta</legend>
				<div class="form-group">
					<label class="col-xs-6 control-label" for="nomePropriedade">Nome
						da Propriedade:</label> <select id="nomePropriedade"
						name="nomePropriedade" class="form-control">
						<option value="1">Fazenda 1</option>
						<option value="2">Fazenda 2</option>
					</select>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="">Quantidade Coletada:</label> <input
						id="qtdeColetada" name="qtdeColetada" type="text"
						placeholder="em L de leite" class="form-control input-md" required>
				</div>
				
				<div class="form-group">
				<div class="row">
				<label class="col-md-4 control-label" for="">Data/Hora:</label> 
					<input type="datetime-local" class="form-control" id="dataHora"
						placeholder="2018-06-12T19:30" name="dataHora">
				</div>
                </div>
                
				<!-- Button -->
				<div class="form-group">
				<div class="row">
					<label class="col-md-4 control-label" for="registrarColeta"></label>
					<button id="registrarColeta" name="registrarColeta"
						class="btn btn-info">Ok</button>
				</div>
				</div>
			</fieldset>
		</form>
		<form action="/sistema-coletor/registro-coleta.jsp" method="post">
		<input type="hidden" id="acao" name="acao" value="ler"/>
		</form>
		<div class="container">
			<h3>Últimas Coletas registradas</h3>
			<div class="table-striped">
				<table class="table">
					<thead>
						<tr>
							<th>Nome</th>
							<th>Litros Coletados</th>
							<th>Horário</th>
							<th>Ação</th>
						</tr>
					</thead>
					<tbody>
					 <c:forEach items="${requestScope.coletaBeanList}" var="coleta">
						<tr>
							<td><c:out value="${coleta.quantidade}</td>
							<td></td>
							<td></td>
							<td><i class="fas fa-trash"></i></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>

</body>
</html>
