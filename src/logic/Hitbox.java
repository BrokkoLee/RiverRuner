package logic;

import logic.entities.Entity;

import java.awt.Graphics;
import java.awt.Color;

public class Hitbox {

    public static  Hitbox nullHitbox=new Hitbox(new Coordinate(0,0),0,0);
    private Coordinate position;
    private int width;
    private int height;
    private int xOffset;
    private int yOffset;
    private Coordinate offsetRelativeToEntityPosition;


    /*private Entity entity;
    private Coordinate offsetRelativeToEntity;
    private int width2;
    private int height2;

    public Hitbox(Entity entity,Coordinate offsetRelativeToEntity, int width2, int height2)
    {
        this.entity
    }*/

    public Hitbox(Coordinate offsetRelativeToEntityPosition,int width, int height) {
        this.position=new Coordinate(0,0);
        this.offsetRelativeToEntityPosition=offsetRelativeToEntityPosition;
        this.width=width;
        this.height=height;
    }

    public void update(Entity entity)
    {
        setPosition(new Coordinate(entity.getPosition().getX(),entity.getPosition().getY()));
        setxOffset(entity.getxOffset());
        setyOffset(entity.getyOffset());
    }

    public void render(Graphics graphics) {
        graphics.setColor(Color.RED);
        graphics.fillRect(getPosition().getX()+getxOffset() + offsetRelativeToEntityPosition.getX(), getPosition().getY()+getyOffset() + offsetRelativeToEntityPosition.getY(), getWidth(), getHeight());
    }

    public boolean isCollidingWith(Entity entity)
    {
        if(entity.getPosition().getX()+entity.getxOffset()+entity.getWidth()>getPosition().getX()+offsetRelativeToEntityPosition.getX()&&
            entity.getPosition().getX()+entity.getxOffset()<=getPosition().getX()+offsetRelativeToEntityPosition.getX()+getWidth()&&
            entity.getPosition().getY()+entity.getyOffset()+entity.getHeight()>getPosition().getY()+offsetRelativeToEntityPosition.getY() &&
            entity.getPosition().getY()+entity.getyOffset()<=getPosition().getY()+offsetRelativeToEntityPosition.getY()+getHeight())
        {
            return true;
        }
        return false;
    }
    /*public Entity getCollidingEntity()
    {

    }*/


    public Coordinate getPosition() {
        return position;
    }

    public void setPosition(Coordinate position) {
        this.position = position;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
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

    public Coordinate getOffsetRelativeToEntityPosition() {
        return offsetRelativeToEntityPosition;
    }
}
