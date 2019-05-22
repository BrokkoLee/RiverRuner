package logic.states;

import gfx.Window;
import gfx.buttons.Button;
import gfx.buttons.PlayButton;
import gfx.buttons.ReturnToMainMenuButton;
import gfx.buttons.SettingsButton;
import logic.Coordinate;

import java.awt.Graphics;

public class PauseMenuState extends State {


    public PauseMenuState()
    {
        buttons= new Button[]{
                new PlayButton(new Coordinate((Window.width / 2) - (Button.DEFAULT_WIDTH / 2), 100), Button.DEFAULT_WIDTH, Button.DEFAULT_HEIGHT),
                new SettingsButton(new Coordinate((Window.width / 2) - (Button.DEFAULT_WIDTH / 2), 100+(Button.DEFAULT_HEIGHT+State.DEFAULT_BUTTON_SPACING)),Button.DEFAULT_WIDTH,Button.DEFAULT_HEIGHT),
                new ReturnToMainMenuButton(new Coordinate((Window.width / 2) - (Button.DEFAULT_WIDTH ), 100+(Button.DEFAULT_HEIGHT+State.DEFAULT_BUTTON_SPACING)*2), Button.DEFAULT_WIDTH*2, Button.DEFAULT_HEIGHT)
        };
    }
    @Override
    public void update() {
        updateButtons();
        managePauseKey(State.game);
        updateButtons();
    }

    @Override
    public void render(Graphics graphics) {
        State.game.render(graphics);
        renderButtons(graphics);
    }

}
