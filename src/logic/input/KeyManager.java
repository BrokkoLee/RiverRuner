package logic.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {
    private boolean[] keys;
    public boolean up;
    public boolean down;
    public boolean left;
    public boolean right;
    public boolean pauseKey;

    public int upKeycode=KeyEvent.VK_W;
    public int downKeycode=KeyEvent.VK_S;
    public int leftKeycode=KeyEvent.VK_A;
    public int rightKeycode=KeyEvent.VK_D;

    public KeyManager() {
        keys = new boolean[66666];
    }

    public void update()
    {
        up=keys[upKeycode];
        down=keys[downKeycode];
        left=keys[leftKeycode];
        right=keys[rightKeycode];
    }
    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()]=true;
        //System.out.println(KeyEvent.getKeyText(e.getKeyCode()));
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()]=false;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        pauseKey=keys[KeyEvent.VK_ESCAPE];
    }

    public void setUpKeycode(int upKeycode) {
        this.upKeycode = upKeycode;
    }

    public void setDownKeycode(int downKeycode) {
        this.downKeycode = downKeycode;
    }

    public void setLeftKeycode(int leftKeycode) {
        this.leftKeycode = leftKeycode;
    }

    public void setRightKeycode(int rightKeycode) {
        this.rightKeycode = rightKeycode;
    }
}
