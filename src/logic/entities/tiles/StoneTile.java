package logic.entities.tiles;

import gfx.sprites.Sprite;

public class StoneTile extends Tile{

    public StoneTile()
    {
        super(Sprite.MCStoneSprite);
    }
    @Override
    public boolean isSolid() {
        return false;
    }
}
