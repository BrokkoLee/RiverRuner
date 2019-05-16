package logic;

import gfx.Sprite;

public abstract class Creature extends Entity{
    public abstract boolean isHostile();

    public Creature(Sprite sprite)
    {
        super(sprite);
    }

}
