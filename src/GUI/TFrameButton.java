package GUI;
import Interface.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class TFrameButton extends TFlatButton implements Definition
{
    TFrame frame;
    String name;

    BufferedImage image;

    public TFrameButton(String name)
    {
        super();
        this.name = name;
        initButton();

        if (name.equals("Increase"))
        {
            try {
                image = ImageIO.read(new File("images/increaseIcon.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if (name.equals("Decrease"))
        {
            try {
                image = ImageIO.read(new File("images/decreaseIcon.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public TFrameButton(TFrame frame, String name)
    {
        super();
        this.frame = frame;
        this.name = name;
        initButton();

        if (name.equals("Close"))
        {
            this.hoverColor = Definition.hoverCrossColor;
            this.pressColor = Definition.pressCrossColor;

            try {
                image = ImageIO.read(new File("images/closeIcon.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if (name.equals("Reduce"))
        {
            try {
                image = ImageIO.read(new File("images/reduceIcon.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void initButton()
    {
        super.setBorderPainted(false);
        super.setFocusPainted(false);
        super.setContentAreaFilled(false);

        if (name.equals("Reduce") || name.equals("Close"))
        {
            super.setPreferredSize(new Dimension(30,30));

            super.addMouseListener(new MouseAdapter()
                                   {
                                       public void mouseReleased(MouseEvent e) {
                                           if (name.equals("Reduce")) {
                                               if (e.getX() >= 0 && e.getX() < 30 && e.getY() >= 0 && e.getY() < 30) {
                                                   frame.setState(Frame.ICONIFIED);
                                               }
                                           } else if (name.equals("Close")) {
                                               if (e.getX() >= 0 && e.getX() < 30 && e.getY() >= 0 && e.getY() < 30) {
                                                   frame.setVisible(false);
                                                   frame.dispose();
                                               }
                                           }
                                       }
                                   });
        }
        else
        {
            super.setPreferredSize(new Dimension(15,15));
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
        g.fillRect(0, 0, getWidth(), getHeight());

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;
        RenderingHints rh = new RenderingHints(
                RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);
        g2.setRenderingHints(rh);
        g2.drawImage(image, 0, 0, getWidth(), getHeight(), this);
    }

    @Override
    public void setContentAreaFilled(boolean b) {
    }
}
