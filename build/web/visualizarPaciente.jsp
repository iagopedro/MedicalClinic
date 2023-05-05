<%-- 
    Document   : visualizarMedico
    Created on : May 3, 2023, 6:37:11 PM
    Author     : ALUNO
--%>

<%@page import="classes.Paciente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
        
        <title>Visualizar paciente</title>
    </head>
    <body>
        <table class="table">
            <tr>
                <th>CPF</th>
                <th>Nome</th>
                <th>Endereço</th>
                <th>Contato</th>
                <th>Plano de Saúde</th>
            </tr>
            
            <tr>
                <td>${requestScope.paciente.cpf}</td>
                <td>${requestScope.paciente.nome}</td>
                <td>${requestScope.paciente.endereco}</td>
                <td>${requestScope.paciente.contato}</td>
                <td>${requestScope.paciente.planoSaude}</td>
            </tr>
            
        </table>
            <a href="pacientes.jsp">Voltar</a>
    </body>
</html>
