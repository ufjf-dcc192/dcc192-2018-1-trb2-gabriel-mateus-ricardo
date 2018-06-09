<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="jspf/cabecalho.jspf" %>
    <body>
        <div class="container text-center">
            <c:choose>
                <c:when test="${evento}">
                    <form method="post">
                        <div class="form-group row">
                            <label> Título </label>
                            <input type="text" class="form-control" name="titulo" placeholder="Nome do seu evento" required>
                            <label>Valor mínimo </label>
                            <input type="number" step="0.01" min="0" class="form-control" name="valorMinimo" placeholder="Coloque somente o valor" required>
                            <label>Data do sorteio (dd/mm/yyyy hh:mm) </label>
                            <input type="datetime-local" class="form-control" name="dataDoSorteio" placeholder="dd/mm/yyyy hh:mm" pattern="dd/mm/yyyy hh:mm" required>
                            <label>Data do evento (dd/mm/yyyy hh:mm) </label>
                            <input type="datetime-local" class="form-control" name="dataDoEvento" placeholder="dd/mm/yyyy hh:mm" pattern="dd/mm/yyyy hh:mm" required> 
                            <label>Senha entrada ao evento - <font color="FF0000">Uma vez informada não poderá ser modificada </font></label>
                            <input type="password" class="form-control" name="senhaEvento" size="20" placeholder="Sua senha" required>
                            <input type="hidden" class="form-control" name="id" value=${id}/>
                            <input type="submit" class="btn btn-success"/>
                            <input type="reset" class="btn btn-secondary"/>
                        </div>
                    </form>
                </c:when>
                <c:when test="${!evento}">
                    <font color="FF0000"> E-mail e/ou senha incorreto(s)! </font>
                    <form method="post">
                        <div class="form-group row">
                            <label>Título</label>
                            <input type="text" class="form-control" name="titulo" placeholder="Nome do seu evento" required>
                            <label>Valor mínimo</label>
                            <input type="number" step="0.01" min="0" class="form-control" name="valorMinimo" placeholder="Coloque somente o valor" required>
                            <label>Data do sorteio</label>
                            <input type="datetime-local" class="form-control" name="dataDoSorteio" placeholder="dd/mm/yyyy hh:mm" pattern="dd/mm/yyyy hh:mm" required>
                            <label>Data do evento</label>
                            <input type="datetime-local" class="form-control" name="dataDoEvento" placeholder="dd/mm/yyyy hh:mm" pattern="dd/mm/yyyy hh:mm" required> 
                            <label>Senha entrada ao evento - <font color="FF0000">Uma vez informada não poderá ser modificada </font> </label>
                            <input type="password" class="form-control" name="senhaEvento" size="20" placeholder="Sua senha" required>
                            <input type="hidden" class="form-control" name="id" value=${id}/>
                            <input type="submit" class="btn btn-success"/>
                            <input type="reset" class="btn btn-secondary"/>                        </div>
                    </form>
                </c:when>
            </c:choose>
        </div>
<%@include file="jspf/rodape.jspf" %>