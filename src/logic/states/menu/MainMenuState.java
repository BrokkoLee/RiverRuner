package logic.states.menu;

import java.awt.Graphics;
import java.awt.Font;
import java.awt.Color;

import gfx.GamePanel;
import gfx.Window;
import gfx.buttons.Button;
import gfx.buttons.ExitButton;
import gfx.buttons.PlayButton;
import gfx.buttons.SettingsButton;
import logic.Coordinate;
import logic.states.State;

public class MainMenuState extends State {

    private final Font MainMenuFont=new Font("MainMenuFont",Font.BOLD|Font.ITALIC,64);
    private final String title="River Runner";

    public MainMenuState()
    {
        buttons=new Button[]{
                new PlayButton(new Coordinate((Window.width/2)-(Button.DEFAULT_WIDTH/2),100+(Button.DEFAULT_HEIGHT+State.DEFAULT_BUTTON_SPACING)*0),Button.DEFAULT_WIDTH,Button.DEFAULT_HEIGHT),
                new SettingsButton(new Coordinate((Window.width/2)-(Button.DEFAULT_WIDTH/2),100+(Button.DEFAULT_HEIGHT+State.DEFAULT_BUTTON_SPACING)*1),Button.DEFAULT_WIDTH,Button.DEFAULT_HEIGHT),
                new ExitButton(new Coordinate((Window.width/2)-(Button.DEFAULT_WIDTH/2),100+(Button.DEFAULT_HEIGHT+State.DEFAULT_BUTTON_SPACING)*2),Button.DEFAULT_WIDTH,Button.DEFAULT_HEIGHT)
        };
    }

    @Override
    public void update() {
        updateButtons();
        managePauseKey();
    }

    @Override
    public void render(Graphics graphics) {
        setBackground(graphics);
        renderTitle(graphics);
        renderStateTitle(graphics,"Main Menu");
        renderButtons(graphics);
    }

    @Override
    public void actionOnPauseKeyPress() {
        GamePanel.keyManager.pauseKey = false;
    }

    public void renderTitle(Graphics graphics)
    {
        graphics.setFont(MainMenuFont);
        graphics.setColor(new Color(0xF9000D));
        fontMetrics=graphics.getFontMetrics();
        graphics.drawString(title,(Window.width/2)-(fontMetrics.stringWidth(title)/2),75);
    }

}
