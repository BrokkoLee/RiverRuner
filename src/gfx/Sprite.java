package gfx;

import logic.Point;

import java.awt.image.BufferedImage;

public class Sprite {
    private final static SpriteSheet spriteSheet=new SpriteSheet("/textures/sprite.png");

    public final static int DEFAULT_SIZE=64;



    public static Sprite defaultTexture=new Sprite(new Point(0,0),DEFAULT_SIZE);


    private BufferedImage texture;
    private Sprite(Point start,int size){
        texture=spriteSheet.crop(start,size);
    }

    public BufferedImage getTexture() {
        return texture;
    }

}
