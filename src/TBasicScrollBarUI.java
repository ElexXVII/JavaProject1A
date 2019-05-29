import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;

public class TBasicScrollBarUI extends BasicScrollBarUI
{
    protected Color backgroundColor = new Color(0xDDDDDD);
    protected Color idleColor = new Color(0x4773B9);
    protected Color hoverColor = new Color(0x416BAA);
    protected Color pressColor = new Color(0x35549B);

    //private final Dimension d = new Dimension();

    @Override
    protected FrameButton createDecreaseButton(int orientation) {
        return new FrameButton("Increase");
    }
    @Override
    protected FrameButton createIncreaseButton(int orientation) {
        return new FrameButton("Decrease");
    }

    @Override
    protected void paintTrack(Graphics g, JComponent c, Rectangle r)
    {
        /*Graphics2D g2 = (Graphics2D)g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);*/

        g.setColor(backgroundColor);
        g.fillRect(0,0,c.getWidth(), c.getHeight());
    }

    @Override
    protected void paintThumb(Graphics g, JComponent c, Rectangle r) {

        /*Graphics2D g2 = (Graphics2D)g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);*/

        Color color = null;
        JScrollBar sb = (JScrollBar)c;

        if(isDragging)
        {
            color = pressColor;
        }
        else if(isThumbRollover())
        {
            color = hoverColor;
        }
        else
        {
            color = idleColor;
        }
        g.setColor(color);
        g.fillRect(r.x,r.y,r.width,r.height);
        /*g2.setPaint(color);
        g2.drawRect(r.x,r.y,r.width,r.height);*/
        //g.dispose();
    }

    @Override
    protected void setThumbBounds(int x, int y, int width, int height) {
        super.setThumbBounds(x, y, width, height);
        scrollbar.repaint();
    }
}
