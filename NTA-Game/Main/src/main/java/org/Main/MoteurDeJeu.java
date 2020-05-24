package org.main;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.stage.Stage;
import org.commun.Exemple;
import org.commun.Joueur;
import org.plugins.Menu;


public class MoteurDeJeu extends Application {

    Joueur joueur;

    public MoteurDeJeu() {
    }



    public void chargementPlugins() {
        ArrayList<File> files = new ArrayList<File>();
        files.add(new File("../Plugins/target/Plugins-1.0-SNAPSHOT-jar-with-dependencies.jar"));
        MyClassLoader mcl = new MyClassLoader(this.getClass().getClassLoader(), files);
        Class c, menu;

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

        try {
            menu = mcl.loadClass("org.plugins.Menu");
            System.out.println("LOADED " + menu);
            for(Class f: menu.getInterfaces()){
                System.out.println(f.getName());
            }
            Exemple test = (Exemple) menu.getDeclaredConstructor().newInstance();
            test.hello();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
                | NoSuchMethodException | SecurityException e) {
            e.printStackTrace();
        }
		
    }

    @Override
    public void start(Stage primaryStage) {
        try{
            final Menu menu = new Menu();
            primaryStage = menu.getMainStage();
            primaryStage.show();
        } catch(final Exception e) {
            e.printStackTrace();
        }

    }
    public static void main(final String[] args){
        System.out.println("Debut programme !");
        MoteurDeJeu m = new MoteurDeJeu();
        m.chargementPlugins();
        launch(args);
    }

}
