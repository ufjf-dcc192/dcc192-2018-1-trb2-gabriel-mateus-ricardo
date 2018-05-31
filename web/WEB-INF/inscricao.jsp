<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="jspf/cabecalho.jspf" %>
    <body>
        <div class="container text-center">
            <c:choose>
                <c:when test="${inscricao}">    
                    <form method="post">
                        <div class="form-group row">
                            <label>Digite a Senha</label>
                            <input type="password" class="form-control" name="senhaEvento" size="20" placeholder="Senha" required>
                            <input type="submit" class="btn btn-success"/>
                            <input type="reset" class="btn btn-secondary"/>
                        </div>
                    </form>
                </c:when>
                <c:when test="${!inscricao}">
                    <h1> As inscrições já estão encerradas </h1>
                </c:when>
            </c:choose>
        </div>
<%@include file="jspf/rodape.jspf" %>
