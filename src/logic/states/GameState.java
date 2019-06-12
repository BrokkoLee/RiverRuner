package logic.states;

import gfx.GamePanel;
import logic.Coordinate;
import logic.camera.Camera;
import logic.entities.creatures.players.ArcherPlayer;
import logic.entities.Entity;
import logic.map.Map;
import logic.map.RandomMap;

import java.awt.Graphics;

public class GameState extends State {

    private Entity player;
    private Map map;
    private Camera camera;

    public GameState()
    {
        map=new RandomMap(30,30);
        player=new ArcherPlayer(new Coordinate(100,100));
        camera=new Camera(player,map);
    }

    @Override
    public void update() {
        camera.update();
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
