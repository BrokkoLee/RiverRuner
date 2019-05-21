package gfx;

import javax.swing.JFrame;

public class Window extends JFrame
{
    public static int width;
    public static int height;


    public Window()
    {
        this.width=800;
        this.height=600;
        initializeWindow();
    }
    public void initializeWindow()
    {
        setTitle("River runner");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setAutoRequestFocus(true);
    }
    public void start()
    {
        add(new GamePanel(width,height));
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}