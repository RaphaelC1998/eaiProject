/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestAchatsWs;

import com.achats.GestionAchatLocal;
import com.sharedcommande.Commande;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
/**
 *
 * @author Raph
 */
@WebService(serviceName = "WSGestAchats")
public class gestAchatsWs {
    @EJB
    private GestionAchatLocal ejbRef;
    
    @WebMethod(operationName = "traiterCommande")
    @Oneway
    public void creerAffaire(@WebParam(name = "commande") Commande commande, @WebParam(name = "acceptation") Boolean acceptation){
        ejbRef.traiterCommande(commande, acceptation);
    }
}
