<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="jspf/cabecalho.jspf" %>
    <body>
        <div class="container text-center">
            <c:choose>
                <c:when test="${!sorteioRealizado}">
                    <h1>Voc� j� est� inscrito neste evento</h1>
                    <a type="button" class="btn btn-secondary btn-md" href="eventos.html?id=${id}"> Voltar para Eventos </a> 
                </c:when>
                <c:when test="${sorteioRealizado}">
                    <h3> Seja bem-vindo ${participante.nome}, o sorteio j� foi realizado </h3>
                    <a type="button" class="btn btn-secondary btn-md" href="inscritos.html?id=${id}&id2=${id2}"> Ver inscritos no evento </a>
                </c:when>
            </c:choose>
        </div>
<%@include file="jspf/rodape.jspf" %>