package logic.states;

import gfx.GamePanel;
import logic.Coordinate;
import logic.camera.Camera;
import logic.entities.creatures.players.ArcherPlayer;
import logic.entities.Entity;
import logic.entities.creatures.players.KnightPlayer;
import logic.map.Map;
import logic.map.RandomMap;

import java.awt.Graphics;
import java.util.ArrayList;

public class GameState extends State {

    private ArrayList<Entity> entityList=new ArrayList<>();
    private Camera camera;

    public GameState()
    {
        initEntityList();
        Map.gameMap=new RandomMap(15,17);
        camera=new Camera(entityList,0,getMap());
    }
    private void initEntityList()
    {
        this.entityList.add(new ArcherPlayer(new Coordinate(0,0)));//350,250
    }
    @Override
    public void update() {
        getMap().update();
        updateEntities();
        camera.update();
        managePauseKey();
    }

    @Override
    public void render(Graphics graphics) {
        setBackground(graphics);
        Map.gameMap.render(graphics);
        renderEntities(graphics);
    }

    @Override
    public void actionOnPauseKeyPress() {
        GamePanel.addState(State.pauseMenu);
    }

    public static Map getMap() {
        return Map.gameMap;
    }
    public void renderEntities(Graphics graphics)
    {
        for (int i=0;i<entityList.size();i++)
        {
            entityList.get(i).render(graphics);
            //System.out.println(entityList.get(i).getHitbox().getPosition().getX()+" "+entityList.get(i).getPosition().getY());
        }
    }
    public void updateEntities()
    {
        for(int i=0;i<entityList.size();i++)
        {
            entityList.get(i).update();
            //System.out.println(entityList.get(i).getHitbox().getPosition().getX());
        }
    }
}
