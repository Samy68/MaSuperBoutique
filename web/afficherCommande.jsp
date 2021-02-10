<%-- 
    Document   : afficherCommande
    Created on : 7 févr. 2021, 23:41:48
    Author     : samy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Afficher Commande</title>
        <link type="text/css" rel="stylesheet" href="inc/style.css" />
    </head>
    <body>
        <p class="info">${ message }</p>
        <p>Client</p>
        <p>Nom : ${ client.nom }</p>
        <p>Prénom : ${ client.prenom }</p>
        <p>Adresse : ${ client.adresse }</p>
        <p>Numéro de téléphone : ${ client.telephone }</p>
        <p>Email : ${ client.email }</p>
        <p>Commande</p>
        <p>Date : ${ commande.date }</p>
        <p>Montant : ${ commande.montant }</p>
        <p>Mode de paiement : ${ commande.modePaiement }</p>
        <p>Statut du paiement : ${ commande.statutPaiement }</p>
        <p>Mode de livraison : ${ commande.modeLivraison }</p>
        <p>Statut de la livraison : ${ commande.statutLivraison }</p>        
    </body>
</html>
