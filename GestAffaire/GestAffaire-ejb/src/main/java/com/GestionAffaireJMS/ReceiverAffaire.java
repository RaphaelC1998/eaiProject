/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.GestionAffaireJMS;

import GestionAffaire.GestionAffaire;
import com.sharedcommande.Commande;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

/**
 *
 * @author Raph
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "FileCommandeAccepter")
    ,
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class ReceiverAffaire implements MessageListener {
    
    GestionAffaire sAffaire;
    public ReceiverAffaire() {
        sAffaire = new GestionAffaire();
    }
    
    @Override
    public void onMessage(Message message) {
        System.err.println("Message recu");
         if (message instanceof TextMessage){
                TextMessage text = (TextMessage) message;
            try {
                System.out.println("Received: " + text.getText());
            } catch (JMSException ex) {
                Logger.getLogger(ReceiverAffaire.class.getName()).log(Level.SEVERE, null, ex);
            }
         }
         if (message instanceof ObjectMessage) {
                ObjectMessage object = (ObjectMessage) message;
            try {
                Commande commande = (Commande) object.getObject();
            } catch (JMSException ex) {
                Logger.getLogger(ReceiverAffaire.class.getName()).log(Level.SEVERE, null, ex);
            }
                System.out.println("Object message dans receiver affaire : " + object);        
            }         
        else if(message != null){
            System.out.println("Received non text receiver Achats");
        }
    }
}

