package logic.states;

import gfx.GamePanel;

import java.awt.Graphics;
import java.awt.FontMetrics;
import java.awt.Font;
import java.awt.Color;

import gfx.Window;
import gfx.buttons.Button;
import logic.states.menu.MainMenuState;
import logic.states.menu.PauseMenuState;
import logic.states.settings.ControlsSettingsState;
import logic.states.settings.SettingsState;

public abstract class State {
    private static final Font stateFont=new Font("StateFont",Font.BOLD,16);
    protected static FontMetrics fontMetrics;

    public static MainMenuState mainMenu = new MainMenuState();
    public static GameState game = new GameState();
    public static PauseMenuState pauseMenu = new PauseMenuState();
    public static SettingsState settings=new SettingsState();
    public static ControlsSettingsState controls=new ControlsSettingsState();

    protected Button[] buttons;
    protected static final int DEFAULT_BUTTON_SPACING=5;

    public State() {
        buttons=new Button[0];
    }

    public abstract void update();

    public abstract void render(Graphics graphics);

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
    public void managePauseKey()
    {
        if (GamePanel.keyManager.pauseKey) {
            actionOnPauseKeyPress();
        }
        GamePanel.keyManager.pauseKey = false;
    }
    public abstract void actionOnPauseKeyPress();
    public void renderStateTitle(Graphics graphics,String title)
    {
        graphics.setColor(Color.BLACK);
        graphics.setFont(stateFont);
        fontMetrics=graphics.getFontMetrics();
        graphics.drawString(title,(Window.width/2)-(fontMetrics.stringWidth(title)/2),95);
    }
}
