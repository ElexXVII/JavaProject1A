import javax.swing.*;
import java.awt.*;

public class TFlatButton extends JButton implements Definition
{
    protected Color idleColor = idleButtonColor;
    protected Color hoverColor = hoverButtonColor;
    protected Color pressColor = pressButtonColor;

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
