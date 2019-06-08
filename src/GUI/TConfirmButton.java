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

    private String name;
    private final int whichMenu;
    private TScrollPane scrollPane;
    private TList tlist;

    private ArrayList list;

    private TTextField[] textFields;

    private TPanel areaToFillCardPanel;
    private CardLayout cardLayout;

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

                areaToFillCardPanel = frame.getContractAreaToFillPanel();
                cardLayout = frame.getContractAreaLayout();
                break;
            case 1:
                scrollPane = frame.getVehicleScrollPane();
                tlist = frame.getVehicleTList();
                list = Gestionnaire.getVehicules();

                areaToFillCardPanel = frame.getVehicleAreaToFillPanel();
                cardLayout = frame.getVehicleAreaLayout();
                break;
            case 2:
                scrollPane = frame.getClientScrollPane();
                tlist = frame.getClientTList();
                list = Gestionnaire.getClients();

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
                    Client cFinal = null;
                    Vehicule vFinal = null;

                    for (int i = 0; i < Gestionnaire.getClients().size(); i++)
                    {
                        Client c = Gestionnaire.getClient(i);

                        if (c.getId() == Integer.parseInt(frame.getClientContractList().getModel().getElementAt(frame.getClientContractList().getSelectedIndex()).toString().split(" ")[0]))
                        {
                            cFinal = c;
                        }
                    }

                    for (int i = 0; i < Gestionnaire.getVehicules().size(); i++)
                    {
                        Vehicule v = Gestionnaire.getVehicule(i);

                        if (v.getId() == Integer.parseInt(frame.getVehicleContractList().getModel().getElementAt(frame.getVehicleContractList().getSelectedIndex()).toString().split(" ")[0]))
                        {
                            vFinal = v;
                        }
                    }

                    if (cFinal!=null && vFinal!=null)
                    {
                        for (int i = 0; i < list.size(); i++)
                        {
                            Contrat c = (Contrat) list.get(i);

                            if (c.getId() == Integer.parseInt(tlist.getModel().getElementAt(tlist.getSelectedIndex()).toString().split(" ")[0]))
                            {
                                System.out.println("--");
                                Contrat newAgent = new Contrat(cFinal, vFinal, frame.getContractBeginningField().getD(), frame.getContractEndingField().getD(), Integer.parseInt(frame.getContractEstimatedKm().getHintOrText()),
                                        frame.getContractHasReduction().isSelected());
                                scrollPane.addElement((DefaultListModel<String>) tlist.getModel(), newAgent);
                                list.set(i,newAgent);
                                ((Contrat) list.get(i)).setId(c.getId());

                                frame.getContractTList().setModel(frame.getContractTList().createDefaultListModel());
                            }
                        }
                    }
                    break;
                case 1:
                    for (int i = 0; i < list.size(); i++) {
                        Vehicule v = (Vehicule) list.get(i);

                        if (v.getId() == Integer.parseInt(tlist.getModel().getElementAt(index).toString().split(" - ")[0])) {

                            System.out.println(frame.getVehicleTypeSelector().getSelectedIndex());
                            switch (frame.getVehicleTypeSelector().getSelectedIndex()) {

                                case 0:
                                    list.set(i, new Voiture(textFields[0].getHintOrText(), textFields[1].getHintOrText(), Float.parseFloat(textFields[2].getHintOrText()),
                                            Float.parseFloat(textFields[3].getHintOrText()), textFields[4].getHintOrText(), Integer.parseInt(textFields[5].getHintOrText()),
                                            Float.parseFloat(textFields[6].getHintOrText()), Integer.parseInt(textFields[7].getHintOrText())) );
                                    ((Vehicule) list.get(i)).setId(v.getId());
                                    System.out.println("Voiture creee");
                                    break;
                                case 1:
                                    list.set(i, new Moto(textFields[0].getHintOrText(), textFields[1].getHintOrText(), Float.parseFloat(textFields[2].getHintOrText()),
                                            Float.parseFloat(textFields[3].getHintOrText()), textFields[4].getHintOrText(), Integer.parseInt(textFields[5].getHintOrText()),
                                            Float.parseFloat(textFields[6].getHintOrText())) );
                                    ((Vehicule) list.get(i)).setId(v.getId());
                                    System.out.println("Moto creee");
                                    break;
                                case 2:
                                    list.set(i, new Avion(textFields[0].getHintOrText(), textFields[1].getHintOrText(), Float.parseFloat(textFields[2].getHintOrText()),
                                            Float.parseFloat(textFields[3].getHintOrText()), textFields[4].getHintOrText(), Integer.parseInt(textFields[8].getHintOrText()),
                                            Integer.parseInt(textFields[9].getHintOrText())) );
                                    ((Vehicule) list.get(i)).setId(v.getId());
                                    System.out.println("Avion creee");
                                    break;

                            }

/*
                            list.set(i, new Voiture(textFields[0].getHintOrText(), textFields[1].getHintOrText(), Float.parseFloat(textFields[2].getHintOrText()),
                                    Float.parseFloat(textFields[3].getHintOrText()), textFields[4].getHintOrText(), Integer.parseInt(textFields[5].getHintOrText()),
                                    Float.parseFloat(textFields[6].getHintOrText()), Integer.parseInt(textFields[7].getHintOrText())) );
                            ((Vehicule) list.get(i)).setId(v.getId());
*/

                            tlist.setModel(tlist.createDefaultListModel());
                            frame.getVehicleContractList().setModel(frame.getVehicleContractList().createDefaultListModel());
                        }
                    }
                    this.setName("Confirmer");
                    break;
                case 2:
                    for (int i = 0; i < list.size(); i++) {
                        Client c = (Client) list.get(i);

                        if (c.getId() == Integer.parseInt((tlist.getModel().getElementAt(index).toString().split(" - ")[0])))
                        {
                            list.set(i, new Client(textFields[0].getHintOrText(), textFields[1].getHintOrText(), textFields[2].getHintOrText(), textFields[3].getHintOrText(), textFields[4].getHintOrText()) );
                            ((Client) list.get(i)).setId(c.getId());

                            tlist.setModel(tlist.createDefaultListModel());
                            frame.getClientContractList().setModel(frame.getClientContractList().createDefaultListModel());

                            textFields[0].setHint("Nom");
                            textFields[1].setHint("Prénom");
                            textFields[2].setHint("Téléphone");
                            textFields[3].setHint("E-mail");
                            textFields[4].setHint("Adresse");

                            textFields[0].setText("");
                            textFields[1].setText("");
                            textFields[2].setText("");
                            textFields[3].setText("");
                            textFields[4].setText("");

                            textFields[0].focusLost();
                            textFields[1].focusLost();
                            textFields[2].focusLost();
                            textFields[3].focusLost();
                            textFields[4].focusLost();
                        }
                    }
                    this.setName("Confirmer");
                    break;
            }
            Gestionnaire.sauvegarder();
            frame.ChangePanelToAddPanel(whichMenu);

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
                if(textField.getText().isEmpty() && textField.isVisible())
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
                        Client c = Gestionnaire.getClient(frame.getClientContractList().getSelectedIndex());
                        Vehicule v = Gestionnaire.getVehicule(frame.getVehicleContractList().getSelectedIndex());
                        newAgent = new Contrat(c, v, frame.getContractBeginningField().getD(), frame.getContractEndingField().getD(), Integer.parseInt(frame.getContractEstimatedKm().getText()), frame.getContractHasReduction().isSelected());
                        scrollPane.addElement((DefaultListModel<String>) tlist.getModel(), newAgent);
                        list.add(newAgent);
                        break;
                    case 1:
                        System.out.println(frame.getVehicleTypeSelector().getSelectedIndex());
                        switch (frame.getVehicleTypeSelector().getSelectedIndex()) {

                            case 0:
                                Voiture voit = new Voiture(textFields[0].getHintOrText(), textFields[1].getHintOrText(), Float.parseFloat(textFields[2].getHintOrText()),
                                        Float.parseFloat(textFields[3].getHintOrText()), textFields[4].getHintOrText(), Integer.parseInt(textFields[5].getHintOrText()),
                                        Float.parseFloat(textFields[6].getHintOrText()), Integer.parseInt(textFields[7].getHintOrText()));
                                frame.getVehicleContractScrollPane().addElement((DefaultListModel<String>) frame.getVehicleContractList().getModel(), voit);
                                scrollPane.addElement((DefaultListModel<String>) tlist.getModel(), voit);

                                list.add(voit);

                                System.out.println("Voiture creee");
                                break;
                            case 1:
                                Moto mot = new Moto(textFields[0].getHintOrText(), textFields[1].getHintOrText(), Float.parseFloat(textFields[2].getHintOrText()),
                                        Float.parseFloat(textFields[3].getHintOrText()), textFields[4].getHintOrText(), Integer.parseInt(textFields[5].getHintOrText()),
                                        Float.parseFloat(textFields[6].getHintOrText()));
                                frame.getVehicleContractScrollPane().addElement((DefaultListModel<String>) frame.getVehicleContractList().getModel(), mot);
                                scrollPane.addElement((DefaultListModel<String>) tlist.getModel(), mot);

                                list.add(mot);
                                System.out.println("Moto creee");
                                break;
                            case 2:
                                Avion av = new Avion(textFields[0].getHintOrText(), textFields[1].getHintOrText(), Float.parseFloat(textFields[2].getHintOrText()),
                                        Float.parseFloat(textFields[3].getHintOrText()), textFields[4].getHintOrText(), Integer.parseInt(textFields[8].getHintOrText()),
                                        Integer.parseInt(textFields[9].getHintOrText()));
                                frame.getVehicleContractScrollPane().addElement((DefaultListModel<String>) frame.getVehicleContractList().getModel(), av);
                                scrollPane.addElement((DefaultListModel<String>) tlist.getModel(), av);

                                list.add(av);
                                System.out.println("Avion creee");
                                break;

                        }

                        break;
                    case 2:
                        newAgent = new Client(textFields[0].getText(), textFields[1].getText(), textFields[2].getText(), textFields[3].getText(), textFields[4].getText());
                        scrollPane.addElement((DefaultListModel<String>) tlist.getModel(), newAgent);
                        frame.getClientContractScrollPane().addElement((DefaultListModel<String>) frame.getClientContractList().getModel(), newAgent);
                        list.add(newAgent);
                        break;

                }
                Gestionnaire.sauvegarder();

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
