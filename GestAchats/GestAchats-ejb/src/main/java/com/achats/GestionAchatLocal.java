/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.achats;

import com.sharedcommande.Commande;
import javafx.util.Pair;
import javax.ejb.Local;

/**
 *
 * @author Raph
 */
@Local
public interface GestionAchatLocal {
   public void traiterCommande(Commande commande, Boolean accepter);
   public boolean verifAccepter(Commande commande);
   public void senderCommande(Pair pCommandeValidation);
           
    
}
