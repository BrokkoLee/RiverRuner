package logic.map;

import logic.entities.Entity;
import logic.entities.tiles.Tile;

import java.awt.Graphics;


public abstract class Map {
    protected final int WIDTH;
    protected final int HEIGHT;
    protected Tile tiles[];
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

    public void setTilePositions(int xOffset,int yOffset)
    {
        for (int i = 0; i< tiles.length; i++)
        {
            tiles[i].setxOffset(xOffset);
            tiles[i].setyOffset(yOffset);
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

    public boolean isOutOfMap(Entity entity)
    {
        if(entity.getHitbox().getPosition().getX()+entity.getHitbox().getxOffset()+entity.getHitbox().getOffsetRelativeToEntityPosition().getX()>=0 &&
           entity.getHitbox().getPosition().getX()+entity.getHitbox().getxOffset()+entity.getHitbox().getOffsetRelativeToEntityPosition().getX()+entity.getHitbox().getWidth()<=Tile.DEFAULT_TILE_WIDTH*WIDTH &&
           entity.getHitbox().getPosition().getY()+entity.getHitbox().getyOffset()+entity.getHitbox().getOffsetRelativeToEntityPosition().getY()>=0 &&
           entity.getHitbox().getPosition().getY()+entity.getHitbox().getyOffset()+entity.getHitbox().getOffsetRelativeToEntityPosition().getY()+entity.getHitbox().getHeight()<=Tile.DEFAULT_TILE_HEIGHT*HEIGHT)
        {
            return false;
        }
        return true;
    }

    public int getWIDTH() {
        return WIDTH;
    }

    public int getHEIGHT() {
        return HEIGHT;
    }
}
