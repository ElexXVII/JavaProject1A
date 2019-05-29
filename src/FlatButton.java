import javax.swing.*;
import java.awt.*;

public class FlatButton extends JButton implements Definition
{
    protected Color idleColor = idleButtonColor;
    protected Color hoverColor = hoverButtonColor;
    protected Color pressColor = pressButtonColor;

    boolean isPressed = false;

    public FlatButton()
    {
        super();
        initButton();
    }

    public FlatButton(String text)
    {
        super(text);
        initButton();
    }

    private void initButton()
    {
        super.setBorderPainted(false);
        super.setFocusPainted(false);
        super.setContentAreaFilled(false);

        this.setFont(new Font("Montserrat",Font.ROMAN_BASELINE, 20));
        this.setForeground(new Color(255,255,255));
        this.setPreferredSize(new Dimension(175,50));
        this.setHorizontalAlignment(SwingConstants.CENTER);
        this.setVerticalAlignment(SwingConstants.CENTER);
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
