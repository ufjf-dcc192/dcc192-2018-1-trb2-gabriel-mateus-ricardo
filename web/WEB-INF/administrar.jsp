<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="jspf/cabecalho.jspf" %>
    <body>
        <div class="container text-center">
            <c:choose>
                <c:when test="${evento}">
                    <h1>Administra��o</h1>
                    <form method="post">
                        <div class="form-group row">
                            <label>Novo T�tulo</label>
                            <input type="text" class="form-control" name="titulo" placeholder="Nome do seu evento" >
                            <label>Novo Valor m�nimo</label>
                            <input type="text" class="form-control" name="valorMinimo" placeholder="Coloque somente o valor" >
                            <label>Nova Data do sorteio</label>
                            <input type="datetime-local" class="form-control" name="dataDoSorteio" placeholder="" >
                            <label>Nova Data do evento</label>
                            <input type="datetime-local" class="form-control" name="dataDoEvento" placeholder="" >
                            <input type="hidden" class="form-control" name="id" value=${id}/>
                            <input type="submit" class="btn btn-success"/>
                            <input type="reset" class="btn btn-secondary"/>
                        </div>
                    </form>
                </c:when>
                <c:when test="${!evento}">
                    <h1>Administra��o</h1>
                    <font color="FF0000"> E-mail e/ou senha incorreto(s)! </font>
                    <form method="post">
                        <div class="form-group row">
                            <label>Novo T�tulo</label>
                            <input type="text" class="form-control" name="titulo" placeholder="Nome do seu evento" >
                            <label>Novo Valor m�nimo</label>
                            <input type="text" class="form-control" name="valorMinimo" placeholder="Coloque somente o valor" >
                            <label>Nova Data do sorteio</label>
                            <input type="datetime-local" class="form-control" name="dataDoSorteio" placeholder="" >
                            <label>Nova Data do evento</label>
                            <input type="datetime-local" class="form-control" name="dataDoEvento" placeholder="" >
                            <input type="hidden" class="form-control" name="id" value=${id}/>
                            <input type="submit" class="btn btn-success"/>
                            <input type="reset" class="btn btn-secondary"/>
                        </div>
                    </form>
                </c:when>
            </c:choose>
        </div>
<%@include file="jspf/rodape.jspf" %>