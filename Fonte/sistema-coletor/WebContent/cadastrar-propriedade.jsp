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
      Nome: <input type="text" id="nome" name="nome" value="${requestScope.propriedadeBean.nome}"/>
      </br>
      Cnpj: <input type="text" id="nome" name="nome" value="${requestScope.propriedadeBean.cnpj}"/>
      </br>
      Endereco: <input type="text" id="nome" name="nome" value="${requestScope.propriedadeBean.endereco}"/>
      </br>
      Numero: <input type="text" id="nome" name="nome" value="${requestScope.propriedadeBean.numero}"/>
      </br>
      Complemento: <input type="text" id="nome" name="nome" value="${requestScope.propriedadeBean.complemento}"/>
      </br>
      Bairro: <input type="text" id="nome" name="nome" value="${requestScope.propriedadeBean.bairro}"/>
      </br>
      <select name="id_cidade">  
        <c:forEach items="${requestScope.cidadeBeanList}" var="cidade"> 
          <option value="${cidade.id}">${cidade.nome}</option>
        </c:forEach>
      </select>
      Proprietário: <input type="text" id="nome" name="nome" value="${requestScope.propriedadeBean.proprietario}"/>
      </br>
      Periodicidade: <input type="text" id="nome" name="nome" value="${requestScope.propriedadeBean.periodicidade}"/>
      </br>
      <input class="btn" type="submit" value="Salvar" />
    </form>
  </div>
</body>
</html>