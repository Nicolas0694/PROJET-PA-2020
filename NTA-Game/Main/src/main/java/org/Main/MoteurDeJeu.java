package org.Main;

import javafx.application.Application;
import javafx.stage.Stage;
import org.commun.CollisionAire;
import org.commun.Exemple;
import org.commun.Joueur;
import org.commun.RessourcesBonus;
import org.plugins.*;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;


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

        try {
            c = mcl.loadClass("org.plugins.PluginRessourcesBonus");
            System.out.println("LOADED " + c);
            for(Class f: c.getInterfaces()){
                System.out.println(f.getName());
            }
            RessourcesBonus ressourcesBonus = (RessourcesBonus) c.getDeclaredConstructor().newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
                | NoSuchMethodException | SecurityException e) {
            e.printStackTrace();
        }

        try {
            c = mcl.loadClass("org.plugins.PluginJoueur");
            System.out.println("LOADED " + c);
            for(Class f: c.getInterfaces()){
                System.out.println(f.getName());
            }
            Joueur joueur = (Joueur) c.getDeclaredConstructor().newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
                | NoSuchMethodException | SecurityException e) {
            e.printStackTrace();
        }

        try {
            c = mcl.loadClass("org.plugins.PluginCollisionAire");
            System.out.println("LOADED " + c);
            for(Class f: c.getInterfaces()){
                System.out.println(f.getName());
            }
            CollisionAire collisionAire = (CollisionAire) c.getDeclaredConstructor().newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
                | NoSuchMethodException | SecurityException e) {
            e.printStackTrace();
        }
        try {
            c = mcl.loadClass("org.plugins.Controles");
            System.out.println("LOADED " + c);
            for(Class f: c.getInterfaces()){
                System.out.println(f.getName());
            }
            Controles controles = (Controles) c.getDeclaredConstructor().newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
                | NoSuchMethodException | SecurityException e) {
            e.printStackTrace();
        }
        try {
            c = mcl.loadClass("org.plugins.EnemyMovement");
            System.out.println("LOADED " + c);
            for(Class f: c.getInterfaces()){
                System.out.println(f.getName());
            }
            EnemyMovement enemyMovement = (EnemyMovement) c.getDeclaredConstructor().newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
                | NoSuchMethodException | SecurityException e) {
            e.printStackTrace();
        }
        try {
            c = mcl.loadClass("org.plugins.Maths");
            System.out.println("LOADED " + c);
            for(Class f: c.getInterfaces()){
                System.out.println(f.getName());
            }
            Maths maths = (Maths) c.getDeclaredConstructor().newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
                | NoSuchMethodException | SecurityException e) {
            e.printStackTrace();
        }
        try {
            c = mcl.loadClass("org.plugins.GameButtons");
            System.out.println("LOADED " + c);
            for(Class f: c.getInterfaces()){
                System.out.println(f.getName());
            }
            GameButtons gameButtons = (GameButtons) c.getDeclaredConstructor().newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
                | NoSuchMethodException | SecurityException e) {
            e.printStackTrace();
        }
        try {
            c = mcl.loadClass("org.plugins.GameSubScenes");
            System.out.println("LOADED " + c);
            for(Class f: c.getInterfaces()){
                System.out.println(f.getName());
            }
            GameSubScene gameSubScene = (GameSubScene) c.getDeclaredConstructor().newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
                | NoSuchMethodException | SecurityException e) {
            e.printStackTrace();
        }
        try {
            c = mcl.loadClass("org.plugins.GameView");
            System.out.println("LOADED " + c);
            for(Class f: c.getInterfaces()){
                System.out.println(f.getName());
            }
            GameView gameview = (GameView) c.getDeclaredConstructor().newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
                | NoSuchMethodException | SecurityException e) {
            e.printStackTrace();
        }
        try {
            c = mcl.loadClass("org.plugins.InfoLabel");
            System.out.println("LOADED " + c);
            for(Class f: c.getInterfaces()){
                System.out.println(f.getName());
            }
            InfoLabel infoLabel = (InfoLabel) c.getDeclaredConstructor().newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
                | NoSuchMethodException | SecurityException e) {
            e.printStackTrace();
        }
        try {
            c = mcl.loadClass("org.plugins.PluginArme");
            System.out.println("LOADED " + c);
            for(Class f: c.getInterfaces()){
                System.out.println(f.getName());
            }
            PluginArme pluginArme = (PluginArme) c.getDeclaredConstructor().newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
                | NoSuchMethodException | SecurityException e) {
            e.printStackTrace();
        }
        try {
            c = mcl.loadClass("org.plugins.PluginEnemy");
            System.out.println("LOADED " + c);
            for(Class f: c.getInterfaces()){
                System.out.println(f.getName());
            }
            PluginEnemy pluginEnemy = (PluginEnemy) c.getDeclaredConstructor().newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
                | NoSuchMethodException | SecurityException e) {
            e.printStackTrace();
        }
        try {
            c = mcl.loadClass("org.plugins.PluginPicker");
            System.out.println("LOADED " + c);
            for(Class f: c.getInterfaces()){
                System.out.println(f.getName());
            }
            PluginPicker pluginPicker = (PluginPicker) c.getDeclaredConstructor().newInstance();
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
