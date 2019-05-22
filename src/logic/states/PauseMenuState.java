package logic.states;

import gfx.Window;
import gfx.buttons.Button;
import gfx.buttons.PlayButton;
import logic.Coordinate;

import java.awt.Color;
import java.awt.Graphics;

public class PauseMenuState extends State {
    Button returnToGameButton;
    public PauseMenuState()
    {
        returnToGameButton=new PlayButton(new Coordinate((Window.width/2)-(200/2),(Window.height/2)-(50/2)),200,50);
    }
    @Override
    public void update() {
        returnToGameButton.update();
        returnToGameButton.playActionOnClick();
    }

    @Override
    public void render(Graphics graphics) {
        graphics.setColor(new Color(0xFEFF39));
        graphics.fillRect(0,0,Window.width,Window.height);

        returnToGameButton.render(graphics);
    }

}
