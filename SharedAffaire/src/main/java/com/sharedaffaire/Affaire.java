/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sharedaffaire;
import java.io.Serializable;
import java.util.ArrayList;
/**
 *
 * @author Raph
 */
public class Affaire implements Serializable {
    private int numAffaire;
    private String nomClient;
    private String prenomClient;
    private String adressePostale;
    private String mail;
    private int telephone;
    private int coordonneeSpatiale;

    public Affaire(int numAffaire, String nomClient, String prenomClient, String adressePostale, String mail, int telephone, int coordonneeSpatiale) {
        this.numAffaire = numAffaire;
        this.nomClient = nomClient;
        this.prenomClient = prenomClient;
        this.adressePostale = adressePostale;
        this.mail = mail;
        this.telephone = telephone;
        this.coordonneeSpatiale = coordonneeSpatiale;
    }

  

    public double getCoordonneeSpatiale() {
        return coordonneeSpatiale;
    }

    public void setCoordonneeSpatiale(int coordonneeSpatiale) {
        this.coordonneeSpatiale = coordonneeSpatiale;
    }

    public int getNumAffaire() {
        return numAffaire;
    }

    public void setNumAffaire(int numAffaire) {
        this.numAffaire = numAffaire;
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public String getPrenomClient() {
        return prenomClient;
    }

    public void setPrenomClient(String prenomClient) {
        this.prenomClient = prenomClient;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }
    
    
    
}
