/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testjmseai;

/**
 *
 * @author Raph
 */

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.Connection;
import javax.jms.Message;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSConsumer;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
public class TestJMSEai {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         Context context = null;
        ConnectionFactory factory = null;
        Connection connection = null;
        String factoryName = "jms/myConnectionFactory";
        String destName = "FileTest";
        Destination dest = null;
        int count = 5;
        Session session = null;
        MessageProducer sender = null;
        
            try{
        context = new InitialContext();
        
        factory = (ConnectionFactory) context.lookup(factoryName);
        System.out.println("Connection factory " + factory.toString());
        
        dest = (Destination) context.lookup(destName);
        
        connection = factory.createConnection();
        
        session = connection.createSession(
        false, Session.AUTO_ACKNOWLEDGE);
        
        sender = session.createProducer(dest);
        
        connection.start();
        
        String text = "toest";
        
        for (int i = 0; i<count; ++i){
            TextMessage message = session.createTextMessage();
            message.setText(text + (i+1));
            sender.send(message);
            System.out.println("Sent: " + message.getText());
        }
        } catch (NamingException ex) {
            Logger.getLogger(JMSConsumer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JMSException ex) {
            Logger.getLogger(JMSConsumer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
