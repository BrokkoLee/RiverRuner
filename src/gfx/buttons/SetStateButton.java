package gfx.buttons;


import gfx.GamePanel;
import logic.Coordinate;
import logic.states.State;

public class SetStateButton extends SetButton{

    private State state;

    public SetStateButton(Coordinate buttonPosition,int width, int height,String text,State state)
    {
        super(buttonPosition,width,height,text);
        this.state=state;
    }
    @Override
    void set() {
        GamePanel.setState(state);
    }
}
