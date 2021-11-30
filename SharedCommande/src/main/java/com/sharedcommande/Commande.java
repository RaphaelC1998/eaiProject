/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sharedcommande;

/**
 *
 * @author Raph
 */
public class Commande {
    private String referenceCatalogue;
    private int cote;
    private int montantNegocie;

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
