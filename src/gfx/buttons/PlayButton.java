package gfx.buttons;

import gfx.GamePanel;
import logic.Coordinate;
import logic.states.State;

public class PlayButton extends SetStateButton {


    public PlayButton(Coordinate buttonPosition, int width, int height) {
        super(buttonPosition,width,height,"Play Game",State.game);
    }

    @Override
    void set() {
        GamePanel.setState(State.game);
    }
}
