package logic.entities;

import gfx.sprites.Sprite;
import logic.Coordinate;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public abstract class Entity {
    private BufferedImage texture=Sprite.defaultSprite.getTexture();
    protected Coordinate coordinate=new Coordinate(0,0);
    private int width=0;
    private int height=0;
    public abstract void update();
    public Entity(Sprite sprite, Coordinate coordinate)
    {
        if (sprite!=null)
        {
            setTexture(sprite);
        }
        setCoordinate(coordinate);
    }
    public Entity(Coordinate coordinate)
    {
        setCoordinate(coordinate);
    }

    public void setTexture(Sprite sprite)
    {
        this.texture=sprite.getTexture();
    }
    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }
    public void render(Graphics graphics) {
        if (width > 0 && height > 0)
            graphics.drawImage(texture, coordinate.getX(), coordinate.getY(), width, height, null);
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
