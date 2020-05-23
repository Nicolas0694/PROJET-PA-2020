package org.plugins;

import javafx.animation.AnimationTimer;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.util.HashMap;

public class Controles {

    private HashMap<KeyCode, Boolean> keys = new HashMap<>();
    Timeline timeline = new Timeline();

    public void update() {
        if (isPressed(KeyCode.UP)) {
            PluginJoueur.timeline.play();
            PluginJoueur.animation.setOffsetY(96);
            PluginJoueur.monter();
        } else if (isPressed(KeyCode.DOWN)) {
            PluginJoueur.timeline.play();
            PluginJoueur.animation.setOffsetY(0);
            PluginJoueur.descendre();
        } else if (isPressed(KeyCode.RIGHT)) {
            PluginJoueur.timeline.play();
            PluginJoueur.animation.setOffsetY(48);
            PluginJoueur.avancer();
        } else if (isPressed(KeyCode.LEFT)) {
            PluginJoueur.timeline.play();
            PluginJoueur.animation.setOffsetY(48);
            PluginJoueur.reculer();
        }
        else if (isPressed(KeyCode.SPACE)) {
            PluginJoueur.timeline.play();
            Bullet bullet = Bullet.addBullet(bullet, x, y );
        }
        else {
            PluginJoueur.animation.stop();
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