<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Usuario</title>
    </head>
    <body>
        <%@include file = "jspf/menu.jspf" %>
        <h1>Editar Usuario</h1>
        <form method="post">
            <table>
                 <tr>
                    <td>Id: </td>
                    <td> <input type="hidden" name="id" value="${usuario.id}"/> ${usuario.id} </td>
                </tr>
                <tr>
                    <td>Nome Completo: </td>
                    <td><input type="text" name="titulo" value="${usuario.nomeCompleto}" /> ${usuario.nomeCompleto}</td>
                </tr>
                <tr>
                    <td>Email: </td>
                    <td><input type="text" name="titulo" value="${usuario.email}" /> ${usuario.email}</td>
                </tr>
                <tr>
                    <td>Senha </td>
                    <td><input type="number" name="senha" value="${usuario.senha}"/> ${usuario.senha}</td>
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
