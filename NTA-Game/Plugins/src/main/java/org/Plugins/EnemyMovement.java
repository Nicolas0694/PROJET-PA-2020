package org.plugins;

import com.sun.javafx.geom.Vec2d;

import java.awt.*;

public class EnemyMovement extends Enemy {
/*
    //Il a de la vie, une attaque, random weapon, vitesse
    // Il a un déplacement aléatoire, si l'ennemi dans le rayon de son arme, à plus petit hp, il va le frapper
    //SInon il s'enfuit', si autant il y va
    Vec2d enemyPos;
    Vec2d joueurPos;
    Vec2d direction; // always normalized
    float velocity;
EnemyMovement() {
    update();
    direction = normalize(joueurPos - enemyPos);
    joueurPos = joueurPos + direction * velocity;

}*/


    protected Maths sense;
    protected int r_sense;
    protected boolean up = false;
    protected boolean down = false;
    protected boolean right = false;
    protected boolean left = false;
    protected Maths attackrange;
    protected int r_attackrange;
    protected Maths.Vector2f pos;

    protected Maths bounds;

    protected int xOffset;
    protected int yOffset;
    public Maths getBounds() { return bounds; }


    public EnemyMovement(Enemy rectangle, Maths.Vector2f origin, int size) {
        super(rectangle, origin, size);

        bounds.setWidth(size / 2);
        bounds.setHeight(size / 2 - yOffset);
        bounds.setXOffset(size / 2 - xOffset);
        bounds.setYOffset(size / 2 + yOffset);

        sense = new Maths(new Maths.Vector2f(origin.x + size / 2 - r_sense / 2, origin.y + size / 2 - r_sense / 2), r_sense);
        attackrange = new Maths(new Maths.Vector2f(origin.x + bounds.getXOffset() + bounds.getWidth() / 2 - r_attackrange / 2 , origin.y + bounds.getYOffset() + bounds.getHeight() / 2 - r_attackrange / 2 ), r_attackrange);
    }

    public void chase(Joueur joueur) {
        Maths joueurBounds = joueur.getBounds();
        if (sense.colCircleBox(joueurBounds) && !attackrange.colCircleBox(joueurBounds)) {
            if (pos.y > joueur.pos.y + 1) {
                up = true;
            } else {
                up = false;
            }
            if (pos.y < joueur.pos.y - 1) {
                down = true;
            } else {
                down = false;
            }

            if (pos.x > joueur.pos.x + 1) {
                left = true;
            } else {
                left = false;
            }
            if (pos.x < joueur.pos.x - 1) {
                right = true;
            } else {
                right = false;
            }
        } else {
            up = false;
            down = false;
            left = false;
            right = false;
        }
    }

    public void update(Joueur joueur, double time) {
        if(Joueur.getX.getBounds().collides(this.bounds)) {
            super.update(time);
            chase(joueur);
            move();

            if(teleported) {
                teleported = false;

                bounds.setWidth(size / 2);
                bounds.setHeight(size / 2 - yOffset);
                bounds.setXOffset(size / 2 - xOffset);
                bounds.sestYOffset(size / 2 + yOffset);

                hitBounds = new Maths(pos, size, size);
                hitBounds.setXOffset(size / 2);

                sense = new Maths(new Maths.Vector2f(pos.x + size / 2 - r_sense / 2, pos.y + size / 2 - r_sense / 2), r_sense);
                attackrange = new Maths(new Maths.Vector2f(pos.x + bounds.getXOffset() + bounds.getWidth() / 2 - r_attackrange / 2 , pos.y + bounds.getYOffset() + bounds.getHeight() / 2 - r_attackrange / 2 ), r_attackrange);
            }

            if(attackrange.colCircleBox(joueur.getBounds())) {
                attack = true;
                joueur.setHealth(joueur.getHealth() - damage);
            } else {
                attack = false;
            }

    }
        }
    
}
