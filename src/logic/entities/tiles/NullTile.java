package logic.entities.tiles;

import gfx.sprites.Sprite;

public class NullTile extends Tile{
    public NullTile()
    {
        super(Sprite.DEFAULT_TEXTURE_SIZE,Sprite.DEFAULT_TEXTURE_SIZE,Sprite.defaultSprite);
    }
    @Override
    public boolean isSolid() {
        return false;
    }
}
