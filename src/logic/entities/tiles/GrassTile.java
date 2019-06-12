package logic.entities.tiles;

import gfx.sprites.Sprite;

public class GrassTile extends Tile
{
    public GrassTile()
    {
        super(Sprite.GrassSprite);
    }


    @Override
    public boolean isSolid() {
        return false;
    }
}
