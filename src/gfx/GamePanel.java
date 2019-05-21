package gfx;


import logic.*;


import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.image.BufferStrategy;

public class GamePanel extends Canvas implements Runnable
{
    private Thread thread;
    private int width;
    private int height;
    private boolean running=false;
    private Graphics graphics;

    public static State state=State.mainMenuState;


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
        final double timeF = 1000000000 / 60;
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
        state.update();
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
        graphics.setColor(new Color(0x3C86FF));
        graphics.fillRect(0,0,width,height);

        //draw here


        state.render(graphics);


        //end drawing
        bs.show();
        graphics.dispose();
    }


    public void getInput()
    {
        GamePanel.keyManager.update();
    }
    public static void setState(State newState)
    {
        state=newState;
    }


}