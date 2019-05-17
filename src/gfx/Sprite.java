package gfx;

import logic.Coordinate;

import java.awt.image.BufferedImage;

public class Sprite {
    private final static SpriteSheet spriteSheet=new SpriteSheet("/textures/sprite.png");

    public final static int DEFAULT_TEXTURE_SIZE=64;



    public static Sprite defaultSprite=new Sprite(new Coordinate(0,0),DEFAULT_TEXTURE_SIZE, DEFAULT_TEXTURE_SIZE);
    public static Sprite playerSkin=new Sprite(new Coordinate(1216,1152),64,128);
    public static Sprite brickWallSprite=new Sprite(new Coordinate(64,0),DEFAULT_TEXTURE_SIZE,DEFAULT_TEXTURE_SIZE);

    private BufferedImage texture;
    private Sprite(Coordinate start, int width,int height){
        texture=spriteSheet.crop(start,width,height);
    }

    public BufferedImage getTexture() {
        return texture;
    }

}
