package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TMotionPanel extends JPanel
{
    private TFrame frame;

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

    public TMotionListener(TFrame frame)
    {
        this.frame = frame;
    }

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