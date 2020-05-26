package org.plugins;

import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import org.commun.Joueur;

import java.util.HashMap;

public class Controles {

    private HashMap<KeyCode, Boolean> keys = new HashMap<>();
    Timeline timeline = new Timeline();
    PluginJoueur getPosition;


    public void update(Joueur joueur) {
        if (isPressed(KeyCode.UP)) {
            PluginJoueur.timeline.play();
          //  PluginJoueur.animation.setOffsetY(96);
            joueur.monter();
        } else if (isPressed(KeyCode.DOWN)) {
            PluginJoueur.timeline.play();
          //  PluginJoueur.animation.setOffsetY(0);
            joueur.descendre();
        } else if (isPressed(KeyCode.RIGHT)) {
            PluginJoueur.timeline.play();
         //   PluginJoueur.animation.setOffsetY(48);
            joueur.avancer();
        } else if (isPressed(KeyCode.LEFT)) {
            PluginJoueur.timeline.play();
         //   PluginJoueur.timeline.setOffsetY(48);
            joueur.reculer();
        }
        else if (isPressed(KeyCode.SPACE)) {
            PluginJoueur.timeline.play();
            joueur.tirer();
        }
        else if (isPressed(KeyCode.ESCAPE)) {
            final Menu menu = new Menu();
            Stage primaryStage = menu.getMainStage();
            primaryStage.show();        }
        else {
            PluginJoueur.timeline.stop();
        }
    }
    public boolean isPressed(KeyCode key) {
        return keys.getOrDefault(key, false);

    }
    final KeyCode stopKey = KeyCode.ENTER;
    EventHandler<KeyEvent> handler = event -> {
        if (event.getCode() == stopKey) {
            timeline.stop();
        }
    };
}