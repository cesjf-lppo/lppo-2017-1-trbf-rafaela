<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nova Etiqueta</title>
    </head>
    <body>
        <%@include file = "jspf/menu.jspf" %>
        <%@include file = "jspf/header.jspf" %>
        <%@include file = "jspf/footer.jspf" %>
                <h1>Nova Etiqueta</h1>
                <form method="post">
                    <table>
                        <tr>
                            <td>Usuário: </td>
                            <td>
                                <select name="idUsuario">
                                    <c:forEach var="usuario" items="${usuarios}">
                                        <option value="${usuario.id}">${usuario.nome}</option>
                                    </c:forEach>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>Tarefa </td>
                            <td>
                                <select name="idTarefa">
                                    <c:forEach var="tarefa" items="${tarefas}">
                                        <option value="${tarefa.id}">${tarefa.titulo}</option>
                                    </c:forEach>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>Titulo: </td>
                            <td>
                                
                                <select name="titulo">
                                    <option value="A Fazer">A Fazer</option> 
                                    <option value="Fazendo">Fazendo</option>
                                    <option value="Finalizado">Finalizado</option>
                                    <option value="Bloqueado">Bloqueado</option>
                                </select>
                            </td>
                        </tr>
                       
                        <tr>
                            <td colspan="2" align="right">
                                <button type="submit">Enviar</button>
                            </td>
                        </tr>
                    </table>
                </form>
                 
</body>
</html>