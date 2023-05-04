<%-- 
    Document   : medicos
    Created on : May 2, 2023, 5:51:42 PM
    Author     : ALUNO
--%>

<%@page import="classes.Medico"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
        
        <title>Médicos | Medical Clinic</title>
    </head>
    <body>
        <h1>Lista de médicos</h1>
        
        <%
            List<Medico> medicos = (List<Medico>) session.getAttribute("medicos");
        %>
        
        
        
        <table class="table">
            <tr>
                <th>CRM</th>
                <th>Nome</th>
                <th>Especialidade</th>
                <th>Contato</th>
                <th>Operações</th>
            </tr>
            
        <% for(Medico m: medicos) { %>
        
            <tr>
                <td><%= m.getCrm() %></td>
                <td><%= m.getNome() %></td>
                <td><%= m.getEspecialidade() %></td>
                <td><%= m.getContato() %></td>
                <td><a href="MedicoServlet?codigo=<%= m.getCrm() %>">Visualizar</a> 
                    <a href="MedicoServlet?codigo=<%= m.getCrm() %>&op=update">Alterar</a> 
                    <a href="MedicoServlet?codigo=<%= m.getCrm() %>&op=delete">Excluir</a></td>
            </tr>
        
        <% } %>
    
        </table>
        
        <button type="button" class="btn btn-light">
            <a href="index.html">Voltar</a>
        </button>
    </body>
</html>
