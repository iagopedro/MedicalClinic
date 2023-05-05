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
            <h1>${requestScope.indicadorExame.codigo ne null ? "Atualizar" : "Cadastrar" } Indicador de exame</h1>
            
            <form action="IndicadorExameServlet" method="post">
                ${(requestScope.indicadorExame ne null)?'<input type="hidden" name="codigo" value="'.concat(requestScope.indicadorExame.codigo).concat('"/>'):''}
                ${(requestScope.indicadorExame ne null)?'<input type="hidden" name="op" value="update"/>':''}
                
                <div class="input-group mb-3">
                    <span class="input-group-text" id="codigo">Código:</span>
                    ${requestScope.indicadorExame ne null ? '<input type="text" id="codigo" name="codigo" class="form-control" aria-label="Username" aria-describedby="codigo" value="'.concat(requestScope.indicadorExame.codigo).concat('"/>') : '<input type="text" id="codigo" name="codigo" class="form-control" aria-label="Username" aria-describedby="codigo"/>'}          
                </div>
                
                <div class="input-group mb-3">
                    <span class="input-group-text" id="indicador">Indicador:</span>
                    <input type="text" id="indicador" name="indicador" class="form-control" aria-label="Username" aria-describedby="indicador" value="${requestScope.indicadorExame.indicador ne null ? (requestScope.indicadorExame.indicador) : ""}">
                </div>
                
                <div class="input-group mb-3">
                    <span class="input-group-text" id="descricao">Descrição:</span>
                    <input type="text" id="descricao" name="descricao" class="form-control" aria-label="Username" aria-describedby="descricao" value="${requestScope.indicadorExame.descricao ne null ? (requestScope.indicadorExame.descricao) : ""}">
                </div>
                
                <div class="input-group mb-3">
                    <span class="input-group-text" id="minValorReferencia">Valor mínimo de referência:</span>
                    <input type="text" id="minValorReferencia" name="minValorReferencia" class="form-control" aria-label="Username" aria-describedby="minValorReferencia" value="${requestScope.indicadorExame.minValorReferencia ne null ? (requestScope.indicadorExame.minValorReferencia) : ""}">
                </div>
                
                <div class="input-group mb-3">
                    <span class="input-group-text" id="maxValorReferencia">Valor máximo de referência:</span>
                    <input type="text" id="maxValorReferencia" name="maxValorReferencia" class="form-control" aria-label="Username" aria-describedby="maxValorReferencia" value="${requestScope.indicadorExame.maxValorReferencia ne null ? (requestScope.indicadorExame.maxValorReferencia) : ""}">
                </div>
                
                <button type="submit" class="btn btn-primary">${requestScope.indicadorExame.codigo ne null ? "Atualizar" : "Cadastrar"}</button>
                <button type="button" class="btn btn-light">
                    <a href="index.html">Voltar</a>
                </button>
                
            </form>
        </div>
    </body>
</html>
