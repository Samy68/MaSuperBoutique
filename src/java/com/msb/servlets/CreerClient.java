/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.msb.servlets;

import com.msb.beans.Client;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author samy
 */
public class CreerClient extends HttpServlet {

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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // récupère les données client
        String nom = request.getParameter("nomClient");
        String prenom = request.getParameter("prenomClient");
        String adresse = request.getParameter("adresseClient");
        String telephone = request.getParameter("telephoneClient");
        String email = request.getParameter("emailClient");
        
        // si un champ pas rempli, erreur, sinon, succès
        String message = "";
        
        if ( nom.isEmpty() || adresse.isEmpty() || telephone.isEmpty() ) {
            message = "Erreur - Vous n'avez pas rempli tous les champs obligatoires<br>"
                    + "<a href='/MaSuperBoutique/creerClient.jsp'>Cliquez ici</a>"
                    + " pour accéder au formulaire de création d'un client.";
        } else {
            message = "Client créé avec succès !";
        }
        
        // créé du bean client
        Client client = new Client();
        client.setNom(nom);
        client.setPrenom(prenom);
        client.setAdresse(adresse);
        client.setTelephone(telephone);
        client.setEmail(email);
        
        // passe le client et le message en paramètre de la requête
        request.setAttribute("client", client);
        request.setAttribute("message", message);
        
        // transmet à la jsp d'affichage du client
        this.getServletContext().getRequestDispatcher("/afficherClient.jsp")
                .forward(request, response);        
    }
}
