package gfx;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.awt.Color;

public class GamePanel extends JPanel implements Runnable
{
    private Thread thread;
    private BufferedImage image;
    private Graphics2D graphics2D;
    public static int width;
    public static int height;
    private boolean running=false;

    public GamePanel(int width, int height)
    {
        this.width=width;
        this.height=height;
        setPreferredSize(new Dimension(width,height));
        setFocusable(true);
        requestFocus();
    }

    public void addNotify()
    {
        super.addNotify();
        if(thread==null)
        {
            thread=new Thread(this,"GameThread");
            thread.start();
        }
    }
    public void run() {
        init();
        long initialTime = System.nanoTime();
        final double timeU = 1000000000 / 30;
        final double timeF = 1000000000 / 30;
        double deltaU = 0, deltaF = 0;
        int frames = 0, ticks = 0;
        long timer = System.currentTimeMillis();

        while (running) {

            long currentTime = System.nanoTime();
            deltaU += (currentTime - initialTime) / timeU;
            deltaF += (currentTime - initialTime) / timeF;
            initialTime = currentTime;

            if (deltaU >= 1) {
                getInput();
                update();
                ticks++;
                deltaU--;
            }

            if (deltaF >= 1) {
                draw();
                render();
                frames++;
                deltaF--;
            }

            if (System.currentTimeMillis() - timer > 1000) {
                if (true) {
                    System.out.println(String.format("UPS: %s, FPS: %s", ticks, frames));
                }
                frames = 0;
                ticks = 0;
                timer += 1000;
            }
        }
    }

    public void init()
    {
        running=true;
        image=new BufferedImage(width,height,BufferedImage.TYPE_INT_ARGB);
        graphics2D=(Graphics2D) image.getGraphics();
    }

    public void update()
    {

    }

    public void render()
    {
        if(graphics2D!=null)
        {
            graphics2D.setColor(new Color(0x000000));
            graphics2D.fillRect(0,0,width,height);
        }
    }

    public void draw()
    {
        Graphics graphics=(Graphics) this.getGraphics();
        graphics.drawImage(image,0,0,width,height,null);
        graphics.dispose();
    }

    public void getInput()
    {

    }
}