/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import entities.Pose;
import javax.ejb.Local;

/**
 *
 * @author Raph
 */
@Local
public interface PoseBeanLocal {
    public Pose ajouterPos(int idEquipePoseur);
    public Pose getPosition(int idPose);
    public void setEtatPose(String etatPose, int idPose);
    
}
