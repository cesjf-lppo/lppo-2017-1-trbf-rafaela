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
                <h1>Usuário: ${usuario.nome}</h1>
                <div id="etiqueta">
                    <h3>A Fazer: </h3>
                    <c:forEach items="${etiquetas}" var="etiqueta">
                        <c:if test="${etiqueta.titulo == 'A Fazer'}">
                            <div id="tarefa">
                                 #${etiqueta.tarefa.id} - ${etiqueta.tarefa.titulo}
                            </div>
                        </c:if>
                    </c:forEach>
                </div>
                <div id="etiqueta">
                    <h3>Fazendo: </h3>
                    <c:forEach items="${etiquetas}" var="etiqueta">
                        <c:if test="${etiqueta.titulo == 'Fazendo'}">
                            <div id="tarefa">
                                 #${etiqueta.tarefa.id} - ${etiqueta.tarefa.titulo}
                            </div>
                        </c:if>
                    </c:forEach>
                </div>
                <div id="etiqueta">
                    <h3>Bloqueado: </h3>
                    <c:forEach items="${etiquetas}" var="etiqueta">
                        <c:if test="${etiqueta.titulo == 'Bloqueado'}">
                            <div id="tarefa">
                                 #${etiqueta.tarefa.id} - ${etiqueta.tarefa.titulo}
                            </div>
                        </c:if>
                    </c:forEach>
                </div>
                <div id="etiqueta">
                    <h3>Finalizado: </h3>
                    <c:forEach items="${etiquetas}" var="etiqueta">
                        <c:if test="${etiqueta.titulo == 'Finalizado'}">
                            <div id="tarefa">
                                 #${etiqueta.tarefa.id} - ${etiqueta.tarefa.titulo}
                            </div>
                        </c:if>
                    </c:forEach>
                </div>
            </div>
            
               
</body>
</html>