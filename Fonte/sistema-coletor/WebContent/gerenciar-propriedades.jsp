<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <jsp:include page="common/dependencies.jsp" />
    <title>Menu</title>
</head>
<body>
    <jsp:include page="common/menu.jsp" />

    <div class="body">
        <legend>Gerenciar propriedades</legend>
    
        <div class="row">
            <form action="/sistema-coletor/servlets/propriedade" method="get">
                <input type="hidden" id="acao" name="acao" value="listar" />
                <div class="col-md-3">
                    <input class="form-control" placeholder="Propriedade" type="text" id="nome" name="nome" value="${requestScope.propriedadeBean.nome}" /> 
                </div>
                <div class="col-md-3"> 
                    <select class="form-control" name="id_cidade">
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
                <div class="col-md-1" style="margin-right: 7px;">
                    <input class="btn btn-primary" type="submit" value="Pesquisar" />
                </div>
            </form>
            <div class="col-md-1">
                <form action="/sistema-coletor/servlets/propriedade" method="post">
                    <input type="hidden" id="acao" name="acao" value="ler" />
                    <input class="btn  btn-primary" type="submit" value="Nova propriedade" />
                </form>
            </div>
        </div>
    
        <legend style="margin-top: 20px"></legend>
        
        <div id="conteudo">
            <table width="95%">
                <thead>
                    <tr>
                        <th align="left" style="width: 20%">Nome</th>
                        <th align="left" style="width: 20%">Proprietário</th>
                        <th align="left" style="width: 15%">Bairro</th>
                        <th align="left" style="width: 15%">Cidade</th>
                        <th align="left" style="width: 15%">Telefone</th>
                        <th align="left" style="width: 12%">Ação</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${requestScope.propriedadeBeanList}" var="propriedade">
                        <tr>
                            <td align="left"><c:out value="${propriedade.nome}" /></td>
                            <td align="left"><c:out value="${propriedade.proprietario}" /></td>
<%--                             <td align="left"><c:out value="${propriedade.endereco}, ${propriedade.numero} - ${propriedade.complemento}" /></td> --%>
                            <td align="left"><c:out value="${propriedade.bairro}" /></td>
                            <td align="left"><c:out value="${propriedade.cidade.nome} - ${propriedade.cidade.estado.sigla}" /></td>
                            <td align="left"><c:out value="${propriedade.telefone}" /></td>
                            <td align="left">
                                <div class="row"  style="margin-bottom: 5px">
                                    <div class="col-md-6">
                                            <form action="/sistema-coletor/servlets/propriedade" method="post">
                                            <input type="hidden" id="id" name="id" value="${propriedade.id}" />
                                            <input type="hidden" id="acao" name="acao" value="ler" />
                                            <input class="btn btn-primary" type="submit" value="Alterar" />
                                        </form>
                                    </div>
                                    <div class="col-md-6">
                                        <form action="/sistema-coletor/servlets/propriedade" method="post">
                                            <input type="hidden" id="id" name="id" value="${propriedade.id}" /> 
                                            <input type="hidden" id="acao" name="acao" value="deletar" />
                                            <input class="btn btn-primary" type="submit" value="Excluir" />
                                        </form>
                                    </div>
                                </div>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>
