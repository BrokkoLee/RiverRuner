package gfx.buttons;

import gfx.GamePanel;
import logic.Coordinate;

public class BackButton extends Button{
    public BackButton(Coordinate buttonPosition, int width, int height) {
        super(buttonPosition, width, height,Button.DEFAULT_PRIMARY_BUTTON_COLOR,Button.DEFAULT_SECONDARY_BUTTON_COLOR ,"Back", Button.DEFAULT_TEXT_COLOR);
    }

    @Override
    void actionOnClick() {
        GamePanel.removeLastState();
    }
}
