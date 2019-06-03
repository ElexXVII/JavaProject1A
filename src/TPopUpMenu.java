import javax.swing.*;

class TPopUpMenu extends JPopupMenu
{
    JMenuItem changeItem;
    JMenuItem deleteItem;

    public TPopUpMenu()
    {
        changeItem = new JMenuItem("Click Me!");
        add(changeItem);
        deleteItem = new JMenuItem("Click Me!");
        add(deleteItem);
    }
}