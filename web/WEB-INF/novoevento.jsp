<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="jspf/cabecalho.jspf" %>
    <body>
        <div class="container text-center">
            <form method="post">
                <div class="form-group row">
                    <label>T�tulo</label>
                    <input type="text" class="form-control" name="titulo" placeholder="Nome do seu evento" required>
                    <label>Valor m�nimo</label>
                    <input type="text" class="form-control" name="valorMinimo" placeholder="Coloque somente o valor" required>
                    <label>Data do sorteio</label>
                    <input type="datetime-local" class="form-control" name="dataDoSorteio" placeholder="" required>
                    <label>Data do evento</label>
                    <input type="datetime-local" class="form-control" name="dataDoEvento" placeholder="" required>
                    <label>Senha entrada ao evento</label>
                    <input type="password" class="form-control" name="senhaEvento" size="20" placeholder="Sua senha" required>
                    <input type="hidden" class="form-control" name="id" value=${id}/>
                    <input type="submit" class="btn btn-success"/>
                    <input type="reset" class="btn btn-secondary"/>
                </div>
            </form>
        </div>
<%@include file="jspf/rodape.jspf" %>