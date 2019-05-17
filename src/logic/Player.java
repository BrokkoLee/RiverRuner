package logic;

import gfx.Sprite;

public class Player extends Creature{
    private int width=64;
    private int height=128;
    public Player(Coordinate startCoordinate)
    {
        super(Sprite.MCplayerSprite,startCoordinate);
        setWidth(width);
        setHeight(height);
    }

    @Override
    public boolean isHostile() {
        return false;
    }

    @Override
    public void move() {
        int x=getX();
        int y=getY();
        x++;
        setCoordinate(new Coordinate(x,y));
    }

    @Override
    public void update() {
        move();
    }
}
