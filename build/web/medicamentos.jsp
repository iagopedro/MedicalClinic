<%-- 
    Document   : medicos
    Created on : May 2, 2023, 5:51:42 PM
    Author     : ALUNO
--%>

<%@page import="classes.Medicamento"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
        
        <title>Medicamentos | Medical Clinic</title>
    </head>
    <body>
        <h1>Lista de médicos</h1>
        
        <%
            List<Medicamento> medicamentos = (List<Medicamento>) session.getAttribute("medicamentos");
        %>
        
        
        
        <table class="table">
            <tr>
                <th>Código</th>
                <th>Nome</th>
                <th>Dosagem</th>
                <th>Tipo da dosagem</th>
                <th>Descrição</th>
                <th>Observação</th>
                <th>Operações</th>
            </tr>
            
        <% for(Medicamento m: medicamentos) { %>
        
            <tr>
                <td><%= m.getCodigo() %></td>
                <td><%= m.getNome() %></td>
                <td><%= m.getDosagem() %></td>
                <td><%= m.getTipoDosagem() %></td>
                <td><%= m.getDescricao() %></td>
                <td><%= m.getObservacao() %></td>
                <td><a href="MedicamentoServlet?codigo=<%= m.getCodigo() %>">Visualizar</a> 
                    <a href="MedicamentoServlet?codigo=<%= m.getCodigo() %>&op=update">Alterar</a> 
                    <a href="MedicamentoServlet?codigo=<%= m.getCodigo() %>&op=delete">Excluir</a></td>
            </tr>
        
        <% } %>
    
        </table>
        
        <button type="button" class="btn btn-light">
            <a href="index.html">Voltar</a>
        </button>
    </body>
</html>
