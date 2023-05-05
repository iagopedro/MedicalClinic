<%-- 
    Document   : cadastroPaciente
    Created on : May 2, 2023, 5:31:48 PM
    Author     : ALUNO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
        
        <title>Medical Clinic</title>
        
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <div class="container home-container">
            <h1>${requestScope.paciente.cpf ne null ? "Atualizar" : "Cadastrar" } paciente</h1>
            
            <form action="PacienteServlet" method="post">
                ${(requestScope.paciente ne null)?'<input type="hidden" name="cpf" value="'.concat(requestScope.paciente.cpf).concat('"/>'):''}
                ${(requestScope.paciente ne null)?'<input type="hidden" name="op" value="update"/>':''}
                
                <div class="input-group mb-3">
                    <span class="input-group-text" id="cpf">CPF:</span>
                    ${requestScope.paciente ne null ? '<input type="text" id="cpf" name="cpf" class="form-control" aria-label="Username" aria-describedby="cpf" value="'.concat(requestScope.paciente.cpf).concat('"/>') : '<input type="text" id="cpf" name="cpf" class="form-control" aria-label="Username" aria-describedby="cpf"/>'}          
                </div>
                
                <div class="input-group mb-3">
                    <span class="input-group-text" id="nome">Nome:</span>
                    <input type="text" id="nome" name="nome" class="form-control" aria-label="Username" aria-describedby="nome" value="${requestScope.paciente.nome ne null ? (requestScope.paciente.nome) : ""}">
                </div>
                
                <div class="input-group mb-3">
                    <span class="input-group-text" id="endereco">Endereço:</span>
                    <input type="text" id="endereco" name="endereco" class="form-control" aria-label="Username" aria-describedby="endereco" value="${requestScope.paciente.endereco ne null ? (requestScope.paciente.endereco) : ""}">
                </div>
                
                <div class="input-group mb-3">
                    <span class="input-group-text" id="contato">Contato:</span>
                    <input type="text" id="contato" name="contato" class="form-control" aria-label="Username" aria-describedby="contato" value="${requestScope.paciente.contato ne null ? (requestScope.paciente.contato) : ""}">
                </div>
                
                <div class="input-group mb-3">
                    <span class="input-group-text" id="planoSaude">Plano de saúde:</span>
                    <input type="text" id="planoSaude" name="planoSaude" class="form-control" aria-label="Username" aria-describedby="planoSaude" value="${requestScope.paciente.planoSaude ne null ? (requestScope.paciente.planoSaude) : ""}">
                </div>
                
                <button type="submit" class="btn btn-primary">${requestScope.paciente.cpf ne null ? "Atualizar" : "Cadastrar"}</button>
                <button type="button" class="btn btn-light">
                    <a href="index.html">Voltar</a>
                </button>
                
            </form>
        </div>
    </body>
</html>
