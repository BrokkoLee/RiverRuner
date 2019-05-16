package gfx;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class SpriteSheet {
    private BufferedImage sheet;

    public SpriteSheet(String path)
    {
        try {
            sheet=ImageIO.read(SpriteSheet.class.getResource(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public BufferedImage crop()

}
