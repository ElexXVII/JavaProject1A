import javax.swing.*;
import java.awt.*;

class TPopUpMenu extends JPopupMenu implements Definition
{
    private JMenuItem changeItem;
    private JMenuItem deleteItem;

    public TPopUpMenu()
    {
        this.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLUE));//Border( 2, 2, 2, 2 ));

        changeItem = new JMenuItem("Modifier");
        add(changeItem);
        deleteItem = new JMenuItem("Supprimer");
        add(deleteItem);
    }
}