package org.plugins;

public class Maths {

    private Vector2f pos;
    private float xOffset = 0;
    private float yOffset = 0;
    private float w;
    private float h;
    private float r;
    private int size;

    private float surfaceArea;

    public Maths(Vector2f pos, int w, int h) {
        this.pos = pos;
        this.w = w;
        this.h = h;
        this.surfaceArea = w * h;

        size = Math.max(w, h);
    }

    public Maths(Vector2f pos, int r) {
        this.pos = pos;
        this.r = r;
        this.surfaceArea = (float) Math.PI * (r * r);

        size = r;
    }



    public Vector2f getPos() { return pos; }

    public float getRadius() { return r; }
    public float getSize() { return size; }
    public float getWidth() { return w; }
    public float getHeight() { return h; }
    public float getSurfaceArea() { return surfaceArea; }

    public void setBox(Vector2f pos, int w, int h) {
        this.pos = pos;
        this.w = w;
        this.h = h;

        size = Math.max(w, h);
    }

    public void setCircle(Vector2f pos, int r) {
        this.pos = pos;
        this.r = r;

        size = r;
    }

    public void setWidth(float f) { w = f; }
    public void setHeight(float f) { h = f; }

    public void setXOffset(float f) { xOffset = f; }
    public void setYOffset(float f) { yOffset = f; }
    public float getXOffset() { return xOffset; }
    public float getYOffset() { return yOffset; }




    public boolean inside(int xp, int yp) {
        if(xp == -1 || yp == - 1) return false;

        int wTemp = (int) this.w;
        int hTemp = (int) this.h;
        int x = (int) this.pos.x;
        int y = (int) this.pos.y;

        if(xp < x || yp < y) {
            return false;
        }

        wTemp += x;
        hTemp += y;
        return ((wTemp < x || wTemp > xp) && (hTemp < y || hTemp > yp));
    }

/*    public boolean intersect(Maths aBox)
    {

        if((pos.x + xOffset > aBox.getPos().x + aBox.getXOffset() + aBox.getSize())
                || (aBox.getPos().x + xOffset > pos.x + aBox.getXOffset() + aBox.getSize()))
        {
            return false;
        }

        if((pos.y + yOffset > aBox.getPos().y + aBox.getYOffset() + aBox.getSize())
                || (aBox.getPos().y + yOffset > pos.y + aBox.getYOffset() + aBox.getSize()))
        {
            return false;
        }

        return true;
    }*/

    public boolean colCircle(Maths circle) {

        float totalRadius = r + circle.getRadius();
        totalRadius *= totalRadius;

        float dx = (pos.x + circle.getPos().x);
        float dy = (pos.y + circle.getPos().y);

        return totalRadius < (dx * dx) + (dy * dy);
    }


    public boolean colCircleBox(Maths aBox) {

        float dx = Math.max(aBox.getPos().x + aBox.getXOffset(), Math.min(pos.x + (r / 2), aBox.getPos().x + aBox.getXOffset() + aBox.getWidth()));
        float dy = Math.max(aBox.getPos().y + aBox.getYOffset(), Math.min(pos.y + (r / 2), aBox.getPos().y + aBox.getYOffset() + aBox.getHeight()));

        dx = pos.x + (r / 2) - dx;
        dy = pos.y + (r / 2) - dy;

        if(Math.sqrt(dx * dx + dy * dy) < r / 2) {
            return true;
        }

        return false;
    }

    public float distance(Vector2f other) {
        float dx = pos.x - other.x;
        float dy = pos.y - other.y;
        return (float) Math.sqrt(dx * dx + dy * dy);
    }

    public Maths merge(Maths other) {
        float minX = Math.min(pos.x, other.getPos().x);
        float minY = Math.min(pos.y, other.getPos().y);

        int maxW = (int) Math.max(w, other.getWidth());
        int maxH = (int) Math.max(h, other.getHeight());

        Vector2f pos = new Vector2f(minX, minY);
        return new Maths(pos, maxW, maxH);
    }

    public String toString() {

        String x = Float.toString(pos.x);
        String y = Float.toString(pos.y);
        String w = Float.toString(this.w);
        String h = Float.toString(this.h);

        return "{" + x + ", " + y + " : " + w + ", " + h + "}";
    }
    public static class Vector2f {

        public float x;
        public float y;

        public Vector2f() {
            x = 0;
            y = 0;
        }

        public Vector2f(Vector2f vec) {
            new Vector2f(vec.x, vec.y);
        }

        public Vector2f(float x, float y) {
            this.x = x;
            this.y = y;
        }

        public void addX(float f) { x += f; }
        public void addY(float f) { y += f; }

        public void setX(float f) { x = f; }
        public void setY(float f) { y = f; }

        public void setVector(Vector2f vec) {
            this.x = vec.x;
            this.y = vec.y;
        }

        public void setVector(float x, float y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return x + ", " + y;
        }

    }
}
