package logic.states;

import gfx.GamePanel;
import logic.Coordinate;
import logic.entities.creatures.players.ArcherPlayer;
import logic.entities.Entity;
import logic.map.Map;
import logic.map.RandomMap;

import java.awt.Graphics;

public class GameState extends State {

    private Entity player;
    private Map map;

    public GameState()
    {
        map=new RandomMap(13,10);
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
        map.render(graphics);
        player.render(graphics);
    }

    @Override
    public void actionOnPauseKeyPress() {
        GamePanel.addState(State.pauseMenu);
    }
}
