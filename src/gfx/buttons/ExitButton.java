package gfx.buttons;

import logic.Coordinate;

public class ExitButton extends Button{

    public ExitButton(Coordinate buttonPosition,int width,int height)
    {
        super(buttonPosition,width,height,Button.DEFAULT_PRIMARY_BUTTON_COLOR,Button.DEFAULT_SECONDARY_BUTTON_COLOR,"Exit game",Button.DEFAULT_TEXT_COLOR);
    }
    @Override
    void actionOnClick() {
        System.exit(0);
    }
}
