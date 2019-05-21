package logic;

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
        if (GamePanel.keyManager.startGame)
        {
            GamePanel.setState(State.gameState);
        }
    }

    @Override
    public void render(Graphics graphics) {
        graphics.setColor(new Color(0xF9000D));
        graphics.setFont(new Font("Courier",Font.BOLD | Font.ITALIC,35));
        graphics.drawString("Press SPACE to start",Window.width/2,Window.height/2);
    }
}
