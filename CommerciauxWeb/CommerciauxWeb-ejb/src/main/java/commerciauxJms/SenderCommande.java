/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commerciauxJms;

import com.sharedcommande.Commande;
import java.io.Serializable;
import java.util.ArrayList;
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
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
/**
 *
 * @author Raph
 */
public class SenderCommande {
    private Message createJMSMessageForDIFFUSION_GESTIONACHATS(Session session, Object messageData) throws JMSException {
        //ArrayList<Commande> list = new ArrayList<>();
        //list.add((Commande) messageData);
        //ObjectMessage om = session.createObjectMessage(list);
        ObjectMessage om = session.createObjectMessage((Commande)messageData);
        return om;
    }

    public void sendJMSMessageToGESTIONACHATS(Object messageData) throws JMSException, NamingException {
        Context c = new InitialContext();
        ConnectionFactory cf = (ConnectionFactory) c.lookup("jms/myConnectionFactory");
        Connection conn = null;
        Session s = null;
        try {
            conn = cf.createConnection();
            s = conn.createSession(false, s.AUTO_ACKNOWLEDGE);
            Destination destination = (Destination) c.lookup("FileCommande");
            MessageProducer mp = s.createProducer(destination);
            mp.send(createJMSMessageForDIFFUSION_GESTIONACHATS(s, messageData));
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
