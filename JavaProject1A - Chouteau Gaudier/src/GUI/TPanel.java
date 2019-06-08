package GUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class TPanel extends JPanel
{
    /**
     * Constructor
     */
    public TPanel()
    {
        super();
    }

    /**
     * Constructor to a standard panel
     * @param x : width
     * @param y : height
     * @param back : Background Color
     * @param front : Front Color
     * @param layout : Layout of this panel
     * @param opaque : Is it visible
     */
    public TPanel(int x, int y, Color back, Color front, LayoutManager layout, boolean opaque)
    {
        super();

        this.setBackground(back);
        this.setForeground(front);
        if (x != -1 && y != -1)
        {
            this.setPreferredSize(new Dimension(x,y));
        }
        this.setOpaque(opaque);
        this.setLayout(layout);
    }

    /**
     * Paint the panel
     * @param g
     */
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
    }
}
