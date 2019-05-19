package logic;

import gfx.Animation;
import gfx.Sprite;

public class Player extends Creature{
    private int width=64;
    private int height=96;
    private final int DEFAULT_ANIMATION_SPEED=250;

    private Sprite[] FramesMovingDown={Sprite.PlayerSprites[0],Sprite.PlayerSprites[1]};
    private Sprite[] FramesMovingLeft={Sprite.PlayerSprites[3],Sprite.PlayerSprites[4]};
    private Sprite[] FramesMovingRight={Sprite.PlayerSprites[6],Sprite.PlayerSprites[7]};
    private Sprite[] FramesMovingUp={Sprite.PlayerSprites[9],Sprite.PlayerSprites[10]};

    private Sprite[] FramesIdleDown={Sprite.PlayerSprites[2]};
    private Sprite[] FramesIdleLeft={Sprite.PlayerSprites[5]};
    private Sprite[] FramesIdleRight={Sprite.PlayerSprites[8]};
    private Sprite[] FramesIdleUp={Sprite.PlayerSprites[11]};


    public Player(Coordinate startCoordinate)
    {
        super(startCoordinate);
        setWidth(width);
        setHeight(height);
        setAnimations();
    }

    @Override
    public boolean isHostile() {
        return false;
    }

    @Override
    public void move() {
        int x=getX();
        int y=getY();
        setCoordinate(new Coordinate(x,y));
    }

    @Override
    public void update() {
        super.update();
        move();
    }
    public void setAnimations()
    {
        setAnimationMovingDown(new Animation(FramesMovingDown,DEFAULT_ANIMATION_SPEED));
        setAnimationMovingLeft(new Animation(FramesMovingLeft,DEFAULT_ANIMATION_SPEED));
        setAnimationMovingRight(new Animation(FramesMovingRight,DEFAULT_ANIMATION_SPEED));
        setAnimationMovingUp(new Animation(FramesMovingUp,DEFAULT_ANIMATION_SPEED));

        setAnimationIdleDown(new Animation(FramesIdleDown,DEFAULT_ANIMATION_SPEED));
        setAnimationIdleLeft(new Animation(FramesIdleLeft,DEFAULT_ANIMATION_SPEED));
        setAnimationIdleRight(new Animation(FramesIdleRight,DEFAULT_ANIMATION_SPEED));
        setAnimationIdleUp(new Animation(FramesIdleUp,DEFAULT_ANIMATION_SPEED));
    }
}
