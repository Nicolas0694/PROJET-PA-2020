package org.plugins;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import org.commun.Enemy;
import org.commun.Joueur;

import java.util.Random;


public abstract class PluginEnemy implements Enemy {
    private static Rectangle enemy;
    private int maxHealth;
    private int currentHealth;
    public int damage;
    private String arme;
    private int speedX;
    private int centerX;
    private int centerY;
    public static final double WIDTH = 50;
    public static final double HEIGHT = 50;


    /**
     * Constructor for Enemy class
     * @param rectangle
     * @param origin
     * @param size
     */

    public PluginEnemy(Enemy rectangle, Maths.Vector2f origin, int size) {
        Enemy.createRectangle(Color.RED, generateRandomEnemyX(), 0, WIDTH, HEIGHT);
    }

    public static Rectangle setEnnemy(double value) {
        return enemy;
    }

    public void update(double time) {
        centerX += speedX;
        speedX = getSpeedX();


    }

    @Override
    public Rectangle setEnemy() {
        return enemy;
    }

    @Override
    public double generateRandomEnemyX() {
        Random r = new Random();
        return (100 - WIDTH) * r.nextDouble();
    }

    public Rectangle createRectangle(Color color, double x, double y, double width, double height) {
        Rectangle rectangle = new Rectangle();
        rectangle.setFill(color);
        rectangle.setX(x);
        rectangle.setY(y);
        rectangle.setWidth(width);
        rectangle.setHeight(height);

        return rectangle;
    }

    @Override
    public int getMaxHealth() {
        return maxHealth;
    }

    @Override
    public int getCurrentHealth() {
        return currentHealth;
    }

    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public String getArme() {
        return String.valueOf(arme);
    }

    @Override
    public int getSpeedX() {
        return speedX;
    }

    @Override
    public int getCenterX() {
        return centerX;
    }

    @Override
    public int getCenterY() {
        return centerY;
    }



    @Override
    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    @Override
    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    @Override
    public void setDamage(int damage) {
        this.damage = damage;
    }

    @Override
    public void setArme(String arme) {
        this.arme = arme;
    }

    @Override
    public void setSpeedX(int speedX) {
        this.speedX = speedX;
    }

    @Override
    public void setCenterX(int centerX) {
        this.centerX = centerX;
    }

    @Override
    public void setCenterY(int centerY) {
        this.centerY = centerY;
    }

    public abstract void chase(PluginJoueur joueur);

    public abstract void update(Joueur joueur);
}
