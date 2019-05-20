package logic;

import gfx.Sprite;

public class ArcherPlayer extends Player{

    private Sprite[] framesIdleUp ={Sprite.ArcherSprites[0]};
    private Sprite[] framesIdleLeft ={Sprite.ArcherSprites[9]};
    private Sprite[] framesIdleRight ={Sprite.ArcherSprites[27]};
    private Sprite[] framesIdleDown ={Sprite.ArcherSprites[18]};
    private int speed=3;

    private Sprite[] framesMovingUp ={
            Sprite.ArcherSprites[1],
            Sprite.ArcherSprites[2],
            Sprite.ArcherSprites[3],
            Sprite.ArcherSprites[4],
            Sprite.ArcherSprites[5],
            Sprite.ArcherSprites[6],
            Sprite.ArcherSprites[7],
            Sprite.ArcherSprites[8]
    };
    private Sprite[] framesMovingLeft ={
            Sprite.ArcherSprites[10],
            Sprite.ArcherSprites[11],
            Sprite.ArcherSprites[12],
            Sprite.ArcherSprites[13],
            Sprite.ArcherSprites[14],
            Sprite.ArcherSprites[15],
            Sprite.ArcherSprites[16],
            Sprite.ArcherSprites[17]
    };
    private Sprite[] framesMovingDown ={
            Sprite.ArcherSprites[19],
            Sprite.ArcherSprites[20],
            Sprite.ArcherSprites[21],
            Sprite.ArcherSprites[22],
            Sprite.ArcherSprites[23],
            Sprite.ArcherSprites[24],
            Sprite.ArcherSprites[25],
            Sprite.ArcherSprites[26]
    };
    private Sprite[] framesMovingRight ={
            Sprite.ArcherSprites[27],
            Sprite.ArcherSprites[28],
            Sprite.ArcherSprites[29],
            Sprite.ArcherSprites[30],
            Sprite.ArcherSprites[31],
            Sprite.ArcherSprites[32],
            Sprite.ArcherSprites[33],
            Sprite.ArcherSprites[34]
    };

    public ArcherPlayer(Coordinate startCoordinate)
    {
        super(startCoordinate);
        setWidth(64);
        setHeight(64);
        setSpeed(speed);
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
