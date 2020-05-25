package org.plugins;

import javafx.scene.effect.Light;
import org.commun.Joueur;

public class EnemyMovement extends PluginEnemy {



    protected Maths sense;
    protected int r_sense;
    protected boolean up = false;
    protected boolean down = false;
    protected boolean right = false;
    protected boolean left = false;
    protected Maths attackrange;
    protected int r_attackrange;
    protected Light.Point pos;

    protected Maths bounds;
    boolean attack;

    protected int xOffset;
    protected int yOffset;


    public EnemyMovement(PluginEnemy rectangle, Maths.Vector2f origin, int size) {
        super(rectangle, origin, size);

        bounds.setWidth(size / 2);
        bounds.setHeight(size / 2 - yOffset);
        bounds.setXOffset(size / 2 - xOffset);
        bounds.setYOffset(size / 2 + yOffset);

        sense = new Maths(new Maths.Vector2f(origin.x + size / 2 - r_sense / 2, origin.y + size / 2 - r_sense / 2), r_sense);
        attackrange = new Maths(new Maths.Vector2f(origin.x + bounds.getXOffset() + bounds.getWidth() / 2 - r_attackrange / 2 , origin.y + bounds.getYOffset() + bounds.getHeight() / 2 - r_attackrange / 2 ), r_attackrange);
    }

    @Override
    public void chase(PluginJoueur joueur) {
        Maths joueurAire = joueur.getAire();
        if (sense.colCircleBox(joueurAire) && !attackrange.colCircleBox(joueurAire)) {
            if (pos.getY() > joueur.getY() + 1) {
                up = true;
            } else {
                up = false;
            }
            if (pos.getY() < joueur.getY() - 1) {
                down = true;
            } else {
                down = false;
            }

            if (pos.getX() > joueur.getX() + 1) {
                left = true;
            } else {
                left = false;
            }
            if (pos.getX() < joueur.getX() - 1) {
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

    @Override
    public void update(Joueur joueur) {
        if(PluginCollisionEnnemie.verificationCollision(this.pos)) {
            chase((PluginJoueur) joueur);
            new Controles();

            if(attackrange.colCircleBox(((PluginJoueur) joueur).getAire())) {
                attack = true;
                joueur.setVie(joueur.getVie() - damage);
            } else {
                attack = false;
            }

    }
        }

}
