package logic.entities.creatures.players;

import gfx.GamePanel;
import logic.Coordinate;
import logic.entities.creatures.Creature;

public  abstract class Player extends Creature {

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
            position.setY(position.getY()-speed);
        }
        if(GamePanel.keyManager.down)
        {
            position.setY(position.getY()+speed);
        }
        if(GamePanel.keyManager.left)
        {
            position.setX(position.getX()-speed);
        }
        if(GamePanel.keyManager.right)
        {
            position.setX(position.getX()+speed);
        }
    }

    @Override
    public void update() {
        super.update();
        move();
    }
    public void setSpeed(int newSpeed)
    {
        this.speed=newSpeed;
    }
}
