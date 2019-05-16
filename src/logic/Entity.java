package logic;

import gfx.Sprite;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Entity {
    private BufferedImage texture=Sprite.defaultSprite.getTexture();
    protected Point coordinate=new Point(0,0);
    public abstract void update();
    public Entity(Sprite sprite, Point coordinate)
    {
        this.texture=sprite.getTexture();
        setCoordinate(coordinate);
    }

    public void setCoordinate(Point coordinate) {
        this.coordinate = coordinate;
    }
    public void render(Graphics graphics)
    {
        try
        {
            graphics.drawImage(this.texture,coordinate.getX(),coordinate.getY(),null);

        }catch(NullPointerException e)
        {
            graphics.drawImage(Sprite.defaultSprite.getTexture(),coordinate.getX(),coordinate.getY(),null);
        }
    }
}
