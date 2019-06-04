package GUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class TPanel extends JPanel
{
    public TPanel()
    {
        super();
    }

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

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
    }
}
