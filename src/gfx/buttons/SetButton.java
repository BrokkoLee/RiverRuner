package gfx.buttons;

import logic.Coordinate;

public abstract class SetButton extends Button {
    public SetButton(Coordinate buttonPosition, int width, int height, String text)
    {
        super(buttonPosition,width,height,Button.DEFAULT_PRIMARY_BUTTON_COLOR,Button.DEFAULT_SECONDARY_BUTTON_COLOR,text,Button.DEFAULT_TEXT_COLOR);
    }

    @Override
    void actionOnClick()
    {
        set();
    }
    abstract void set();
}
