package org.plugins;

import org.commun.CollisionEnnemie;
import org.commun.Joueur;

import javafx.scene.effect.Light.Point;

/**
 * @author Thomas Gauci
 */


public class PluginCollisionEnnemie implements CollisionEnnemie {

    private static Joueur ennemie;
    //Joueur ennemie;

    /**
     * Constructeur qui permet...
     */
    public PluginCollisionEnnemie(Joueur ennemie) {
        this.ennemie = ennemie;
    }

    /**
     * @author Thomas Gauci
     * Permet de donner vérifier si le joueur touche un ennemie
     * @param pos la position du joueur
     */
    public static boolean verificationCollision(Point pos){
        boolean flag = false;
        if(pos.getX() <= 0 || pos.getX() <= ennemie.getX()){
            flag = true;
        }
        if(pos.getY() <= 0 || pos.getY() <= ennemie.getY()){
            flag = true;
        }
        return flag;
    }

}