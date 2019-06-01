package logic.states;

import gfx.GamePanel;
import logic.Coordinate;
import logic.entities.creatures.players.ArcherPlayer;
import logic.entities.Entity;
import java.awt.Graphics;

public class GameState extends State {

    Entity player;

    public GameState()
    {
        player=new ArcherPlayer(new Coordinate(50,50));
    }

    @Override
    public void update() {
        player.update();
        managePauseKey();
    }

    @Override
    public void render(Graphics graphics) {
        setBackground(graphics);
        player.render(graphics);
    }

    @Override
    public void actionOnPauseKeyPress() {
        GamePanel.addState(State.pauseMenu);
    }
}
