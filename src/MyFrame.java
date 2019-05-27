import javax.swing.*;
import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.border.Border;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MyFrame extends JFrame
{
    private MyFrame frame;

    public Panel pContent;
    public CardLayout cardLayout;

    public MyFrame()
    {
        frame = this;

        this.setSize(1000,700);
        this.setTitle("JavaParkTest");
        this.setUndecorated(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        System.out.println(new File("images/logo.png").getAbsolutePath());
        try {
            BufferedImage image = ImageIO.read(new File("images/logo.png"));
            frame.setIconImage(image);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        this.setBackground(new Color(0));

        Panel mainPanel = new Panel();
        mainPanel.setBackground(new Color(0xFFFFFF));
        mainPanel.setPreferredSize(new Dimension(1000,700));
        this.setContentPane(mainPanel);
        mainPanel.setLayout(new BorderLayout(0,0));

        //Container cTop = new Container();
        MotionPanel pTop = new MotionPanel(this);
        pTop.setBackground(new Color(0x4773B9));
        pTop.setPreferredSize(new Dimension(1000,100));
        mainPanel.add(pTop, BorderLayout.PAGE_START);
        pTop.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));

        Panel MenuLeft = new Panel();
        MenuLeft.setBackground(new Color(0x4773B9));
        MenuLeft.setPreferredSize(new Dimension(940,100));
        pTop.add(MenuLeft);
        MenuLeft.setLayout(new FlowLayout(FlowLayout.LEFT,0,40));

        JPanel buttonLeftSpace = new JPanel();
        buttonLeftSpace.setBackground(new Color(0x4773B9));
        buttonLeftSpace.setPreferredSize(new Dimension(50,0));
        MenuLeft.add(buttonLeftSpace);

        /*JPanel buttonSpace1 = new JPanel();
        buttonSpace1.setBackground(new Color(0xFFFFFF));
        buttonSpace1.setPreferredSize(new Dimension(2,50));
        MenuLeft.add(buttonSpace1);*/

        MenuButton b1 = new MenuButton(frame, "Mon parc");
        MenuButton b2 = new MenuButton(frame, "Mes véhicules");
        MenuButton b3 = new MenuButton(frame, "Mes clients");

        b1.setOtherButtons(b2, b3);
        b2.setOtherButtons(b3, b1);
        b3.setOtherButtons(b1, b2);
        MenuLeft.add(b1);
        MenuLeft.add(b2);
        MenuLeft.add(b3);

        b1.setIsPressed(true);

        Panel MenuRight1 = new Panel();
        MenuRight1.setBackground(new Color(0x4773B9));
        MenuRight1.setPreferredSize(new Dimension(30,100));
        MenuRight1.setLayout(new BorderLayout(0,0));
        pTop.add(MenuRight1);

        FrameButton reduceButton = new FrameButton(frame, "Reduce");
        MenuRight1.add(reduceButton, BorderLayout.PAGE_START);

        Panel MenuRight2 = new Panel();
        MenuRight2.setBackground(new Color(0x4773B9));
        MenuRight2.setPreferredSize(new Dimension(30,100));
        MenuRight2.setLayout(new BorderLayout(0,0));
        pTop.add(MenuRight2);

        FrameButton closeCross = new FrameButton(frame, "Close");
        //closeCross.setPressedIcon(pressedIcon);
        MenuRight2.add(closeCross, BorderLayout.PAGE_START);

        pContent = new Panel();
        pContent.setBackground(new Color(0x555555));
        pContent.setPreferredSize(new Dimension(600,570));
        mainPanel.add(pContent, BorderLayout.CENTER);
        cardLayout = new CardLayout();
        pContent.setLayout(cardLayout);

        Panel card1 = new Panel();
        card1.setBackground(new Color(0xDD0000));
        card1.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
        Panel card2 = new Panel();
        card2.setBackground(new Color(0x00BB00));
        Panel card3 = new Panel();
        card3.setBackground(new Color(0x000099));

        String categories[] = { "Household", "Office", "Extended Family",
                "Company (US)", "Company (World)", "Team", "Will",
                "Birthday Card List", "High School", "Country", "Continent",
                "Planet", "Household", "Office", "Extended Family",
                "Company (US)", "Company (World)", "Team", "Will",
                "Birthday Card List", "High School", "Country", "Continent",
                "Planet" , "Household", "Office", "Extended Family",
                "Company (US)", "Company (World)", "Team", "Will",
                "Birthday Card List", "High School", "Country", "Continent",
                "Planet" , "Household", "Office", "Extended Family",
                "Company (US)", "Company (World)", "Team", "Will",
                "Birthday Card List", "High School", "Country", "Continent",
                "Planet" , "Household", "Office", "Extended Family",
                "Company (US)", "Company (World)", "Team", "Will",
                "Birthday Card List", "High School", "Country", "Continent",
                "Planet" , "Household", "Office", "Extended Family",
                "Company (US)", "Company (World)", "Team", "Will",
                "Birthday Card List", "High School", "Country", "Continent",
                "Planet" };
        JList list = new JList(categories);
        JScrollPane scrollpane = new JScrollPane(list);
        scrollpane.getVerticalScrollBar().setPreferredSize(new Dimension(15,15));
        scrollpane.getHorizontalScrollBar().setPreferredSize(new Dimension(15,15));
        scrollpane.getVerticalScrollBar().setUI(new MyBasicScrollBarUI());
        scrollpane.getHorizontalScrollBar().setUI(new MyBasicScrollBarUI());
        Border border = BorderFactory.createEmptyBorder( 0, 0, 0, 0 );
        scrollpane.setPreferredSize(new Dimension(300,570));
        scrollpane.setBorder(border);

        card1.add(scrollpane);

        pContent.add(card1, "Mon parc");
        pContent.add(card2, "Mes véhicules");
        pContent.add(card3, "Mes clients");

        cardLayout.show(pContent, "Mon parc");

        Panel pFooter = new Panel();
        pFooter.setBackground(new Color(0x4773B9));
        pFooter.setPreferredSize(new Dimension(600,30));
        mainPanel.add(pFooter, BorderLayout.PAGE_END);

        this.pack();
        this.setVisible(true);

        //panel.setBackground(new Color(153, 192, 255));

    }
}