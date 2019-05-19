package gfx;

import java.awt.Graphics;

public class Animation {
    private Sprite[] frames;
    private int speed;
    private int index;
    private long lastTime;
    private long timer;
    public Animation(Sprite[] frames, int speed)
    {
        this.speed=speed;
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

}
