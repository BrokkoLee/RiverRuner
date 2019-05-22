package gfx.buttons;

import logic.Coordinate;
import logic.states.State;

public class BackButton extends SetStateButton{

    public BackButton(Coordinate buttonPosition, int width, int height, State state) {
        super(buttonPosition, width, height, "Back", state);
    }
}
