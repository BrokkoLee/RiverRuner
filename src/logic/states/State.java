package logic.states;

import gfx.GamePanel;

import java.awt.Graphics;
import java.awt.Color;
import gfx.Window;
import gfx.buttons.Button;

public abstract class State {
    public static MainMenuState mainMenu = new MainMenuState();
    public static GameState game = new GameState();
    public static PauseMenuState pauseMenu = new PauseMenuState();
    public static SettingsState settings=new SettingsState();

    protected Button[] buttons;
    protected static final int DEFAULT_BUTTON_SPACING=5;

    public State() {
        buttons=new Button[0];
    }

    public abstract void update();

    public abstract void render(Graphics graphics);

    public void managePauseKey(State pauseKeySetState) {
        if (GamePanel.keyManager.pauseKey) {
            GamePanel.addState(pauseKeySetState);
        }
        GamePanel.keyManager.pauseKey = false;
    }

    public void setBackground(Graphics graphics)
    {
        graphics.setColor(new Color(0x5C5C5C));
        graphics.fillRect(0,0,Window.width,Window.height);
    }
    public void updateButtons() {
        for (int i=0;i<buttons.length;i++)
        {
            buttons[i].update();
        }
    }
    public void renderButtons(Graphics graphics)
    {
        for (int i=0;i<buttons.length;i++)
        {
            buttons[i].render(graphics);
        }
    }
}
