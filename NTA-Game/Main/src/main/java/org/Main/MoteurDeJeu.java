package org.main;

public class MoteurDeJeu {

    Joueur joueur;

    public MoteurDeJeu() {
        // this.joueur = new PluginJoueur();
        this.chargementPlugins();

    }

    public void chargementPlugins() {
        String className = "org.plugins.Joueur";
        LoadFromJar lfj = new LoadFromJar();
        Class c;
        try {
            c = lfj.loadClass(className);
            System.out.println("LoadFromJar.main() LOADED " + c);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
		
    }

    public void lancementDuJeu(){

    }

}