import javax.swing.*;

public class TList extends JList implements Definition
{

    public TList()
    {
        super();

        this.setModel(createDefaultListModel());
    }

    public ListModel<String> createDefaultListModel()
    {
        DefaultListModel<String> model = new DefaultListModel<>();
        for (String s : elementArray) {
            model.addElement(s);
        }
        return model;
    }
}
