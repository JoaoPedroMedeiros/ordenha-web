<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <jsp:include page="common/dependencies.jsp" />
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Insert title here</title>
</head>
<body>
    <jsp:include page="common/menu.jsp" />
    <div class="body">
        <legend>Propriedade</legend>
        
        
        <div id="conteudo">
            <form action="/sistema-coletor/servlets/propriedade" method="post">
                <input type="hidden" id="id" name="id" value="${requestScope.propriedadeBean.id}" />
                <c:choose>
                    <c:when test="${requestScope.propriedadeBean.id != null}">
                        <input type="hidden" id="acao" name="acao" value="alterar" />
                    </c:when>
                    <c:otherwise>
                        <input type="hidden" id="acao" name="acao" value="inserir" />
                    </c:otherwise>
                </c:choose>
                <br/>
                <div class="row">
                    <div class="col-md-8">
                        <input type="text" id="nome" name="nome" placeholder="Nome" class="form-control" value="${requestScope.propriedadeBean.nome}" required />
                    </div>
                    <div class="col-md-4">
                        <input type="text" id="cnpj" name="cnpj" placeholder="CNPJ" class="form-control" value="${requestScope.propriedadeBean.cnpj}" required />
                    </div>
                </div>
                <br/>
                <div class="row">
                    <div class="col-md-12">
                        <input type="text" id="endereco" name="endereco" placeholder="Endereço" class="form-control" value="${requestScope.propriedadeBean.endereco}" required />
                    </div>
                </div>
                <br/>
                <div class="row">
                    <div class="col-md-4">
                        <input type="text" id="bairro" name="bairro" placeholder="Bairro" class="form-control" value="${requestScope.propriedadeBean.bairro}" required />
                    </div>
                    <div class="col-md-4">
                        <input type="text" id="numero" name="numero" placeholder="Número" class="form-control" value="${requestScope.propriedadeBean.numero}" required />
                    </div>
                    <div class="col-md-4">
                        <input type="text" id="complemento" name="complemento" placeholder="Complemento" class="form-control" value="${requestScope.propriedadeBean.complemento}" />
                    </div>
                </div>
                <br/>
                <div class="row">
                    <div class="col-md-4">
                        <select name="id_cidade" required class="form-control" >
                            <option value="">--selecione</option>
                            <c:forEach items="${requestScope.cidadeBeanList}" var="cidade">
                                <c:if test="${requestScope.propriedadeBean.cidade.id} == ${cidade.id}">
                                    <%!String str = "selected";%>
                                </c:if>
                                <option <%=str%> value="${cidade.id}">${cidade.nome}- ${cidade.estado.sigla}</option>
                                <%
                                    str = "";
                                %>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="col-md-8">
                        <input type="text" id="proprietario" placeholder="Proprietário" class="form-control" name="proprietario" value="${requestScope.propriedadeBean.proprietario}" required />
                    </div>
                </div>
                <br/>
                <div class="row">
                    <div class="col-md-4">
                        <input type="text" id="telefone" class="form-control" placeholder="Telefone" name="telefone" value="${requestScope.propriedadeBean.telefone}" required />
                    </div>
                    <div class="col-md-4">
                        <input type="text" id="email" class="form-control" placeholder="E-mail" name="email" value="${requestScope.propriedadeBean.email}" required />
                    </div>
                    <div class="col-md-4">
                        <input type="text" id="periodicidade" class="form-control" placeholder="Periodicidade" name="periodicidade" value="${requestScope.propriedadeBean.periodicidade}" required />
                    </div>
                </div>
                <br/>
                <div class="row">
                    <div class="col-md-12">
                        <input class="btn btn-primary" type="submit" value="Salvar" />
                    </div>
                </div>
            </form>
        </div>
    </div>
</body>
</html>