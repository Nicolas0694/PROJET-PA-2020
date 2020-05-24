package org.commun;

import java.awt.Point;

public interface CollisionAire {

    public void verificationCollision(Joueur joueur);
    public void teleporter(Joueur joueur,Point pos);
}