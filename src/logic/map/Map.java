package logic.map;

import logic.Coordinate;
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
            tiles[i].setPosition(new Coordinate(tiles[i].getPosition().getX()+xOffset, tiles[i].getPosition().getY()+yOffset));
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
            tiles[i].render(graphics);
        }
    }

    public void render(Graphics graphics)
    {
        renderTiles(graphics);
        renderProps(graphics);
    }
}
