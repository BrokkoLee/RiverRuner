package logic.states;

import java.awt.Graphics;
import java.awt.Font;
import java.awt.Color;

import gfx.GamePanel;
import gfx.Window;

public class MainMenuState extends State{

    public MainMenuState()
    {

    }

    @Override
    public void update() {
        manageStateSwitching();
    }

    @Override
    public void render(Graphics graphics) {
        graphics.setColor(new Color(0x3C86FF));
        graphics.fillRect(0,0,Window.width,Window.height);

        graphics.setColor(new Color(0xF9000D));
        graphics.setFont(new Font("Courier",Font.BOLD | Font.ITALIC,35));
        graphics.drawString("Press LEFT MOUSE BUTTON to start",5,Window.height/2);
    }

    @Override
    public void manageStateSwitching() {
        if (GamePanel.mouseManager.left)
        {
            GamePanel.setState(State.gameState);
        }
    }
}
