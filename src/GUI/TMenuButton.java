package GUI;
import Class.*;
import Interface.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TMenuButton extends TFlatButton implements Definition
{
    private TFrame frame;

    private String name;
    private ArrayList<TMenuButton> otherButtons;

    public TMenuButton(TFrame frame, String text)
    {
        super(text);
        super.setBorderPainted(false);
        super.setFocusPainted(false);
        super.setContentAreaFilled(false);

        this.setFont(Definition.menuFont);

        this.frame = frame;
        this.name = text;

        this.setForeground(Color.WHITE);
        this.setPreferredSize(new Dimension(175,50));
        this.setHorizontalAlignment(SwingConstants.CENTER);
        this.setVerticalAlignment(SwingConstants.CENTER);
    }

    @Override
    public void paint(Graphics g)
    {
        if (getModel().isPressed())
        {
            for (TMenuButton button : otherButtons)
            {
                button.setIsPressed(false);
                button.repaint();
            }
            isPressed = true;

            frame.getCardLayout().show(frame.getContentPanel(), this.name);
        }
        if (isPressed)
        {
            g.setColor(pressColor);
        }
        else if (getModel().isRollover())
        {
            g.setColor(hoverColor);
        }
        else
        {
            g.setColor(idleColor);
        }

        Graphics2D g2 = (Graphics2D)g;
        RenderingHints rh = new RenderingHints(
                RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);
        g2.setRenderingHints(rh);

        g2.fillRect(0, 0, getWidth(), getHeight());

        g2.setColor(new Color(0xFFFFFF));
        //g2.fillRect(0, 0, 1, getHeight());
        //g2.fillRect(getWidth()-1, 0, getWidth(), getHeight());

        super.paintComponent(g);
    }

    public void setOtherButtons(TMenuButton ... buttons)
    {
        otherButtons = new ArrayList<TMenuButton>();

        for (TMenuButton button : buttons)
        {
            otherButtons.add(button);
        }
    }

    public void setIsPressed(boolean isPressed)
    {
        this.isPressed = isPressed;
    }
}
