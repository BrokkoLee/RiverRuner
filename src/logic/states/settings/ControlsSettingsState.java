package logic.states.settings;

import gfx.GamePanel;
import gfx.Window;
import gfx.buttons.BackButton;
import gfx.buttons.Button;
import logic.Coordinate;
import logic.states.State;

import java.awt.Graphics;

public class ControlsSettingsState extends State {
    public ControlsSettingsState()
    {
        buttons=new Button[]{
                new BackButton(new Coordinate((Window.width/2)-(Button.DEFAULT_WIDTH/2),100),100,50),
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
        renderStateTitle(graphics,"Controls");
        renderButtons(graphics);
    }

    @Override
    public void actionOnPauseKeyPress() {
        GamePanel.removeLastState();
    }
}
