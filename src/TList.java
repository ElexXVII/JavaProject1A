import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class TList extends JList implements Definition, MouseListener {
    TFrame frame;

    private final int whichMenu;
    private ArrayList<ParcAgent> list;

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

        this.addMouseListener(this);
    }

    public ListModel<String> createDefaultListModel()
    {
        DefaultListModel<String> model = new DefaultListModel<>();

        for (ParcAgent agent : list)
        {
            model.addElement(agent.getDisplay());
        }
        return model;
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {
        JList list = (JList)e.getSource();
        if (e.getClickCount() == 2)
        {
            System.out.println(list.getSelectedIndex());
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}
