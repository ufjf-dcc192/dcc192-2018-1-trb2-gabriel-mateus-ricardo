<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="jspf/cabecalho.jspf" %>
    <body>
        <div class="container text-center">
            <c:choose>
                <c:when test="${sorteioRealizado}">
                    <h1> Sorteio realizado </h1>
                    <h1> Participantes </h1>
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
                                    <th>
                                    <form method="post">
                                        <input type="submit" value="Veja seu amigo oculto"/>
                                            <input type="hidden" value="${participantes.codigo}" class="form-control" name="idParticipante">
                                            <input type="hidden" value="${participantes.codigoAmigoOculto}" class="form-control" name="idAmigoOculto">
                                            <input type="hidden" value="${id2}" class="form-control" name="idEvento">
                                    </form>
                                    </th>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </c:when>
            </c:choose>
            <c:choose>
                <c:when test="${!sorteioRealizado}">
                    <h1> Sorteio ainda não realizado </h1>
                    <h1> Participantes </h1>
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