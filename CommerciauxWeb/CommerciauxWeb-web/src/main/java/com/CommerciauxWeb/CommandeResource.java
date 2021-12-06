/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.CommerciauxWeb;

import com.google.gson.Gson;
import static java.lang.Integer.parseInt;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.POST;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Raph
 */
@Path("Commande")
@RequestScoped
public class CommandeResource {

    com.CommerciauxService.CommandeBeanLocal commandeBean = lookupCommandeBeanLocal();

    @Context
    private UriInfo context;
    private Gson gson;

     public CommandeResource() {
        this.gson = new Gson();
        this.commandeBean = this.lookupCommandeBeanLocal();
    }


    /**
     * Retrieves representation of an instance of com.CommerciauxWeb.CommandeResource
     * @return an instance of java.lang.String
     * http://localhost:8080/CommerciauxWeb-web/webresources/Commande/
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        return this.commandeBean.getPosition(0).toString();
    }
    
     /**
     * Renvoie la représentation JSON d'un pose Pour l'appeler on doit utiliser l'URL :
     * http://localhost:8080/CommerciauxWeb-web/webresources/Commande/?idCommande=0
    *
     */
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String postJson(@QueryParam("idCommande") String idCommande) {
        if ((idCommande == null) || (idCommande.isEmpty())) {
            idCommande = "1";
        }
        return this.gson.toJson(this.commandeBean.ajouterCom(parseInt(idCommande)));
    }

    /**
     * PUT method for updating or creating an instance of CommandeResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
        // pas encore opérationnel
    }

    private com.CommerciauxService.CommandeBeanLocal lookupCommandeBeanLocal() {
        try {
            javax.naming.Context c = new InitialContext();
            return (com.CommerciauxService.CommandeBeanLocal) c.lookup("java:global/CommerciauxWeb-ear/CommerciauxWeb-ejb-1.0-SNAPSHOT/CommandeBean");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
