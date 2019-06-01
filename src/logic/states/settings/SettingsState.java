package logic.states.settings;

import gfx.GamePanel;
import gfx.Window;
import gfx.buttons.BackButton;
import gfx.buttons.Button;
import gfx.buttons.ControlSettingsButton;
import logic.Coordinate;
import logic.states.State;

import java.awt.Graphics;

public class SettingsState extends State {

    public SettingsState()
    {
        buttons=new Button[]{
                new ControlSettingsButton(new Coordinate((Window.width/2)-(Button.DEFAULT_WIDTH/2),100),Button.DEFAULT_WIDTH,Button.DEFAULT_HEIGHT),
                new BackButton(new Coordinate((Window.width/2)-(Button.DEFAULT_WIDTH/2),100+(Button.DEFAULT_HEIGHT+State.DEFAULT_BUTTON_SPACING)),Button.DEFAULT_WIDTH,Button.DEFAULT_HEIGHT),
        };
    }


    @Override
    public void update() {
        updateButtons();
        managePauseKey();
    }

    @Override
    public void render(Graphics graphics) {
        setBackground(graphics);
        renderStateTitle(graphics,"Settings");
        renderButtons(graphics);
    }

    @Override
    public void actionOnPauseKeyPress() {
        GamePanel.removeLastState();
    }

}
