package gfx.buttons;

import gfx.GamePanel;
import logic.Coordinate;
import logic.states.State;

import java.awt.Color;

public class ReturnToMainMenuButton extends Button {

    public ReturnToMainMenuButton(Coordinate buttonPosition, int width, int height)
    {
        super(buttonPosition,width,height,Color.YELLOW,"Return to main menu",Color.BLACK);
    }
    @Override
    void actionOnClick() {
        GamePanel.setState(State.mainMenu);
    }
}
