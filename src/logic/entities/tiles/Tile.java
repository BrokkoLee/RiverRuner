package logic.entities.tiles;

import gfx.sprites.Sprite;
import logic.Coordinate;
import logic.Hitbox;
import logic.entities.Entity;

public abstract class Tile extends Entity {
    public static Tile[] tiles;
    public static final int DEFAULT_TILE_WIDTH=64;
    public static final int DEFAULT_TILE_HEIGHT=64;
    public Tile(Sprite texture)
    {
        super(texture,new Coordinate(0,0));
        setHitbox(Hitbox.nullHitbox);
        setWidth(DEFAULT_TILE_WIDTH);
        setHeight(DEFAULT_TILE_HEIGHT);
    }
    @Override
    public void update()
    {

    }
    public abstract boolean isSolid();

    public Coordinate getPosition() {
        return position;
    }

    public void setPosition(Coordinate position) {
        this.position = position;
    }

    public static void initializeTiles()
    {
        tiles=new Tile[]{
                new GrassTile(),
                new StoneTile(),
        };
    }


}
