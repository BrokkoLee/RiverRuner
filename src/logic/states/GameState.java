package logic.states;

import gfx.GamePanel;
import logic.Coordinate;
import logic.entities.creatures.players.ArcherPlayer;
import logic.entities.Entity;
import gfx.Window;
import java.awt.Graphics;
import java.awt.Color;

public class GameState extends State {

    Entity player;

    public GameState()
    {
        player=new ArcherPlayer(new Coordinate(50,50));
    }

    @Override
    public void update() {
        player.update();
        managePauseKey(State.pauseMenu);
    }

    @Override
    public void render(Graphics graphics) {
        graphics.setColor(new Color(0x5C5C5C));
        graphics.fillRect(0,0,Window.width,Window.height);

        player.render(graphics);
    }
}
