package gfx;


import logic.Entity;
import logic.KeyManager;
import logic.Player;
import logic.Coordinate;


import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.image.BufferStrategy;

public class GamePanel extends Canvas implements Runnable
{
    private Thread thread;
    public static int width;
    public static int height;
    private boolean running=false;
    private Graphics graphics;

    Entity player=new Player(new Coordinate(50,50));
    Entity player2=new Player(new Coordinate(150,150));
    public static KeyManager keyManager=new KeyManager();

    public GamePanel(int width, int height)
    {
        this.width=width;
        this.height=height;
        setPreferredSize(new Dimension(width,height));
        setFocusable(true);
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
        final double timeU = 1000000000 / 60;
        final double timeF = 1000000000 /60;
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
        this.addKeyListener(keyManager);
        requestFocus();
    }

    public void update()
    {
        player.update();
        player2.update();
    }

    public void render()
    {

        graphics=this.getGraphics();
        BufferStrategy bs=getBufferStrategy();
        if (bs==null)
        {
            createBufferStrategy(3);
            return;
        }
        graphics=bs.getDrawGraphics();
        graphics.setColor(new Color(0x5C5C5C));
        graphics.fillRect(0,0,width,height);

        //draw here


        draw();


        //end drawing
        bs.show();
        graphics.dispose();
    }

    public void draw()
    {
        player.render(graphics);
        player2.render(graphics);
    }

    public void getInput()
    {

    }



}