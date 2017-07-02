<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar Etiqueta</title>
    </head>
    <body>
        <%@include file = "jspf/menu.jspf" %>
        <%@include file = "jspf/header.jspf" %>
        <%@include file = "jspf/footer.jspf" %>
                <h1>Listar Etiqueta</h1>
                <table border='1'>
                    <tr>
                        <th>Id</th>
                        <th>Id Autor</th>
                        <th>Id Tarefa</th>
                        <th>Titulo</th>
                        <th>Excluir</th>
                    </tr>
                    <c:forEach var="etiqueta" items="${etiquetas}">
                        <tr>
                            <td><a href="editar-etiqueta.html?id=${etiqueta.id}">${etiqueta.id}</a></td>
                            <td><a href="listar-etiqueta.html?idAutor=${etiqueta.usuario.id}">${etiqueta.usuario.nome}</td>
                            <td>${etiqueta.tarefa.titulo}</td>
                            <td><a href="listar-etiqueta.html?titulo=${etiqueta.titulo}">${etiqueta.titulo}</td>
                            <td><a href="excluir-etiqueta.html?id=${etiqueta.id}">X</a></td>
                        </tr>    
                    </c:forEach>        
                </table>
                
                
</body>
</html>