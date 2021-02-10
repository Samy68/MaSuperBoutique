/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.msb.servlets;

import com.msb.beans.Client;
import com.msb.beans.Commande;
import java.io.IOException;
import java.util.Locale;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.joda.time.DateTime;

/**
 *
 * @author samy
 */
public class CreerCommande extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {

        // récupère les données client
        String nom = request.getParameter( "nomClient" );
        String prenom = request.getParameter( "prenomClient" );
        String adresse = request.getParameter( "adresseClient" );
        String telephone = request.getParameter( "telephoneClient" );
        String email = request.getParameter( "emailClient" );

        // créé une date
        DateTime dt = new DateTime();
        String date = dt.toString( "dd/MM/yyyy HH:mm:ss" );

        // récupère les données de la commande        
        double montant;
        try {
            montant = Double.parseDouble( request.getParameter( "montantCommande" ) );
        } catch ( NumberFormatException e ) {
            montant = -1;
        }

        String modePaiement = request.getParameter( "modePaiementCommande" );
        String statutPaiement = request.getParameter( "statutPaiementCommande" );
        String modeLivraison = request.getParameter( "modeLivraisonCommande" );
        String statutLivraison = request.getParameter( "statutLivraisonCommande" );

        // vérifie que les champs obligatoires sont bien remplis
        String message = "";
        if ( nom.trim().isEmpty() || adresse.trim().isEmpty() 
                || telephone.trim().isEmpty() || date.trim().isEmpty() 
                || montant == -1 || modePaiement.trim().isEmpty()
                || modeLivraison.trim().isEmpty() ) {
            message = "Erreur - Vous n'avez pas rempli tous les champs obligatoires<br>"
                    + "<a href='/MaSuperBoutique/creerCommande.jsp'>Cliquez ici</a>"
                    + " pour accéder au formulaire de création d'une commande.";
        } else {
            message = "Commande créée avec succès !";
        }
        
        // créé un bean Client
        Client client = new Client();
        client.setNom( nom );
        client.setPrenom( prenom );
        client.setAdresse( adresse );
        client.setTelephone( telephone );
        client.setEmail( email );
        
        // créé un bean Commande
        Commande commande = new Commande();
        commande.setClient( client );
        commande.setDate( date );
        commande.setMontant( montant );
        commande.setModePaiement( modePaiement );
        commande.setStatutPaiement( statutPaiement );
        commande.setModeLivraison( modeLivraison );
        commande.setStatutLivraison( statutLivraison );

        // passe les données à la vue
        request.setAttribute( "message", message );
        request.setAttribute( "commande", commande );
        this.getServletContext().getRequestDispatcher( "/afficherCommande.jsp" )
                .forward( request, response );
    }
}
