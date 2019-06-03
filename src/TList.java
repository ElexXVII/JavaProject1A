import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class TList extends JList implements Definition, MouseListener {
    TFrame frame;

    private final int whichMenu;
    private ArrayList list;

    public TList(TFrame frame, int whichMenu)
    {
        super();
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
                    System.out.println(e.getPoint());
                    list.setSelectedIndex(row);
                }
            }

        });

        this.addMouseListener(new TPopClickListener());
    }

    public ListModel<String> createDefaultListModel()
    {
        DefaultListModel<String> model = new DefaultListModel<>();

        for (ParcAgent agent : (ArrayList<ParcAgent>) list)
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
