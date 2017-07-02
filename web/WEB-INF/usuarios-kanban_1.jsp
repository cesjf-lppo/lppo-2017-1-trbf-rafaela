<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
    <head>
        <title></title>
        <meta charset="UTF-8" />
       
    </head>
    <body>
    
           <%@include file = "jspf/menu.jspf" %>
        <%@include file = "jspf/header.jspf" %>
        <%@include file = "jspf/footer.jspf" %>
            <div id="conteudo">
                <h1>Selecione o usuário para montar o Kanban:</h1>
                
                <form method="post">
                    Usuário: 
                    <select name="idUsuario">
                        <c:forEach items="${usuarios}" var="usuario">
                            <option value="${usuario.id}">${usuario.nome}</option>
                        </c:forEach>
                    </select>
                    <button type="submit">Montar</button>
                </form>
                
                
            </div>
            
</body>
</html>