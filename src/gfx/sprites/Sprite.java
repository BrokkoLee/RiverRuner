package gfx.sprites;

import logic.Coordinate;

import java.awt.image.BufferedImage;

public class Sprite {
    private final static SpriteSheet spriteSheet=new SpriteSheet("/textures/SpriteSheet.png");

    public final static int DEFAULT_TEXTURE_SIZE=64;



    public static Sprite defaultSprite=new Sprite(new Coordinate(64*0,64*0),DEFAULT_TEXTURE_SIZE, DEFAULT_TEXTURE_SIZE);
    public static Sprite brickWallSprite=new Sprite(new Coordinate(64*1,64*0),DEFAULT_TEXTURE_SIZE,DEFAULT_TEXTURE_SIZE);
    public static Sprite GrassSprite=new Sprite(new Coordinate(64*7,64*0),DEFAULT_TEXTURE_SIZE,DEFAULT_TEXTURE_SIZE);

    public static Sprite MCdioriteSprite=new Sprite(new Coordinate(64*2,64*0),DEFAULT_TEXTURE_SIZE,DEFAULT_TEXTURE_SIZE);
    public static Sprite MCbrickWallSprite=new Sprite(new Coordinate(64*3,64*0),DEFAULT_TEXTURE_SIZE,DEFAULT_TEXTURE_SIZE);
    public static Sprite MCDirtSprite=new Sprite(new Coordinate(64*4,64*0),DEFAULT_TEXTURE_SIZE,DEFAULT_TEXTURE_SIZE);
    public static Sprite MCStoneSprite=new Sprite(new Coordinate(64*5,64*0),DEFAULT_TEXTURE_SIZE,DEFAULT_TEXTURE_SIZE);
    public static Sprite MCWoodPlankSprite=new Sprite(new Coordinate(64*6,64*0),DEFAULT_TEXTURE_SIZE,DEFAULT_TEXTURE_SIZE);
    public static Sprite MCWaterSprite=new Sprite(new Coordinate(64*8,64*0),DEFAULT_TEXTURE_SIZE,DEFAULT_TEXTURE_SIZE);

    public static Sprite MCPlayerSprite =new Sprite(new Coordinate(0,1152),64,128);

    public static Sprite[] KnightSprites ={
            //down movements here
            new Sprite(new Coordinate(4928,4736),64,96),
            new Sprite(new Coordinate(4992,4736),64,96),
            new Sprite(new Coordinate(5056,4736),64,96),
            //down movements end

            //left movements here
            new Sprite(new Coordinate(4928,4832),64,96),
            new Sprite(new Coordinate(4992,4832),64,96),
            new Sprite(new Coordinate(5056,4832),64,96),
            //left movements end

            //right movements here
            new Sprite(new Coordinate(4928,4928),64,96),
            new Sprite(new Coordinate(4992,4928),64,96),
            new Sprite(new Coordinate(5056,4928),64,96),
            //right movements end

            //up movements here
            new Sprite(new Coordinate(4928,5024),64,96),
            new Sprite(new Coordinate(4992,5024),64,96),
            new Sprite(new Coordinate(5056,5024),64,96),
            //up movements end
    };

