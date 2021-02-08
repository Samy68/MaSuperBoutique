<%-- 
    Document   : afficherClient
    Created on : 7 févr. 2021, 23:41:36
    Author     : samy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Afficher un client</title>
        <link type="text/css" rel="stylesheet" href="inc/style.css" />
    </head>
    <body>
        <p class="info">${ message }</p>
        <p>Nom : ${ client.nom }</p>
        <p>Prénom : ${ client.prenom }</p>
        <p>Numéro de téléphone : ${ client.telephone }</p>
        <p>Adresse : ${ client.adresse }</p>
        <p>Email : ${ client.email }</p>        
    </body>
</html>
