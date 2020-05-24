package org.plugins;

import javafx.scene.Node;

public class Arme {

    public enum WeaponList {
        ONE_H_SWORD(5, 3, 1, 2, 8), DAGGER(10, 10, 1, 1, 10),
        TWO_H_SWORD(10, 1, 3, 1, 7),
        GUN(8, 9, 9, 2, 5),
        MACHINE_GUN(7, 10, 6, 3, 3),
        BAZOOKA(10, 1, 10, 5, 1);

        private static int size;
        private static int damage;
        private int speed;
        private int range;
        private int accuracy;

        WeaponList(int damage, int speed, int range, int size, int accuracy) {
            this.setDamage(damage);
            this.setSpeed(speed);
            this.setRange(range);
            WeaponList.setSize(size);
            this.setAccuracy(accuracy);

        }

        public static int getSize() {
            return size;
        }

        public static void setSize(int size) {
            WeaponList.size = size;
        }


        public void add(WeaponList bullet) {

        }

        public Node getView() {
            return null;
            //A voir ce que l'on mettra
        }

        public int getDamage() {
            return damage;
        }

        public static void setDamage(int damage) {
            WeaponList.damage = damage;
        }

        public int getSpeed() {
            return speed;
        }

        public void setSpeed(int speed) {
            this.speed = speed;
        }

        public int getRange() {
            return range;
        }

        public void setRange(int range) {
            this.range = range;
        }

        public int getAccuracy() {
            return accuracy;
        }

        public void setAccuracy(int accuracy) {
            this.accuracy = accuracy;
        }
    }
}
