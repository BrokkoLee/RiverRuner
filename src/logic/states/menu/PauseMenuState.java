package logic.states.menu;

import gfx.GamePanel;
import gfx.Window;
import gfx.buttons.*;
import logic.Coordinate;
import logic.states.State;

import java.awt.Graphics;

public class PauseMenuState extends State {


    public PauseMenuState()
    {
        buttons= new Button[]{
                new ResumeButton(new Coordinate((Window.width / 2) - (Button.DEFAULT_WIDTH / 2), 100), Button.DEFAULT_WIDTH, Button.DEFAULT_HEIGHT),
                new SettingsButton(new Coordinate((Window.width / 2) - (Button.DEFAULT_WIDTH / 2), 100+(Button.DEFAULT_HEIGHT+State.DEFAULT_BUTTON_SPACING)),Button.DEFAULT_WIDTH,Button.DEFAULT_HEIGHT),
                new ReturnToMainMenuButton(new Coordinate((Window.width / 2) - (Button.DEFAULT_WIDTH ), 100+(Button.DEFAULT_HEIGHT+State.DEFAULT_BUTTON_SPACING)*2), Button.DEFAULT_WIDTH*2, Button.DEFAULT_HEIGHT)
        };
    }
    @Override
    public void update() {
        updateButtons();
        managePauseKey();
    }

    @Override
    public void render(Graphics graphics) {
        State.game.render(graphics);
        renderStateTitle(graphics,"Paused");
        renderButtons(graphics);
    }

    @Override
    public void actionOnPauseKeyPress() {
        GamePanel.removeLastState();
    }

}
