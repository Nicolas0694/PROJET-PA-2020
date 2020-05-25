package org.plugins;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import org.commun.Enemy;

import java.util.Random;


public class PluginEnemy implements Enemy {
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
        this.enemy = createRectangle(Color.RED, generateRandomEnemyX(), 0, WIDTH, HEIGHT);
    }

    public static Rectangle setEnnemy(double value) {
        return enemy;
    }

    public void update(double time) {
        centerX += speedX;
        speedX = getSpeedX();


    }

    @Override
    public void Rectangle() {

    }


    public Rectangle setEnemy() {
        return enemy;
    }

    public double generateRandomEnemyX() {
        Random r = new Random();
        return (100 - WIDTH) * r.nextDouble();
    }

    public static Rectangle createRectangle(Color color, double x, double y, double width, double height) {
        Rectangle rectangle = new Rectangle();
        rectangle.setFill(color);
        rectangle.setX(x);
        rectangle.setY(y);
        rectangle.setWidth(width);
        rectangle.setHeight(height);

        return rectangle;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public int getDamage() {
        return damage;
    }

    public String getArme() {
        return String.valueOf(arme);
    }

    public int getSpeedX() {
        return speedX;
    }

    public int getCenterX() {
        return centerX;
    }

    public int getCenterY() {
        return centerY;
    }

    @Override
    public void setMaxHealth() {

    }

    @Override
    public void setCurrentHealth() {

    }

    @Override
    public void setDamage() {

    }

    @Override
    public void setArme() {

    }

    @Override
    public void setSpeedX() {

    }

    @Override
    public void setCenterX() {

    }

    @Override
    public void setCenterY() {

    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setArme(String arme) {
        this.arme = arme;
    }

    public void setSpeedX(int speedX) {
        this.speedX = speedX;
    }

    public void setCenterX(int centerX) {
        this.centerX = centerX;
    }

    public void setCenterY(int centerY) {
        this.centerY = centerY;
    }
}
