package logic;

import gfx.Sprite;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Entity {
    private BufferedImage texture=Sprite.defaultSprite.getTexture();
    protected Coordinate coordinate=new Coordinate(0,0);
    private int width=0;
    private int height=0;
    public abstract void update();
    public Entity(Sprite sprite, Coordinate coordinate)
    {
        setTexture(sprite);
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
}
