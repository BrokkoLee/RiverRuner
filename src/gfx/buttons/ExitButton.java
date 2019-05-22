package gfx.buttons;

import logic.Coordinate;

import java.awt.Color;

public class ExitButton extends Button{

    public ExitButton(Coordinate buttonPosition,int width,int height)
    {
        super(buttonPosition,width,height,Color.RED,"Exit game",Color.BLACK);
    }
    @Override
    void actionOnClick() {
        System.exit(0);
    }
}
