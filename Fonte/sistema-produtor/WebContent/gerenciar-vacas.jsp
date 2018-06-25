<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="pt-br">
  <head>
    <jsp:include page="common/dependencies.jsp" />
    <title>Menu</title>
</head>
<body>
    <jsp:include page="common/menu.jsp" />
    
    <div>
    <h1 class="body">Fazenda
      ${sessionScope.usuario.propriedade.nome}</h1>
  </div>
  <form action="/sistema-produtor/servlets/vaca" method="post"> 
    <input type="hidden" id="acao" name="acao" value="ler"/>
    <input class="btn" type="submit" value="Cadastrar"/>
  </form>
  <form action="/sistema-produtor/servlets/vaca" method="get"> 
    <input type="hidden" id="acao" name="acao" value="listar"/>
    Nome: <input type="text" id="nome" name="nome" value="${requestScope.vacaBean.nome}"/>
    </br>
    Raça: 
    <select name="id_raca">
      <option value="">--selecione</option>  
      <c:forEach items="${requestScope.racaBeanList}" var="raca">
        <c:if test="${requestScope.vacaBean.raca.id} == ${raca.id}">
          <%! String str = "selected"; %>
        </c:if> 
        <option <%=str%> value="${raca.id}">${raca.descricao}</option>
        <% str=""; %>
      </c:forEach>
    </select>
    </br>
    <input class="btn" type="submit" value="Pesquisar"/>
  </form>
  <div id="conteudo">
      <table width="100%">
        <thead>
          <tr>
            <th align="left">Nome</th>
            <th align="left">Data Nascimento</th>
            <th align="left">Peso</th>
            <th align="left">Raça</th>
            <th align="left">Observação</th>
            <th align="left">Ação</th>
          </tr>
        </thead>
        <tbody>
          <c:forEach items="${requestScope.vacaBeanList}" var="vaca">
              <tr>
                <td align="left"><c:out value="${vaca.nome}" /></td>
                <td align="left"><fmt:formatDate pattern = "dd/MM/yyyy" value="${vaca.dataNascimento}" /></td>
                <td align="left"><c:out value="${vaca.peso}" /></td>
                <td align="left"><c:out value="${vaca.raca.descricao}" /></td>
                <td align="left"><c:out value="${vaca.observacao}" /></td>
                <td align="left">
                  <form action="/sistema-produtor/servlets/vaca" method="post"> 
                    <input type="hidden" id="id" name="id" value="${vaca.id}"/>
                    <input type="hidden" id="acao" name="acao" value="ler"/>
                    <input class="btn" type="submit" value="Alterar" />
                  </form>
                  <form action="/sistema-produtor/servlets/vaca" method="post">
                    <input type="hidden" id="id" name="id" value="${vaca.id}"/>
                    <input type="hidden" id="acao" name="acao" value="deletar"/>
                    <input class="btn" type="submit" value="Excluir" />
                  </form>
                </td>
              </tr>
            </form>
          </c:forEach>
        </tbody>
      </table>
  </div>
</body>
</html>
