<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="jspf/cabecalho.jspf" %>
    <body>
        <div class="container text-center">
            <h1> Sorteio ainda não realizado </h1>
            <h1> Participantes </h1>
            <c:choose>
                <c:when test="${!sorteioRealizado}">
                    <table class="table table-dark">
                    <thead>
                                <tr>
                                    <th scope="col">Nome</th>
                                    <th scope="col">Status</th>
                                </tr>
                    </thead>
                        <tbody>
                            <c:forEach var="participantes" items="${participantes}">
                                <tr>
                                    <th>${participantes.nome}</th>
                                    <th>?</th>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </c:when>
            </c:choose>
        </div>
<%@include file="jspf/rodape.jspf" %>