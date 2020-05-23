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
    private Point position;
    //private Sprite sprite;
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

    @Override
    public  void tirer(){
        if(this.arme != null){
            this.arme.tirer();
        }
    }

    /**
     * @author Thomas Gauci
     * Permet au joueur d'avancer vers l'avant
     */
    @Override

    public  void avancer(){
        position.translate(1,0);
    }

    /**
     * @author Thomas Gauci
     * Permet au joueur d'avancer vers l'arrière
     */
    @Override

    public  void reculer(){
        position.translate(-1,0);
    }

    /**
     * @author Thomas Gauci
     * Permet au joueur d'avancer vers le haut
     */
    @Override
    public  void monter(){
        position.translate(0,1);
    }

    /**
     * @author Thomas Gauci
     * Permet au joueur d'avancer vers le bas
     */
    @Override
    public  void descendre(){
        position.translate(0,-1);
    }
    @Override
    public  int getVie(){
        return this.vie;
    }
    @Override
    public  void setVie(int vie){
        this.vie = vie;
    }
    @Override
    public  Point getPosition(){
        return this.position;
    }
    @Override
    public  void setPosition(Point position){
        this.position = position;
    }
    @Override
    public  Arme getArme(){
        return this.arme;
    }
    @Override
    public  void setArme(Arme arme){
        this.arme = arme;
    }
    @Override
    public  int getBouclier(){
        return this.bouclier;
    }
    @Override
    public  void setBouclier(int bouclier){
        this.bouclier = bouclier;
    }
    @Override
    public  int getDegatArme(){
        return this.arme.getDegat();
    }
    @Override
    public  void setDegatArme(int degat){
        this.arme.setDegat(degat);
    }
    
    @Override
    public int getMunition(){
        return this.arme.getMunition();
    }

    @Override
    public void setMunition(int munition){
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