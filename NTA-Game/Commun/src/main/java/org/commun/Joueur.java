package org.commun;

import java.awt.Point;

public interface Joueur {

    public void tirer();

    public static void avancer();

    public static void reculer();

    public void monter();

    public void descendre();

    public void setVie(int vie);
   
    public void setBouclier(int bouclier);
   
    public void setMunition(int munition);
   
    public void setDegatArme(int degat);

    public int getX();

    public int getY();

    public void setPosition(Point pos);
}