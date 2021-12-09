/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionAffaire;

import com.GestionAffaireJMS.SenderMAJSujetAffaire;
import com.sharedaffaire.Affaire;
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
public class GestionAffaire implements GestionAffaireLocal {
    
    private static final ArrayList<Affaire> affaireEnCours = new ArrayList<Affaire>();
    private static int idTAffaire = 0;
    
    @Override
    public void MAJAffaire(Affaire affaire){
       //A ajouter des fonctionnalité si on a des idées       
    }
    
    @Override
    public void createAffaire(String nomClient, String prenomClient, String adressePostale, String adresseMail,
            int telephone, double coordonneeSpatiale){
       Affaire a = new Affaire(idTAffaire, nomClient, prenomClient, adressePostale,adresseMail,telephone, coordonneeSpatiale);
       idTAffaire = idTAffaire+1;
       senderAffaireSujet(a);
    }
    
    @Override
    public void senderAffaireSujet(Affaire affaire){
        SenderMAJSujetAffaire sAchat = new SenderMAJSujetAffaire();
        try {
            sAchat.sendJMSMessageToSUJET_AFFAIRE(affaire);
        } catch (JMSException ex) {
            Logger.getLogger(GestionAffaire.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(GestionAffaire.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
