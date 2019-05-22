package logic.states;

import gfx.GamePanel;

import java.awt.Graphics;

public abstract class State {
    public static MainMenuState mainMenu =new MainMenuState();
    public static GameState game = new GameState();
    public static PauseMenuState pauseMenu=new PauseMenuState();

    public State()
    {

    }

    public abstract void update();
    public abstract void render(Graphics graphics);
    public void managePauseKey(State pauseKeySetState) {
        if(GamePanel.keyManager.pauseKey)
        {
            GamePanel.setState(pauseKeySetState);
            GamePanel.keyManager.pauseKey=false;
        }
    }
}
