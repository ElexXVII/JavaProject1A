package GUI;
import Class.*;
import Interface.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TConfirmButton extends TFlatButton implements Definition, ActionListener
{
    TFrame frame;

    String name;
    private final int whichMenu;
    int id;
    TScrollPane scrollPane;
    TList tlist;

    TScrollPane contractVehicleScrollPane;
    TScrollPane contractClientScrollPane;

    ArrayList list;

    TTextField[] textFields;

    TPanel areaToFillCardPanel;
    CardLayout cardLayout;

    public TConfirmButton(TFrame frame, int whichMenu, String text, int x, int y, TTextField... textFields)
    {
        super(text);

        this.frame = frame;
        this.whichMenu = whichMenu;
        this.textFields = textFields;
        this.name = text;
        this.setPreferredSize(new Dimension(x, y));
        this.setForeground(Definition.WHITE);
        this.setFont(Definition.menuFont);

        contractVehicleScrollPane = frame.getVehicleContractScrollPane();
        contractClientScrollPane = frame.getClientContractScrollPane();

        super.setBorderPainted(false);
        super.setFocusPainted(false);
        super.setContentAreaFilled(false);

        this.addActionListener(this);

        idleColor = Definition.idleButtonLightColor;

        if (text.equals("Annuler") || text.equals("Supprimer"))
        {
            hoverColor = Definition.hoverCrossColor;
            pressColor = Definition.pressCrossColor;
        }
        else
        {
            hoverColor = Definition.hoverButtonLightColor;
            pressColor = Definition.pressButtonLightColor;
        }

        switch(whichMenu)
        {
            case 0:
                scrollPane = frame.getContractScrollPane();
                tlist = frame.getContractTList();
                list = Gestionnaire.getContrats();
                id = frame.contractID;

                areaToFillCardPanel = frame.getContractAreaToFillPanel();
                cardLayout = frame.getContractAreaLayout();
                break;
            case 1:
                scrollPane = frame.getVehicleScrollPane();
                tlist = frame.getVehicleTList();
                list = Gestionnaire.getVehicules();
                id = frame.vehicleID;

                areaToFillCardPanel = frame.getVehicleAreaToFillPanel();
                cardLayout = frame.getVehicleAreaLayout();
                break;
            case 2:
                scrollPane = frame.getClientScrollPane();
                tlist = frame.getClientTList();
                list = Gestionnaire.getClients();
                id = frame.clientID;

                areaToFillCardPanel = frame.getClientAreaToFillPanel();
                cardLayout = frame.getClientAreaLayout();
                break;
        }
    }

    @Override
    public void paint(Graphics g)
    {
        if (getModel().isPressed())
        {
            g.setColor(pressColor);
        }
        else if (getModel().isRollover())
        {
            g.setColor(hoverColor);
        }
        else
        {
            g.setColor(idleColor);
        }

        Graphics2D g2 = (Graphics2D)g;
        RenderingHints rh = new RenderingHints(
                RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);
        g2.setRenderingHints(rh);

        g2.fillRect(0, 0, getWidth(), getHeight());

        g2.setColor(new Color(0xFFFFFF));
        //g2.fillRect(0, 0, 1, getHeight());
        //g2.fillRect(getWidth()-1, 0, getWidth(), getHeight());

        super.paintComponent(g);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (name.equals("Annuler") || name.equals("Retour"))
        {
            cardLayout.show(areaToFillCardPanel, Definition.areaTofillCardName[0]);
        }
        else if (name.equals("Supprimer"))
        {
            int index = tlist.getSelectedIndex();

            switch (whichMenu)
            {
                case 0:
                    for (int i = 0; i < list.size(); i++) {
                        Contrat c = (Contrat) list.get(i);

                        if (c.getId() == Integer.parseInt((tlist.getModel().getElementAt(index).toString().split(" - ")[0]))) {
                            list.remove(i);
                        }
                    }
                    break;
                case 1:
                    for (int i = 0; i < list.size(); i++) {
                        Vehicule v = (Vehicule) list.get(i);

                        if (v.getId() == Integer.parseInt((tlist.getModel().getElementAt(index).toString().split(" - ")[0]))) {
                            list.remove(i);
                        }
                    }
                    break;
                case 2:
                    for (int i = 0; i < list.size(); i++) {
                        Client c = (Client) list.get(i);

                        if (c.getId() == Integer.parseInt((tlist.getModel().getElementAt(index).toString().split(" - ")[0]))) {
                            list.remove(i);
                        }
                    }
                    break;
            }

            scrollPane.delElement((DefaultListModel<String>) tlist.getModel(), index);
            switch (whichMenu) {
                case 1:
                    frame.getClientContractScrollPane().delElement((DefaultListModel<String>) frame.getVehicleContractList().getModel(), index);
                    break;
                case 2:
                    frame.getClientContractScrollPane().delElement((DefaultListModel<String>) frame.getClientContractList().getModel(), index);
                    break;
            }
            Gestionnaire.sauvegarder();
            cardLayout.show(areaToFillCardPanel, Definition.areaTofillCardName[0]);
        }
        else if (name.equals("Modifier"))
        {
            int index = tlist.getSelectedIndex();

            switch (whichMenu)
            {
                case 0:
                    for (int i = 0; i < list.size(); i++) {
                        Contrat c = (Contrat) list.get(i);

                        if (c.getId() == Integer.parseInt((tlist.getModel().getElementAt(index).toString().split(" - ")[0]))) {
                            //list.remove(i);
                        }
                    }
                    break;
                case 1:
                    for (int i = 0; i < list.size(); i++) {
                        Vehicule v = (Vehicule) list.get(i);

                        if (v.getId() == Integer.parseInt((tlist.getModel().getElementAt(index).toString().split(" - ")[0]))) {
                            System.out.println(index+" "+Integer.parseInt((tlist.getModel().getElementAt(index).toString().split(" - ")[0]))+ " "+v.getId());
                            list.set(i, new Voiture(textFields[0].getHintOrText(), textFields[1].getHintOrText(), Float.parseFloat(textFields[2].getHintOrText()),
                                    Float.parseFloat(textFields[3].getHintOrText()), textFields[4].getHintOrText(), Integer.parseInt(textFields[5].getHintOrText()),
                                    Float.parseFloat(textFields[6].getHintOrText()), Integer.parseInt(textFields[7].getHintOrText())) );
                            ((Vehicule) list.get(i)).setId(v.getId());

                            //System.out.println(((Vehicule) list.get(i)).getMarque());

                            tlist.setModel(tlist.createDefaultListModel());
                            frame.getVehicleContractList().setModel(frame.getVehicleContractList().createDefaultListModel());
                            //scrollPane.filterModel((DefaultListModel<String>) tlist.getModel(), "");
                        }
                    }
                    break;
                case 2:
                    for (int i = 0; i < list.size(); i++) {
                        Client c = (Client) list.get(i);

                        if (c.getId() == Integer.parseInt((tlist.getModel().getElementAt(index).toString().split(" - ")[0]))) {
                            c = new Client(textFields[0].getHintOrText(), textFields[1].getHintOrText(), textFields[2].getHintOrText(), textFields[3].getHintOrText());
                        }
                    }
                    break;
            }
            Gestionnaire.sauvegarder();

            //String newElement = (id++)+ " - "+ frame.getClientSurnameField().getText()+" "+frame.getClientNameField().getText();
            //scrollPane.addElement((DefaultListModel<String>) tlist.getModel(), newAgent);
            //list.add(newAgent);
            cardLayout.show(areaToFillCardPanel, Definition.areaTofillCardName[0]);

            for (TTextField textField : textFields)
            {
                textField.setText("");
                textField.focusLost();
            }
        }
        else
        {
            boolean isEmpty = false;

            for (TTextField textField : textFields)
            {
                //System.out.println(textField);
                if(textField.getText().isEmpty())
                {
                    isEmpty = true;
                    textField.setBackground(Definition.emptyErrorColor);
                }
                else
                {
                    textField.setBackground(Definition.WHITE);
                }
            }

            if (!isEmpty)
            {
                ParcAgent newAgent;

                switch(whichMenu)
                {
                    case 0:
                        System.out.println(frame.getClientContractList().getSelectedIndex() + " " + Gestionnaire.getClients().size());
                        Client c = Gestionnaire.getClient(frame.getClientContractList().getSelectedIndex());
                        Vehicule v = Gestionnaire.getVehicule(frame.getVehicleContractList().getSelectedIndex());
                        newAgent = new Contrat(c, v, frame.getContractBeginningField().getD(), frame.getContractEndingField().getD(), 100, frame.getContractHasReduction().isSelected());
                        scrollPane.addElement((DefaultListModel<String>) tlist.getModel(), newAgent);
                        list.add(newAgent);
                        break;
                    case 1:
                        newAgent = new Voiture(textFields[0].getText(), textFields[1].getText(), Float.parseFloat(textFields[2].getText()),
                                Float.parseFloat(textFields[3].getText()), textFields[4].getText(), Long.parseLong(textFields[5].getText()),
                                Float.parseFloat(textFields[6].getText()), Integer.parseInt(textFields[7].getText()));
                        scrollPane.addElement((DefaultListModel<String>) tlist.getModel(), newAgent);
                        frame.getVehicleContractScrollPane().addElement((DefaultListModel<String>) frame.getVehicleContractList().getModel(), newAgent);
                        list.add(newAgent);
                        break;
                    case 2:
                        newAgent = new Client(textFields[0].getText(), textFields[1].getText(), textFields[2].getText(), textFields[3].getText());
                        scrollPane.addElement((DefaultListModel<String>) tlist.getModel(), newAgent);
                        frame.getClientContractScrollPane().addElement((DefaultListModel<String>) frame.getClientContractList().getModel(), newAgent);
                        list.add(newAgent);
                        break;

                }
                Gestionnaire.sauvegarder();

                //String newElement = (id++)+ " - "+ frame.getClientSurnameField().getText()+" "+frame.getClientNameField().getText();
                //scrollPane.addElement((DefaultListModel<String>) tlist.getModel(), newAgent);
                //list.add(newAgent);
                cardLayout.show(areaToFillCardPanel, Definition.areaTofillCardName[0]);

                for (TTextField textField : textFields)
                {
                    textField.setText("");
                    textField.focusLost();
                }
            }
        }
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
