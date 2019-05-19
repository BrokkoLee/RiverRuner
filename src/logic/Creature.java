package logic;

import gfx.Animation;

import java.awt.Graphics;

public abstract class Creature extends Entity{
    private Direction CurrentMovementDirection=Direction.right;
    private MovementStatus movementStatus=MovementStatus.idle;

    private Animation AnimationMovingDown;
    private Animation AnimationMovingLeft;
    private Animation AnimationMovingRight;
    private Animation AnimationMovingUp;
    private Animation AnimationIdleDown;
    private Animation AnimationIdleLeft;
    private Animation AnimationIdleRight;
    private Animation AnimationIdleUp;

    public Creature(Coordinate coordinate)
    {
        super(coordinate);
    }

    public abstract boolean isHostile();
    protected abstract void move();

    @Override
    public void update()
    {
        updateAnimation();
    }
    @Override
    public void render(Graphics graphics)
    {
        playAnimation(graphics);
    }

    public void setCurrentMovementDirection(Direction currentMovementDirection)
    {
        this.CurrentMovementDirection = currentMovementDirection;
    }

    public Direction getCurrentMovementDirection()
    {
        return CurrentMovementDirection;
    }

    public void playAnimation(Graphics graphics)
    {
        switch (CurrentMovementDirection)
        {
            case up:
                if (movementStatus==MovementStatus.idle)
                {
                    graphics.drawImage(AnimationIdleUp.getCurrentFrame().getTexture(),coordinate.getX(),coordinate.getY(),getWidth(),getHeight(),null);
                }
                else
                {
                    graphics.drawImage(AnimationMovingUp.getCurrentFrame().getTexture(),coordinate.getX(),coordinate.getY(),getWidth(),getHeight(),null);
                }
                break;
            case down:
                if (movementStatus==MovementStatus.idle)
                {
                    graphics.drawImage(AnimationIdleDown.getCurrentFrame().getTexture(),coordinate.getX(),coordinate.getY(),getWidth(),getHeight(),null);
                }
                else
                {
                    graphics.drawImage(AnimationMovingDown.getCurrentFrame().getTexture(),coordinate.getX(),coordinate.getY(),getWidth(),getHeight(),null);
                }
                break;
            case left:
                if (movementStatus==MovementStatus.idle)
                {
                    graphics.drawImage(AnimationIdleLeft.getCurrentFrame().getTexture(),coordinate.getX(),coordinate.getY(),getWidth(),getHeight(),null);
                }
                else
                {
                    graphics.drawImage(AnimationMovingLeft.getCurrentFrame().getTexture(),coordinate.getX(),coordinate.getY(),getWidth(),getHeight(),null);
                }
                break;
            case right:
                if (movementStatus==MovementStatus.idle)
                {
                    graphics.drawImage(AnimationIdleRight.getCurrentFrame().getTexture(),coordinate.getX(),coordinate.getY(),getWidth(),getHeight(),null);
                }
                else
                {
                    graphics.drawImage(AnimationMovingRight.getCurrentFrame().getTexture(),coordinate.getX(),coordinate.getY(),getWidth(),getHeight(),null);
                }
                break;
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
