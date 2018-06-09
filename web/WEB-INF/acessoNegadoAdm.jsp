<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="jspf/cabecalho.jspf" %>
<body>
    <c:choose>
        <c:when test="${ocorreu}">
            <div class="container text-center">
                <h1>O evento já ocorreu!</h1>
                    <a type="button" class="btn btn-secondary btn-md" href="eventos.html?id=${id}"> Voltar para Eventos </a> 
            </div>
        </c:when>
        <c:when test="${!ocorreu}">
            <div class="container text-center">
                <h1>Você não é o criador do evento!</h1>
                    <a type="button" class="btn btn-secondary btn-md" href="eventos.html?id=${id}"> Voltar para Eventos </a> 
            </div>
        </c:when>
    </c:choose>
    
<%@include file="jspf/rodape.jspf" %>