<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="pt-br">
  <head>
    <jsp:include page="common/dependencies.jsp" />
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %><%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
    <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
    <title>Linha do tempo</title>
</head>
<body>
    <jsp:include page="common/menu.jsp" />
    <div class="body">
        <div class="form-group">
            <div class="row">
                <form method="get" action="/sistema-produtor/servlets/movimento-tanque">
                    <div class="col-md-2">
                        <input id="ano" name="ano" type="text" placeholder="Ano" value="${requestScope.ano}" class="form-control input-md">
                    </div>
                    <div class="col-md-2">
                        <select id="mes" name="mes" class="form-control">
                          <option value="1" ${requestScope.mes == 1 ? 'selected' : ''}>Janeiro</option>
                          <option value="2" ${requestScope.mes == 2 ? 'selected' : ''}>Fevereiro</option>
                          <option value="3" ${requestScope.mes == 3 ? 'selected' : ''}>Março</option>
                          <option value="4" ${requestScope.mes == 4 ? 'selected' : ''}>Abril</option>
                          <option value="5" ${requestScope.mes == 5 ? 'selected' : ''}>Maio</option>
                          <option value="6" ${requestScope.mes == 6 ? 'selected' : ''}>Junho</option>
                          <option value="7" ${requestScope.mes == 7 ? 'selected' : ''}>Julho</option>
                          <option value="8" ${requestScope.mes == 8 ? 'selected' : ''}>Agosto</option>
                          <option value="9" ${requestScope.mes == 9 ? 'selected' : ''}>Setembro</option>
                          <option value="10" ${requestScope.mes == 10 ? 'selected' : ''}>Outubro</option>
                          <option value="11" ${requestScope.mes == 11 ? 'selected' : ''}>Novembro</option>
                          <option value="12" ${requestScope.mes == 12 ? 'selected' : ''}>Dezembro</option>
                        </select>
                    </div>
                    <div class="col-md-2">
                        <button id="pesquisar" name="pesquisar" class="btn btn-warning">Pesquisar</button>    
                    </div>
                </form>
            </div>
            
            <div style="margin-top: 30px"></div>
            
            <c:if test="${requestScope.movimentos.size() > 0}">
                <c:forEach items="${requestScope.movimentos}" var="movimento">
                    <div class="row">
                        <div style="margin-top: 20px"></div>
                        <div class="col-md-1">
                            <c:if test="${movimento.getClass().getSimpleName().equals(\"MovimentoOrdenhaBean\")}">
                                <img alt="" src="/sistema-produtor/images/balde_cheio.png" height="80px" width="80px">
                            </c:if>
                            <c:if test="${movimento.getClass().getSimpleName().equals(\"MovimentoColetaBean\")}">
                                <img alt="" src="/sistema-produtor/images/caminhao.png" height="80px" width="80px">
                            </c:if>
                        </div>
                        <div class="col-md-2">
                            <c:if test="${movimento.getClass().getSimpleName().equals(\"MovimentoOrdenhaBean\")}">
                                <span style="font-size: 2em"><b>ORDENHA</b></span><br/>
                            </c:if>
                            <c:if test="${movimento.getClass().getSimpleName().equals(\"MovimentoColetaBean\")}">
                                <span style="font-size: 2em"><b>COLETA</b></span><br/>
                            </c:if>
                        </div>
                        <div class="col-md-5">
                            <span style="font-size: 2em"><b><fmt:formatDate pattern="dd/MM/yyyy hh:mm:ss" value="${movimento.getDataHora()}" /></b></span><br/>
                            <span style="font-size: 1.2em">
                                <c:out value="${movimento.getQuantidade()}"/> litros
                                <c:if test="${movimento.getClass().getSimpleName().equals(\"MovimentoOrdenhaBean\")}">
                                    ordenhados. Total de vacas:
                                    
                                    <c:out value="${ movimento.getOrdenha().getVacas().size() }"></c:out>
                                </c:if>
                                <c:if test="${movimento.getClass().getSimpleName().equals(\"MovimentoColetaBean\")}">
                                    coletados
                                </c:if> 
                            </span>
                        </div>
                        <div class="col-md-2">
                            <button id="singlebutton" name="singlebutton" class="btn btn-warning">Editar</button>
                        </div>
                    </div>
                </c:forEach>
            </c:if>
            <c:if test="${requestScope.movimentos.size() == 0}">
                <p style="font-size: 2em"><b>Não encontramos nenhuma coleta ou ordenha nesse mês :(</b></p>
            </c:if>
        </div>
    </div>
</body>
</html>
