<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="jspf/cabecalho.jspf" %>
<body>
    <div class="container text-center">
        <h1>Você não é o criador do evento, portanto não pode administrá-lo</h1>
        <form method="post">
            <input type="submit" value="Voltar"/>
        </form>
    </div>
    <%@include file="jspf/rodape.jspf" %>