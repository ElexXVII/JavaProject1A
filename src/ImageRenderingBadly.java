import javax.imageio.*;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class ImageRenderingBadly extends JPanel
{
    BufferedImage cross;

    public ImageRenderingBadly()
    {
        try {
            URL url = new URL("https://i.imgur.com/cWGntek.png");
            cross = ImageIO.read(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D)g;
        RenderingHints rh = new RenderingHints(
                RenderingHints.KEY_STROKE_CONTROL,
                RenderingHints.VALUE_RENDER_QUALITY);
        g2.setRenderingHints(rh);
        g2.drawImage(cross,0,0,null);
    }

    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        frame.setSize(new Dimension(200,200));
        frame.setBackground(new Color(0));

        ImageRenderingBadly panel = new ImageRenderingBadly();

        frame.setContentPane(panel);
        frame.setVisible(true);
    }
}