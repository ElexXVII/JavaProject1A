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

    public TFlatButton()
    {
        super();
        initButton();
    }

    public TFlatButton(String text)
    {
        super(text);
        initButton();
    }

    private void initButton()
    {
        super.setBorderPainted(false);
        super.setFocusPainted(false);
        super.setContentAreaFilled(false);
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
    }

    @Override
    public void setContentAreaFilled(boolean b) {
    }

    protected void setHoverColor(Color color)
    {
        this.hoverColor = color;
    }
}
