package org.Plugins;

/**
 * @author Thomas Gauci
 */


public class CollisionEnnemie implements InterfaceCollisionEnnemie {

    Personnage ennemie;

    /**
     * Constructeur qui permet...
     */
    public CollisionEnnemie(Personnage ennemie){
        this.ennemie = ennemie;
    }

    /**
     * @author Thomas Gauci
     * Permet de donner vérifier si le joueur touche un ennemie
     * @param pos la position du joueur
     */
    public boolean verificationCollision(Position pos){
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