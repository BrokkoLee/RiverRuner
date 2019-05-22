package gfx.buttons;

import gfx.GamePanel;
import logic.Coordinate;
import logic.states.State;

public class SettingsButton extends Button{

    public SettingsButton(Coordinate buttonPosition,int width, int height)
    {
        super(buttonPosition,width,height,Button.DEFAULT_PRIMARY_BUTTON_COLOR,Button.DEFAULT_SECONDARY_BUTTON_COLOR,"Settings",Button.DEFAULT_TEXT_COLOR);
    }
    @Override
    void actionOnClick() {
        GamePanel.setState(State.settings);
    }
}
