/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.CommerciauxService;

import java.util.HashMap;
import javax.ejb.Singleton;
import com.sharedcommande.Commande;
import commerciauxJms.SenderCommande;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.JMSException;
import javax.jms.ObjectMessage;
import javax.naming.NamingException;

/**
 *
 * @author Raph
 */
@Singleton
public class CommandeBean implements CommandeBeanLocal {

   private HashMap<Integer, Commande> lescommandes ;
    private static ArrayList<Commande> commandesAEnvoyer = new ArrayList<Commande>();
   private int lastid;

    public CommandeBean() {
        this.lescommandes = new HashMap();
        this.lastid = 0;
    }
    
    @Override
    public Commande ajouterCom(int idCommande) {
        Commande c = new Commande(idCommande);
        createAndSendCommande(c);
        this.lescommandes.put(lastid, c);
        lastid++;
        return c;
    }
    
    @Override
    public Commande getPosition(int idCommande) {
        return this.lescommandes.get(idCommande);
    }
    
    @Override
    public void deleteCommande(int idCommande) {
        this.lescommandes.remove(idCommande);
    }
    
    @Override
    public void createAndSendCommande(Commande c) {
        System.out.println("DISTRIBUTEUR - Contrat créé, envoi du contrat");
        commandesAEnvoyer.add(c);
        SenderCommande sender = new SenderCommande();
        Object om = (Object)c;
        try {
            sender.sendJMSMessageToGESTIONACHATS(om);
        } catch (JMSException ex) {
            Logger.getLogger(CommandeBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(CommandeBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
