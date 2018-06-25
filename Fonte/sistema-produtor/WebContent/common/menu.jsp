<jsp:useBean id="usuario" class="com.dac.produtor.beans.UsuarioBean" scope="session"/>

<header></header>
<input type="checkbox" id="chk">
<label for="chk" class="menu-icon">&#9776;</label>
<span class="menu-icon" style="left: 350px;width: 800px; text-align: left;">
    <%
       out.print(usuario != null ? usuario.getPropriedade().getNome() : "Sem fazenda");
    %>
</span>

<div class="bg"></div>
<nav class="menu" id="principal">
    <ul>
        <li>
            
            <div class="voltar">
                <i class=" fa fa-user" aria-hidden="true"></i> 
                <%
                   out.print(usuario != null ? usuario.getNome() : "Nenhum usuário logado");
                %>
            </div>
        </li>
        <li><a href="" class="menu-btn"><i class="fa fa-chevron-left" aria-hidden="true"></i> Voltar</a></li>
        <li><a href="/sistema-produtor/servlets/movimento-tanque" class="menu-btn"><i class="fa fa-calendar-o" aria-hidden="true"></i> Linha do tempo</a></li>
        <li><a href="/sistema-produtor/servlets/ordenha" class="menu-btn"><i class="fa fa-plus" aria-hidden="true"></i> Cadastrar Ordenha</a></li>
        <li><a href="/sistema-produtor/servlets/vaca?acao=listar" class="menu-btn"><i class="fa fa-clipboard" aria-hidden="true"></i> Gerenciar vacas</a></li>
        <li><a href="/sistema-produtor/servlets/logout" class="menu-btn"><i class="fa fa-sign-out" aria-hidden="true"></i> Sair</a></li>
    </ul>
</nav>
