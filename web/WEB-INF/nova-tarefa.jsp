<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nova Tarefa</title>
    </head>
    <body>
        <%@include file = "jspf/menu.jspf" %>
        <%@include file = "jspf/header.jspf" %>
        <%@include file = "jspf/footer.jspf" %>
        <h1>Nova Tarefa</h1>
        <form method="post">
            <table>
                <tr>
                    <td>Titulo </td>
                    <td><input type="text" name="titulo" /></td>
                </tr>
                <tr>
                    <td>Descricao </td>
                    <td><input type="text" name="descricao" /></td>
                </tr>
                <tr>
                             <td>Data Prevista Conclusão: </td>
                            <td>
                                <input type="date" name="dataConcluir" />
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
