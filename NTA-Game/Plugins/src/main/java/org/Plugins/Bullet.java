package org.plugins;


import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.layout.Pane;



public class Bullet {


    private Node view;
    private Point2D velocity = new Point2D(0, 0);

    private Pane root;


    public Bullet(Node view) {
        this.view = view;
    }

    public void update() {
        view.setTranslateX(view.getTranslateX() + velocity.getX());
        view.setTranslateY(view.getTranslateY() + velocity.getY());
    }

    public void setVelocity(Point2D velocity) {
        this.velocity = velocity;
    }

    public Point2D getVelocity() {
        return velocity;
    }

    public Node getView() {
        return view;
    }




    private void addBullet(Arme.WeaponList bullet, double x, double y) {
        bullet.add(bullet);
        addGameObject(bullet, x, y);
    }



    public Bullet(Node view, int width, int height, int damage) {
        this.view = view;
        Arme.WeaponList.setSize(height);
        Arme.WeaponList.setSize(width);
        Arme.WeaponList.setDamage(damage);
    }


    private void addGameObject(Arme.WeaponList object, double x, double y) {
        object.getView().setTranslateX(x);
        object.getView().setTranslateY(y);
        root.getChildren().add(object.getView());
    }

}













