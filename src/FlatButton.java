import javax.swing.*;
import java.awt.*;

public class FlatButton extends JButton
{
    protected Color idleColor = new Color(0x4773B9);
    protected Color hoverColor = new Color(0x416BAA);
    protected Color pressColor = new Color(0x35549B);

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
        this.hoverColor = hoverColor;
    }
}
