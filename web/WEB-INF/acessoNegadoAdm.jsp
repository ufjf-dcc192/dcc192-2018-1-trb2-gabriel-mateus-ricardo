<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="jspf/cabecalho.jspf" %>
<body>
    <div class="container text-center">
        <h1>Voc� n�o � o criador do evento, portanto n�o pode administr�-lo</h1>
        <form method="post">
            <input type="submit" value="Voltar"/>
        </form>
    </div>
    <%@include file="jspf/rodape.jspf" %>