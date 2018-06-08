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
                    <th>
                        <fmt:setLocale value="pt-BR" />
                        <fmt:formatNumber value="${evento.minimo}" type="currency"/>
                    </th>
                    <th><fmt:formatDate pattern="dd/MM/yyyy HH:mm" value="${evento.sorteio}" /></th>
                    <th><fmt:formatDate pattern="dd/MM/yyyy HH:mm" value="${evento.data}" /></th>
                    <th> <a href="inscritos.html?id=${id}&id2=${evento.codigo}"> <i class="material-icons">people</i> </a> 
                        <a href="inscricao.html?id=${id}&id2=${evento.codigo}"> <i class="material-icons">person_add</i> </a>  
                        <a href="administrar.html?id=${id}&id2=${evento.codigo}"> <i class="material-icons">mode_edit</i> </a> </th>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
<%@include file="jspf/rodape.jspf" %>
