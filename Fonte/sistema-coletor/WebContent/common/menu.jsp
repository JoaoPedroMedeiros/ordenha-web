
<header></header>
<input type="checkbox" id="chk">
<label for="chk" class="menu-icon">&#9776;</label>

<div class="bg"></div>
<nav class="menu" id="principal">
    <ul>
        <li>
            <jsp:useBean id="usuario" class="com.dac.coletor.beans.UsuarioBean" scope="session"/>
            <div class="voltar">
                <i class=" fa fa-user" aria-hidden="true"></i> 
                <%
                out.print(usuario != null ? usuario.getNome() : "Nenhum usuário logado");
                %>
            </div>
        </li>
        <li><a href="" class="menu-btn"><i class="fa fa-chevron-left" aria-hidden="true"></i> Voltar</a></li>
        <li><a href="/sistema-produtor/home.jsp" class="menu-btn"><i class="fa fa-calendar-o" aria-hidden="true"></i> Página inicial</a></li>
        <li><a href="/sistema-produtor/registro-coleta.jsp" class="menu-btn"><i class="fa fa-plus" aria-hidden="true"></i> Registrar coleta</a></li>
        <li><a href="/sistema-produtor/gerenciar-propriedades.jsp" class="menu-btn"><i class="fa fa-clipboard" aria-hidden="true"></i> Gerenciar propriedades</a></li>
        <li><a href="#" class="menu-btn"><i class="fa fa-sign-out" aria-hidden="true"></i> Sair</a></li>
    </ul>
</nav>
