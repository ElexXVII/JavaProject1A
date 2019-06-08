package GUI;

import javax.swing.*;
import java.awt.*;

import Interface.*;

public class TFlatButton extends JButton implements Definition
{
    protected Color idleColor = Definition.idleButtonColor;
    protected Color hoverColor = Definition.hoverButtonColor;
    protected Color pressColor = Definition.pressButtonColor;

    boolean isPressed = false;

    /**
     * Constructor 1
     */
    public TFlatButton()
    {
        super();
        initButton();
    }

    /**
     * Constructor 2
     * @param text : Title
     */
    public TFlatButton(String text)
    {
        super(text);
        initButton();
    }

    /**
     * Init params of buttons
     */
    private void initButton()
    {
        super.setBorderPainted(false);
        super.setFocusPainted(false);
        super.setContentAreaFilled(false);
    }

    /**
     * Dessiner le boutons (Flat design)
     * @param g : Composant graphique
     */
    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
    }

    /**
     * Override this methods allows to draw myself the button
     * @param b
     */
    @Override
    public void setContentAreaFilled(boolean b) {
    }

    protected void setHoverColor(Color color)
    {
        this.hoverColor = color;
    }
}
