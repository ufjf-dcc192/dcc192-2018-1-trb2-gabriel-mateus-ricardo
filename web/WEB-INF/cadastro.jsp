<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="jspf/cabecalhoInicial.jspf" %>
    <body>
        <div class="container text-center">
            <form>
                <div class="form-group row">
                    <label>Nome do usuário</label>
                    <input type="text" class="form-control" name="nomeUsuario" placeholder="Seu nome" required>
                    <label>Email</label>
                    <input type="text" class="form-control" name="emailUsuario" placeholder="Seu email" required>
                    <label>Senha</label>
                    <input type="password" class="form-control" name="senhaUsuario" size="20" placeholder="Sua senha" required>
                    <a type="submit" class="btn btn-success" href="cadastrar.html">Criar</a>
                    <a type="reset" class="btn btn-secondary">Reset</a>
                </div>
            </form>
        </div>
<%@include file="jspf/rodapeInicial.jspf" %>
