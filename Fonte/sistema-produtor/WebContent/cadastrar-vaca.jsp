<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
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
  <div id="conteudo">
    <form action="/sistema-produtor/servlets/vaca" method="post"> 
      <input type="hidden" id="id" name="id" value="${requestScope.vacaBean.id}"/>
      <c:choose>
        <c:when test="${requestScope.vacaBean.id != null}">
              <input type="hidden" id="acao" name="acao" value="alterar"/>
          </c:when>    
          <c:otherwise>
              <input type="hidden" id="acao" name="acao" value="inserir"/>
          </c:otherwise>
      </c:choose>
      Nome: <input type="text" id="nome" name="nome" value="${requestScope.vacaBean.nome}"/>
      </br>
      <fmt:formatDate value="${requestScope.vacaBean.dataNascimento}"  
                type="date" 
                pattern="dd/MM/yyyy"
                var="theFormattedDate" />
      Data Nascimento: <input type="text" id="data_nascimento" name="data_nascimento" value="${theFormattedDate}"/>
      </br>
      Peso: <input type="text" id="peso" name="peso" value="${requestScope.vacaBean.peso}"/>
      </br>
      Observação: <input type="text" id="observacao" name="observacao" value="${requestScope.vacaBean.observacao}"/>
      </br>
      Raça: 
      <select name="id_raca">  
        <c:forEach items="${requestScope.racaBeanList}" var="raca"> 
          <option value="${raca.id}">${raca.descricao}</option>
        </c:forEach>
      </select>
      </br>
      <input class="btn" type="submit" value="Salvar" />
    </form>
  </div>
</body>
</html>
