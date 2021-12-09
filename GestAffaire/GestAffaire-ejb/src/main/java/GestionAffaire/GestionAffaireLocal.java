/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionAffaire;

import com.sharedaffaire.Affaire;
import javafx.util.Pair;
import javax.ejb.Local;

/**
 *
 * @author Raph
 */
@Local
public interface GestionAffaireLocal {
    public void MAJAffaire(Affaire affaire);
    public void createAffaire(String nomClient, String prenomClient, String adressePostale, String adresseMail,
            int telephone, double coordonneeSpatiale);
     public void senderAffaireSujet(Affaire affaire);
    
}
