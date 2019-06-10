package logic.entities.tiles;

import gfx.sprites.Sprite;

public class GrassTile extends Tile
{
    public GrassTile()
    {
        super(Sprite.DEFAULT_TEXTURE_SIZE,Sprite.DEFAULT_TEXTURE_SIZE,Sprite.GrassSprite);
    }


    @Override
    public boolean isSolid() {
        return false;
    }
}
