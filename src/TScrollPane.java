import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class TScrollPane extends JScrollPane implements Definition
{
    TFrame frame;

    ArrayList<ParcAgent> list;
    TList tlist;

    public TScrollPane(TFrame frame, int whichMenu, TList tlist, int x, int y)
    {
        super(tlist);

        this.getVerticalScrollBar().setPreferredSize(new Dimension(15,15));
        this.getHorizontalScrollBar().setPreferredSize(new Dimension(15,15));
        this.getVerticalScrollBar().setUI(new TBasicScrollBarUI());
        this.getHorizontalScrollBar().setUI(new TBasicScrollBarUI());
        this.setPreferredSize(new Dimension(x, y));
        this.setBorder(border);

        this.tlist = tlist;

        switch(whichMenu)
        {
            case 0:
                list = frame.getContractArrayList();
                break;
            case 1:
                list = frame.getVehicleArrayList();
                break;
            case 2:
                list = frame.getClientArrayList();
                break;
        }
    }

    public void filterModel(DefaultListModel<String> model, String filter)
    {
        for (ParcAgent agent : list)
        {
            if (!agent.getDisplay().contains(filter))
            {
                if (model.contains(agent.getDisplay()))
                {
                    model.removeElement(agent.getDisplay());
                }
            }
            else
            {
                if (!model.contains(agent.getDisplay()))
                {
                    model.addElement(agent.getDisplay());
                }
            }
        }
    }

    public void addElement(DefaultListModel<String> model, ParcAgent agent)
    {
        model.addElement(agent.getDisplay());
    }
}
