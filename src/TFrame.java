import javax.swing.*;
import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.border.Border;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class TFrame extends JFrame implements Definition
{
    //=============
    // VARIABLES
    //=============

    // Main
    private TFrame frame;
    private TPanel mainPanel;

    // Menu & Menu Buttons
    private TMotionPanel pTop;
    private TPanel MenuLeft;
    private TPanel buttonLeftSpace;
    private TMenuButton[] buttons;

    // Frame buttons
    private TPanel MenuRight1;
    private TPanel MenuRight2;
    private TFrameButton reduceButton;
    private TFrameButton closeButton;

    // Content
    private TPanel contentPanel;
    private CardLayout cardLayout;
    private TPanel[] cards;

    // Contract Panel
    private TPanel contractListPanel;
    private TPanel ListTitlePanel;
    private TLabel ListeTitleLabel;
    private TPanel verticalSeparator1;
    private TPanel verticalSeparator2;
    // List
    TList list;
    TTextField searchBar;
    TScrollPane scrollPane;

    //=============
    // CONSTRUCTOR
    //=============

    public TFrame()
    {
        super();

        initFrame();

        initFramePanel();

        initMenu();

        initContent();

        this.setVisible(true);
        this.pack();
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

    //=============
    // PRIVATE FUNCTIONS
    //=============

    private void initFramePanel()
    {
        mainPanel = new TPanel(1000,700, null, null, new BorderLayout(0,0), false);
        this.setContentPane(mainPanel);

        TPanel pRightBorder = new TPanel(5, 615, InterfaceMainColor, null, null, true);
        mainPanel.add(pRightBorder, BorderLayout.EAST);

        TPanel pLeftBorder = new TPanel(5, 615, InterfaceMainColor, null, null, true);
        mainPanel.add(pLeftBorder, BorderLayout.WEST);

        TPanel pBottomBorder = new TPanel(600, 5, InterfaceMainColor, null, null, true);
        mainPanel.add(pBottomBorder, BorderLayout.PAGE_END);
    }

    private void initMenu()
    {
        pTop = new TMotionPanel(this, 1000,80, InterfaceMainColor, null,
                new FlowLayout(FlowLayout.CENTER,0,0), true);
        mainPanel.add(pTop, BorderLayout.PAGE_START);

        MenuLeft = new TPanel(940, 80, null, null, new FlowLayout(FlowLayout.CENTER,0,0), false);
        pTop.add(MenuLeft);

        buttonLeftSpace = new TPanel(60, 0, null, null, null, false);
        MenuLeft.add(buttonLeftSpace);

        initMenuButtons();
        initFrameButtons();
    }

    private void initMenuButtons()
    {
        buttons = new TMenuButton[3];

        for (int i=0; i<3; i++)
        {
            buttons[i] = new TMenuButton(frame, buttonsName[i]);
        }

        for (int i=0; i<3; i++)
        {
            buttons[i].setOtherButtons(buttons[(i + 1) % 3], buttons[(i + 2) % 3]);
            MenuLeft.add(buttons[i]);
        }

        buttons[0].setIsPressed(true);
    }

    private void initFrameButtons()
    {
        MenuRight1 = new TPanel(30, 80, null, null, new BorderLayout(0,0),false);
        pTop.add(MenuRight1);

        reduceButton = new TFrameButton(frame, "Reduce");
        MenuRight1.add(reduceButton, BorderLayout.PAGE_START);

        MenuRight2 = new TPanel(30, 80, null, null, new BorderLayout(0,0),false);
        pTop.add(MenuRight2);

        closeButton = new TFrameButton(frame, "Close");
        MenuRight2.add(closeButton, BorderLayout.PAGE_START);
    }

    private void initContent()
    {
        cardLayout = new CardLayout();
        contentPanel = new TPanel(1000, 615, null, null, cardLayout, false);
        mainPanel.add(contentPanel, BorderLayout.CENTER);

        initCards();

        initContractPanel();
    }

    private void initCards()
    {
        cards = new TPanel[3];

        for (int i=0; i<3; i++)
        {
            cards[i] = new TPanel(-1, -1, new Color(255<<16>>(i*8)), null, null, true);
            cards[i].setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
            contentPanel.add(cards[i], buttonsName[i]);
        }
    }

    private void initContractPanel()
    {
        TPanel card = cards[0];

        contractListPanel = new TPanel(300, 585, null, null, new FlowLayout(FlowLayout.LEFT, 0, 0), false);
        cards[0].add(contractListPanel);

        initLists();

        initToFillArea();
    }

    private void initLists()
    {
        ListTitlePanel = new TPanel(285, 30, InterfaceLightColor, WHITE, new FlowLayout(FlowLayout.CENTER), true);
        contractListPanel.add(ListTitlePanel);

        ListeTitleLabel = new TLabel("Historique des contrats", WHITE);
        ListTitlePanel.add(ListeTitleLabel);

        verticalSeparator1 = new TPanel(15, 30, InterfaceMainColor, null, null, true);
        contractListPanel.add(verticalSeparator1);

        list = new TList();
        scrollPane = new TScrollPane(list);

        searchBar = new TTextField(frame, "Rechercher un contrat", 285, 30, LIGHTGREY, DARKGREY);
        contractListPanel.add(searchBar);

        verticalSeparator2 = new TPanel(15, 30, InterfaceMainColor, null, null, true);
        contractListPanel.add(verticalSeparator2);

        contractListPanel.add(scrollPane);

        cardLayout.show(contentPanel, "Mon parc");

        //filterModel((DefaultListModel<String>) list.getModel(), "House");
        //TPanel.setBackground(new Color(153, 192, 255));
    }

    private void initToFillArea()
    {

    }

    //=============
    // GETTERS
    //=============

    public TPanel getContentPanel() {
        return contentPanel;
    }

    public CardLayout getCardLayout() {
        return cardLayout;
    }

    public TList getList() {
        return list;
    }

    public TScrollPane getScrollPane() {
        return scrollPane;
    }
}