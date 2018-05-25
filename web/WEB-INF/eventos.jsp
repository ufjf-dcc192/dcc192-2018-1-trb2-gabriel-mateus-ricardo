<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Eventos</title>
    </head>
    <body>
        <h1>Eventos de Amigo Oculto</h1>
        <table border = "2px">
            <thead>
                <tr>
                    <th>Código</th>
                    <th>Título</th>
                    <th>Valor mínimo</th>
                    <th>Data do evento</th>
                    <th>Data do Sorteio</th>
                    <th>Participantes</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach var="evento" items="${eventos}">
                <td>${eventos.codigo}</td>
                <td>${eventos.titulo}</td>
                <td>${eventos.minimo}</td>
                <td>${eventos.data}</td>
                <td>${eventos.sorteio}</td>
                <td><a href="">Participantes</a></td>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
