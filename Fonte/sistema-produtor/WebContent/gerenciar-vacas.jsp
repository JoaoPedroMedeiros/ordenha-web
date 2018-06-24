<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
  <div id="conteudo">
    <form action="/sistema-produtor/servlets/vaca" method="get">
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
              <td align="left"><c:out value="${vaca.dataNascimento}" /></td>
              <td align="left"><c:out value="${vaca.peso}" /></td>
              <td align="left"><c:out value="${vaca.raca.descricao}" /></td>
              <td align="left"><c:out value="${vaca.observacao}" /></td>
              <td align="left">
                <table>
                  <tr>
                    <td>
                      <form action="/sistema-produtor/servlets/vaca" method="get">
                        input classE="btn" type="submit" value="Alterar" />
                        <input type="hidden" id="id" name="id" value="${vaca.id}"/>
                      </form>
                    </td>
                    <td>
                      <form action="/sistema-produtor/servlets/vaca" method="delete">
                        <input class="btn" type="submit" value="Excluir" />
                        <input type="hidden" id="id" name="id" value="${vaca.id}"/>
                      </form>
                    </td>
                  </tr>
                </table>
              </td>
            </tr>
          </c:forEach>
        </tbody>
      </table>
    </form>
  </div>
</body>
</html>
