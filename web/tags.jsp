<%-- 
    Document   : tags
    Created on : May 3, 2023, 7:10:51 PM
    Author     : ALUNO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tags" uri="/WEB-INF/tlds/tagsIFPE.tld" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Aprendendo Taglib!</h1>
        
        <tags:Tag1/>
        <tags:Tag2>Isso aqui vem da Tag2</tags:Tag2>
        <tags:Tag3 attr1="teste1" attr2="2"/>
    </body>
</html>
