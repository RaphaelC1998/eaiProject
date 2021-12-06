/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sharedcommande;

import java.io.Serializable;

/**
 *
 * @author Raph
 */
public class Commande  implements Serializable{
    private int idCommande;
    private String referenceCatalogue;
    private int cote;
    private int montantNegocie;

    public Commande(int idCommande) {
        this.idCommande = idCommande;
    }

    public int getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(int idCommande) {
        this.idCommande = idCommande;
    }

    public String getReferenceCatalogue() {
        return referenceCatalogue;
    }

    public void setReferenceCatalogue(String referenceCatalogue) {
        this.referenceCatalogue = referenceCatalogue;
    }

    public int getCote() {
        return cote;
    }

    public void setCote(int cote) {
        this.cote = cote;
    }

    public int getMontantNegocie() {
        return montantNegocie;
    }

    public void setMontantNegocie(int montantNegocie) {
        this.montantNegocie = montantNegocie;
    }
    
   
    
}
