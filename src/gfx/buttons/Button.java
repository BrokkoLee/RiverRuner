package gfx.buttons;

import gfx.GamePanel;
import logic.Coordinate;
import logic.states.State;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.FontMetrics;
import java.awt.Font;

public abstract class Button {

    public static final int DEFAULT_WIDTH=100;
    public static final int DEFAULT_HEIGHT=50;
    public static final Color DEFAULT_PRIMARY_BUTTON_COLOR=new Color(0x0000FF);
    public static final Color DEFAULT_SECONDARY_BUTTON_COLOR=new Color(0x0065F9);
    public static final Color DEFAULT_TEXT_COLOR=new Color(0x000000);
    public static final Font DEFAULT_BUTTON_FONT =new Font("ButtonFont",Font.BOLD|Font.ITALIC,12);
    public static final String DEFAULT_BUTTON_TEXT="";

    FontMetrics fontMetrics;
    private int textWidth;
    private int textDescent;


    private Coordinate buttonPosition;
    private int width;
    private int height;
    private Color buttonColor;
    private Color secondaryButtonColor;
    private String text;
    private Color textColor;


    public Button(Coordinate buttonPosition, int width, int height, Color buttonColor,Color secondaryButtonColor, String text, Color textColor) {
        this.buttonPosition = buttonPosition;
        this.width = width;
        this.height = height;
        this.text = text;
        this.buttonColor = buttonColor;
        this.textColor = textColor;
        this.secondaryButtonColor=secondaryButtonColor;
    }
    /*public Button(Coordinate buttonPosition)
    {

    }*/

    public void playActionOnClick()
    {
        if (checkIfMouseIsOnButton() && GamePanel.mouseManager.isClicked)
        {
            State previousState=GamePanel.state;
            actionOnClick();
            GamePanel.state.previousState=previousState;
        }
    }
    public void update()
    {
        playActionOnClick();
    }
    public void render(Graphics graphics) {

        setButtonColorBasedOnMouseLocation(graphics);

        graphics.fillRect(buttonPosition.getX(),buttonPosition.getY(),width,height);

        graphics.setFont(DEFAULT_BUTTON_FONT);
        graphics.setColor(textColor);
        setTextSizes(graphics);
        graphics.drawString(text,buttonPosition.getX()+(width/2)-(textWidth/2),buttonPosition.getY()+(height/2)+(textDescent));

    }
    public boolean checkIfMouseIsOnButton()
    {
        if(GamePanel.mouseManager.coordinate.x>=buttonPosition.getX() &&
           GamePanel.mouseManager.coordinate.x<=buttonPosition.getX()+width &&
           GamePanel.mouseManager.coordinate.y>=buttonPosition.getY() &&
           GamePanel.mouseManager.coordinate.y<=buttonPosition.getY()+height)
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
    public void setButtonColorBasedOnMouseLocation(Graphics graphics)
    {
        if(checkIfMouseIsOnButton())
        {
            graphics.setColor(secondaryButtonColor);
        }
        else
        {
            graphics.setColor(buttonColor);
        }
    }
    abstract void actionOnClick();

}
