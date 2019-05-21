package logic;

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
    }

    @Override
    public void render(Graphics graphics) {
        player.render(graphics);
    }
}