    public static Sprite[] ArcherSprites={
            //up movements here
            new Sprite(new Coordinate(4352,4864),DEFAULT_TEXTURE_SIZE,DEFAULT_TEXTURE_SIZE),
            new Sprite(new Coordinate(4416,4864),DEFAULT_TEXTURE_SIZE,DEFAULT_TEXTURE_SIZE),
            new Sprite(new Coordinate(4480,4864),DEFAULT_TEXTURE_SIZE,DEFAULT_TEXTURE_SIZE),
            new Sprite(new Coordinate(4544,4864),DEFAULT_TEXTURE_SIZE,DEFAULT_TEXTURE_SIZE),
            new Sprite(new Coordinate(4608,4864),DEFAULT_TEXTURE_SIZE,DEFAULT_TEXTURE_SIZE),
            new Sprite(new Coordinate(4672,4864),DEFAULT_TEXTURE_SIZE,DEFAULT_TEXTURE_SIZE),
            new Sprite(new Coordinate(4736,4864),DEFAULT_TEXTURE_SIZE,DEFAULT_TEXTURE_SIZE),
            new Sprite(new Coordinate(4800,4864),DEFAULT_TEXTURE_SIZE,DEFAULT_TEXTURE_SIZE),
            new Sprite(new Coordinate(4864,4864),DEFAULT_TEXTURE_SIZE,DEFAULT_TEXTURE_SIZE),
            //up movements end

            //left movements here
            new Sprite(new Coordinate(4352,4928),DEFAULT_TEXTURE_SIZE,DEFAULT_TEXTURE_SIZE),
            new Sprite(new Coordinate(4416,4928),DEFAULT_TEXTURE_SIZE,DEFAULT_TEXTURE_SIZE),
            new Sprite(new Coordinate(4480,4928),DEFAULT_TEXTURE_SIZE,DEFAULT_TEXTURE_SIZE),
            new Sprite(new Coordinate(4544,4928),DEFAULT_TEXTURE_SIZE,DEFAULT_TEXTURE_SIZE),
            new Sprite(new Coordinate(4608,4928),DEFAULT_TEXTURE_SIZE,DEFAULT_TEXTURE_SIZE),
            new Sprite(new Coordinate(4672,4928),DEFAULT_TEXTURE_SIZE,DEFAULT_TEXTURE_SIZE),
            new Sprite(new Coordinate(4736,4928),DEFAULT_TEXTURE_SIZE,DEFAULT_TEXTURE_SIZE),
            new Sprite(new Coordinate(4800,4928),DEFAULT_TEXTURE_SIZE,DEFAULT_TEXTURE_SIZE),
            new Sprite(new Coordinate(4864,4928),DEFAULT_TEXTURE_SIZE,DEFAULT_TEXTURE_SIZE),
            //left movements end

            //down movements here
            new Sprite(new Coordinate(4352,4992),DEFAULT_TEXTURE_SIZE,DEFAULT_TEXTURE_SIZE),
            new Sprite(new Coordinate(4416,4992),DEFAULT_TEXTURE_SIZE,DEFAULT_TEXTURE_SIZE),
            new Sprite(new Coordinate(4480,4992),DEFAULT_TEXTURE_SIZE,DEFAULT_TEXTURE_SIZE),
            new Sprite(new Coordinate(4544,4992),DEFAULT_TEXTURE_SIZE,DEFAULT_TEXTURE_SIZE),
            new Sprite(new Coordinate(4608,4992),DEFAULT_TEXTURE_SIZE,DEFAULT_TEXTURE_SIZE),
            new Sprite(new Coordinate(4672,4992),DEFAULT_TEXTURE_SIZE,DEFAULT_TEXTURE_SIZE),
            new Sprite(new Coordinate(4736,4992),DEFAULT_TEXTURE_SIZE,DEFAULT_TEXTURE_SIZE),
            new Sprite(new Coordinate(4800,4992),DEFAULT_TEXTURE_SIZE,DEFAULT_TEXTURE_SIZE),
            new Sprite(new Coordinate(4864,4992),DEFAULT_TEXTURE_SIZE,DEFAULT_TEXTURE_SIZE),
            //down movements end

            //right movements here
            new Sprite(new Coordinate(4352,5056),DEFAULT_TEXTURE_SIZE,DEFAULT_TEXTURE_SIZE),
            new Sprite(new Coordinate(4416,5056),DEFAULT_TEXTURE_SIZE,DEFAULT_TEXTURE_SIZE),
            new Sprite(new Coordinate(4480,5056),DEFAULT_TEXTURE_SIZE,DEFAULT_TEXTURE_SIZE),
            new Sprite(new Coordinate(4544,5056),DEFAULT_TEXTURE_SIZE,DEFAULT_TEXTURE_SIZE),
            new Sprite(new Coordinate(4608,5056),DEFAULT_TEXTURE_SIZE,DEFAULT_TEXTURE_SIZE),
            new Sprite(new Coordinate(4672,5056),DEFAULT_TEXTURE_SIZE,DEFAULT_TEXTURE_SIZE),
            new Sprite(new Coordinate(4736,5056),DEFAULT_TEXTURE_SIZE,DEFAULT_TEXTURE_SIZE),
            new Sprite(new Coordinate(4800,5056),DEFAULT_TEXTURE_SIZE,DEFAULT_TEXTURE_SIZE),
            new Sprite(new Coordinate(4864,5056),DEFAULT_TEXTURE_SIZE,DEFAULT_TEXTURE_SIZE),
            //right movements end
    };

    private BufferedImage texture;
    private Sprite(Coordinate start, int width, int height){
        texture=spriteSheet.crop(start,width,height);
    }

    public BufferedImage getTexture() {
        return texture;
    }

}
