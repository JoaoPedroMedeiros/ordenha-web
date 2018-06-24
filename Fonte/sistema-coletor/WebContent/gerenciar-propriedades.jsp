<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <jsp:include page="common/dependencies.jsp" />
    <title>Menu</title>
</head>
<body>
    <jsp:include page="common/menu.jsp" />
    
    <div>
      <h1 class="body">Gerenciar Propriedades</h1>
    </div>
    <div id="conteudo">
    <table width="100%">
      <thead>
        <tr>
          <th align="left">Nome</th>
          <th align="left">Cnpj</th>
          <th align="left">Proprietário</th>
          <th align="left">Endereco</th>
          <th align="left">Telefone</th>
          <th align="left">Email</th>
          <th align="left">Periodicidade</th>
          <th align="left">Ação</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach items="${requestScope.propriedadeBeanList}" var="propriedade"> 
          <form action="/sistema-produtor/servlets/propriedade" method="get"> 
            <input type="hidden" id="id" name="id" value="${propriedade.id}"/>
            <tr>
              <td align="left"><c:out value="${propriedade.nome}" /></td>
              <td align="left"><c:out value="${propriedade.cnpj}" /></td>
              <td align="left"><c:out value="${propriedade.proprietario}" /></td>
              <td align="left"><c:out value="${propriedade.endereco}, ${propriedade.numero} - ${propriedade.complemento}" /></td>
              <td align="left"><c:out value="${propriedade.telefone}" /></td>
              <td align="left"><c:out value="${propriedade.email}" /></td>
              <td align="left"><c:out value="${propriedade.periodicidade}" /></td>
              <td align="left">
                <input class="btn" type="submit" value="Alterar" />
                <input class="btn" type="submit" value="Excluir" />
              </td>
            </tr>
          </form>
        </c:forEach>
      </tbody>
    </table>
  </div>
</body>
</html>
