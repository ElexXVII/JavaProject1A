import javax.swing.*;
import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.border.Border;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class TFrame extends JFrame implements Definition
{
    private TFrame frame;
    private TPanel mainPanel;

    public TPanel pContent;
    public CardLayout cardLayout;

    public TFrame()
    {
        super();

        initFrame();

        initContentPane();

        //Container cTop = new Container();
        MotionPanel pTop = new MotionPanel(this);
        pTop.setBackground(new Color(0x4773B9));
        pTop.setPreferredSize(new Dimension(1000,80));
        mainPanel.add(pTop, BorderLayout.PAGE_START);
        pTop.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));

        TPanel MenuLeft = new TPanel();
        MenuLeft.setBackground(new Color(0x4773B9));
        MenuLeft.setPreferredSize(new Dimension(940,80));
        pTop.add(MenuLeft);
        MenuLeft.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));

        JPanel buttonLeftSpace = new JPanel();
        buttonLeftSpace.setBackground(new Color(0x4773B9));
        buttonLeftSpace.setPreferredSize(new Dimension(60,0));
        MenuLeft.add(buttonLeftSpace);

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

        TPanel MenuRight1 = new TPanel();
        MenuRight1.setBackground(new Color(0x4773B9));
        MenuRight1.setPreferredSize(new Dimension(30,80));
        MenuRight1.setLayout(new BorderLayout(0,0));
        pTop.add(MenuRight1);

        FrameButton reduceButton = new FrameButton(frame, "Reduce");
        MenuRight1.add(reduceButton, BorderLayout.PAGE_START);

        TPanel MenuRight2 = new TPanel();
        MenuRight2.setBackground(new Color(0x4773B9));
        MenuRight2.setPreferredSize(new Dimension(30,80));
        MenuRight2.setLayout(new BorderLayout(0,0));
        pTop.add(MenuRight2);

        FrameButton closeCross = new FrameButton(frame, "Close");
        //closeCross.setPressedIcon(pressedIcon);
        MenuRight2.add(closeCross, BorderLayout.PAGE_START);

        pContent = new TPanel();
        pContent.setBackground(new Color(0x555555));
        pContent.setPreferredSize(new Dimension(1000,615));
        mainPanel.add(pContent, BorderLayout.CENTER);
        cardLayout = new CardLayout();
        pContent.setLayout(cardLayout);

        TPanel pRightBorder = new TPanel();
        pRightBorder.setBackground(new Color(0x4773B9));
        pRightBorder.setPreferredSize(new Dimension(5,615));
        mainPanel.add(pRightBorder, BorderLayout.EAST);

        TPanel pLeftBorder = new TPanel();
        pLeftBorder.setBackground(new Color(0x4773B9));
        pLeftBorder.setPreferredSize(new Dimension(5,615));
        mainPanel.add(pLeftBorder, BorderLayout.WEST);

        TPanel card1 = new TPanel();
        card1.setBackground(new Color(0xDD0000));
        card1.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
        TPanel card2 = new TPanel();
        card2.setBackground(new Color(0x00BB00));
        TPanel card3 = new TPanel();
        card3.setBackground(new Color(0x000099));

        TPanel listPanel = new TPanel();
        listPanel.setBackground(new Color(0));
        listPanel.setPreferredSize(new Dimension(300,615));
        listPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        card1.add(listPanel);

        TPanel ListTitlePanel = new TPanel();
        ListTitlePanel.setBackground(new Color(0x6A9DDB));
        ListTitlePanel.setPreferredSize(new Dimension(285,30));
        listPanel.add(ListTitlePanel);

        JLabel ListeTitleLabel = new JLabel("Historique des contrats");
        ListeTitleLabel.setFont(new Font("Montserrat",Font.ROMAN_BASELINE, 15));
        ListeTitleLabel.setForeground(new Color(255,255,255));
        ListTitlePanel.add(ListeTitleLabel);

        TPanel verticalSeparator1 = new TPanel();
        verticalSeparator1.setBackground(new Color(0x4773B9));
        verticalSeparator1.setPreferredSize(new Dimension(15,30));
        listPanel.add(verticalSeparator1);

        TList list = new TList();
        TScrollPane scrollPane = new TScrollPane(list);

        TTextField searchBar = new TTextField("Rechercher un contrat");
        searchBar.setFont(new Font("Montserrat",Font.ROMAN_BASELINE, 12));
        searchBar.setBackground(new Color(0xDDDDDD));
        searchBar.setForeground(new Color(0x555555));
        searchBar.setPreferredSize(new Dimension(285,30));
        searchBar.setBorder(border);
        searchBar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                scrollPane.filterModel((DefaultListModel<String>) list.getModel(), searchBar.getText());
            }
        });
        listPanel.add(searchBar);

        TPanel verticalSeparator2 = new TPanel();
        verticalSeparator2.setBackground(new Color(0x4773B9));
        verticalSeparator2.setPreferredSize(new Dimension(15,30));
        listPanel.add(verticalSeparator2);

        listPanel.add(scrollPane);

        pContent.add(card1, "Mon parc");
        pContent.add(card2, "Mes véhicules");
        pContent.add(card3, "Mes clients");

        cardLayout.show(pContent, "Mon parc");

        TPanel pBottomBorder = new TPanel();
        pBottomBorder.setBackground(new Color(0x4773B9));
        pBottomBorder.setPreferredSize(new Dimension(600,5));
        mainPanel.add(pBottomBorder, BorderLayout.PAGE_END);

        this.pack();
        this.setVisible(true);

        //filterModel((DefaultListModel<String>) list.getModel(), "House");

        //TPanel.setBackground(new Color(153, 192, 255));

    }

    private void initFrame()
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
        this.setLocation((int) (dim.getWidth()/2-this.getSize().width/2), (int) (dim.getHeight()/2-this.getSize().height/2));
        this.setBackground(new Color(0));
    }

    public void initContentPane()
    {
        mainPanel = new TPanel(1000,700,WHITE,WHITE, new BorderLayout(0,0));
        this.setContentPane(mainPanel);
    }


}