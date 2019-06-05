package GUI;
import Interface.*;
import Class.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class TPopUpMenu extends JPopupMenu implements Definition
{
    private JMenuItem changeItem;
    private JMenuItem deleteItem;

    private TFrame frame;
    private TScrollPane scrollPane;
    private TList tlist;
    private int whichMenu;
    private int selectedIndex;

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
                break;
            case 1:
                scrollPane = frame.getVehicleScrollPane();
                tlist = frame.getVehicleTList();
                break;
            case 2:
                scrollPane = frame.getClientScrollPane();
                tlist = frame.getClientTList();
                break;
        }

        changeItem = new JMenuItem("Modifier");
        changeItem.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {

            }
        });
        add(changeItem);

        deleteItem = new JMenuItem("Supprimer");
        deleteItem.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                scrollPane.delElement((DefaultListModel<String>) tlist.getModel(), selectedIndex);
                Gestionnaire.sauvegarder();
            }
        });
        add(deleteItem);
    }
}