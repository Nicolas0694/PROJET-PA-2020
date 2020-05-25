package org.commun;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public interface Enemy {


    static void createRectangle(Color red, double generateRandomEnemyX, int i, double width, double height) {
    }

    public Rectangle setEnemy();

    public double generateRandomEnemyX();


    public int getMaxHealth();

    public int getCurrentHealth();

    public int getDamage();

    public String getArme();

    public int getSpeedX();

    public int getCenterX();

    public int getCenterY() ;



    void setMaxHealth(int maxHealth);

    void setCurrentHealth(int currentHealth);

    void setDamage(int damage);

    void setArme(String arme);

    void setSpeedX(int speedX);

    void setCenterX(int centerX);

    void setCenterY(int centerY);
}


