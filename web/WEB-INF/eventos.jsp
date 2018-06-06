<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="jspf/cabecalho.jspf" %>
    
    <body>
        <div class="container text-center">
        <h1>Eventos de Amigo Oculto</h1>
        </div>
        <table class="table table-dark">
            <thead>
                <tr>
                    <th scope="col">C�digo</th>
                    <th scope="col">T�tulo</th>
                    <th scope="col">Valor m�nimo</th>
                    <th scope="col">Data do sorteio</th>
                    <th scope="col">Data do evento</th>
                    <th scope="col">A��es</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="evento" items="${evento}">
                    <tr>
                    <th>${evento.codigo}</th>
                    <th>${evento.titulo}</th>
                    <th>R$${evento.minimo}</th>
                    <th><fmt:formatDate pattern="dd/MM/yyyy HH:mm" value="${evento.sorteio}" /></th>
                    <th><fmt:formatDate pattern="dd/MM/yyyy HH:mm" value="${evento.data}" /></th>
                    <th><a href="inscritos.html?id=${id}&id2=${evento.codigo}">Inscritos</a> // <a href="inscricao.html?id=${id}&id2=${evento.codigo}">Inscri��o</a> // <a href="administrar.html?id=${id}&id2=${evento.codigo}">Administrar</a> </th>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
<%@include file="jspf/rodape.jspf" %>
