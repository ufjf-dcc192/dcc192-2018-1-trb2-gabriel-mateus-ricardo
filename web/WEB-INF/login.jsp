<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="jspf/cabecalhoInicial.jspf" %>
    <body>
        <div class="container text-center">
            <form method="post">
                <div class="form-group row">
                    <label>Email</label>
                    <input type="text" class="form-control" name="emailUsuario" placeholder="Seu email" required>
                    <label>Senha</label>
                    <input type="password" class="form-control" name="senhaUsuario" size="20" placeholder="Sua senha" required>
                    <input type="submit" class="btn btn-success"/>
                    <input type="reset" class="btn btn-secondary"/>
                </div>
            </form>
        </div>
<%@include file="jspf/rodapeInicial.jspf" %>