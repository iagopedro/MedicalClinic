<%-- 
    Document   : cadastroMedico_success
    Created on : May 2, 2023, 5:35:38 PM
    Author     : ALUNO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
        
        <title>Indicador cadastrado com sucesso!</title>
    </head>
    <body>
        <%
            String indicador = (String) session.getAttribute("indicador");
        %>
        <h1>Indicador <%= indicador %> cadastrado/atualizado com sucesso</h1>
        
        <a href="indicadoresExame.jsp">Ir para lista de indicadores</a>
        <a href="index.html">Voltar para página inicial</a>
    </body>
</html>
