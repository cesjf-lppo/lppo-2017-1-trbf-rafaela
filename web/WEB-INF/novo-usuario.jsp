<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Novo Usuario</title>
    </head>
    <body>
        <%@include file = "jspf/menu.jspf" %>
        <%@include file = "jspf/header.jspf" %>
        <%@include file = "jspf/footer.jspf" %>
        <h1>Novo Usuario</h1>
        <form method="post">
            <table>
                <tr>
                    <td>Nome </td>
                    <td><input type="text" name="nome" /></td>
                </tr>
                <tr>
                    <td>Email </td>
                    <td><input type="text" name="email" /></td>
                </tr>
                <tr>
                    <td>Senha </td>
                    <td><input type="text" name="senha" /></td>
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
