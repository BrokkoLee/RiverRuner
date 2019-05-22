package gfx.buttons;

import gfx.GamePanel;
import logic.Coordinate;
import logic.states.State;

import java.awt.Color;

public class PlayButton extends Button {


    public PlayButton(Coordinate buttonPosition, int width, int height) {
        super(buttonPosition,width,height,new Color(0x8F503F),"Play Game",Color.BLACK);
    }

    @Override
    void actionOnClick() {
        GamePanel.setState(State.game);
    }
}
