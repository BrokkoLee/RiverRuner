package logic.states;

import java.awt.Graphics;

import gfx.Window;
import gfx.buttons.Button;
import gfx.buttons.ExitButton;
import gfx.buttons.PlayButton;
import gfx.buttons.SettingsButton;
import logic.Coordinate;

public class MainMenuState extends State{


    public MainMenuState()
    {
        buttons=new Button[]{
                new PlayButton(new Coordinate((Window.width/2)-(Button.DEFAULT_WIDTH/2),100),Button.DEFAULT_WIDTH,Button.DEFAULT_HEIGHT),
                new SettingsButton(new Coordinate((Window.width/2)-(Button.DEFAULT_WIDTH/2),100+(Button.DEFAULT_HEIGHT+State.DEFAULT_BUTTON_SPACING)),Button.DEFAULT_WIDTH,Button.DEFAULT_HEIGHT),
                new ExitButton(new Coordinate((Window.width/2)-(Button.DEFAULT_WIDTH/2),100+(Button.DEFAULT_HEIGHT+State.DEFAULT_BUTTON_SPACING)*2),Button.DEFAULT_WIDTH,Button.DEFAULT_HEIGHT)
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
