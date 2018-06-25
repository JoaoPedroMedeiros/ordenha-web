<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <div>
    <h1 class="body">Cadastrar Propriedade</h1>
  </div>
  <div id="conteudo">
    <form action="/sistema-coletor/servlets/propriedade" method="post"> 
      <input type="hidden" id="id" name="id" value="${requestScope.propriedadeBean.id}"/>
      <c:choose>
        <c:when test="${requestScope.propriedadeBean.id != null}">
              <input type="hidden" id="acao" name="acao" value="alterar"/>
          </c:when>    
          <c:otherwise>
              <input type="hidden" id="acao" name="acao" value="inserir"/>
          </c:otherwise>
      </c:choose>
      Nome: <input type="text" id="nome" name="nome" value="${requestScope.propriedadeBean.nome}" required/>
      </br>
      Cnpj: <input type="text" id="cnpj" name="cnpj" value="${requestScope.propriedadeBean.cnpj}" required/>
      </br>
      Endereco: <input type="text" id="endereco" name="endereco" value="${requestScope.propriedadeBean.endereco}" required/>
      </br>
      Numero: <input type="text" id="numero" name="numero" value="${requestScope.propriedadeBean.numero}" required/>
      </br>
      Complemento: <input type="text" id="complemento" name="complemento" value="${requestScope.propriedadeBean.complemento}"/>
      </br>
      Bairro: <input type="text" id="bairro" name="bairro" value="${requestScope.propriedadeBean.bairro}" required/>
      </br>
      <select name="id_cidade" required>  
        <c:forEach items="${requestScope.cidadeBeanList}" var="cidade"> 
          <option value="${cidade.id}">${cidade.nome}</option>
        </c:forEach>
      </select>
      Proprietário: <input type="text" id="proprietario" name="proprietario" value="${requestScope.propriedadeBean.proprietario}" required/>
      </br>
      Telefone: <input type="text" id="telefone" name="telefone" value="${requestScope.propriedadeBean.telefone}" required/>
      </br>
      Email: <input type="text" id="email" name="email" value="${requestScope.propriedadeBean.email}" required/>
      </br>
      Periodicidade: <input type="text" id="periodicidade" name="periodicidade" value="${requestScope.propriedadeBean.periodicidade}" required/>
      </br>
      <input class="btn" type="submit" value="Salvar" />
    </form>
  </div>
</body>
</html>