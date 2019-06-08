package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TMotionPanel extends JPanel
{
    private TFrame frame;

    /**
     * Constructor of the MotionPanel
     * @param frame : Ref to the main frame
     * @param x : width
     * @param y : height
     * @param back : Background Color
     * @param front : Front Color
     * @param layout : Layout used
     * @param opaque : Is it visible or not
     */
    public TMotionPanel(TFrame frame, int x, int y, Color back, Color front, LayoutManager layout, boolean opaque)
    {
        this.frame = frame;

        this.setBackground(back);
        this.setForeground(front);
        this.setPreferredSize(new Dimension(x,y));
        this.setOpaque(opaque);
        this.setLayout(layout);

        TMotionListener motionListener = new TMotionListener(frame);
        TListener listener = new TListener(this, motionListener);

        addMouseMotionListener(motionListener);
        addMouseListener(listener);
    }
}

class TListener extends MouseAdapter
{
    TMotionPanel panel;
    TMotionListener motionListener;

    /**
     * Constructor of the listener
     * @param panel : Ref to the panel
     * @param motionListener : Ref to the motionListener
     */
    public TListener(TMotionPanel panel, TMotionListener motionListener)
    {
        this.panel = panel;
        this.motionListener = motionListener;
    }

    public void mousePressed(MouseEvent e)
    {
        Point initialClick = e.getPoint();
        panel.getComponentAt(initialClick);
        motionListener.setInitialClick(initialClick);
    }
}

class TMotionListener extends MouseMotionAdapter
{
    private TFrame frame;
    private Point initialClick = new Point(0,0);

    /**
     * Constructor
     * @param frame : Ref to the main frame
     */
    public TMotionListener(TFrame frame)
    {
        this.frame = frame;
    }

    /**
     * Get the dragged vector and move the frame
     * @param e : Event
     */
    @Override
    public void mouseDragged(MouseEvent e)
    {
        int thisX = frame.getLocation().x;
        int thisY = frame.getLocation().y;

        int xMoved = e.getX() - initialClick.x;
        int yMoved = e.getY() - initialClick.y;

        int X = thisX + xMoved;
        int Y = thisY + yMoved;
        frame.setLocation(X, Y);
    }

    public void setInitialClick(Point initialClick)
    {
        this.initialClick = initialClick;
    }
}