package logic.input;

import java.awt.Point;
import java.awt.MouseInfo;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseManager implements MouseListener {

    private boolean[] buttons;
    public boolean left;
    public boolean right;
    public Point coordinate;

    public MouseManager()
    {
        buttons=new boolean[10];
    }
    public void update()
    {
        coordinate=MouseInfo.getPointerInfo().getLocation();
        left=buttons[MouseEvent.BUTTON1];
        right=buttons[MouseEvent.BUTTON2];
    }
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        buttons[e.getButton()]=true;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        buttons[e.getButton()]=false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
