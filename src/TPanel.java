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

    public TPanel(int x, int y, Color back, Color front, LayoutManager l)
    {
        super();

        this.setBackground(new Color(0xFFFFFF));
        this.setPreferredSize(new Dimension(1000,700));
        this.setLayout(new BorderLayout(0,0));
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
    }
}
