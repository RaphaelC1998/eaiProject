/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.GestionAffaireJMS;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Raph
 */
public class ReceiverAffaire {
    
    public static void main(String[] args) {
        System.out.println("MESSAGE CLASSLOADER IN JMSMANAGER:" );
        /*Context context = null;
        ConnectionFactory factory = null;
        Connection connection = null;
        String factoryName = "jms/myConnectionFactory";
        String destName = "FileTest";
        Destination dest = null;
        int count = 3;
        Session session = null;
        MessageConsumer receiver = null;
         System.out.println("MESSAGE CLASSLOADER IN JMSMANAGER:" + 
       javax.jms.Message.class.getProtectionDomain().getCodeSource().getLocation());
        
         
        try{
        context = new InitialContext();
        
        factory = (ConnectionFactory) context.lookup(factoryName);
        
        
        dest = (Destination) context.lookup(destName);
        
        connection = factory.createConnection();
        
        session = connection.createSession(
        false, Session.AUTO_ACKNOWLEDGE);
        
       receiver = session.createConsumer(dest);
                
        connection.start();
        System.out.println("avant le for");
        for (int i = 0; i<count; i++){
            Message message = receiver.receive();
            System.out.println("message " + message);
            if (message instanceof TextMessage){
                TextMessage text = (TextMessage) message;
                System.out.println("Received: " + text.getText());
            }else if(message != null){
                System.out.println("Received non text message");
            }
        }
        } catch (NamingException ex) {
            Logger.getLogger(ReceiverAffaire.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        catch (JMSException ex) {
            Logger.getLogger(ReceiverAffaire.class.getName()).log(Level.SEVERE, null, ex);
        }*/
                
                
    }
    
}
