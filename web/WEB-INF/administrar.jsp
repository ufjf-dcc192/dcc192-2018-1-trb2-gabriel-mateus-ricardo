<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="jspf/cabecalho.jspf" %>
    <body>
        <div class="container text-center">
            <c:choose>
                <c:when test="${evento}">
                    <h1>Administração</h1>
                    <form method="post">
                        <div class="form-group row">
                            <label> Título </label>
                            <input type="text" class="form-control" name="titulo" value="${eventoModificar.titulo}">
                            <label>Valor mínimo </label>
                            <input type="number" step="0.01" min="0" class="form-control" name="valorMinimo" value="${eventoModificar.minimo}">
                            <label>Nova Data do sorteio</label>
                            <input type="datetime-local" class="form-control" name="dataDoSorteio">
                            <label>Nova Data do evento</label>
                            <input type="datetime-local" class="form-control" name="dataDoEvento">
                            <input type="hidden" class="form-control" name="id" value=${id}/>
                            <input type="hidden" class="form-control" name="id2" value=${id2}/>
                            <input type="hidden" class="form-control" name="id3" value="0"/>
                            <input type="submit" class="btn btn-success"/>
                            <input type="reset" class="btn btn-secondary"/>
                        </div>
                    </form>
                </c:when>
                <c:when test="${!evento}">
                    <h1>Administração</h1>
                    <form method="post">
                        <div class="form-group row">
                            <label> Título </label>
                            <input type="text" class="form-control" name="titulo" value="${eventoModificar.titulo}">
                            <label>Valor mínimo </label>
                            <input type="number" step="0.01" min="0" class="form-control" name="valorMinimo" value="${eventoModificar.minimo}">
                            <label>Nova Data do evento</label>
                            <input type="datetime-local" class="form-control" name="dataDoEvento">
                            <input type="hidden" class="form-control" name="id" value=${id}/>
                            <input type="hidden" class="form-control" name="id2" value=${id2}/>
                            <input type="hidden" class="form-control" name="id3" value="1"/>
                            <input type="submit" class="btn btn-success"/>
                            <input type="reset" class="btn btn-secondary"/>
                        </div>
                    </form>
                </c:when>
            </c:choose>
        </div>
<%@include file="jspf/rodape.jspf" %>