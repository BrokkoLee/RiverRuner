package logic.entities;

import gfx.Window;
import gfx.sprites.Sprite;
import logic.Coordinate;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public abstract class Entity {
    private BufferedImage texture=Sprite.defaultSprite.getTexture();
    protected Coordinate position =new Coordinate(0,0);
    private int width=0;
    private int height=0;
    public abstract void update();
    private int xOffset;
    private int yOffset;
    public Entity(Sprite sprite, Coordinate position)
    {
        if (sprite!=null)
        {
            setTexture(sprite);
        }
        setPosition(position);
    }
    public Entity(Coordinate position)
    {
        setPosition(position);
    }

    public void setTexture(Sprite sprite)
    {
        this.texture=sprite.getTexture();
    }
    public void setPosition(Coordinate position) {
        this.position = position;
    }
    public void render(Graphics graphics) {
        if (isOnScreen())
            graphics.drawImage(texture, position.getX()+xOffset, position.getY()+yOffset, width, height, null);
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

    public int getxOffset() {
        return xOffset;
    }

    public void setxOffset(int xOffset) {
        this.xOffset = xOffset;
    }

    public int getyOffset() {
        return yOffset;
    }

    public void setyOffset(int yOffset) {
        this.yOffset = yOffset;
    }

    public Coordinate getPosition() {
        return position;
    }
    public boolean isOnScreen()
    {
        if(getPosition().getX()+xOffset>=-getWidth() && getPosition().getX()+xOffset<Window.width &&
                getPosition().getY()+yOffset>=-getHeight() && getPosition().getY()+yOffset< Window.height)
        {
            return true;
        }
        else return false;
    }

    public BufferedImage getTexture() {
        return texture;
    }
}
