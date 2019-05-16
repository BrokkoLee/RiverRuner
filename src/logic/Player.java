package logic;

import gfx.Sprite;

public class Player extends Creature{
    public Player(Coordinate startCoordinate)
    {
        super(Sprite.defaultSprite,startCoordinate);
    }

    @Override
    public boolean isHostile() {
        return false;
    }

    @Override
    public void move() {
        /*int x=getX();
        int y=getY();
        setCoordinate(new Coordinate(x,y));*/
    }

    @Override
    public void update() {
        move();
    }
}
