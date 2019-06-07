package GUI;
import Class.*;
import Interface.*;

import javax.swing.*;
import java.awt.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class TFrame extends JFrame implements Definition
{
    //=============
    // VARIABLES
    //=============

    static int contractID = 0;
    static int vehicleID = 0;
    static int clientID = 0;

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
    private TPanel contractListPanel;
    private TPanel contractListContent;
    private TPanel contractListTitlePanel;
    private TLabel contractListTitleLabel;
    private TPanel contractVerticalSeparator;
    private TContentButton contractNewContractButton;
    private TList contractList;
    private TSearchBar contractSearchBar;
    private TScrollPane contractScrollPane;
    // Contract Area To Fill
    private CardLayout contractAreaLayout;
    private TPanel contractAreaToFillPanel;

    private TPanel contractTextFieldArea;
    private TPanel contractEmpty;
    private TTextField contractClientField;
    private TTextField contractVehicleField;
    private TTextField contractEstimatedKm;
    private TDateField contractBeginningField;
    private TDateField contractEndingField;
    private TCheckBox contractHasReduction;
    private TLabel contractPriceField;
    private TConfirmButton contractConfirmButton;
    private TConfirmButton contractCancelButton;

    private TPanel contractDeletePanel;
    private TConfirmButton contractConfirmDeleteButton;
    private TConfirmButton contractCancelDeleteButton;

    // Contract Panel : Card[1]
    // List
    private TPanel vehicleListPanel;
    private TPanel vehicleListContent;
    private TPanel vehicleListTitlePanel;
    private TLabel vehicleListTitleLabel;
    private TPanel vehicleVerticalSeparator;
    private TContentButton vehicleNewVehicleButton;
    private TList vehicleList;
    private TSearchBar vehicleSearchBar;
    private TScrollPane vehicleScrollPane;
    // vehicle Area To Fill
    private CardLayout vehicleAreaLayout;
    private TPanel vehicleAreaToFillPanel;

    private TPanel vehicleTextFieldArea;
    private TPanel vehicleEmpty;
    private TTextField vehicleBrandField;
    private TTextField vehicleModelField;
    private TTextField vehicleDailyPriceField;
    private TTextField vehicleMaxSpeedField;
    private TTextField vehicleStateField;
    private TTextField vehicleOdometerField;
    private TTextField vehiclePowerField;
    private TTextField vehicleNbSeatField;
    private TConfirmButton vehicleConfirmButton;
    private TConfirmButton vehicleCancelButton;

    private TPanel vehicleDeletePanel;
    private TConfirmButton vehicleConfirmDeleteButton;
    private TConfirmButton vehicleCancelDeleteButton;

    // Class.Client Panel : Card[2]
    // List
    private TPanel clientListPanel;
    private TPanel clientListContent;
    private TPanel clientListTitlePanel;
    private TLabel clientListTitleLabel;
    private TPanel clientVerticalSeparator;
    private TContentButton clientNewclientButton;
    private TList clientList;
    private TSearchBar clientSearchBar;
    private TScrollPane clientScrollPane;
    // client Area To Fill
    private CardLayout clientAreaLayout;
    private TPanel clientAreaToFillPanel;

    private TPanel clientTextFieldArea;
    private TPanel clientEmpty;
    private TTextField clientSurnameField;
    private TTextField clientNameField;
    private TTextField clientPhoneField;
    private TTextField clientMailField;
    private TTextField clientAdressField;
    private TConfirmButton clientConfirmButton;
    private TConfirmButton clientCancelButton;

    private TPanel clientDeletePanel;
    private TConfirmButton clientConfirmDeleteButton;
    private TConfirmButton clientCancelDeleteButton;

    // Lists
    private ArrayList<ParcAgent> clients;
    private ArrayList<ParcAgent> vehicles;
    private ArrayList<ParcAgent> contracts;
    private TPanel contractListsArea;
    private TList vehicleContractList;
    private TScrollPane vehicleContractScrollPane;

    public TList getVehicleContractList() {
        return vehicleContractList;
    }

    public TScrollPane getVehicleContractScrollPane() {
        return vehicleContractScrollPane;
    }

    private TList clientContractList;
    private TScrollPane clientContractScrollPane;

    //=============
    // CONSTRUCTOR
    //=============

    public TFrame()
    {
        super();

        initFrame();

        Gestionnaire.initArrayList();

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

    private void initArrayLists()
    {
    }

    private void initFramePanel()
    {
        mainPanel = new TPanel(1000,700, null, null, new BorderLayout(0,0), false);
        this.setContentPane(mainPanel);

        TPanel pRightBorder = new TPanel(5, 615, Definition.InterfaceMainColor, null, null, true);
        mainPanel.add(pRightBorder, BorderLayout.EAST);

        TPanel pLeftBorder = new TPanel(5, 615, Definition.InterfaceMainColor, null, null, true);
        mainPanel.add(pLeftBorder, BorderLayout.WEST);

        TPanel pBottomBorder = new TPanel(600, 5, Definition.InterfaceMainColor, null, null, true);
        mainPanel.add(pBottomBorder, BorderLayout.PAGE_END);
    }

    private void initMenu()
    {
        pTop = new TMotionPanel(this, 1000,80, Definition.InterfaceMainColor, null,
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
            buttons[i] = new TMenuButton(frame, Definition.buttonsName[i]);
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

        fillVehiculeCard();
        fillClientCard();
        fillContractCard();

        cardLayout.show(contentPanel, Definition.buttonsName[0]);
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
            contentPanel.add(cards[i], Definition.buttonsName[i]);
        }
    }

    //=============
    // INIT CARD 0
    //=============

    private void fillContractCard()
    {
        contractListPanel = new TPanel(300, 615, null, null, new FlowLayout(FlowLayout.LEFT, 0, 0), false);
        cards[0].add(contractListPanel);

        contractAreaLayout = new CardLayout();
        contractAreaToFillPanel = new TPanel(690, 616, Definition.InterfaceLightColor, null, contractAreaLayout, true);

        initContractLists();

        cards[0].add(contractAreaToFillPanel);

        initContractAreasToFill();
    }

    private void initContractLists()
    {
        // Card0
        contractListContent = new TPanel(295, 615, null, null, new FlowLayout(FlowLayout.LEFT, 0, 0), false);
        contractListPanel.add(contractListContent);

        contractVerticalSeparator = new TPanel(5, 615, Definition.InterfaceMainColor, null, null, true);
        contractListPanel.add(contractVerticalSeparator);

        contractListTitlePanel = new TPanel(295, 30, Definition.InterfaceLightColor, Definition.WHITE, new FlowLayout(FlowLayout.CENTER), true);
        contractListContent.add(contractListTitlePanel);
        contractListTitleLabel = new TLabel("Historique des contrats", Definition.WHITE);
        contractListTitlePanel.add(contractListTitleLabel);

        contractList = new TList(frame, 0);
        contractScrollPane = new TScrollPane(this, 0, contractList, 295,525);

        contractSearchBar = new TSearchBar(frame, 0, "Rechercher un contrat", 295, 30, Definition.LIGHTGREY, Definition.DARKGREY);
        contractListContent.add(contractSearchBar);

        contractListContent.add(contractScrollPane);

        contractNewContractButton = new TContentButton(frame, 0, "Nouveau contrat", 295, 30);
        contractListContent.add(contractNewContractButton);
    }

    public TCheckBox getContractHasReduction() {
        return contractHasReduction;
    }

    public TDateField getContractBeginningField() {
        return contractBeginningField;
    }

    public TDateField getContractEndingField() {
        return contractEndingField;
    }

    public TList getClientContractList() {
        return clientContractList;
    }

    public TScrollPane getClientContractScrollPane() {
        return clientContractScrollPane;
    }

    private void initContractAreasToFill()
    {
        // Empty Panel
        contractEmpty = new TPanel(690, 616, Definition.InterfaceLightColor, null, null, true);
        contractAreaToFillPanel.add(contractEmpty, Definition.areaTofillCardName[0]);

        // TextField Panel
        TPanel t = new TPanel(690, 616, null, null, new FlowLayout(0, 0, 0), false);
        contractAreaToFillPanel.add(t, Definition.areaTofillCardName[1]);

        vehicleContractList = new TList(frame, 3);
        vehicleContractScrollPane = new TScrollPane(this, 1, vehicleContractList, 295,247);

        clientContractList = new TList(frame, 4);
        clientContractScrollPane = new TScrollPane(this, 2, clientContractList, 295,247);

        contractTextFieldArea = new TPanel(390, 616, Definition.InterfaceLightColor, null, new FlowLayout(FlowLayout.CENTER, 195, 15), true);
        t.add(contractTextFieldArea);

        TPanel CenterPanel1 = new TPanel(500, ((int)contractTextFieldArea.getPreferredSize().getHeight()-6*30-7*15)/2, null, null, null, false);
        contractTextFieldArea.add(CenterPanel1);

        contractBeginningField = new TDateField(frame, "Début : DD/MM/YYYY", 250, 30, Definition.WHITE, Definition.BLACK, true);
        contractTextFieldArea.add(contractBeginningField);

        contractEndingField = new TDateField(frame, "Fin : DD/MM/YYYY", 250, 30, Definition.WHITE, Definition.BLACK, false);
        contractTextFieldArea.add(contractEndingField);

        contractBeginningField.setOtherDate();
        contractEndingField.setOtherDate();

        contractEstimatedKm = new TTextField(frame, "KM estimés", 250, 30, Definition.WHITE, Definition.BLACK);
        contractTextFieldArea.add(contractEstimatedKm);

        contractHasReduction = new TCheckBox("Réduction -10% ?");
        contractTextFieldArea.add(contractHasReduction);

        contractBeginningField.setReduc();
        contractEndingField.setReduc();

        contractConfirmButton = new TConfirmButton(frame, 0, "Confirmer", 250, 30, contractClientField, contractVehicleField, contractBeginningField, contractEndingField, contractEstimatedKm);
        contractTextFieldArea.add(contractConfirmButton);

        contractCancelButton = new TConfirmButton(frame, 0, "Annuler", 250, 30);
        contractTextFieldArea.add(contractCancelButton);

        // Lists + Bar Panel
        TPanel locListBarPanel = new TPanel(300, 616, null, null, new FlowLayout(FlowLayout.CENTER, 0, 0), false);
        t.add(locListBarPanel);
        locListBarPanel.add(new TPanel(5, 615, Definition.InterfaceMainColor, null, null, true));
        // Lists Panel
        contractListsArea = new TPanel(295, 616, null, null, new FlowLayout(FlowLayout.CENTER, 0, 0), false);
        locListBarPanel.add(contractListsArea);

        // Vehicle List Panel
        TPanel locVehicleListContent = new TPanel(295, 308, null, null, new FlowLayout(FlowLayout.LEFT, 0, 0), false);
        contractListsArea.add(locVehicleListContent);

        TPanel locVehicleListTitlePanel = new TPanel(295, 30, Definition.InterfaceLightColor, Definition.WHITE, new FlowLayout(FlowLayout.CENTER), true);
        locVehicleListContent.add(locVehicleListTitlePanel);
        TLabel locVehicleListTitleLabel = new TLabel("Liste des véhicules", Definition.WHITE);
        locVehicleListTitlePanel.add(locVehicleListTitleLabel);
        
        TSearchBar locVehicleSearchBar = new TSearchBar(frame, 3, "Rechercher un véhicule", 295, 30, Definition.LIGHTGREY, Definition.DARKGREY);
        
        locVehicleListContent.add(locVehicleSearchBar);
        locVehicleListContent.add(vehicleContractScrollPane);

        // Client List Panel
        TPanel locClientListContent = new TPanel(295, 308, null, null, new FlowLayout(FlowLayout.LEFT, 0, 0), false);
        contractListsArea.add(locClientListContent);

        TPanel locClientListTitlePanel = new TPanel(295, 30, Definition.InterfaceLightColor, Definition.WHITE, new FlowLayout(FlowLayout.CENTER), true);
        locClientListContent.add(locClientListTitlePanel);
        TLabel locClientListTitleLabel = new TLabel("Liste des clients", Definition.WHITE);
        locClientListTitlePanel.add(locClientListTitleLabel);

        TSearchBar locClientSearchBar = new TSearchBar(frame, 4, "Rechercher un client", 295, 30, Definition.LIGHTGREY, Definition.DARKGREY);
        
        locClientListContent.add(locClientSearchBar);
        locClientListContent.add(clientContractScrollPane);

        // Delete Panel
        contractDeletePanel = new TPanel(690, 616, Definition.InterfaceLightColor, null, new FlowLayout(FlowLayout.CENTER, getWidth()/2, 15), true);
        contractAreaToFillPanel.add(contractDeletePanel, Definition.areaTofillCardName[2]);

        TPanel CenterPanel2 = new TPanel(500, ((int)contractTextFieldArea.getPreferredSize().getHeight()-2*30-4*15)/2, null, null, null, false);
        contractDeletePanel.add(CenterPanel2);

        contractConfirmDeleteButton = new TConfirmButton(frame, 0, "Supprimer", 250, 30);
        contractDeletePanel.add(contractConfirmDeleteButton);
        contractCancelDeleteButton = new TConfirmButton(frame, 0, "Retour", 250, 30);
        contractDeletePanel.add(contractCancelDeleteButton);

        contractAreaLayout.show(contractAreaToFillPanel, Definition.areaTofillCardName[0]);
    }

    //=============
    // INIT CARD 2
    //=============

    private void fillVehiculeCard()
    {
        vehicleListPanel = new TPanel(300, 615, null, null, new FlowLayout(FlowLayout.LEFT, 0, 0), false);
        cards[1].add(vehicleListPanel);

        vehicleAreaLayout = new CardLayout();
        vehicleAreaToFillPanel = new TPanel(690, 616, Definition.InterfaceLightColor, null, vehicleAreaLayout, true);

        initVehicleLists();

        cards[1].add(vehicleAreaToFillPanel);

        initVehicleAreasToFill();
    }

    private void initVehicleLists()
    {
        // Card0
        vehicleListContent = new TPanel(295, 615, null, null, new FlowLayout(FlowLayout.LEFT, 0, 0), false);
        vehicleListPanel.add(vehicleListContent);

        vehicleVerticalSeparator = new TPanel(5, 615, Definition.InterfaceMainColor, null, null, true);
        vehicleListPanel.add(vehicleVerticalSeparator);

        vehicleListTitlePanel = new TPanel(295, 30, Definition.InterfaceLightColor, Definition.WHITE, new FlowLayout(FlowLayout.CENTER), true);
        vehicleListContent.add(vehicleListTitlePanel);
        vehicleListTitleLabel = new TLabel("Historique des véhicules", Definition.WHITE);
        vehicleListTitlePanel.add(vehicleListTitleLabel);

        vehicleList = new TList(frame, 1);
        vehicleScrollPane = new TScrollPane(this, 1, vehicleList, 295,525);

        vehicleSearchBar = new TSearchBar(frame, 1, "Rechercher un véhicule", 295, 30, Definition.LIGHTGREY, Definition.DARKGREY);
        vehicleListContent.add(vehicleSearchBar);

        vehicleListContent.add(vehicleScrollPane);

        vehicleNewVehicleButton = new TContentButton(frame, 1, "Nouveau véhicule", 295, 30);
        vehicleListContent.add(vehicleNewVehicleButton);

    }

    private void initVehicleAreasToFill()
    {
        // Empty Panel
        vehicleEmpty = new TPanel(690, 616, Definition.InterfaceLightColor, null, null, true);
        vehicleAreaToFillPanel.add(vehicleEmpty, Definition.areaTofillCardName[0]);

        // TextField Panel
        vehicleTextFieldArea = new TPanel(690, 616, Definition.InterfaceLightColor, null, new FlowLayout(FlowLayout.CENTER, getWidth()/2, 15), true);
        vehicleAreaToFillPanel.add(vehicleTextFieldArea, Definition.areaTofillCardName[1]);

        TPanel CenterPanel = new TPanel(500, ((int)vehicleTextFieldArea.getPreferredSize().getHeight()-11*30-12*15)/2, null, null, null, false);
        vehicleTextFieldArea.add(CenterPanel);

        vehicleBrandField = new TTextField(frame, "Marque", 250, 30, Definition.WHITE, Definition.BLACK);
        vehicleTextFieldArea.add(vehicleBrandField);

        vehicleModelField = new TTextField(frame, "Modèle", 250, 30, Definition.WHITE, Definition.BLACK);
        vehicleTextFieldArea.add(vehicleModelField);

        vehicleDailyPriceField = new TTextField(frame, "Prix journalier", 250, 30, Definition.WHITE, Definition.BLACK);
        vehicleTextFieldArea.add(vehicleDailyPriceField);

        vehicleMaxSpeedField = new TTextField(frame, "Vitesse maximale", 250, 30, Definition.WHITE, Definition.BLACK);
        vehicleTextFieldArea.add(vehicleMaxSpeedField);

        vehicleStateField = new TTextField(frame, "Etat du véhicule", 250, 30, Definition.WHITE, Definition.BLACK);
        vehicleTextFieldArea.add(vehicleStateField);

        vehicleOdometerField = new TTextField(frame, "Distance déjà parcourue", 250, 30, Definition.WHITE, Definition.BLACK);
        vehicleTextFieldArea.add(vehicleOdometerField);

        vehiclePowerField = new TTextField(frame, "Puissance", 250, 30, Definition.WHITE, Definition.BLACK);
        vehicleTextFieldArea.add(vehiclePowerField);

        vehicleNbSeatField = new TTextField(frame, "Nombre de places", 250, 30, Definition.WHITE, Definition.BLACK);
        vehicleTextFieldArea.add(vehicleNbSeatField);

        vehicleConfirmButton = new TConfirmButton(frame, 1, "Confirmer", 250, 30, vehicleBrandField, vehicleModelField, vehicleDailyPriceField,
                vehicleMaxSpeedField, vehicleStateField, vehicleOdometerField, vehiclePowerField, vehicleNbSeatField);
        vehicleTextFieldArea.add(vehicleConfirmButton);

        vehicleCancelButton = new TConfirmButton(frame, 1, "Annuler", 250, 30);
        vehicleTextFieldArea.add(vehicleCancelButton);

        // Delete Panel
        vehicleDeletePanel = new TPanel(690, 616, Definition.InterfaceLightColor, null, new FlowLayout(FlowLayout.CENTER, getWidth()/2, 15), true);
        vehicleAreaToFillPanel.add(vehicleDeletePanel, Definition.areaTofillCardName[2]);

        TPanel CenterPanel2 = new TPanel(500, ((int)vehicleTextFieldArea.getPreferredSize().getHeight()-2*30-4*15)/2, null, null, null, false);
        vehicleDeletePanel.add(CenterPanel2);

        vehicleConfirmDeleteButton = new TConfirmButton(frame, 1, "Supprimer", 250, 30);
        vehicleDeletePanel.add(vehicleConfirmDeleteButton);
        vehicleCancelDeleteButton = new TConfirmButton(frame, 1, "Retour", 250, 30);
        vehicleDeletePanel.add(vehicleCancelDeleteButton);

        vehicleAreaLayout.show(vehicleAreaToFillPanel, Definition.areaTofillCardName[0]);
    }

    //=============
    // INIT CARD 3
    //=============

    private void fillClientCard()
    {
        clientListPanel = new TPanel(300, 615, null, null, new FlowLayout(FlowLayout.LEFT, 0, 0), false);
        cards[2].add(clientListPanel);

        clientAreaLayout = new CardLayout();
        clientAreaToFillPanel = new TPanel(690, 616, Definition.InterfaceLightColor, null, clientAreaLayout, true);

        initClientLists();

        cards[2].add(clientAreaToFillPanel);

        initClientAreasToFill();
    }

    private void initClientLists()
    {
        // Card0
        clientListContent = new TPanel(295, 615, null, null, new FlowLayout(FlowLayout.LEFT, 0, 0), false);
        clientListPanel.add(clientListContent);

        clientVerticalSeparator = new TPanel(5, 615, Definition.InterfaceMainColor, null, null, true);
        clientListPanel.add(clientVerticalSeparator);

        clientListTitlePanel = new TPanel(295, 30, Definition.InterfaceLightColor, Definition.WHITE, new FlowLayout(FlowLayout.CENTER), true);
        clientListContent.add(clientListTitlePanel);
        clientListTitleLabel = new TLabel("Liste des clients", Definition.WHITE);
        clientListTitlePanel.add(clientListTitleLabel);

        clientList = new TList(frame, 2);
        clientScrollPane = new TScrollPane(this, 2, clientList, 295,525);

        clientSearchBar = new TSearchBar(frame, 2, "Rechercher un client", 295, 30, Definition.LIGHTGREY, Definition.DARKGREY);
        clientListContent.add(clientSearchBar);

        clientListContent.add(clientScrollPane);

        clientNewclientButton = new TContentButton(frame, 2, "Nouveau client", 295, 30);
        clientListContent.add(clientNewclientButton);
    }

    private void initClientAreasToFill()
    {
        // Empty Panel
        clientEmpty = new TPanel(690, 616, Definition.InterfaceLightColor, null, null, true);
        clientAreaToFillPanel.add(clientEmpty, Definition.areaTofillCardName[0]);

        // TextField Panel
        clientTextFieldArea = new TPanel(690, 616, Definition.InterfaceLightColor, null, new FlowLayout(FlowLayout.CENTER, getWidth()/2, 15), true);
        clientAreaToFillPanel.add(clientTextFieldArea, Definition.areaTofillCardName[1]);

        TPanel CenterPanel = new TPanel(500, ((int)clientTextFieldArea.getPreferredSize().getHeight()-7*30-8*15)/2, null, null, null, false);
        clientTextFieldArea.add(CenterPanel);

        /*clientSurnameLabel = new GUI.TLabel("Nom : ", WHITE);
        clientAreaToFillPanel.add(clientSurnameLabel);*/
        clientSurnameField = new TTextField(frame, "Nom", 250, 30, Definition.WHITE, Definition.BLACK);
        clientTextFieldArea.add(clientSurnameField);

        clientNameField = new TTextField(frame, "Prenom", 250, 30, Definition.WHITE, Definition.BLACK);
        clientTextFieldArea.add(clientNameField);

        clientPhoneField = new TTextField(frame, "Telephone", 250, 30, Definition.WHITE, Definition.BLACK);
        clientTextFieldArea.add(clientPhoneField);

        clientMailField = new TTextField(frame, "E-mail", 250, 30, Definition.WHITE, Definition.BLACK);
        clientTextFieldArea.add(clientMailField);

        clientAdressField = new TTextField(frame, "Adresse", 250, 30, Definition.WHITE, Definition.BLACK);
        clientTextFieldArea.add(clientAdressField);

        clientConfirmButton = new TConfirmButton(frame, 2, "Confirmer", 250, 30, clientSurnameField, clientNameField, clientPhoneField, clientMailField, clientAdressField);
        clientTextFieldArea.add(clientConfirmButton);
        clientCancelButton = new TConfirmButton(frame, 2, "Annuler", 250, 30);
        clientTextFieldArea.add(clientCancelButton);

        // Delete Panel
        clientDeletePanel = new TPanel(690, 616, Definition.InterfaceLightColor, null, new FlowLayout(FlowLayout.CENTER, getWidth()/2, 15), true);
        clientAreaToFillPanel.add(clientDeletePanel, Definition.areaTofillCardName[2]);

        TPanel CenterPanel2 = new TPanel(500, ((int)clientTextFieldArea.getPreferredSize().getHeight()-2*30-4*15)/2, null, null, null, false);
        clientDeletePanel.add(CenterPanel2);

        clientConfirmDeleteButton = new TConfirmButton(frame, 2, "Supprimer", 250, 30);
        clientDeletePanel.add(clientConfirmDeleteButton);
        clientCancelDeleteButton = new TConfirmButton(frame, 2, "Retour", 250, 30);
        clientDeletePanel.add(clientCancelDeleteButton);

        clientAreaLayout.show(clientAreaToFillPanel, Definition.areaTofillCardName[0]);
    }

    //=============
    // PUBLICS FUNCTIONS
    //=============

    public void AddPanelToChangePanel(int whichMenu, int index)
    {
        switch (whichMenu)
        {
            case 0:
                contractConfirmButton.setName("Modifier");
                break;
            case 1:
                vehicleConfirmButton.setName("Modifier");
                System.out.println(vehicleConfirmButton.getName());

                for (int i = 0; i < Gestionnaire.getVehicules().size(); i++) {
                    Vehicule v = (Vehicule) Gestionnaire.getVehicules().get(i);

                    if (v.getId() == Integer.parseInt((vehicleList.getModel().getElementAt(index).toString().split(" - ")[0])))
                    {
                        vehicleBrandField.setHint(v.getMarque());
                        vehicleModelField.setHint(v.getModele());
                        vehicleDailyPriceField.setHint(""+v.getPrixJournalier());
                        vehicleMaxSpeedField.setHint(""+v.getVitesseMax());
                        vehicleStateField.setHint(v.getEtat());
                        vehicleOdometerField.setHint("0");
                        vehiclePowerField.setHint("0");
                        vehicleNbSeatField.setHint("0");

                        vehicleBrandField.focusLost();
                        vehicleModelField.focusLost();
                        vehicleDailyPriceField.focusLost();
                        vehicleMaxSpeedField.focusLost();
                        vehicleStateField.focusLost();
                        vehicleOdometerField.focusLost();
                        vehiclePowerField.focusLost();
                        vehicleNbSeatField.focusLost();
                    }
                }
                break;
            case 2:
                clientConfirmButton.setName("Modifier");
                break;
        }
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

    public CardLayout getContractAreaLayout()
    {
        //System.out.println((contractAreaLayout==null)+"");
        return contractAreaLayout;
    }

    public CardLayout getVehicleAreaLayout()
    {
        return vehicleAreaLayout;
    }

    public CardLayout getClientAreaLayout()
    {
        return clientAreaLayout;
    }

    public TPanel getContractAreaToFillPanel()
    {
        return contractAreaToFillPanel;
    }
    public TPanel getVehicleAreaToFillPanel()
    {
        return vehicleAreaToFillPanel;
    }

    public TPanel getClientAreaToFillPanel()
    {
        return clientAreaToFillPanel;
    }

    // TLIST GETTERS

    public TList getContractTList()
    {
        return contractList;
    }
    public TList getVehicleTList()
    {
        return vehicleList;
    }
    public TList getClientTList()
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

    /*public ArrayList<ParcAgent> getContractArrayList()
    {
        return contracts;
    }

    public ArrayList<ParcAgent> getVehicleArrayList()
    {
        return vehicles;
    }

    public ArrayList<ParcAgent> getClientArrayList()
    {
        return clients;
    }*/

    // TEXTFIELD ADD NEW CLIENT

    public TTextField getClientSurnameField() {
        return clientSurnameField;
    }

    public TTextField getClientNameField()
    {
        return clientNameField;
    }
}