<%-- 
    Document   : cadastroMedico
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
            <h1>${requestScope.medico.crm ne null ? "Atualizar" : "Cadastrar" } médico</h1>
            
            <form action="MedicoServlet" method="post">
                ${(requestScope.medico ne null)?'<input type="hidden" name="crm" value="'.concat(requestScope.medico.crm).concat('"/>'):''}
                ${(requestScope.medico ne null)?'<input type="hidden" name="op" value="update"/>':''}
                
                <div class="input-group mb-3">
                    <span class="input-group-text" id="crm">CRM:</span>
                    ${requestScope.medico ne null ? '<input type="text" id="crm" name="crm" class="form-control" aria-label="Username" aria-describedby="crm" value="'.concat(requestScope.medico.crm).concat('"/>') : '<input type="text" id="crm" name="crm" class="form-control" aria-label="Username" aria-describedby="crm"/>'}          
                </div>
                
                <div class="input-group mb-3">
                    <span class="input-group-text" id="nome">Nome:</span>
                    <input type="text" id="nome" name="nome" class="form-control" aria-label="Username" aria-describedby="nome" value="${requestScope.medico.nome ne null ? (requestScope.medico.nome) : ""}">
                </div>
                
                <div class="input-group mb-3">
                    <span class="input-group-text" id="especialidade">Especialidade:</span>
                    <input type="text" id="especialidade" name="especialidade" class="form-control" aria-label="Username" aria-describedby="especialidade" value="${requestScope.medico.especialidade ne null ? (requestScope.medico.especialidade) : ""}">
                </div>
                
                <div class="input-group mb-3">
                    <span class="input-group-text" id="contato">Contato:</span>
                    <input type="text" id="contato" name="contato" class="form-control" aria-label="Username" aria-describedby="contato" value="${requestScope.medico.contato ne null ? (requestScope.medico.contato) : ""}">
                </div>
                
                <button type="submit" class="btn btn-primary">${requestScope.medico.crm ne null ? "Atualizar" : "Cadastrar"}</button>
                <button type="button" class="btn btn-light">
                    <a href="index.html">Voltar</a>
                </button>
                
            </form>
        </div>
    </body>
</html>
