package org.plugins;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;

import java.util.HashMap;

public class Deplacements {

    private HashMap<KeyCode, Boolean> keys = new HashMap<>();

    public void update() {
        if (isPressed(KeyCode.UP)) {
            PluginJoueur.animation.play();
            PluginJoueur.animation.setOffsetY(96);
            PluginJoueur.moveY(-2);
        } else if (isPressed(KeyCode.DOWN)) {
            PluginJoueur.animation.play();
            PluginJoueur.animation.setOffsetY(0);
            PluginJoueur.moveY(2);
        } else if (isPressed(KeyCode.RIGHT)) {
            PluginJoueur.animation.play();
            PluginJoueur.animation.setOffsetY(48);
            PluginJoueur.moveX(2);
        } else if (isPressed(KeyCode.LEFT)) {
            PluginJoueur.animation.play();
            PluginJoueur.animation.setOffsetY(48);
            PluginJoueur.moveX(-2);
        } else {
            PluginJoueur.animation.stop();
        }
    }
    public boolean isPressed(KeyCode key) {
        return keys.getOrDefault(key, false);

    }
}