<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="pt-br">
<head>
<jsp:include page="common/dependencies.jsp" />
<title>Menu</title>
</head>
<body>
    <jsp:include page="common/menu.jsp" />

    <div class="body">
        <legend>Nova vaca</legend>
        <form action="/sistema-produtor/servlets/vaca" method="post">
            <input type="hidden" id="id" name="id" value="${requestScope.vacaBean.id}" />
            <c:choose>
                <c:when test="${requestScope.vacaBean.id != null}">
                    <input type="hidden" id="acao" name="acao" value="alterar" />
                </c:when>
                <c:otherwise>
                    <input type="hidden" id="acao" name="acao" value="inserir" />
                </c:otherwise>
            </c:choose>
            
            <div style="width: 90%">
                <div class="row">
                    <div class="col-md-12">
                        <input type="text" class="form-control" id="nome" name="nome" placeholder="Nome" value="${requestScope.vacaBean.nome}" required />
                    </div>
                </div>
                
                <br/>
                
                <div class="row">
                    <div class="col-md-4">
                        <fmt:formatDate value="${requestScope.vacaBean.dataNascimento}" type="date" pattern="dd/MM/yyyy" var="theFormattedDate" />
                        <input type="text" id="data_nascimento" class="form-control" name="data_nascimento" value="${theFormattedDate}" placeholder="Data de nascimento" required />
                    </div>
                    <div class="col-md-4">
                        <input type="text" class="form-control" id="peso" name="peso" placeholder="Peso" value="${requestScope.vacaBean.peso}" required />
                    </div>
                    <div class="col-md-4">
                        <select name="id_raca" class="form-control" required>
                            <c:forEach items="${requestScope.racaBeanList}" var="raca">
                                <c:if test="${requestScope.vacaBean.raca.id} == ${raca.id}">
                                    <%!String str = "selected";%>
                                </c:if>
                                <option <%=str%> value="${raca.id}">${raca.descricao}</option>
                                <%
                                    str = "";
                                %>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                
                <br/>
                
                <div class="row">
                    <div class="col-md-12">
                        <textarea class="form-control" placeholder="Observações" type="text" id="observacao" name="observacao" value="${requestScope.vacaBean.observacao}"
                            style="height: 100px"></textarea>
                    </div>
                </div>
                
                <br/>
                
                <div class="row">
                    <div class="col-md-2">
                        <input class="btn btn-warning" type="submit" value="Salvar" />
                    </div>
                </div>
            </div>
        </form>
    </div>
    
    <div id="conteudo">
        
    </div>
</body>
</html>
