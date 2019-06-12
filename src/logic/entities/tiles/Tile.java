package logic.entities.tiles;

import gfx.sprites.Sprite;
import logic.Coordinate;
import logic.entities.Entity;

import java.awt.Graphics;

public abstract class Tile extends Entity {
    public static Tile[] tiles;
    public static final int DEFAULT_TILE_WIDTH=64;
    public static final int DEFAULT_TILE_HEIGHT=64;
    public Tile(Sprite texture)
    {
        super(texture,new Coordinate(0,0));
        setWidth(DEFAULT_TILE_WIDTH);
        setHeight(DEFAULT_TILE_HEIGHT);
    }
    public void update()
    {

    }
    public void render(Graphics graphics)
    {
        graphics.drawImage(getTexture(),position.getX()+getxOffset(),position.getY()+getyOffset(),getWidth(),getHeight(),null);
    }
    public abstract boolean isSolid();

    public Coordinate getPosition() {
        return position;
    }

    public void setPosition(Coordinate position) {
        this.position = position;
    }

    public static void initializeTiles()
    {
        tiles=new Tile[]{
                new GrassTile(),
                new StoneTile(),
        };
    }


}
