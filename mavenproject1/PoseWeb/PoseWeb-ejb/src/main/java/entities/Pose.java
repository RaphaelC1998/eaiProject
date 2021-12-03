/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;


import java.util.Date;

/**
 *
 * @author Raph
 */
public class Pose {
    int idPose;
    Date dateDePose;
    int idEquipePoseur;
    String statutPose;

    public String getStatutPose() {
        return statutPose;
    }

    public void setStatutPose(String statutPose) {
        this.statutPose = statutPose;
    }

    public Pose(int idPose, int idEquipePoseur) {
        this.idPose = idPose;
        this.idEquipePoseur = idEquipePoseur;
        this.statutPose = statutPose;
    }

    public int getIdPose() {
        return idPose;
    }

    public void setIdPose(int idPose) {
        this.idPose = idPose;
    }

    public Date getDateDePose() {
        return dateDePose;
    }

    public void setDateDePose(Date dateDePose) {
        this.dateDePose = dateDePose;
    }

    public int getIdEquipePoseur() {
        return idEquipePoseur;
    }

    public void setIdEquipePoseur(int idEquipePoseur) {
        this.idEquipePoseur = idEquipePoseur;
    }
}
