package gfx.buttons;

import gfx.GamePanel;
import logic.Coordinate;
import logic.states.State;

import java.awt.*;

public class PlayButton extends Button {


    public PlayButton(Coordinate buttonPosition, int width, int height) {
        super(buttonPosition,width,height,Color.BLUE,"Play Game",new Coordinate(buttonPosition.getX()+5,buttonPosition.getY()+height/2),Color.BLACK);
    }

    @Override
    void actionOnClick() {
        GamePanel.setState(State.gameState);
    }
}
