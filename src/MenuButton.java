import java.awt.*;
import java.util.ArrayList;

public class MenuButton extends FlatButton
{
    private String name;

    private ArrayList<MenuButton> otherButtons = new ArrayList<MenuButton>();

    private TFrame frame;

    public MenuButton()
    {
        super();
    }

    public MenuButton(TFrame frame, String text)
    {
        super(text);
        super.setBorderPainted(false);
        super.setFocusPainted(false);
        super.setContentAreaFilled(false);

        this.frame = frame;
        this.name = text;
    }

    @Override
    public void paint(Graphics g)
    {
        if (getModel().isPressed())
        {
            for (MenuButton button : otherButtons)
            {
                button.setIsPressed(false);
                button.repaint();
            }
            isPressed = true;

            frame.cardLayout.show(frame.pContent, this.name);
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

    public void setOtherButtons(MenuButton ... buttons)
    {
        otherButtons = new ArrayList<MenuButton>();

        for (MenuButton button : buttons)
        {
            otherButtons.add(button);
        }
    }

    public void setIsPressed(boolean isPressed)
    {
        this.isPressed = isPressed;
    }
}
