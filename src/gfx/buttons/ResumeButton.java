package gfx.buttons;

import gfx.GamePanel;
import logic.Coordinate;

public class ResumeButton extends Button{
    public ResumeButton(Coordinate buttonPosition, int width, int height) {
        super(buttonPosition, width, height,Button.DEFAULT_PRIMARY_BUTTON_COLOR,Button.DEFAULT_SECONDARY_BUTTON_COLOR ,"Resume game", Button.DEFAULT_TEXT_COLOR);
    }

    @Override
    void actionOnClick() {
        GamePanel.removeLastState();
    }
}
