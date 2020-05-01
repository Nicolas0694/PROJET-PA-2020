package org.plugins;

/**
 * @author Thomas Gauci
 */

public class PluginCollisionAire implements CollisionEnnemie {

    AireDeJeu aire;

    /**
     * Constructeur qui permet d'initialiser l'aire de jeu
     * 
     * @param aire l'aide de jeu
     */
    public PluginCollisionAire(AireDeJeu aire) {
        this.aire = aire;
    }

    /**
     * @author Thomas Gauci
     * Permet de donner vérifier si le joueur sort de l'aire de jeu
     * @param pos la position du joueur
     */
    public boolean verificationCollision(Position pos){
        boolean flag = false;
        if(pos.getX() <= 0 || pos.getX() <= aire.getMaxX()){
            flag = true;
        }
        if(pos.getY() <= 0 || pos.getY() <= aire.getMaxY()){
            flag = true;
        }
        return flag;
    }

}