/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.achatsJMS;

import com.achats.GestionAchat;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSConsumer;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import com.sharedcommande.Commande;
import java.util.ArrayList;
import javax.jms.BytesMessage;
import javax.jms.ObjectMessage;
import javax.jms.StreamMessage;

/**
 *
 * @author Raph
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "FileCommande")
    ,
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class ReceiverAchats implements MessageListener {
    
    GestionAchat sAchat;
    public ReceiverAchats() {
        sAchat = new GestionAchat();
    }
    
    @Override
    public void onMessage(Message message) {
        System.err.println("Message recu");
         if (message instanceof TextMessage){
                TextMessage text = (TextMessage) message;
            try {
                System.out.println("Received: " + text.getText());
            } catch (JMSException ex) {
                Logger.getLogger(ReceiverAchats.class.getName()).log(Level.SEVERE, null, ex);
            }
         }
         if (message instanceof ObjectMessage) {
                ObjectMessage object = (ObjectMessage) message;
                System.out.println("Object message : " + object);       
                try {
                Commande commande = (Commande) object.getObject();
                //APPEL METIER                
                //sAchat.traiterCommande(commande, true);
            } catch (JMSException ex) {
                Logger.getLogger(ReceiverAchats.class.getName()).log(Level.SEVERE, null, ex);
            }           
        }else if(message != null){
            System.out.println("Received non text receiver Achats");
        }
    }
    
}
