
<header></header>
<input type="checkbox" id="chk">
<label for="chk" class="menu-icon">&#9776;</label>

<div class="bg"></div>
<nav class="menu" id="principal">
    <ul>
        <li>
            <jsp:useBean id="usuario" class="com.dac.produtor.beans.UsuarioBean" scope="session"/>
            <div class="voltar">
                <i class=" fa fa-user" aria-hidden="true"></i> 
                <%
                   out.print(usuario != null ? usuario.getNome() : "Nenhum usuário logado");
                %>
            </div>
        </li>
        <li><a href="" class="menu-btn"><i class="fa fa-chevron-left" aria-hidden="true"></i> Voltar</a></li>
        <li><a href="/sistema-produtor/linha-do-tempo.jsp" class="menu-btn"><i class="fa fa-calendar-o" aria-hidden="true"></i> Linha do tempo</a></li>
        <li><a href="/sistema-produtor/cadastro-ordenha.jsp" class="menu-btn"><i class="fa fa-plus" aria-hidden="true"></i> Cadastrar Ordenha</a></li>
        <li><a href="/sistema-produtor/gerenciar-vacas.jsp" class="menu-btn"><i class="fa fa-clipboard" aria-hidden="true"></i> Gerenciar vacas</a></li>
        <li><a href="/sistema-produtor/servlets/logout" class="menu-btn"><i class="fa fa-sign-out" aria-hidden="true"></i> Sair</a></li>
    </ul>
</nav>
