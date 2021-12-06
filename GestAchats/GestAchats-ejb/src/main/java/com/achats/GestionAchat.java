/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.achats;

import com.achatsJMS.SenderAchats;
import com.sharedcommande.Commande;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.util.Pair;
import javax.ejb.Stateless;
import javax.jms.JMSException;
import javax.naming.NamingException;

/**
 *
 * @author Raph
 */
@Stateless
public class GestionAchat implements GestionAchatLocal {
    
    private static final ArrayList<Commande> titresEnStock = new ArrayList<Commande>();
    private static int idTCommande = 0;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    public static void genererCommande() {
        Commande c = new Commande(1);
    }
    
    public void traiterCommande(Commande commande){
       Boolean accepter = true ;
       accepter = verifAccepter(commande);
       Pair<Commande, Boolean> pairAcceptation = new Pair<>(commande, accepter);
       System.out.println("boolean " + accepter);
       senderCommande(pairAcceptation);
    }
    
    public boolean verifAccepter(Commande commande){
        if (commande.getCote() < 100){
            return true;
        }
        return false;
    }
    
    public void senderCommande(Pair pCommandeValidation){
        SenderAchats sAchat = new SenderAchats();
        try {
            sAchat.sendJMSMessageToGESTIONAFFAIRE(pCommandeValidation);
        } catch (JMSException ex) {
            Logger.getLogger(GestionAchat.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(GestionAchat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
