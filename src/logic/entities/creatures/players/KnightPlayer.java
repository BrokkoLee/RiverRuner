package logic.entities.creatures.players;

import gfx.Animation;
import gfx.sprites.Sprite;
import logic.Coordinate;

public class KnightPlayer extends Player {

    private Sprite[] framesMovingDown ={Sprite.KnightSprites[0],Sprite.KnightSprites[1]};
    private Sprite[] framesMovingLeft ={Sprite.KnightSprites[3],Sprite.KnightSprites[4]};
    private Sprite[] framesMovingRight ={Sprite.KnightSprites[6],Sprite.KnightSprites[7]};
    private Sprite[] framesMovingUp ={Sprite.KnightSprites[9],Sprite.KnightSprites[10]};

    private Sprite[] framesIdleDown ={Sprite.KnightSprites[2]};
    private Sprite[] framesIdleLeft ={Sprite.KnightSprites[5]};
    private Sprite[] framesIdleRight ={Sprite.KnightSprites[8]};
    private Sprite[] framesIdleUp ={Sprite.KnightSprites[11]};

    private int speed=1;
    public KnightPlayer(Coordinate startCoordinate)
    {
        super(startCoordinate);
        setWidth(64);
        setHeight(96);
        setSpeed(speed);
        setAnimations();
        setAnimationSpeeds();

    }
    @Override
    public void setAnimations() {
        setAnimationIdleDown(new Animation(framesIdleDown));
        setAnimationIdleUp(new Animation(framesIdleUp));
        setAnimationIdleLeft(new Animation(framesIdleLeft));
        setAnimationIdleRight(new Animation(framesIdleRight));

        setAnimationMovingDown(new Animation(framesMovingDown));
        setAnimationMovingUp(new Animation(framesMovingUp));
        setAnimationMovingLeft(new Animation(framesMovingLeft));
        setAnimationMovingRight(new Animation(framesMovingRight));
    }
    public void setAnimationSpeeds()
    {
        setAnimationSpeed(getAnimationIdleDown(),500/framesIdleDown.length);
        setAnimationSpeed(getAnimationIdleUp(),500/framesIdleUp.length);
        setAnimationSpeed(getAnimationIdleLeft(),500/framesIdleLeft.length);
        setAnimationSpeed(getAnimationIdleRight(),500/framesIdleRight.length);

        setAnimationSpeed(getAnimationMovingDown(),500/framesMovingDown.length);
        setAnimationSpeed(getAnimationMovingUp(),500/framesMovingUp.length);
        setAnimationSpeed(getAnimationMovingLeft(),500/framesMovingLeft.length);
        setAnimationSpeed(getAnimationMovingRight(),500/framesMovingRight.length);
    }
}
