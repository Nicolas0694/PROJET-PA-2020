package org.commun;

import java.awt.Point;

public interface Joueur {

    public void tirer();

    public void avancer();

    public void reculer();

    public void monter();

    public void descendre();

    public void setVie(int vie);
   
    public void setBouclier(int bouclier);
   
    public void setMunition(int munition);

    public int getMunition();

    public  int getVie();

    public  Point getPosition();

    public  Arme getArme();

    public  void setArme(Arme arme);

    public  int getBouclier();

    public  int getDegatArme();
   
    public void setDegatArme(int degat);

    public int getX();

    public int getY();

    public void setPosition(Point pos);
}