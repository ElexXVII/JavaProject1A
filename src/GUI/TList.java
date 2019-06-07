package GUI;
import Class.*;
import Interface.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class TList extends JList implements Definition, MouseListener {
    TFrame frame;

    private final int whichMenu;
    private ArrayList list;

    TPanel areaToFillCardPanel;
    CardLayout cardLayout;

    public TList(TFrame frame, int whichMenu)
    {
        super();
        this.whichMenu = whichMenu;

        switch(whichMenu)
        {
            case 0:
                areaToFillCardPanel = frame.getContractAreaToFillPanel();
                cardLayout = frame.getContractAreaLayout();
                list = Gestionnaire.getContrats();
                break;
            case 1:
            case 3:
                areaToFillCardPanel = frame.getVehicleAreaToFillPanel();
                cardLayout = frame.getVehicleAreaLayout();
                list = Gestionnaire.getVehicules();
                break;
            case 2:
            case 4:
                areaToFillCardPanel = frame.getClientAreaToFillPanel();
                cardLayout = frame.getClientAreaLayout();
                list = Gestionnaire.getClients();
                break;
        }
        this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        this.setModel(createDefaultListModel());

        this.addMouseListener(this);

        this.addMouseListener( new MouseAdapter()
        {
            @Override
            public void mousePressed(MouseEvent e)
            {
                if ( SwingUtilities.isRightMouseButton(e) )
                {
                    JList list = (JList)e.getSource();
                    int row = list.locationToIndex(e.getPoint());
                    //System.out.println(e.getPoint());
                    list.setSelectedIndex(row);
                }
            }

        });

        if (whichMenu < 3)
        {
            TPopClickListener popListener = new TPopClickListener();
            popListener.initFrame(frame, whichMenu);
            this.addMouseListener(popListener);
        }
    }

    public ArrayList getList() {
        return list;
    }

    public ListModel<String> createDefaultListModel()
    {
        DefaultListModel<String> model = new DefaultListModel<>();

        for (ParcAgent agent : (ArrayList<ParcAgent>) list)
        {
            model.addElement(agent.toString());
        }
        return model;
    }

    public int getWhichMenu()
    {
        return whichMenu;
    }

    @Override
    public void mousePressed(MouseEvent e)
    {
        cardLayout.show(areaToFillCardPanel, Definition.areaTofillCardName[0]);
    }

    @Override
    public void mouseClicked(MouseEvent e){}
    @Override
    public void mouseReleased(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
}
