package GUI;
import Interface.*;
import Class.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class TPopUpMenu extends JPopupMenu implements Definition
{
    private JMenuItem EndItem;
    private JMenuItem changeItem;
    private JMenuItem deleteItem;

    private TFrame frame;
    private TScrollPane scrollPane;
    private TList tlist;
    private int whichMenu;
    private int selectedIndex;

    private CardLayout cardLayout;
    private TPanel areaToFillCardPanel;


    public TPopUpMenu(TFrame frame, int whichMenu, int selectedIndex)
    {
        this.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLUE));//Border( 2, 2, 2, 2 ));

        this.frame = frame;
        this.whichMenu = whichMenu;
        this.selectedIndex = selectedIndex;

        switch(whichMenu)
        {
            case 0:
                scrollPane = frame.getContractScrollPane();
                tlist = frame.getContractTList();

                areaToFillCardPanel = frame.getContractAreaToFillPanel();
                cardLayout = frame.getContractAreaLayout();

                break;
            case 1:
                scrollPane = frame.getVehicleScrollPane();
                tlist = frame.getVehicleTList();

                areaToFillCardPanel = frame.getVehicleAreaToFillPanel();
                cardLayout = frame.getVehicleAreaLayout();
                break;
            case 2:
                scrollPane = frame.getClientScrollPane();
                tlist = frame.getClientTList();

                areaToFillCardPanel = frame.getClientAreaToFillPanel();
                cardLayout = frame.getClientAreaLayout();
                break;
        }

        if (whichMenu == 0)
        {
            EndItem = new JMenuItem("Finaliser");
            EndItem.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {

                }
            });
            add(EndItem);
        }

        changeItem = new JMenuItem("Modifier");
        changeItem.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                frame.AddPanelToChangePanel(whichMenu, tlist.getSelectedIndex());
                cardLayout.show(areaToFillCardPanel, Definition.areaTofillCardName[1]);
            }
        });
        add(changeItem);

        deleteItem = new JMenuItem("Supprimer");
        deleteItem.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                cardLayout.show(areaToFillCardPanel, Definition.areaTofillCardName[2]);
                //scrollPane.delElement((DefaultListModel<String>) tlist.getModel(), selectedIndex);
            }
        });
        add(deleteItem);
    }
}