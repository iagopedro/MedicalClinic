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
            <h1>${requestScope.medicamento.codigo ne null ? "Atualizar" : "Cadastrar" } medicamento</h1>
            
            <form action="MedicamentoServlet" method="post">
                ${(requestScope.medicamento ne null)?'<input type="hidden" name="codigo" value="'.concat(requestScope.medicamento.codigo).concat('"/>'):''}
                ${(requestScope.medicamento ne null)?'<input type="hidden" name="op" value="update"/>':''}
                
                <div class="input-group mb-3">
                    <span class="input-group-text" id="codigo">Código:</span>
                    ${requestScope.medicamento ne null ? '<input type="text" id="codigo" name="codigo" class="form-control" aria-label="Username" aria-describedby="codigo" value="'.concat(requestScope.medicamento.codigo).concat('"/>') : '<input type="text" id="codigo" name="codigo" class="form-control" aria-label="Username" aria-describedby="codigo"/>'}          
                </div>
                
                <div class="input-group mb-3">
                    <span class="input-group-text" id="nome">Nome:</span>
                    <input type="text" id="nome" name="nome" class="form-control" aria-label="Username" aria-describedby="nome" value="${requestScope.medicamento.nome ne null ? (requestScope.medicamento.nome) : ""}">
                </div>
                
                <div class="input-group mb-3">
                    <span class="input-group-text" id="dosagem">Dosagem:</span>
                    <input type="text" id="dosagem" name="dosagem" class="form-control" aria-label="Username" aria-describedby="dosagem" value="${requestScope.medicamento.dosagem ne null ? (requestScope.medicamento.dosagem) : ""}">
                </div>
                
                <div class="input-group mb-3">
                    <span class="input-group-text" id="tipoDosagem">Tipo da dosagem:</span>
                    <input type="text" id="tipoDosagem" name="tipoDosagem" class="form-control" aria-label="Username" aria-describedby="tipoDosagem" value="${requestScope.medicamento.tipoDosagem ne null ? (requestScope.medicamento.tipoDosagem) : ""}">
                </div>
                
                <div class="input-group mb-3">
                    <span class="input-group-text" id="descricao">Descrição:</span>
                    <input type="text" id="descricao" name="descricao" class="form-control" aria-label="Username" aria-describedby="descricao" value="${requestScope.medicamento.descricao ne null ? (requestScope.medicamento.descricao) : ""}">
                </div>
                
                <div class="input-group mb-3">
                    <span class="input-group-text" id="observacao">Observação:</span>
                    <input type="text" id="observacao" name="observacao" class="form-control" aria-label="Username" aria-describedby="observacao" value="${requestScope.medicamento.observacao ne null ? (requestScope.medicamento.observacao) : ""}">
                </div>
                
                <button type="submit" class="btn btn-primary">${requestScope.medicamento.codigo ne null ? "Atualizar" : "Cadastrar"}</button>
                <button type="button" class="btn btn-light">
                    <a href="index.html">Voltar</a>
                </button>
                
            </form>
        </div>
    </body>
</html>
