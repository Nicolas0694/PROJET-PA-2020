package org.commun;

import javafx.geometry.Point2D;

/**
 * @author Thomas Gauci
 */


public class PluginCollisionEnnemie implements CollisionEnnemie {

    Personnage ennemie;

    /**
     * Constructeur qui permet...
     */
    public PluginCollisionEnnemie(Personnage ennemie) {
        this.ennemie = ennemie;
    }

    /**
     * @author Thomas Gauci
     * Permet de donner vérifier si le joueur touche un ennemie
     * @param pos la position du joueur
     */
    public boolean verificationCollision(Point2D pos){
        boolean flag = false;
        // if(pos.getX() <= 0 || pos.getX() <= ennemie.getX()){
        //     flag = true;
        // }
        // if(pos.getY() <= 0 || pos.getY() <= ennemie.getY()){
        //     flag = true;
        // }
        return flag;
    }

}