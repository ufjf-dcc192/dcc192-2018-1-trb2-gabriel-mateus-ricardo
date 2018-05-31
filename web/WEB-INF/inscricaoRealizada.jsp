<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="jspf/cabecalho.jspf" %>
    <body>
        <div class="container text-center">
            <c:choose>
                <c:when test="${!sorteioRealizado}">
                    <h1>Você já está inscrito neste evento</h1>
                    <a type="button" class="btn btn-secondary btn-lg btn-block" href="eventos.html?id=${id}"> Voltar para Eventos </a> 
                </c:when>
                <c:when test="${sorteioRealizado}">
                    <h3> Seja bem-vindo ${participante.nome}, o sorteio já foi realizado </h3>
                    <form method="post">
                            <input type="submit" value="Veja seu amigo oculto"/>
                            <input type="hidden" value="${participante.codigo}" class="form-control" name="idParticipante">
                            <input type="hidden" value="${participante.codigoAmigoOculto}" class="form-control" name="idAmigoOculto">
                            <input type="hidden" value="${id2}" class="form-control" name="idEvento">
                    </form>
                </c:when>
            </c:choose>
        </div>
<%@include file="jspf/rodape.jspf" %>