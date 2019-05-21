package logic;

import gfx.GamePanel;

public  abstract class Player extends Creature{

    private int speed=2;

    public Player(Coordinate startCoordinate)
    {
        super(startCoordinate);
    }

    @Override
    public boolean isHostile() {
        return false;
    }

    @Override
    public void move() {
        if (GamePanel.keyManager.up)
        {
            coordinate.setY(coordinate.getY()-speed);
        }
        if(GamePanel.keyManager.down)
        {
            coordinate.setY(coordinate.getY()+speed);
        }
        if(GamePanel.keyManager.left)
        {
            coordinate.setX(coordinate.getX()-speed);
        }
        if(GamePanel.keyManager.right)
        {
            coordinate.setX(coordinate.getX()+speed);
        }
    }

    @Override
    public void update() {
        super.update();
        move();
    }
    public void setSpeed(int newSpeed)
    {

    }
}
