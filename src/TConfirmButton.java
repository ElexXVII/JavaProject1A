import java.awt.*;

public class TConfirmButton extends TFlatButton implements Definition
{
    TFrame frame;

    public TConfirmButton(TFrame frame, String text, int x, int y)
    {
        super(text);

        this.frame = frame;
        this.setPreferredSize(new Dimension(x, y));
        this.setForeground(WHITE);
        this.setFont(menuFont);

        super.setBorderPainted(false);
        super.setFocusPainted(false);
        super.setContentAreaFilled(false);

        idleColor = idleButtonLightColor;

        if (text.equals("Annuler"))
        {
            hoverColor = hoverCrossColor;
            pressColor = pressCrossColor;
        }
        else
        {
            hoverColor = hoverButtonLightColor;
            pressColor = pressButtonLightColor;
        }
    }

    @Override
    public void paint(Graphics g)
    {
        if (getModel().isPressed())
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
}
