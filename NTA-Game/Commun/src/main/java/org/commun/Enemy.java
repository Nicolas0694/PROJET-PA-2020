package org.commun;

import javafx.scene.shape.Rectangle;

public interface Enemy {



    public void Rectangle();

    public void update(double time);

    public Rectangle setEnemy();

    public double generateRandomEnemyX();

    public int getMaxHealth();

    public int getCurrentHealth();

    public int getDamage();

    public String getArme();

    public int getSpeedX();

    public int getCenterX();

    public int getCenterY() ;

    public void setMaxHealth();

    public void setCurrentHealth();

    public void setDamage();

    public void setArme();

    public void setSpeedX();

    public void setCenterX();

    public void setCenterY();
}


