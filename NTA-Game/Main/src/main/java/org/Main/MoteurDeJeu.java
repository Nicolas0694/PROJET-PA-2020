package org.main;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import org.commun.Exemple;
import org.commun.Joueur;

public class MoteurDeJeu {

    Joueur joueur;

    public MoteurDeJeu() {
    }

    public void chargementPlugins() {
        ArrayList<File> files = new ArrayList<File>();
        files.add(new File("../Plugins/target/Plugins-1.0-SNAPSHOT-jar-with-dependencies.jar"));
        MyClassLoader mcl = new MyClassLoader(this.getClass().getClassLoader(), files);
        Class c;

        try {
            c = mcl.loadClass("org.plugins.PluginExemple");
            System.out.println("LOADED " + c);
            for(Class f: c.getInterfaces()){
                System.out.println(f.getName());
            }
            Exemple test = (Exemple) c.getDeclaredConstructor().newInstance();
            test.hello();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
                | NoSuchMethodException | SecurityException e) {
            e.printStackTrace();
        }
		
    }

    public void lancementDuJeu(){

    }

    public final static void main(String args[]){
        System.out.println("Debut programme !");
        MoteurDeJeu m = new MoteurDeJeu();
        m.chargementPlugins();
    }

}