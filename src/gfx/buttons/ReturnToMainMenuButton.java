package gfx.buttons;

import gfx.GamePanel;
import logic.Coordinate;
import logic.states.State;

public class ReturnToMainMenuButton extends Button {

    public ReturnToMainMenuButton(Coordinate buttonPosition, int width, int height)
    {
        super(buttonPosition,width,height,Button.DEFAULT_PRIMARY_BUTTON_COLOR,Button.DEFAULT_SECONDARY_BUTTON_COLOR,"Return to main menu",Button.DEFAULT_TEXT_COLOR);
    }
    @Override
    void actionOnClick() {
        GamePanel.setState(State.mainMenu);
    }
}
