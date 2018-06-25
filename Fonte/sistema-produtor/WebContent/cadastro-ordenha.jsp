<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="pt-br">
  <head>
    <jsp:include page="common/dependencies.jsp" />
    <title>Menu</title>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
    <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
</head>
<body>
    <jsp:include page="common/menu.jsp" />
    
    <div class="body">
        
        <legend style="font-size: 1.8em"><b>Cadastro de ordenha</b></legend>
        <form method="post" action="/sistema-produtor/servlets/ordenha?action=inserir">
            <div class="row">
                <div class="col-md-3" style="margin-bottom: 20px">
                    <label style="margin-top: 2px">Data/hora:</label>
                    <input type="datetime-local" class="form-control" id="dataHora" placeholder="2018-06-1219:30" name="dataHora">
                </div>
                <div class="col-md-1">
                    <button style="margin-top: 26px" class="btn btn-warning">Registrar ordenha</button>
                </div>
                
            </div>
            
            <div class="row" style="margin-left: 15px">
                <span style="color: red;"><c:out value="${ requestScope.msgValidacao }"></c:out></span>
            </div>
    
            <legend style="font-size: 1.8em; margin-top: 10px"><b></b></legend>
            
            <div class="row" style="margin-bottom: 10px; margin-right: 15px;" >
                <div class="col-md-5">
                    <span style="font-size: 1.2em"><b>Vaca</b></span>
                </div>
                <div class="col-md-3">
                    <span style="font-size: 1.2em"><b>Quantidade</b></span>
                </div>
            </div>
        
            
            <div>
                <c:forEach items="${ requestScope.vacas }" var="vaca">
                    <div class="row" style="margin-top: 10px; margin-right: 15px">
                        <div class="col-md-5">
                            <span>${ vaca.nome }</span>
                        </div>
                        <div class="col-md-3">
                            <input id="quantidade${ vaca.id }" name="quantidade${ vaca.id }" type="text" placeholder="Quantidade (Litros de leite)" class="form-control input-md" value="0" required>
                        </div>
                    </div>
                </c:forEach>
            </div>
            
            <legend style="font-size: 1.8em; margin-top: 10px"><b></b></legend>
        </form>
    </div>
</body>
</html>
