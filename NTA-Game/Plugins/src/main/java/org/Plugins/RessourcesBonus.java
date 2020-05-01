package org.Plugins;

import java.util.Random;
import java.lang.Math;

/**
 * @author Thomas Gauci
 */

public class RessourcesBonus implements InterfaceRessourcesBonus {

    private String type;
    private String types["vie","bouclier","munition","degat"];
    private int vieBonus;
    private int degatBonus;
    private int bouclier;
    private int munition;
    // private Point position; position sur l'aire de jeu ?

    /**
     * Constructeur qui permet d'initialiser le bonus. Le bonus est aléatoire
     */
    public RessourcesBonus(){
        Random random = new Random()
        switch(this.type = this.types[random.nextInt(4)]) {
            case "vie":
                this.vieBonus = 25;
                break;
            case "bouclier":
                this.bouclier = 50;
                break;
            case "munition":
                this.munition = 25;
                break;
            case "degat":
                this.degatBonus = 10;
                break;
            default:
                this.vieBonus = 0;
                this.degatBonus = 0;
                this.bouclier = 0;
                this.munition = 0;
        }
    }
    /**
     * @author Thomas Gauci
     * Permet de donner le bonus au joueur
     * @param joueur le joueur ciblé
     */
    public final void obtenirBonus(Joueur joueur){
        switch(this.type) {
            case "vie":
                joueur.setVie(this.vieBonus);
                break;
            case "bouclier":
                joueur.setBouclier(this.bouclier);
                break;
            case "munition":
                joueur.setMunition(this.munition);
                break;
            case "degat":
                joueur.setDegatArme(this.degatBonus);
                break;
            default:
               
        }
    }

    public final String getType(){
        return this.type;
    }

}