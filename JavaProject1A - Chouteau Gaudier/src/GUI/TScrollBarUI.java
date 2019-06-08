package GUI;
import Interface.*;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;

public class TScrollBarUI extends BasicScrollBarUI implements Definition
{
    protected Color idleColor = Definition.idleButtonColor;
    protected Color hoverColor = Definition.hoverButtonColor;
    protected Color pressColor = Definition.pressButtonColor;

    protected Color backgroundColor = Definition.backgroundSlideColor;

    //private final Dimension d = new Dimension();
    private int direction;

    public TScrollBarUI(int dir)
    {
        direction = dir;
    }

    /**
     * Create TList down/Right button (depends on the parameter)
     * @param orientation : Horizontal or Vertical Bar
     * @return
     */
    @Override
    protected TFrameButton createDecreaseButton(int orientation)
    {
        return new TFrameButton(direction==0?"Decrease":"Right");
    }

    /**
     * Create TList up/Left button (depends on the parameter)
     * @param orientation : Horizontal or Vertical Bar
     * @return
     */
    @Override
    protected TFrameButton createIncreaseButton(int orientation)
    {
        return new TFrameButton(direction==0?"Increase":"Left");
    }

    /**
     * I draw my own TrackBar
     * @param g
     * @param c
     * @param r
     */
    @Override
    protected void paintTrack(Graphics g, JComponent c, Rectangle r)
    {
        /*Graphics2D g2 = (Graphics2D)g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);*/

        g.setColor(backgroundColor);
        g.fillRect(0,0,c.getWidth(), c.getHeight());
    }

    /**
     * I draw my own TrackBar
     * @param g : Graphics
     * @param c : JComponent linked
     * @param r : Rectangle
     */
    @Override
    protected void paintThumb(Graphics g, JComponent c, Rectangle r)
    {

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

    /**
     * Update TList
     * @param x : x value
     * @param y : y value
     * @param width : width
     * @param height : height
     */
    @Override
    protected void setThumbBounds(int x, int y, int width, int height)
    {
        super.setThumbBounds(x, y, width, height);
        scrollbar.repaint();
    }
}
