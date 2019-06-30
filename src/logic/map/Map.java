package logic.map;

import logic.entities.Entity;
import logic.entities.tiles.Tile;

import java.awt.Graphics;


public abstract class Map {
    public static Map gameMap;

    protected final int WIDTH;
    protected final int HEIGHT;
    protected Tile tiles[];
    protected int xOffset=0;
    protected int yOffset=0;

    public Map(int width, int height)
    {
        this.WIDTH=width;
        this.HEIGHT=height;
        Tile.initializeTiles();
        tiles=new Tile[WIDTH*HEIGHT];
        initialize();
    }

    public void loadMapData()
    {
        loadTiles();
        loadProps();
    }

    public void initialize()
    {
        loadMapData();
    }

    public abstract void loadTiles();
    public abstract void loadProps();

    public void setTilesOffset ()
    {
        for (int i = 0; i< tiles.length; i++)
        {
            tiles[i].setxOffset(this.xOffset);
            tiles[i].setyOffset(this.yOffset);
        }
    }
    public void setPropsPositions()
    {

    }
    public void renderProps(Graphics graphics)
    {

    }

    public void update()
    {
        setTilesOffset();
    }

    public void renderTiles(Graphics graphics)
    {
        for (int i = 0; i< tiles.length; i++)
        {
            if (tiles[i].isOnScreen())
            {
                tiles[i].render(graphics);
            }
        }
    }

    public void render(Graphics graphics)
    {
        renderTiles(graphics);
        renderProps(graphics);
    }

    public Tile getTile(int x, int y) {
        return tiles[y*WIDTH+x];
    }

    public void setTilesXOffset(int xOffset)
    {
        for (int i=0;i<tiles.length;i++)
        {
            tiles[i].setxOffset(xOffset);
        }
    }
    public void setTilesYOffset(int yOffset)
    {
        for (int i=0;i<tiles.length;i++)
        {
            tiles[i].setyOffset(yOffset);
        }
    }
    public boolean isBindingToLeftSideOfTheMap(Entity entity)
    {
        if(entity.getHitbox().getPosition().getX()<=0)
            return true;
        return false;
    }
    public boolean isBindingToRightSideOfTheMap(Entity entity)
    {
        if(entity.getHitbox().getPosition().getX()+entity.getHitbox().getWidth()>=Tile.DEFAULT_TILE_WIDTH*WIDTH)
            return true;
        return false;
    }
    public boolean isBindingToTopSideOfTheMap(Entity entity)
    {
        if(entity.getHitbox().getPosition().getY()<=0)
            return true;
        return false;
    }
    public boolean isBindingToBottomSideOfTheMap(Entity entity)
    {
        if(entity.getHitbox().getPosition().getY()+entity.getHitbox().getHeight()>=Tile.DEFAULT_TILE_HEIGHT*HEIGHT)
            return true;
        return false;
    }

    public void preventGettingOutOfTheMap(Entity entity)
    {
        if (isOutOfLeftSideOfTheMap(entity))
            entity.getPosition().setX(-entity.getHitbox().getOffsetRelativeToEntityPosition().getX());
        if (isOutOfRightSideOfTheMap(entity))
            entity.getPosition().setX(Map.gameMap.getWIDTH()*Tile.DEFAULT_TILE_WIDTH-entity.getHitbox().getOffsetRelativeToEntityPosition().getX()-entity.getHitbox().getWidth());
        if (isOutOfTopSideOfTheMap(entity))
            entity.getPosition().setY(-entity.getHitbox().getOffsetRelativeToEntityPosition().getY());
        if (isOutOfBottomSideOfTheMap(entity))
            entity.getPosition().setY(Map.gameMap.getHEIGHT()*Tile.DEFAULT_TILE_HEIGHT-entity.getHitbox().getOffsetRelativeToEntityPosition().getY()-entity.getHitbox().getHeight());
    }
    
    
    public boolean isOutOfLeftSideOfTheMap(Entity entity)
    {
        if(entity.getHitbox().getPosition().getX()<0)
            return true;
        return false;
    }
    public boolean isOutOfRightSideOfTheMap(Entity entity)
    {
        if(entity.getHitbox().getPosition().getX()+entity.getHitbox().getWidth()>Tile.DEFAULT_TILE_WIDTH*WIDTH)
            return true;
        return false;   
    }
    public boolean isOutOfTopSideOfTheMap(Entity entity)
    {
        if(entity.getHitbox().getPosition().getY()<0)
            return true;
        return false;
    }
    public boolean isOutOfBottomSideOfTheMap(Entity entity)
    {
        if(entity.getHitbox().getPosition().getY()+entity.getHitbox().getHeight()>Tile.DEFAULT_TILE_HEIGHT*HEIGHT)
            return true;
        return false;
    }

    public int getWIDTH() {
        return WIDTH;
    }

    public int getHEIGHT() {
        return HEIGHT;
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
    public void setMapOffset(int xOffset, int yOffset)
    {
        this.xOffset=xOffset;
        this.yOffset=yOffset;
    }
}
