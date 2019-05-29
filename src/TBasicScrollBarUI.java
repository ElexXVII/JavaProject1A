import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;

public class TBasicScrollBarUI extends BasicScrollBarUI implements Definition
{
    protected Color idleColor = idleButtonColor;
    protected Color hoverColor = hoverButtonColor;
    protected Color pressColor = pressButtonColor;

    protected Color backgroundColor = backgroundSlideColor;

    //private final Dimension d = new Dimension();

    @Override
    protected TFrameButton createDecreaseButton(int orientation) {
        return new TFrameButton("Increase");
    }
    @Override
    protected TFrameButton createIncreaseButton(int orientation) {
        return new TFrameButton("Decrease");
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
