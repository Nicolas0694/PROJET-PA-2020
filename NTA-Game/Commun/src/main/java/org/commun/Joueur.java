package org.commun;

public interface Joueur {

    public void tirer();

    public void avancer();

    public void reculer();

    public void monter();

    public void descendre();

    public void setVie(int vie);
   
    public void setBouclier(int bouclier);
   
    public void setMunition(int munition);
   
    public void setDegatArme(int degat);
}