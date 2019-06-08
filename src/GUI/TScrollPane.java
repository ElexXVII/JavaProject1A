package GUI;
import Class.*;
import Interface.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TScrollPane extends JScrollPane implements Definition
{
    TFrame frame;

    ArrayList list;
    TList tlist;

    int whichMenu;

    public TScrollPane(TFrame frame, int whichMenu, TList tlist, int x, int y)
    {
        super(tlist);

        this.getVerticalScrollBar().setPreferredSize(new Dimension(15,15));
        this.getHorizontalScrollBar().setPreferredSize(new Dimension(15,15));
        this.getVerticalScrollBar().setUI(new TBasicScrollBarUI());
        this.getHorizontalScrollBar().setUI(new TBasicScrollBarUI());
        this.setPreferredSize(new Dimension(x, y));
        this.setBorder(Definition.border);

        this.tlist = tlist;
        this.whichMenu = whichMenu;
        switch(whichMenu)
        {
            case 0:
                list = Gestionnaire.getContrats();
                break;
            case 1:
                list = Gestionnaire.getVehicules();
                break;
            case 2:
                list = Gestionnaire.getClients();
                break;
        }
    }

    public void filterModel(DefaultListModel<String> model, String filter)
    {
        for (ParcAgent agent : (ArrayList<ParcAgent>) list)
        {
            if (!agent.toString().toLowerCase().contains(filter.toLowerCase()))
            {
                if (model.contains(agent.toString()))
                {
                    model.removeElement(agent.toString());
                }
            }
            else
            {
                if (!model.contains(agent.toString()))
                {
                    model.addElement(agent.toString());
                }
            }
        }
    }

    public void addElement(DefaultListModel<String> model, ParcAgent agent)
    {
        model.addElement(agent.toString());
    }

    public void delElement(DefaultListModel<String> model, int index)
    {
        model.remove(index);
    }
}
