package logic.camera;

import gfx.Window;
import logic.entities.tiles.Tile;
import logic.map.Map;
import logic.entities.Entity;

public class Camera {
    private Map map;
    private Entity entity;
    public Camera(Entity entity, Map map)
    {
        this.map=map;
        setCenterEntity(entity);
    }
    public void setCenterEntity(Entity entity)
    {
        this.entity=entity;
    }
    public void alignMapToCenterEntity()
    {
        map.setTilePositions(entity.getxOffset(),entity.getyOffset());
    }
    public void update() {
        entity.update();
        System.out.println(isBindingLeft() +" "+isBindingRight()+" "+isBindingUp()+" "+isBindingDown());
        System.out.println(entity.getxOffset()+" "+entity.getyOffset()+" "+entity.getPosition().getX()+" "+entity.getPosition().getY());


        manageBinding();
        /*alignCenterEntityHorizontally();
        alignCenterEntityVertically();
        moveMapVertically();
        moveMapHorizontally();*/

    }

    public boolean isBindingLeft()
    {
        if (entity.getxOffset()>0)
        {
            return true;
        }
        return false;
    }
    public boolean isBindingRight()
    {
        if(entity.getxOffset()<-(Tile.DEFAULT_TILE_WIDTH*map.getWIDTH()-Window.width))
        {
            return true;
        }
        return false;
    }
    public boolean isBindingUp()
    {
        if (entity.getyOffset()>0)
        {
            return true;
        }
        return false;
    }
    public boolean isBindingDown()
    {
        if (entity.getyOffset()<-(Tile.DEFAULT_TILE_HEIGHT*map.getHEIGHT()-Window.height))
        {
            return true;
        }
        return false;
    }

    public void manageBinding()
    {
        manageHorizontalBinding();
        manageVerticalBinding();
    }


    public void manageHorizontalBinding()
    {
        if(!isBindingLeft() && !isBindingRight())
        {
            alignCenterEntityHorizontally();
            moveMapHorizontally();
        }
        else
        {
            if(isBindingLeft() && entity.getPosition().getX()>(Window.width/2)-(entity.getWidth()/2))
            {
                entity.setxOffset(0);
            }
            if (isBindingRight() && entity.getPosition().getX()<(map.getWIDTH()*Tile.DEFAULT_TILE_WIDTH-(entity.getWidth()/2))-(Window.width/2))
            {
                entity.setxOffset(-((map.getWIDTH()*Tile.DEFAULT_TILE_WIDTH)-Window.width));
            }
        }
    }

    public void manageVerticalBinding()
    {
        if(!isBindingUp() && !isBindingDown())
        {
            alignCenterEntityVertically();
            moveMapVertically();
        }
        else
        {
            if(isBindingUp() && entity.getPosition().getY()>(Window.height/2)-(entity.getHeight()/2))
            {
                entity.setyOffset(0);
            }
            if (isBindingDown() && entity.getPosition().getY()<(map.getHEIGHT()*Tile.DEFAULT_TILE_HEIGHT-(entity.getHeight()/2))-(Window.height/2))
            {
                entity.setyOffset(-((map.getHEIGHT()*Tile.DEFAULT_TILE_HEIGHT)-Window.height));
            }
        }
    }

    public void moveMapHorizontally()
    {
        map.setTilesXOffset(entity.getxOffset());
    }
    public void moveMapVertically()
    {
        map.setTilesYOffset(entity.getyOffset());
    }
    public void alignCenterEntityHorizontally()
    {
        entity.setxOffset((-entity.getPosition().getX())+(Window.width/2)-(entity.getWidth()/2));
    }
    public void alignCenterEntityVertically()
    {
        entity.setyOffset((-entity.getPosition().getY())+(Window.height/2)-(entity.getHeight()/2));
    }
}

/*if (entity.getxOffset()<=-(map.getWIDTH()*Tile.DEFAULT_TILE_WIDTH-Window.width))
        {
            alignCenterEntityHorizontally();
            moveMapHorizontally();
        }
        else if(entity.getPosition().getX()<Tile.DEFAULT_TILE_WIDTH*map.getWIDTH())
        {
            entity.setxOffset(0);
        }
*/
