/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.achatsJMS;

import com.achats.GestionAchat;
import com.sharedaffaire.Affaire;
import com.sharedcommande.Commande;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

/**
 *
 * @author Raph
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "SujetAffaire"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic")
})
public class ReceiverSujetAffaire implements MessageListener {
    
    public ReceiverSujetAffaire() {
    }
    
    @Override
    public void onMessage(Message message) {
        if (message instanceof ObjectMessage) {
            try {
                System.out.println("mise a jour4" );
                ObjectMessage om = (ObjectMessage) message;
                Affaire affaire = (Affaire) om.getObject();
                System.out.println("message " + affaire);
            } catch (JMSException ex) {
                Logger.getLogger(GestionAchat.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
