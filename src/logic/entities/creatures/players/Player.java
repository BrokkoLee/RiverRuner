package logic.entities.creatures.players;

import gfx.GamePanel;
import logic.Coordinate;
import logic.entities.creatures.Creature;
import logic.map.Map;

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
        if (GamePanel.keyManager.up && !Map.gameMap.isBindingToTopSideOfTheMap(this))
        {
            position.setY(position.getY()-speed);
        }
        if(GamePanel.keyManager.down && !Map.gameMap.isBindingToBottomSideOfTheMap(this))
        {
            position.setY(position.getY()+speed);
        }
        if(GamePanel.keyManager.left && !Map.gameMap.isBindingToLeftSideOfTheMap(this))
        {
            position.setX(position.getX()-speed);
        }
        if(GamePanel.keyManager.right && !Map.gameMap.isBindingToRightSideOfTheMap(this))
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
