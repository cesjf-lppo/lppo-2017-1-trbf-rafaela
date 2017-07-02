<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Tarefa</title>
    </head>
    <body>
        <%@include file = "jspf/menu.jspf" %>
        <%@include file = "jspf/header.jspf" %>
        <%@include file = "jspf/footer.jspf" %>
                <h1>Editar Etiqueta</h1>
                <form method="post">
                    <table>
                         <tr>
                            <td>Id: </td>
                            <td> <input type="hidden" name="id" value="${etiqueta.id}"/>${etiqueta.id}</td>
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