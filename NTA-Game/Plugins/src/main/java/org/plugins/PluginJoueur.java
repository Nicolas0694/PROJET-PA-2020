package org.plugins;

import java.awt.Point;

import javafx.animation.Animation;
import org.commun.Arme;
import org.commun.Joueur;

/**
 * @author Thomas Gauci, Alexis Vighi
 */

public class PluginJoueur implements Joueur {

    public static Animation timeline;
    public int Height;
    public int Width;
    private int vie;
    private int bouclier;
    private static Point position;
    // private Sprite sprite;
    private Arme arme;

    /**
     * Constructeur qui permet d'initialiser le joueur avec des statistiques de base
     */
    public PluginJoueur() {
        this.vie = 100;
        this.bouclier = 0;
        this.position = new Point(0, 0);
        // this.sprite = 
        this.arme = null;
    }

    /**
     * @author Thomas Gauci
     * Permet au joueur de tirer si il est armé
     */
    public final void tirer() {
        if (this.arme != null) {
            this.arme.tirer();
        }
    }

    /**
     * @author Thomas Gauci
     * Permet au joueur d'avancer vers l'avant
     */
    @Override
    public void avancer() {
        position.translate(1, 0);
    }

    /**
     * @author Thomas Gauci
     * Permet au joueur d'avancer vers l'arrière
     */
    @Override
    public void reculer() {
        position.translate(-1, 0);
    }

    /**
     * @author Thomas Gauci
     * Permet au joueur d'avancer vers le haut
     */
    @Override
    public void monter() {
        position.translate(0, 1);
    }

    /**
     * @author Thomas Gauci
     * Permet au joueur d'avancer vers le bas
     */
    @Override
    public void descendre() {
        position.translate(0, -1);
    }

    public final int getVie() {
        return this.vie;
    }

    public final void setVie(int vie) {
        this.vie = vie;
    }

    public final Point getPosition() {
        return this.position;
    }

    public final void setPosition(Point position) {
        this.position = position;
    }

    public final Arme getArme() {
        return this.arme;
    }

    public final void setArme(Arme arme) {
        this.arme = arme;
    }

    public final int getBouclier() {
        return this.bouclier;
    }

    public final void setBouclier(int bouclier) {
        this.bouclier = bouclier;
    }

    public final int getDegatArme() {
        return this.arme.getDegat();
    }

    public final void setDegatArme(int degat) {
        this.arme.setDegat(degat);
    }

    public final int getMunition() {
        return this.arme.getMunition();
    }

    public final void setMunition(int munition) {
        this.arme.setMunition(munition);
    }

    @Override
    public int getX() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int getY() {
        // TODO Auto-generated method stub
        return 0;
    }

 
}