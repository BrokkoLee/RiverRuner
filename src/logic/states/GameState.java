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
    private static Map map;
    private Camera camera;

    public GameState()
    {
        map=new RandomMap(100,100);
        player=new ArcherPlayer(new Coordinate(350,250));
        camera=new Camera(player,map);
    }

    @Override
    public void update() {
        System.out.println(map.isOutOfMap(player));
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

    public static Map getMap() {
        return map;
    }
}
