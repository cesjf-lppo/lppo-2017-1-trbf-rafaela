<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Novo Livro</title>
    </head>
    <body>
        <%@include file = "jspf/menu.jspf" %>
        <h1>Novo Livro</h1>
        <form method="post">
            <table>
                <tr>
                    <td>Título: </td>
                    <td><input type="text" name="titulo" /></td>
                </tr>
                <tr>
                    <td>Ano </td>
                    <td><input type="number" name="ano" value="2017"/></td>
                </tr>
                <tr>
                    <td>Autor </td>
                    <td><input type="text" name="autor" /></td>
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
