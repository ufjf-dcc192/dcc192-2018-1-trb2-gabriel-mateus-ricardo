<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="jspf/cabecalho.jspf" %>
<body>
    <div class="container text-center">
        <h1>Voc� n�o � o criador do evento, portanto n�o pode administr�-lo</h1>
            <a type="button" class="btn btn-secondary btn-lg btn-block" href="eventos.html?id=${id}"> Voltar para Eventos </a> 
    </div>
    <%@include file="jspf/rodape.jspf" %>