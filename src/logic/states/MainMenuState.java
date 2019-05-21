package logic.states;

import java.awt.Graphics;
import java.awt.Color;

import gfx.GamePanel;
import gfx.Window;
import gfx.buttons.Button;
import gfx.buttons.PlayButton;
import logic.Coordinate;

public class MainMenuState extends State{

    Button playButton;

    public MainMenuState()
    {
        playButton=new PlayButton(new Coordinate(100,100),100,50);
    }

    @Override
    public void update() {
        manageStateSwitching();
        playButton.playActionOnClick();
    }

    @Override
    public void render(Graphics graphics) {
        graphics.setColor(new Color(0x3C86FF));
        graphics.fillRect(0,0,Window.width,Window.height);

        /*graphics.setColor(new Color(0xF9000D));
        graphics.setFont(new Font("Courier",Font.BOLD | Font.ITALIC,35));
        graphics.drawString("Press LEFT MOUSE BUTTON to start",5,Window.height/2);*/
        playButton.render(graphics);
    }

    @Override
    public void manageStateSwitching() {
        playButton.update();
    }
}
