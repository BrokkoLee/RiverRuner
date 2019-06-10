package logic.entities.tiles;

import gfx.sprites.Sprite;
import logic.Coordinate;

import java.awt.Graphics;

public abstract class Tile {
    private Coordinate position;
    private int width;
    private int height;
    private Sprite texture;

    public static Tile[] tiles;

    public Tile(int width, int height, Sprite texture)
    {
        this.position =new Coordinate(0,0);
        this.width=width;
        this.height=height;
        this.texture=texture;
    }
    public void update()
    {

    }
    public void render(Graphics graphics)
    {
        graphics.drawImage(texture.getTexture(),position.getX(),position.getY(),this.width,this.height,null);
    }
    public abstract boolean isSolid();

    public Coordinate getPosition() {
        return position;
    }

    public void setPosition(Coordinate position) {
        this.position = position;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
    public static void initializeTiles()
    {
        tiles=new Tile[]{
                new GrassTile(),
                new StoneTile(),
        };
    }
}
