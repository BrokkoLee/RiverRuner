package logic.entities.creatures;

import gfx.Animation;
import gfx.GamePanel;
import logic.Coordinate;
import logic.Direction;
import logic.entities.Entity;

import java.awt.Graphics;

public abstract class Creature extends Entity {
    private boolean moving=false;

    private Animation animationMovingDown;
    private Animation animationMovingLeft;
    private Animation animationMovingRight;
    private Animation animationMovingUp;

    private Animation animationIdleDown;
    private Animation animationIdleLeft;
    private Animation animationIdleRight;
    private Animation animationIdleUp;


    private Direction direction;
    public Creature(Coordinate coordinate)
    {
        super(coordinate);
        direction=Direction.down;
        setAnimations();
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
            switch (direction) {
                case up:
                    graphics.drawImage(animationMovingUp.getCurrentFrame().getTexture(), coordinate.getX(), coordinate.getY(), getWidth(), getHeight(), null);
                    break;
                case down:
                    graphics.drawImage(animationMovingDown.getCurrentFrame().getTexture(), coordinate.getX(), coordinate.getY(), getWidth(), getHeight(), null);
                    break;
                case left:
                    graphics.drawImage(animationMovingLeft.getCurrentFrame().getTexture(), coordinate.getX(), coordinate.getY(), getWidth(), getHeight(), null);
                    break;
                case right:
                    graphics.drawImage(animationMovingRight.getCurrentFrame().getTexture(), coordinate.getX(), coordinate.getY(), getWidth(), getHeight(), null);
                    break;
            }
        }
        else
        {
            if (direction==Direction.up)
            {
                graphics.drawImage(animationIdleUp.getCurrentFrame().getTexture(),coordinate.getX(),coordinate.getY(),getWidth(),getHeight(),null);
            }
            else if (direction==Direction.down)
            {
                graphics.drawImage(animationIdleDown.getCurrentFrame().getTexture(),coordinate.getX(),coordinate.getY(),getWidth(),getHeight(),null);
            }
            else if (direction==Direction.left)
            {
                graphics.drawImage(animationIdleLeft.getCurrentFrame().getTexture(),coordinate.getX(),coordinate.getY(),getWidth(),getHeight(),null);
            }
            else if (direction==Direction.right)
            {
                graphics.drawImage(animationIdleRight.getCurrentFrame().getTexture(),coordinate.getX(),coordinate.getY(),getWidth(),getHeight(),null);
            }
        }
    }

    public void updateAnimation()
    {
        animationIdleUp.update();
        animationIdleDown.update();
        animationIdleLeft.update();
        animationIdleRight.update();

        animationMovingDown.update();
        animationMovingLeft.update();
        animationMovingRight.update();
        animationMovingUp.update();
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

    public abstract void setAnimations();

    public int getX() {
        return coordinate.getX();
    }

    public int getY() {
        return coordinate.getY();
    }

    public void setAnimationMovingDown(Animation animationMovingDown) {
        this.animationMovingDown = animationMovingDown;
    }

    public void setAnimationMovingLeft(Animation animationMovingLeft) {
        this.animationMovingLeft = animationMovingLeft;
    }

    public void setAnimationMovingRight(Animation animationMovingRight) {
        this.animationMovingRight = animationMovingRight;
    }

    public void setAnimationMovingUp(Animation animationMovingUp) {
        this.animationMovingUp = animationMovingUp;
    }

    public void setAnimationIdleDown(Animation animationIdleDown) {
        this.animationIdleDown = animationIdleDown;
    }

    public void setAnimationIdleLeft(Animation animationIdleLeft) {
        this.animationIdleLeft = animationIdleLeft;
    }

    public void setAnimationIdleRight(Animation animationIdleRight) {
        this.animationIdleRight = animationIdleRight;
    }

    public void setAnimationIdleUp(Animation animationIdleUp) {
        this.animationIdleUp = animationIdleUp;
    }

    public Animation getAnimationMovingDown() {
        return animationMovingDown;
    }

    public Animation getAnimationMovingLeft() {
        return animationMovingLeft;
    }

    public Animation getAnimationMovingRight() {
        return animationMovingRight;
    }

    public Animation getAnimationMovingUp() {
        return animationMovingUp;
    }

    public Animation getAnimationIdleDown() {
        return animationIdleDown;
    }

    public Animation getAnimationIdleLeft() {
        return animationIdleLeft;
    }

    public Animation getAnimationIdleRight() {
        return animationIdleRight;
    }

    public Animation getAnimationIdleUp() {
        return animationIdleUp;
    }

    public void setAnimationSpeed(Animation animation, int newSpeed)
    {
        animation.setSpeed(newSpeed);
    }

}
