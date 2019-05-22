package logic.input;

import javax.swing.SwingUtilities;
import javax.swing.event.MouseInputListener;
import java.awt.Point;
import java.awt.MouseInfo;
import java.awt.event.MouseEvent;

public class MouseManager implements MouseInputListener {

    private boolean[] buttons;
    public boolean left;
    public boolean right;
    public Point coordinate;
    public boolean isClicked=false;

    public MouseManager()
    {
        buttons=new boolean[10];
        coordinate=new Point();
    }
    public void update()
    {
        left=buttons[MouseEvent.BUTTON1];
        right=buttons[MouseEvent.BUTTON2];
    }
    @Override
    public void mouseMoved(MouseEvent e) {
        coordinate= MouseInfo.getPointerInfo().getLocation();
        SwingUtilities.convertPointFromScreen(coordinate,e.getComponent());
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
    public void mouseClicked(MouseEvent e) {
        isClicked=true;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

}
