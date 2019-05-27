import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MotionPanel extends JPanel
{
    private Point initialClick;
    private JFrame frame;

    public MotionPanel(final JFrame frame)
    {
        this.frame = frame;

        addMouseListener(new MouseAdapter()
            {
                public void mousePressed(MouseEvent e)
                {
                    initialClick = e.getPoint();
                    getComponentAt(initialClick);
                }
            }
            );

        addMouseMotionListener(new MouseMotionAdapter()
        {
            @Override
            public void mouseDragged(MouseEvent e)
            {

                // get location of Window
                int thisX = frame.getLocation().x;
                int thisY = frame.getLocation().y;

                // Determine how much the mouse moved since the initial click
                int xMoved = e.getX() - initialClick.x;
                int yMoved = e.getY() - initialClick.y;

                // Move window to this position
                int X = thisX + xMoved;
                int Y = thisY + yMoved;
                frame.setLocation(X, Y);
            }
        });
    }
}