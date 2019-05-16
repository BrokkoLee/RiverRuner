package logic;

import gfx.Sprite;

public class Player extends Creature{
    public Player(Point startCoordinate)
    {
        super(Sprite.defaultSprite,startCoordinate);
    }

    @Override
    public boolean isHostile() {
        return false;
    }

    @Override
    public void move() {
        int x=getX();
        int y=getY();
        setCoordinate(new Point(x,y));
    }

    @Override
    public void update() {
        move();
    }
}
