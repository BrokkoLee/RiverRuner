package gfx;

import logic.Point;

import java.awt.image.BufferedImage;

public class Sprite {
    private final static SpriteSheet spriteSheet=new SpriteSheet("/textures/sprite.png");

    private final static int DEFAULT_SIZE=64;



    public static Sprite defaultTexture=new Sprite(new Point(0,0),DEFAULT_SIZE);


    private BufferedImage texture;
    public Sprite(Point start,int size)
    {
        texture=SpriteSheet.crop(start,size);
    }

    public BufferedImage getTexture() {
        return texture;
    }

    public static int getDefaultSize() {
        return DEFAULT_SIZE;
    }
}
