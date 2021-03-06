package org.plugins;

import java.awt.Point;

import org.commun.AireDeJeu;
import org.commun.CollisionAire;
import org.commun.Joueur;
/**
 * @author Thomas Gauci
 */

public class PluginCollisionAire implements CollisionAire {

    AireDeJeu aire;

    /**
     * Constructeur qui permet d'initialiser l'aire de jeu
     * 
     * @param aire l'aide de jeu
     */
    public PluginCollisionAire(AireDeJeu aire) {
        this.aire = aire;
    }
    public PluginCollisionAire() {

    }

    /**
     * @author Thomas Gauci
     * Permet de donner vérifier si le joueur sort de l'aire de jeu
     * @param joueur le joueur en jeu
     */
    @Override
    public void verificationCollision(Joueur joueur){
        boolean flag = false;
        if(joueur.getX() <= 0){
            flag = true;
            this.teleporter(joueur,new Point(aire.getMaxX()-1,joueur.getY()));
        }
        if(joueur.getX() <= aire.getMaxX() && flag == false){
            this.teleporter(joueur,new Point(1,joueur.getY()));
        }
        if(joueur.getY() <= 0 && flag == false){
            flag = true;
            this.teleporter(joueur,new Point(joueur.getX(),aire.getMaxY()-1));
        }
        if(joueur.getY() <= aire.getMaxY() && flag == false){
            this.teleporter(joueur,new Point(joueur.getX(),1));
        }
    }

    /**
     * @author Thomas Gauci
     * Permet de donner teleporter un joueur a une position
     * @param joueur le joueur à teleporter
     * @param pos la position de la teleportation
     */
    @Override
    public void teleporter(Joueur joueur,Point pos){
        joueur.setPosition(pos);
    }

}