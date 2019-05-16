package logic;

import gfx.Sprite;

public abstract class Creature extends Entity{
    public Creature(Sprite sprite, Point coordinate)
    {
        super(sprite,coordinate);
    }

    public abstract boolean isHostile();
    public abstract void move();

    public int getX() {
        return coordinate.getX();
    }

    public int getY() {
        return coordinate.getY();
    }

}
