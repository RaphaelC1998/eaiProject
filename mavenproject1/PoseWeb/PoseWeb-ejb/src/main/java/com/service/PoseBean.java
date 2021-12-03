/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import entities.Pose;
import java.util.HashMap;
import javax.ejb.Singleton;

/**
 *
 * @author Raph
 */
@Singleton
public class PoseBean implements PoseBeanLocal {
    
    private HashMap<Integer, Pose> lesposes;
    private int lastid;

    public PoseBean() {
        this.lesposes = new HashMap();
        this.lastid = 0;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

   @Override
    public Pose ajouterPos(int idEquipePoseur) {
        Pose p = new Pose(lastid, idEquipePoseur);
        this.lesposes.put(lastid, p);
        lastid++;
        return p;
    }
    
    @Override
    public Pose getPosition(int idPose) {
        return this.lesposes.get(idPose);
    }
    
    @Override
    public void setEtatPose(String etatPose, int idPose) {
        this.lesposes.get(idPose).setStatutPose(etatPose);
    }
}
