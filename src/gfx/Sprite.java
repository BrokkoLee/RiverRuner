package gfx;

import logic.Coordinate;

import java.awt.image.BufferedImage;

public class Sprite {
    private final static SpriteSheet spriteSheet=new SpriteSheet("/textures/SpriteSheet.png");

    public final static int DEFAULT_TEXTURE_SIZE=64;



    public static Sprite defaultSprite=new Sprite(new Coordinate(64*0,64*0),DEFAULT_TEXTURE_SIZE, DEFAULT_TEXTURE_SIZE);
    public static Sprite brickWallSprite=new Sprite(new Coordinate(64*1,64*0),DEFAULT_TEXTURE_SIZE,DEFAULT_TEXTURE_SIZE);
    public static Sprite MCdioriteSprite=new Sprite(new Coordinate(64*2,64*0),DEFAULT_TEXTURE_SIZE,DEFAULT_TEXTURE_SIZE);
    public static Sprite MCbrickWallSprite=new Sprite(new Coordinate(64*3,64*0),DEFAULT_TEXTURE_SIZE,DEFAULT_TEXTURE_SIZE);
    public static Sprite MCDirtSprite=new Sprite(new Coordinate(64*4,64*0),DEFAULT_TEXTURE_SIZE,DEFAULT_TEXTURE_SIZE);
    public static Sprite MCStoneSprite=new Sprite(new Coordinate(64*5,64*0),DEFAULT_TEXTURE_SIZE,DEFAULT_TEXTURE_SIZE);
    public static Sprite MCWoodPlankSprite=new Sprite(new Coordinate(64*6,64*0),DEFAULT_TEXTURE_SIZE,DEFAULT_TEXTURE_SIZE);
    public static Sprite MCGrassSprite=new Sprite(new Coordinate(64*7,64*0),DEFAULT_TEXTURE_SIZE,DEFAULT_TEXTURE_SIZE);
    public static Sprite MCWaterSprite=new Sprite(new Coordinate(64*8,64*0),DEFAULT_TEXTURE_SIZE,DEFAULT_TEXTURE_SIZE);

    public static Sprite MCplayerSprite =new Sprite(new Coordinate(1216,1152),64,128);

    private BufferedImage texture;
    private Sprite(Coordinate start, int width,int height){
        texture=spriteSheet.crop(start,width,height);
    }

    public BufferedImage getTexture() {
        return texture;
    }

}
