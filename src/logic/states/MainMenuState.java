package logic.states;

import java.awt.Graphics;
import java.awt.Color;

import gfx.Window;
import gfx.buttons.Button;
import gfx.buttons.PlayButton;
import logic.Coordinate;

public class MainMenuState extends State{

    private Button playButton;

    public MainMenuState()
    {
        playButton=new PlayButton(new Coordinate((Window.width/2)-(100/2),(Window.height/2)-(50/2)),100,50);
    }

    @Override
    public void update() {
        playButton.update();
        playButton.playActionOnClick();
    }

    @Override
    public void render(Graphics graphics) {
        graphics.setColor(new Color(0x3C86FF));
        graphics.fillRect(0,0,Window.width,Window.height);
        playButton.render(graphics);
    }

}
