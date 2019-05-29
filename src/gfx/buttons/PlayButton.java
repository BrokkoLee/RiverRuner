package gfx.buttons;

import gfx.GamePanel;
import logic.Coordinate;
import logic.states.State;

public class PlayButton extends Button {


    public PlayButton(Coordinate buttonPosition, int width, int height) {
        super(buttonPosition,width,height,Button.DEFAULT_PRIMARY_BUTTON_COLOR,Button.DEFAULT_SECONDARY_BUTTON_COLOR,"Play Game",Button.DEFAULT_TEXT_COLOR);
    }

    @Override
    void actionOnClick() {
        GamePanel.addState(State.game);
    }
}
