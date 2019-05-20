package logic;

import gfx.Sprite;

public class KnightPlayer extends Player {

    private Sprite[] framesMovingDown ={Sprite.KnightSprites[0],Sprite.KnightSprites[1]};
    private Sprite[] framesMovingLeft ={Sprite.KnightSprites[3],Sprite.KnightSprites[4]};
    private Sprite[] framesMovingRight ={Sprite.KnightSprites[6],Sprite.KnightSprites[7]};
    private Sprite[] framesMovingUp ={Sprite.KnightSprites[9],Sprite.KnightSprites[10]};

    private Sprite[] framesIdleDown ={Sprite.KnightSprites[2]};
    private Sprite[] framesIdleLeft ={Sprite.KnightSprites[5]};
    private Sprite[] framesIdleRight ={Sprite.KnightSprites[8]};
    private Sprite[] framesIdleUp ={Sprite.KnightSprites[11]};

    public KnightPlayer(Coordinate startCoordinate)
    {
        super(startCoordinate);
        setWidth(64);
        setHeight(96);
        setSpeed(1);
        setAnimationFrames();
        setAnimations();
        setAnimationSpeeds();

    }

    @Override
    public void setAnimationFrames() {
        setFramesMovingDown(framesMovingDown);
        setFramesIdleDown(framesIdleDown);

        setFramesMovingLeft(framesMovingLeft);
        setFramesIdleLeft(framesIdleLeft);

        setFramesMovingRight(framesMovingRight);
        setFramesIdleRight(framesIdleRight);

        setFramesMovingUp(framesMovingUp);
        setFramesIdleUp(framesIdleUp);
    }
    public void setAnimationSpeeds()
    {
        setAnimationSpeed(getAnimationIdleDown(),1000/framesIdleDown.length);
        setAnimationSpeed(getAnimationIdleUp(),1000/framesIdleUp.length);
        setAnimationSpeed(getAnimationIdleLeft(),1000/framesIdleLeft.length);
        setAnimationSpeed(getAnimationIdleRight(),1000/framesIdleRight.length);

        setAnimationSpeed(getAnimationMovingDown(),1000/framesMovingDown.length);
        setAnimationSpeed(getAnimationMovingUp(),1000/framesMovingUp.length);
        setAnimationSpeed(getAnimationMovingLeft(),1000/framesMovingLeft.length);
        setAnimationSpeed(getAnimationMovingRight(),1000/framesMovingRight.length);
    }
}
