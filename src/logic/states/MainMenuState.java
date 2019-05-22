package logic.states;

import java.awt.Graphics;
import java.awt.Color;

import gfx.Window;
import gfx.buttons.Button;
import gfx.buttons.ExitButton;
import gfx.buttons.PlayButton;
import logic.Coordinate;

public class MainMenuState extends State{

    private Button playButton;
    private Button exitButton;

    public MainMenuState()
    {
        playButton=new PlayButton(new Coordinate((Window.width/2)-(100/2),100),100,50);
        exitButton=new ExitButton(new Coordinate((Window.width/2)-(100/2),155),100,50);
    }

    @Override
    public void update() {
        updateButtons();
    }

    @Override
    public void render(Graphics graphics) {
        graphics.setColor(new Color(0x3C86FF));
        graphics.fillRect(0,0,Window.width,Window.height);
        playButton.render(graphics);
        exitButton.render(graphics);
    }
    public void updateButtons()
    {
        playButton.update();
        exitButton.update();
    }

}
