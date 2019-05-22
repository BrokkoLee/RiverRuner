package logic.states;

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
}
