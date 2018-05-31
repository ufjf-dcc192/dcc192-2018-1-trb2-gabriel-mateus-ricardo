<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="jspf/cabecalhoInicial.jspf" %>
    <body>
        <div class="container text-center">
            <c:choose>
                <c:when test="${cadastro}">
                    <form method="post">
                        <div class="form-group row">
                            <label>Nome do usuário</label>
                            <input type="text" class="form-control" name="nomeUsuario" placeholder="Seu nome" required>
                            <label>Email</label>
                            <input type="text" class="form-control" name="emailUsuario" placeholder="Seu email" required>
                            <label>Senha</label>
                            <input type="password" class="form-control" name="senhaUsuario" size="20" placeholder="Sua senha" required>
                            <input type="submit" class="btn btn-success"/>
                            <input type="reset" class="btn btn-secondary"/>
                        </div>
                    </form>
                </c:when>
                <c:when test="${!cadastro}">
                    <h5><font color="FF0000"> Algum problema com a data! </font></h5>
                    <form method="post">
                        <div class="form-group row">
                            <label>Nome do usuário</label>
                            <input type="text" class="form-control" name="nomeUsuario" placeholder="Seu nome" required>
                            <label>Email</label>
                            <input type="text" class="form-control" name="emailUsuario" placeholder="Seu email" required>
                            <label>Senha</label>
                            <input type="password" class="form-control" name="senhaUsuario" size="20" placeholder="Sua senha" required>
                            <input type="submit" class="btn btn-success"/>
                            <input type="reset" class="btn btn-secondary"/>
                        </div>
                    </form>
                </c:when>
            </c:choose>
        </div>
<%@include file="jspf/rodapeInicial.jspf" %>
