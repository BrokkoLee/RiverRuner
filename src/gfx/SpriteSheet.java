package gfx;

import javax.imageio.ImageIO;

import logic.Coordinate;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class SpriteSheet {
    private BufferedImage image;

    public SpriteSheet(String path)
    {
        try {
            image=ImageIO.read(SpriteSheet.class.getResource(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public BufferedImage crop(Coordinate start, int size)
    {
        return image.getSubimage(start.getX(),start.getY(),size,size);
    }

}
