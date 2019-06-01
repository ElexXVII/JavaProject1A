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

    // Contract Panel : Card[0]
    // List
    ArrayList<String> contractArrayList;
    private TPanel contractListPanel;
    private TPanel contractListTitlePanel;
    private TLabel contractListTitleLabel;
    private TPanel contractVerticalSeparator1;
    private TContentButton contractNewContractButton;
    private TPanel contractVerticalSeparator3;
    private TList contractList;
    private TSearchBar contractSearchBar;
    private TPanel contractVerticalSeparator2;
    private TScrollPane contractScrollPane;
    // Contract Area To Fill
    private TPanel contractAreaToFillPanel;
    //private TLabel contractSurnameLabel;
    private TTextField contractSurnameField;
    //private TLabel contractNameLabel;
    private TTextField contractNameField;
    private TConfirmButton contractConfirmButton;
    private TConfirmButton contractCancelButton;

    // Contract Panel : Card[1]
    // List
    ArrayList<String> vehicleArrayList;
    private TPanel vehicleListPanel;
    private TPanel vehicleListTitlePanel;
    private TLabel vehicleListTitleLabel;
    private TPanel vehicleVerticalSeparator1;
    private TContentButton vehicleNewvehicleButton;
    private TPanel vehicleVerticalSeparator3;
    private TList vehicleList;
    private TSearchBar vehicleSearchBar;
    private TPanel vehicleVerticalSeparator2;
    private TScrollPane vehicleScrollPane;
    // vehicle Area To Fill
    private TPanel vehicleAreaToFillPanel;
    //private TLabel vehicleSurnameLabel;
    private TTextField vehicleSurnameField;
    //private TLabel vehicleNameLabel;
    private TTextField vehicleNameField;
    private TConfirmButton vehicleConfirmButton;
    private TConfirmButton vehicleCancelButton;

    // Client Panel : Card[2]
    // List
    ArrayList<String> clientArrayList;
    private TPanel clientListPanel;
    private TPanel clientListTitlePanel;
    private TLabel clientListTitleLabel;
    private TPanel clientVerticalSeparator1;
    private TContentButton clientNewclientButton;
    private TPanel clientVerticalSeparator3;
    private TList clientList;
    private TSearchBar clientSearchBar;
    private TPanel clientVerticalSeparator2;
    private TScrollPane clientScrollPane;
    // client Area To Fill
    private TPanel clientAreaToFillPanel;
    //private TLabel clientSurnameLabel;
    private TTextField clientSurnameField;
    //private TLabel clientNameLabel;
    private TTextField clientNameField;
    private TTextField clientPhoneField;
    private TTextField clientMailField;
    private TTextField clientAdressField;
    private TConfirmButton clientConfirmButton;
    private TConfirmButton clientCancelButton;

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

        fillContractCard();
        fillVehiculeCard();
        fillClientCard();

        cardLayout.show(contentPanel, buttonsName[0]);
    }

    //=============
    // INIT CARDS
    //=============

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

    //=============
    // INIT CARD 0
    //=============

    private void fillContractCard()
    {
        contractArrayList = new ArrayList<String>();

        contractListPanel = new TPanel(300, 615, null, null, new FlowLayout(FlowLayout.LEFT, 0, 0), false);
        cards[0].add(contractListPanel);

        initContractLists();

        contractAreaToFillPanel = new TPanel(690, 616, InterfaceLightColor, null, new FlowLayout(FlowLayout.CENTER, getWidth()/2, 30), true);
        cards[0].add(contractAreaToFillPanel);

        initContractAreasToFill();

    }

    private void initContractLists()
    {
        // Card0
        contractListTitlePanel = new TPanel(285, 30, InterfaceLightColor, WHITE, new FlowLayout(FlowLayout.CENTER), true);
        contractListPanel.add(contractListTitlePanel);
        contractListTitleLabel = new TLabel("Historique des contrats", WHITE);
        contractListTitlePanel.add(contractListTitleLabel);

        contractVerticalSeparator1 = new TPanel(15, 30, InterfaceMainColor, null, null, true);
        contractListPanel.add(contractVerticalSeparator1);

        contractList = new TList(frame, 0);
        contractScrollPane = new TScrollPane(this, 0, contractList, 300,525);

        contractSearchBar = new TSearchBar(frame, 0, "Rechercher un contrat", 285, 30, LIGHTGREY, DARKGREY);
        contractListPanel.add(contractSearchBar);

        contractVerticalSeparator2 = new TPanel(15, 30, InterfaceMainColor, null, null, true);
        contractListPanel.add(contractVerticalSeparator2);

        contractListPanel.add(contractScrollPane);

        contractNewContractButton = new TContentButton(frame, "Nouveau contrat", 285, 30);
        contractListPanel.add(contractNewContractButton);

        contractVerticalSeparator3 = new TPanel(15, 30, InterfaceMainColor, null, null, true);
        contractListPanel.add(contractVerticalSeparator3);
    }

    private void initContractAreasToFill()
    {
        /*contractSurnameLabel = new TLabel("Nom : ", WHITE);
        contractAreaToFillPanel.add(contractSurnameLabel);*/
        contractSurnameField = new TTextField(frame, "Nom", 250, 30, WHITE, BLACK);
        contractAreaToFillPanel.add(contractSurnameField);

        /*contractNameLabel = new TLabel("Prenom : ", WHITE);
        contractAreaToFillPanel.add(contractNameLabel);*/
        contractNameField = new TTextField(frame, "Prenom", 250, 30, WHITE, BLACK);
        contractAreaToFillPanel.add(contractNameField);

        contractNameField = new TTextField(frame, "Telephone", 250, 30, WHITE, BLACK);
        contractAreaToFillPanel.add(contractNameField);
    }

    //=============
    // INIT CARD 2
    //=============

    private void fillVehiculeCard()
    {
        vehicleArrayList = new ArrayList<String>();

        vehicleListPanel = new TPanel(300, 615, null, null, new FlowLayout(FlowLayout.LEFT, 0, 0), false);
        cards[1].add(vehicleListPanel);

        initVehicleLists();

        vehicleAreaToFillPanel = new TPanel(690, 616, InterfaceLightColor, null, new FlowLayout(FlowLayout.CENTER, getWidth()/2, 30), true);
        cards[1].add(vehicleAreaToFillPanel);

        initVehicleAreasToFill();

        cardLayout.show(contentPanel, "Mes contrats");
    }

    private void initVehicleLists()
    {
        // Card0
        vehicleListTitlePanel = new TPanel(285, 30, InterfaceLightColor, WHITE, new FlowLayout(FlowLayout.CENTER), true);
        vehicleListPanel.add(vehicleListTitlePanel);
        vehicleListTitleLabel = new TLabel("Historique des véhicules", WHITE);
        vehicleListTitlePanel.add(vehicleListTitleLabel);

        vehicleVerticalSeparator1 = new TPanel(15, 30, InterfaceMainColor, null, null, true);
        vehicleListPanel.add(vehicleVerticalSeparator1);

        vehicleList = new TList(frame, 1);
        vehicleScrollPane = new TScrollPane(this, 1, vehicleList, 300,525);

        vehicleSearchBar = new TSearchBar(frame, 1, "Rechercher un véhicule", 285, 30, LIGHTGREY, DARKGREY);
        vehicleListPanel.add(vehicleSearchBar);

        vehicleVerticalSeparator2 = new TPanel(15, 30, InterfaceMainColor, null, null, true);
        vehicleListPanel.add(vehicleVerticalSeparator2);

        vehicleListPanel.add(vehicleScrollPane);

        vehicleNewvehicleButton = new TContentButton(frame, "Nouveau véhicule", 285, 30);
        vehicleListPanel.add(vehicleNewvehicleButton);

        vehicleVerticalSeparator3 = new TPanel(15, 30, InterfaceMainColor, null, null, true);
        vehicleListPanel.add(vehicleVerticalSeparator3);
    }

    private void initVehicleAreasToFill()
    {
        /*vehicleSurnameLabel = new TLabel("Nom : ", WHITE);
        vehicleAreaToFillPanel.add(vehicleSurnameLabel);*/
        vehicleSurnameField = new TTextField(frame, "Marque", 250, 30, WHITE, BLACK);
        vehicleAreaToFillPanel.add(vehicleSurnameField);

        /*vehicleNameLabel = new TLabel("Prenom : ", WHITE);
        vehicleAreaToFillPanel.add(vehicleNameLabel);*/
        vehicleNameField = new TTextField(frame, "Modèle", 250, 30, WHITE, BLACK);
        vehicleAreaToFillPanel.add(vehicleNameField);

        vehicleNameField = new TTextField(frame, "Prix par jour", 250, 30, WHITE, BLACK);
        vehicleAreaToFillPanel.add(vehicleNameField);
    }

    //=============
    // INIT CARD 3
    //=============

    private void fillClientCard()
    {
        clientArrayList = new ArrayList<String>();
        clientArrayList.add("TEXT1");
        clientArrayList.add("TEXT2");
        clientArrayList.add("TEXT3");
        clientArrayList.add("TEXT4");

        clientListPanel = new TPanel(300, 615, null, null, new FlowLayout(FlowLayout.LEFT, 0, 0), false);
        cards[2].add(clientListPanel);

        initClientLists();

        clientAreaToFillPanel = new TPanel(690, 616, InterfaceLightColor, null, new FlowLayout(FlowLayout.CENTER, getWidth()/2, 30), true);
        cards[2].add(clientAreaToFillPanel);

        initClientAreasToFill();
    }

    private void initClientLists()
    {
        // Card0
        clientListTitlePanel = new TPanel(285, 30, InterfaceLightColor, WHITE, new FlowLayout(FlowLayout.CENTER), true);
        clientListPanel.add(clientListTitlePanel);
        clientListTitleLabel = new TLabel("Liste des clients", WHITE);
        clientListTitlePanel.add(clientListTitleLabel);

        clientVerticalSeparator1 = new TPanel(15, 30, InterfaceMainColor, null, null, true);
        clientListPanel.add(clientVerticalSeparator1);

        clientList = new TList(frame, 2);
        clientScrollPane = new TScrollPane(this, 2, clientList, 300,525);

        clientSearchBar = new TSearchBar(frame, 2, "Rechercher un client", 285, 30, LIGHTGREY, DARKGREY);
        clientListPanel.add(clientSearchBar);

        clientVerticalSeparator2 = new TPanel(15, 30, InterfaceMainColor, null, null, true);
        clientListPanel.add(clientVerticalSeparator2);

        clientListPanel.add(clientScrollPane);

        clientNewclientButton = new TContentButton(frame, "Nouveau client", 285, 30);
        clientListPanel.add(clientNewclientButton);

        clientVerticalSeparator3 = new TPanel(15, 30, InterfaceMainColor, null, null, true);
        clientListPanel.add(clientVerticalSeparator3);
    }

    private void initClientAreasToFill()
    {
        /*clientSurnameLabel = new TLabel("Nom : ", WHITE);
        clientAreaToFillPanel.add(clientSurnameLabel);*/
        clientSurnameField = new TTextField(frame, "Nom", 250, 30, WHITE, BLACK);
        clientAreaToFillPanel.add(clientSurnameField);

        /*clientNameLabel = new TLabel("Prenom : ", WHITE);
        clientAreaToFillPanel.add(clientNameLabel);*/
        clientNameField = new TTextField(frame, "Prenom", 250, 30, WHITE, BLACK);
        clientAreaToFillPanel.add(clientNameField);

        clientPhoneField = new TTextField(frame, "Telephone", 250, 30, WHITE, BLACK);
        clientAreaToFillPanel.add(clientPhoneField);

        clientMailField = new TTextField(frame, "E-mail", 250, 30, WHITE, BLACK);
        clientAreaToFillPanel.add(clientMailField);

        clientAdressField = new TTextField(frame, "Adresse", 250, 30, WHITE, BLACK);
        clientAreaToFillPanel.add(clientAdressField);

        clientConfirmButton = new TConfirmButton(frame, 2, "Confirmer", 250, 30);
        clientAreaToFillPanel.add(clientConfirmButton);
        clientCancelButton = new TConfirmButton(frame, 2, "Annuler", 250, 30);
        clientAreaToFillPanel.add(clientCancelButton);
    }

    //=============
    // GETTERS
    //=============

    public TFrame getFrame() {
        return frame;
    }
    public TPanel getContentPanel() {
        return contentPanel;
    }

    public CardLayout getCardLayout() {
        return cardLayout;
    }

    // TLIST GETTERS

    public TList getContractList()
    {
        return contractList;
    }

    public TList getVehicleList()
    {
        return vehicleList;
    }
    public TList getClientList()
    {
        return clientList;
    }

    // SCROLLPAN GETTERS

    public TScrollPane getContractScrollPane()
    {
        return contractScrollPane;
    }

    public TScrollPane getVehicleScrollPane()
    {
        return vehicleScrollPane;
    }

    public TScrollPane getClientScrollPane()
    {
        return clientScrollPane;
    }

    // ARRAYLIST GETTERS

    public ArrayList<String> getContractArrayList()
    {
        return contractArrayList;
    }

    public ArrayList<String> getVehicleArrayList()
    {
        return vehicleArrayList;
    }

    public ArrayList<String> getClientArrayList()
    {
        return clientArrayList;
    }

    // TEXTFIELD ADD NEW CLIENT

    public TTextField getClientSurnameField() {
        return clientSurnameField;
    }

    public TTextField getClientNameField() {
        return clientNameField;
    }
}