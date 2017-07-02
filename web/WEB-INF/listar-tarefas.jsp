<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%><html>
    <head>
        <title></title>
        <meta charset="UTF-8" />
        <link rel="stylesheet" href="estilo.css" />
    </head>
    <body>
        <%@include file = "jspf/menu.jspf" %>
        <%@include file = "jspf/header.jspf" %>
        <%@include file = "jspf/footer.jspf" %>
           
            
                <h1>Lista de Tarefas:</h1>
                <table border='1'>
                    <tr>
                        <th>Id: </th>
                        <th>Título: </th>
                        <th>Descrição:</th>
                        <th>Data Prevista Conclusão: </th>
                        <th>Data de Conclusão:</th>
                        <th>Excluir</th>
                    </tr>
                    <c:forEach var="tarefa" items="${tarefas}">
                        <tr>
                            <td><a href="editar-tarefa.html?id=${tarefa.id}">${tarefa.id}</a></td>
                            <td>${tarefa.titulo}</td>
                            <td>${tarefa.descricao}</td>
                            <td>${tarefa.dataConcluir}</td>
                            <td>${tarefa.dataConclusao}</td>
                            <td><a href="excluirTarefa.html?id=${tarefa.id}"> X </a></td>
                        </tr>
                    </c:forEach>
                </table>
     
</body>
</html>