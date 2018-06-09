<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="jspf/cabecalho.jspf" %>
    <body>
        <div class="container text-center">
            <h5> <font color="FF0000"> Confirme seu login e senha para exclusão do evento </font> </h5>
            <c:choose>
                <c:when test="${excluir}">
                    <form method="post">
                        <div class="form-group row">
                            <label>Email</label>
                            <input type="text" class="form-control" name="emailUsuario" placeholder="Seu email" required>
                            <label>Senha</label>
                            <input type="hidden" value="${id}" class="form-control" name="idParticipante"/>
                            <input type="hidden" value="${id2}" class="form-control" name="idEvento"/>
                            <input type="password" class="form-control" name="senhaUsuario" size="20" placeholder="Sua senha" required>
                            <input type="submit" class="btn btn-success"/>
                            <input type="reset" class="btn btn-secondary"/>
                        </div>
                    </form>
                </c:when>
                <c:when test="${!excluir}">
                    <h5> <font color="FF0000"> E-mail e/ou senha incorreto(s)! </font> </h5>
                    <form method="post">
                        <div class="form-group row">
                            <label>Email</label>
                            <input type="text" class="form-control" name="emailUsuario" placeholder="Seu email" required>
                            <label>Senha</label>
                            <input type="hidden" value="${id}" class="form-control" name="idParticipante"/>
                            <input type="hidden" value="${id2}" class="form-control" name="idEvento"/>
                            <input type="password" class="form-control" name="senhaUsuario" size="20" placeholder="Sua senha" required>
                            <input type="submit" class="btn btn-success"/>
                            <input type="reset" class="btn btn-secondary"/>
                        </div>
                    </form>
                </c:when>
            </c:choose>
        </div>
<%@include file="jspf/rodape.jspf" %>
