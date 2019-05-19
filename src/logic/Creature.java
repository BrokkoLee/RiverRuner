package logic;

import gfx.Animation;
import gfx.GamePanel;

import java.awt.Graphics;

public abstract class Creature extends Entity{
    private boolean moving=false;

    private Animation AnimationMovingDown;
    private Animation AnimationMovingLeft;
    private Animation AnimationMovingRight;
    private Animation AnimationMovingUp;
    private Animation AnimationIdleDown;
    private Animation AnimationIdleLeft;
    private Animation AnimationIdleRight;
    private Animation AnimationIdleUp;

    private Direction direction;
    public Creature(Coordinate coordinate)
    {
        super(coordinate);
        direction=Direction.down;
    }

    public abstract boolean isHostile();
    protected abstract void move();

    @Override
    public void update()
    {
        updateMoving();
        updateDirection();
        updateAnimation();
    }
    @Override
    public void render(Graphics graphics)
    {
        playAnimation(graphics);
    }


    public void playAnimation(Graphics graphics)
    {
        if(moving)
        {
            if (direction==Direction.up)
            {
                graphics.drawImage(AnimationMovingUp.getCurrentFrame().getTexture(),coordinate.getX(),coordinate.getY(),getWidth(),getHeight(),null);
            }
            else if (direction==Direction.down)
            {
                graphics.drawImage(AnimationMovingDown.getCurrentFrame().getTexture(),coordinate.getX(),coordinate.getY(),getWidth(),getHeight(),null);
            }
            else if (direction==Direction.left)
            {
                graphics.drawImage(AnimationMovingLeft.getCurrentFrame().getTexture(),coordinate.getX(),coordinate.getY(),getWidth(),getHeight(),null);
            }
            else if (direction==Direction.right)
            {
                graphics.drawImage(AnimationMovingRight.getCurrentFrame().getTexture(),coordinate.getX(),coordinate.getY(),getWidth(),getHeight(),null);
            }
        }
        else
        {
            if (direction==Direction.up)
            {
                graphics.drawImage(AnimationIdleUp.getCurrentFrame().getTexture(),coordinate.getX(),coordinate.getY(),getWidth(),getHeight(),null);
            }
            else if (direction==Direction.down)
            {
                graphics.drawImage(AnimationIdleDown.getCurrentFrame().getTexture(),coordinate.getX(),coordinate.getY(),getWidth(),getHeight(),null);
            }
            else if (direction==Direction.left)
            {
                graphics.drawImage(AnimationIdleLeft.getCurrentFrame().getTexture(),coordinate.getX(),coordinate.getY(),getWidth(),getHeight(),null);
            }
            else if (direction==Direction.right)
            {
                graphics.drawImage(AnimationIdleRight.getCurrentFrame().getTexture(),coordinate.getX(),coordinate.getY(),getWidth(),getHeight(),null);
            }
        }
    }

    public void updateAnimation()
    {
        AnimationIdleUp.update();
        AnimationIdleDown.update();
        AnimationIdleLeft.update();
        AnimationIdleRight.update();

        AnimationMovingDown.update();
        AnimationMovingLeft.update();
        AnimationMovingRight.update();
        AnimationMovingUp.update();
    }
    public void updateDirection()
    {
        if(GamePanel.keyManager.down)
        {
            direction=Direction.down;
        }
        else if(GamePanel.keyManager.up)
        {
            direction=Direction.up;
        }
        else if(GamePanel.keyManager.left)
        {
            direction=Direction.left;
        }
        else if(GamePanel.keyManager.right)
        {
            direction=Direction.right;
        }

    }
    public void updateMoving()
    {
        if(GamePanel.keyManager.up || GamePanel.keyManager.down || GamePanel.keyManager.right || GamePanel.keyManager.left)
        {
            moving=true;
        }
        else
        {
            moving=false;
        }
    }

    public int getX() {
        return coordinate.getX();
    }

    public int getY() {
        return coordinate.getY();
    }

    public void setAnimationMovingDown(Animation animationMovingDown) {
        AnimationMovingDown = animationMovingDown;
    }

    public void setAnimationMovingLeft(Animation animationMovingLeft) {
        AnimationMovingLeft = animationMovingLeft;
    }

    public void setAnimationMovingRight(Animation animationMovingRight) {
        AnimationMovingRight = animationMovingRight;
    }

    public void setAnimationMovingUp(Animation animationMovingUp) {
        AnimationMovingUp = animationMovingUp;
    }

    public void setAnimationIdleDown(Animation animationIdleDown) {
        AnimationIdleDown = animationIdleDown;
    }

    public void setAnimationIdleLeft(Animation animationIdleLeft) {
        AnimationIdleLeft = animationIdleLeft;
    }

    public void setAnimationIdleRight(Animation animationIdleRight) {
        AnimationIdleRight = animationIdleRight;
    }

    public void setAnimationIdleUp(Animation animationIdleUp) {
        AnimationIdleUp = animationIdleUp;
    }
}
