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
    <form action="/sistema-coletor/servlets/propriedade" method="post"> 
      <input type="hidden" id="acao" name="acao" value="ler"/>
      <input class="btn" type="submit" value="Cadastrar"/>
    </form>
    <form action="/sistema-coletor/servlets/propriedade" method="get"> 
    <input type="hidden" id="acao" name="acao" value="listar"/>
    Nome: <input type="text" id="nome" name="nome" value="${requestScope.propriedadeBean.nome}"/>
    </br>
    Cnpj: <input type="text" id="cnpj" name="cnpj" value="${requestScope.propriedadeBean.cnpj}"/>
    </br>
    Cidade: 
    <select name="id_cidade">
      <option value="">--selecione</option>  
      <c:forEach items="${requestScope.cidadeBeanList}" var="cidade">
        <c:if test="${requestScope.propriedadeBean.cidade.id} == ${cidade.id}">
          <%! String str = "selected"; %>
        </c:if>
        <option <%=str%> value="${cidade.id}">${cidade.nome} - ${cidade.estado.sigla}</option>
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
          <th align="left">Cnpj</th>
          <th align="left">Proprietário</th>
          <th align="left">Endereco</th>
          <th align="left">Bairro</th>
          <th align="left">Cidade</th>
          <th align="left">Telefone</th>
          <th align="left">Email</th>
          <th align="left">Periodicidade</th>
          <th align="left">Ação</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach items="${requestScope.propriedadeBeanList}" var="propriedade">
          <tr>
            <td align="left"><c:out value="${propriedade.nome}" /></td>
            <td align="left"><c:out value="${propriedade.cnpj}" /></td>
            <td align="left"><c:out value="${propriedade.proprietario}" /></td>
            <td align="left"><c:out value="${propriedade.endereco}, ${propriedade.numero} - ${propriedade.complemento}" /></td>
            <td align="left"><c:out value="${propriedade.bairro}" /></td>
            <td align="left"><c:out value="${propriedade.cidade.nome} - ${propriedade.cidade.estado.sigla}" /></td>
            <td align="left"><c:out value="${propriedade.telefone}" /></td>
            <td align="left"><c:out value="${propriedade.email}" /></td>
            <td align="left"><c:out value="${propriedade.periodicidade}" /></td>
            <td align="left">
              <form action="/sistema-coletor/servlets/propriedade" method="post">
                <input type="hidden" id="id" name="id" value="${propriedade.id}"/>
                <input type="hidden" id="acao" name="acao" value="ler"/> 
                <input class="btn" type="submit" value="Alterar" />
              </form>
              <form action="/sistema-coletor/servlets/propriedade" method="post">
                <input type="hidden" id="id" name="id" value="${propriedade.id}"/>
                <input type="hidden" id="acao" name="acao" value="deletar"/> 
                <input class="btn" type="submit" value="Excluir" />
              </form>
            </td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
  </div>
</body>
</html>
