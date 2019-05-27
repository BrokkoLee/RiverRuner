package logic.states;

import gfx.Window;
import gfx.buttons.BackButton;
import gfx.buttons.Button;
import logic.Coordinate;

import java.awt.Graphics;

public class SettingsState extends State{

    public SettingsState()
    {
        buttons=new Button[]{
                new BackButton(new Coordinate((Window.width/2)-(Button.DEFAULT_WIDTH/2),100),Button.DEFAULT_WIDTH,Button.DEFAULT_HEIGHT),
        };
    }


    @Override
    public void update() {
        updateButtons();
    }

    @Override
    public void render(Graphics graphics) {
        setBackground(graphics);
        renderButtons(graphics);
    }

}
