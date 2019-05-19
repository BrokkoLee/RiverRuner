package logic;

import gfx.Sprite;

import java.awt.Graphics;

public abstract class Creature extends Entity{
    private Direction CurrentMovementDirection;
    private Sprite[] AnimationTexturesDown;
    private Sprite[] AnimationTexturesLeft;
    private Sprite[] AnimationTexturesRight;
    private Sprite[] AnimationTexturesUp;
    private int CurrentAnimationIndex=0;

    public Creature(Sprite[] sprites,int animationCycleLength, Coordinate coordinate )
    {
        super(coordinate);
        setAnimationTextures(sprites);

    }
    private void setAnimationTextures(Sprite[] textures)
    {

    }

    public abstract boolean isHostile();
    protected abstract void move();

    public int getX() {
        return coordinate.getX();
    }

    public int getY() {
        return coordinate.getY();
    }

    @Override
    public void update()
    {

    }
    @Override
    public void render(Graphics graphics)
    {

    }

    public void setCurrentMovementDirection(Direction currentMovementDirection)
    {
        this.CurrentMovementDirection = currentMovementDirection;
    }

    public Direction getCurrentMovementDirection()
    {
        return CurrentMovementDirection;
    }
    public void playAnimation()
    {
        switch (CurrentMovementDirection)
        {
            case up:

                break;
            case down:

                break;
            case left:

                break;
            case right:

                break;
        }
    }

}
