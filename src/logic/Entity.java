package logic;

import gfx.Sprite;

import java.awt.image.BufferedImage;

public abstract class Entity {
    private BufferedImage texture;

    public Entity(Sprite sprite)
    {
        texture=sprite.getTexture();
    }
}
