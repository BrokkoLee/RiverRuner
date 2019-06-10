package logic.map;

import logic.Coordinate;
import logic.entities.tiles.GrassTile;
import logic.entities.tiles.NullTile;
import logic.entities.tiles.StoneTile;
import logic.entities.tiles.Tile;

import java.util.Random;



public class RandomMap extends Map {

    public RandomMap(int width, int height)
    {
        super(width,height);
    }

    @Override
    public void loadTiles() {
        Random random = new Random(System.currentTimeMillis());

        for (int y = 0; y < HEIGHT; y++)
        {
            for (int x=0;x<WIDTH;x++)
            {
                tiles[y*WIDTH+x]=getTile(random.nextInt(Tile.tiles.length));
                tiles[y*WIDTH+x].setPosition(new Coordinate(x*tiles[y*WIDTH+x].getWidth(),y*tiles[y*WIDTH+x].getHeight()));
            }
        }
    }

    public Tile getTile(int id)
    {
        switch (id)
        {
            case 0:
                return new GrassTile();
            case 1:
                return new StoneTile();
        }
        return new NullTile();
    }

    @Override
    public void loadProps() {

    }
}
