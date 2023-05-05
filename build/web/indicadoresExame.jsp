<%-- 
    Document   : medicos
    Created on : May 2, 2023, 5:51:42 PM
    Author     : ALUNO
--%>

<%@page import="classes.IndicadorExame"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
        
        <title>Indicadores | Medical Clinic</title>
    </head>
    <body>
        <h1>Lista de indicadores</h1>
        
        <%
            List<IndicadorExame> indicadores = (List<IndicadorExame>) session.getAttribute("indicadoresExame");
        %>
        
        
        
        <table class="table">
            <tr>
                <th>Código</th>
                <th>Indicador</th>
                <th>Descrição</th>
                <th>Valor mínimo de referência</th>
                <th>Valor máximo de referência</th>
                <th>Operações</th>
            </tr>
            
        <% for(IndicadorExame i: indicadores) { %>
        
            <tr>
                <td><%= i.getCodigo() %></td>
                <td><%= i.getIndicador() %></td>
                <td><%= i.getDescricao()) %></td>
                <td><%= i.getMinValorReferencia() %></td>
                <td><%= i.getMaxValorReferencia() %></td>
                <td><a href="MedicoServlet?crm=<%= i.getCrm() %>">Visualizar</a> 
                    <a href="MedicoServlet?crm=<%= igetCrm() %>&op=update">Alterar</a> 
                    <a href="MedicoServlet?crm=<%= i.getCrm() %>&op=delete">Excluir</a></td>
            </tr>
        
        <% } %>
    
        </table>
        
        <button type="button" class="btn btn-light">
            <a href="index.html">Voltar</a>
        </button>
    </body>
</html>
