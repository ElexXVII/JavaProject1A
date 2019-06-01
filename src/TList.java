import javax.swing.*;
import java.util.ArrayList;

public class TList extends JList implements Definition
{
    TFrame frame;

    private final int whichMenu;
    private ArrayList<String> list;

    public TList(TFrame frame, int whichMenu)
    {
        super();
        this.whichMenu = whichMenu;

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

        this.setModel(createDefaultListModel());
    }

    public ListModel<String> createDefaultListModel()
    {
        DefaultListModel<String> model = new DefaultListModel<>();
        for (String s : list)
        {
            model.addElement(s);
        }
        return model;
    }
}
