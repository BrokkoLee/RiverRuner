package gfx;


import logic.input.KeyManager;
import logic.input.MouseManager;
import logic.states.State;

import java.text.BreakIterator;
import java.util.ArrayList;


import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class GamePanel extends Canvas implements Runnable
{
    private Thread thread;
    private static boolean running=false;
    private Graphics graphics;

    public static ArrayList<State> states=new ArrayList<>();


    public static KeyManager keyManager=new KeyManager();
    public static MouseManager mouseManager=new MouseManager();

    public GamePanel(int width, int height)
    {
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
        states.add(State.mainMenu);
        running=true;
        this.addKeyListener(keyManager);
        this.addMouseListener(mouseManager);
        this.addMouseMotionListener(mouseManager);
        requestFocus();
    }

    public void update()
    {
        states.get(states.size()-1).update();
        mouseManager.isClicked=false;
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

        //draw here


        states.get(states.size()-1).render(graphics);


        //end drawing
        bs.show();
        graphics.dispose();
    }


    public void getInput()
    {
        keyManager.update();
        mouseManager.update();
    }
    public static void addState(State newState)
    {
        states.add(newState);
    }
    public static void clearStates()
    {
        states.clear();
    }
    public static void removeLastState()
    {
        states.remove(states.size()-1);
    }

    public static void setRunning(boolean running) {
        GamePanel.running = running;
    }
}