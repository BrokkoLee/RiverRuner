package gfx.buttons;

import gfx.GamePanel;
import logic.Coordinate;
import logic.states.State;

public class ReturnToMainMenuButton extends SetStateButton {

    public ReturnToMainMenuButton(Coordinate buttonPosition, int width, int height)
    {
        super(buttonPosition,width,height,"Return to Main Menu",State.mainMenu);
    }
    @Override
    void set() {
        GamePanel.setState(State.mainMenu);
    }
}
