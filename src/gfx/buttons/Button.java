package gfx.buttons;

import gfx.GamePanel;
import logic.Coordinate;
import java.awt.Color;
import java.awt.Graphics;

public abstract class Button {

    private String text;
    private Coordinate buttonPosition;
    private int width;
    private int height;
    private Coordinate textPosition;
    private Color buttonColor;
    private Color textColor;

    public Button(Coordinate buttonPosition, int width, int height, Color buttonColor, String text, Coordinate textPosition, Color textColor)
    {
        this.buttonPosition=buttonPosition;
        this.width=width;
        this.height=height;
        this.text=text;
        this.textPosition=textPosition;
        this.buttonColor=buttonColor;
        this.textColor=textColor;
    }

    public void playActionOnClick()
    {
        if (GamePanel.mouseManager.left && checkIfMouseIsOnButton())
        {
            actionOnClick();
        }
    }
    public void update()
    {
        playActionOnClick();
    }
    public void render(Graphics graphics)
    {
        graphics.setColor(buttonColor);
        graphics.fillRect(buttonPosition.getX(),buttonPosition.getY(),width,height);
        graphics.setColor(textColor);
        graphics.drawString(text,textPosition.getX(),textPosition.getY());

    }
    public boolean checkIfMouseIsOnButton()
    {
        if(GamePanel.mouseManager.coordinate.x>buttonPosition.getX() &&
           GamePanel.mouseManager.coordinate.x<buttonPosition.getX()+width &&
           GamePanel.mouseManager.coordinate.y>buttonPosition.getY() &&
           GamePanel.mouseManager.coordinate.y<buttonPosition.getY()+height)
        {
            return true;
        }
        else return false;
    }
    abstract void actionOnClick();

}
