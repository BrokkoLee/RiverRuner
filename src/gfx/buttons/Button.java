package gfx.buttons;

import gfx.GamePanel;
import logic.Coordinate;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.FontMetrics;
import java.awt.Font;

public abstract class Button {

    private String text;
    private Coordinate buttonPosition;
    private int width;
    private int height;
    private Color buttonColor;
    private Color textColor;
    FontMetrics fontMetrics;
    private int textWidth;
    private int textDescent;

    public static Font buttonFont=new Font("ButtonFont",Font.BOLD|Font.ITALIC,16);

    public Button(Coordinate buttonPosition, int width, int height, Color buttonColor, String text, Color textColor) {
        this.buttonPosition = buttonPosition;
        this.width = width;
        this.height = height;
        this.text = text;
        this.buttonColor = buttonColor;
        this.textColor = textColor;
    }

    public void playActionOnClick()
    {
        if (GamePanel.mouseManager.isClicked && checkIfMouseIsOnButton())
        {
            actionOnClick();
            GamePanel.mouseManager.isClicked=false;
        }
    }
    public void update()
    {
        playActionOnClick();
    }
    public void render(Graphics graphics) {

        graphics.setColor(buttonColor);
        graphics.fillRect(buttonPosition.getX(),buttonPosition.getY(),width,height);

        graphics.setFont(buttonFont);
        graphics.setColor(textColor);
        setTextSizes(graphics);
        graphics.drawString(text,buttonPosition.getX()+(width/2)-(textWidth/2),buttonPosition.getY()+(height/2)+(textDescent));

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
    public int getTextWidthOnScreen(Graphics graphics)
    {
        fontMetrics=graphics.getFontMetrics();
        return fontMetrics.stringWidth(text);
    }
    public int getTextDescentOnScreen(Graphics graphics)
    {
        fontMetrics=graphics.getFontMetrics();
        return fontMetrics.getDescent();
    }
    public void setTextSizes(Graphics graphics)
    {
        if (textWidth != getTextWidthOnScreen(graphics)) {
            textWidth = getTextWidthOnScreen(graphics);
        }
        if (textDescent != getTextDescentOnScreen(graphics))
        {
            textDescent = getTextDescentOnScreen(graphics);
        }
    }
    abstract void actionOnClick();

}
