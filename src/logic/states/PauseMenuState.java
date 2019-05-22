package logic.states;

import gfx.Window;
import gfx.buttons.Button;
import gfx.buttons.PlayButton;
import gfx.buttons.ReturnToMainMenuButton;
import logic.Coordinate;

import java.awt.Color;
import java.awt.Graphics;

public class PauseMenuState extends State {

    private Button returnToGameButton;
    private Button returnToMainMenuButton;

    public PauseMenuState()
    {
        returnToGameButton=new PlayButton(new Coordinate((Window.width/2)-(200/2),100),200,50);
        returnToMainMenuButton=new ReturnToMainMenuButton(new Coordinate((Window.width/2)-(200/2),155),200,50);
    }
    @Override
    public void update() {
        updateButtons();
    }

    @Override
    public void render(Graphics graphics) {
        graphics.setColor(new Color(0xFEFF39));
        graphics.fillRect(0,0,Window.width,Window.height);

        returnToGameButton.render(graphics);
        returnToMainMenuButton.render(graphics);
    }

    public void updateButtons() {
        returnToGameButton.update();
        returnToMainMenuButton.update();
    }
}
