import javax.swing.*;
import java.awt.*;

public class TScrollPane extends JScrollPane implements Definition
{
    TFrame frame;

    public TScrollPane(TFrame frame, JList list, int x, int y)
    {
        super(list);

        this.getVerticalScrollBar().setPreferredSize(new Dimension(15,15));
        this.getHorizontalScrollBar().setPreferredSize(new Dimension(15,15));
        this.getVerticalScrollBar().setUI(new TBasicScrollBarUI());
        this.getHorizontalScrollBar().setUI(new TBasicScrollBarUI());
        this.setPreferredSize(new Dimension(x, y));
        this.setBorder(border);
    }

    public void filterModel(DefaultListModel<String> model, String filter) {
        for (String s : elementArray) {
            if (!s.contains(filter)) {
                if (model.contains(s)) {
                    model.removeElement(s);
                }
            } else {
                if (!model.contains(s)) {
                    model.addElement(s);
                }
            }
        }
    }
}
