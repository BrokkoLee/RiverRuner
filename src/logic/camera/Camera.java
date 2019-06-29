package logic.camera;

import gfx.Window;
import logic.entities.tiles.Tile;
import logic.map.Map;
import logic.entities.Entity;

import java.util.ArrayList;

public class Camera {
    private Map map;
    private Entity centerEntity;
    private ArrayList<Entity> entityList;
    private int xOffset=0;
    private int yOffset=0;
    public Camera(ArrayList<Entity> entityList,int entityIndex, Map map)
    {
        this.map=map;
        this.entityList=entityList;
        setCenterEntity(entityList.get(entityIndex));
    }

    public Camera(ArrayList<Entity> entityList,Entity entity, Map map)
    {
        this.map=map;
        this.entityList=entityList;
        setCenterEntity(entity);
    }
    public void setCenterEntity(Entity entity)
    {
        this.centerEntity=entity;
    }
    public void setCenterEntity(int entityIndex)
    {
        this.centerEntity=entityList.get(entityIndex);
    }
    public void update() {
        manageOffsets();
        map.setMapOffset(xOffset,yOffset);
        for (int i=0;i<entityList.size();i++)
        {
            entityList.get(i).setOffset(xOffset,yOffset);
        }
    }

    public void manageOffsets()
    {
        if(!isBindingLeft() && !isBindingRight())
            xOffset=-(centerEntity.getHitbox().getPosition().getX()+centerEntity.getHitbox().getWidth()/2-Window.width/2);
        if(isBindingLeft())
            xOffset=0;
        if (isBindingRight())
            xOffset=-(map.getWIDTH()*Tile.DEFAULT_TILE_WIDTH-Window.width);
        if (!isBindingUp() && !isBindingDown())
            yOffset=-(centerEntity.getHitbox().getPosition().getY()+centerEntity.getHitbox().getHeight()/2-Window.height/2);
        if (isBindingUp())
            yOffset=0;
        if (isBindingDown())
            yOffset=-(map.getHEIGHT()*Tile.DEFAULT_TILE_HEIGHT-Window.height);

    }

    public boolean isBindingLeft()
    {
        if (centerEntity.getHitbox().getPosition().getX()+centerEntity.getHitbox().getWidth()/2<Window.width/2)
        {
            return true;
        }
        return false;
    }
    public boolean isBindingRight()
    {
        if(centerEntity.getHitbox().getPosition().getX()+centerEntity.getHitbox().getWidth()/2>map.getWIDTH()*Tile.DEFAULT_TILE_WIDTH-Window.width/2)
            return true;
        return false;
    }
    public boolean isBindingUp()
    {
        if(centerEntity.getHitbox().getPosition().getY()+centerEntity.getHitbox().getHeight()/2<Window.height/2)
            return true;
        return false;
    }
    public boolean isBindingDown()
    {
        if (centerEntity.getHitbox().getPosition().getY()+centerEntity.getHitbox().getHeight()/2>map.getHEIGHT()*Tile.DEFAULT_TILE_HEIGHT-Window.height/2)
            return true;
        return false;
    }
}
