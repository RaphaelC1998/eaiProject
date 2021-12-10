/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestAffaireWs;

import GestionAffaire.GestionAffaireLocal;
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
@WebService(serviceName = "WSGestAffaire")
public class gestAffaireWs {
    @EJB
    private GestionAffaireLocal ejbRef;
    
    @WebMethod(operationName = "createAffaire")
    @Oneway
    public void creerAffaire(@WebParam(name = "nomClient") String nomClient,
            @WebParam(name = "prenomClient") String prenomClient, @WebParam(name = "adressePostale") String adressePostale,
            @WebParam(name = "adresseMail") String adresseMail, @WebParam(name = "telephone") int telephone,
            @WebParam(name = "coordonneeSpatiale") int coordonneeSpatiale) {
        ejbRef.createAffaire(nomClient, prenomClient, adressePostale,adresseMail,
            telephone,coordonneeSpatiale);
    }
}
