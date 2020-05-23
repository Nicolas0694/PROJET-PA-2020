package org.plugins;

import java.util.Random;

import org.commun.Joueur;
import org.commun.RessourcesBonus;


/**
 * @author Thomas Gauci
 */

public class PluginRessourcesBonus implements RessourcesBonus {

    private String type;
    private String types[] = { "vie", "bouclier", "munition", "degat" };
    private int vieBonus;
    private int degatBonus;
    private int bouclier;
    private int munition;
    // private Point position; position sur l'aire de jeu ?

    /**
     * Constructeur qui permet d'initialiser le bonus. Le bonus est aléatoire
     */
    public PluginRessourcesBonus() {
        Random random = new Random();
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
    @Override
    public void obtenirBonus(Joueur joueur){
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

    @Override
    public String getType(){
        return this.type;
    }
}