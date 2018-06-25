<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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

    <div class="body">
        <legend>Gerenciar vacas</legend>
        
        <div class="row">
            <form action="/sistema-produtor/servlets/vaca" method="get">
                <input type="hidden" id="acao" name="acao" value="listar" />
                <div class="col-md-2">
                    <input type="text" id="nome" class="form-control input-md" name="nome" value="${requestScope.vacaBean.nome}" placeholder="Filtrar por nome"/>
                </div> 
                <div class="col-md-4">
                    <select name="id_raca" class="form-control">
                        <option value="">Nenhuma</option>
                        <c:forEach items="${requestScope.racaBeanList}" var="raca">
                            <c:if test="${requestScope.raca_id} == ${raca.id}">
                                <%!String str = "selected";%>
                            </c:if>
                            <option <%=str%> value="${raca.id}">${raca.descricao}</option>
                            <%
                                str = "";
                            %>
                        </c:forEach>
                    </select>
                </div>
                <div class="col-md-1">
                    <input class="btn btn-warning" type="submit" value="Pesquisar" style="padding-right: 10px"/>
                </div>
            </form>
            <div class="col-md-1">
                <form action="/sistema-produtor/servlets/vaca" method="post">
                    <input type="hidden" id="acao" name="acao" value="ler" /> <input class="btn btn-warning" type="submit" value="Nova vaca" />
                </form>
            </div>
        </div>
        
        <legend style="margin-top: 10px"></legend>
        
        <div id="conteudo">
            <table width="90%">
                <thead>
                    <tr>
                        <th style="width: 30%" align="left">Nome</th>
                        <th style="width: 20%" align="left">Data Nascimento</th>
                        <th style="width: 15%" align="left">Peso</th>
                        <th style="width: 20%" align="left">Raça</th>
                        <th style="width: 12%" align="left"></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${requestScope.vacaBeanList}"
                        var="vaca">
                        <tr>
                            <td align="left"><c:out
                                    value="${vaca.nome}" /></td>
                            <td align="left"><fmt:formatDate
                                    pattern="dd/MM/yyyy"
                                    value="${vaca.dataNascimento}" /></td>
                            <td align="left"><c:out
                                    value="${vaca.peso}" /></td>
                            <td align="left"><c:out
                                    value="${vaca.raca.descricao}" /></td>
                            <td align="left">
                                <div class="row" style="margin-bottom: 5px">
                                    <div class="col-md-6">
                                        <form
                                            action="/sistema-produtor/servlets/vaca"
                                            method="post">
                                            <input type="hidden" id="id" name="id"
                                                value="${vaca.id}" /> <input
                                                type="hidden" id="acao" name="acao"
                                                value="ler" /> <input class="btn btn-warning"
                                                type="submit" value="Alterar" />
                                        </form>
                                    </div>
                                    <div class="col-md-6">
                                        <form
                                            action="/sistema-produtor/servlets/vaca"
                                            method="post">
                                            <input type="hidden" id="id" name="id"
                                                value="${vaca.id}" /> <input
                                                type="hidden" id="acao" name="acao"
                                                value="deletar" /> <input
                                                class="btn btn-warning" type="submit"
                                                value="Excluir" />
                                        </form>
                                    </div>
                                </div>
                            </td>
                        </tr>
                        </form>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>
