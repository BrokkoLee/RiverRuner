package gfx;

import gfx.sprites.Sprite;

public class Animation {
    private Sprite[] frames;
    private int speed;
    private int index;
    private long lastTime;
    private long timer;
    public Animation(Sprite[] frames)
    {
        setSpeed(0);
        this.frames=frames;
        index=0;
        timer=0;
        lastTime=System.currentTimeMillis();
    }
    public void update()
    {
        timer+=System.currentTimeMillis()-lastTime;
        lastTime=System.currentTimeMillis();

        if(timer>speed)
        {
            index++;
            timer=0;
            if(index>=frames.length)
            {
                index=0;
            }
        }
    }

    public Sprite getCurrentFrame()
    {
        return frames[index];
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
