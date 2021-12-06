/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.CommerciauxService;

import com.sharedcommande.Commande;
import java.util.HashMap;
import javax.ejb.Local;

/**
 *
 * @author Raph
 */
@Local
public interface CommandeBeanLocal {
    
    public Commande ajouterCom(int idCommande);
    public Commande getPosition(int idCommande);
    public void deleteCommande(int idCommande);
    public void createAndSendCommande(Commande c);
    
}
