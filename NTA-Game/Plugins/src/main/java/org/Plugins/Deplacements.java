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
            joueur.animation.play();
            joueur.animation.setOffsetY(96);
            joueur.moveY(-2);
        } else if (isPressed(KeyCode.DOWN)) {
            joueur.animation.play();
            joueur.animation.setOffsetY(0);
            joueur.moveY(2);
        } else if (isPressed(KeyCode.RIGHT)) {
            joueur.animation.play();
            joueur.animation.setOffsetY(48);
            joueur.moveX(2);
        } else if (isPressed(KeyCode.LEFT)) {
            joueur.animation.play();
            joueur.animation.setOffsetY(48);
            joueur.moveX(-2);
        } else {
            joueur.animation.stop();
        }
    }
    public boolean isPressed(KeyCode key) {
        return keys.getOrDefault(key, false);

    }
}