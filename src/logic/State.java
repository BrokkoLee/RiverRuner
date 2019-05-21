package logic;

import java.awt.Graphics;

public abstract class State {
    public static MainMenuState mainMenuState =new MainMenuState();
    public static GameState gameState= new GameState();

    public State()
    {

    }

    public abstract void update();
    public abstract void render(Graphics graphics);
}
