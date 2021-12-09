/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.GestionAffaireJMS;

import com.sharedaffaire.Affaire;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Raph
 */
public class SenderMAJSujetAffaire {
    
    private Message createJMSMessageForSUJET_AFFAIRE(Session session, Object messageData) throws JMSException {
        ObjectMessage om = session.createObjectMessage((Affaire)messageData);
        return om;
    }
    //Envoyer les titres dans le topic app distributeur

    public void sendJMSMessageToSUJET_AFFAIRE(Object messageData) throws JMSException, NamingException {
        Context c = new InitialContext();
        ConnectionFactory cf = (ConnectionFactory) c.lookup("jms/myConnectionFactory");
        Connection conn = null;
        Session s = null;
        try {
            conn = cf.createConnection();
            s = conn.createSession(false, s.AUTO_ACKNOWLEDGE);
            Destination destination = (Destination) c.lookup("SujetAffaire");
            MessageProducer mp = s.createProducer(destination);
            mp.send(createJMSMessageForSUJET_AFFAIRE(s, messageData));
        } finally {
            if (s != null) {
                try {
                    s.close();
                } catch (JMSException e) {
                    Logger.getLogger(this.getClass().getName()).log(Level.WARNING, "Cannot close session", e);
                }
            }
            if (conn != null) {
                conn.close();
            }
        }
    }
}
