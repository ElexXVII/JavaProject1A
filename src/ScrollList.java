import java.awt.*;

import javax.swing.*;
import javax.swing.border.Border;

public class ScrollList extends JFrame {

    JScrollPane scrollpane;

    public ScrollList() {
        super("JScrollPane Demonstration");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        String categories[] = { "Household", "Office", "Extended Family",
                "Company (US)", "Company (World)", "Team", "Will",
                "Birthday Card List", "High School", "Country", "Continent",
                "Planet" };
        JList list = new JList(categories);
        scrollpane = new JScrollPane(list);
        scrollpane.getVerticalScrollBar().setPreferredSize(new Dimension(15,15));
        scrollpane.getHorizontalScrollBar().setPreferredSize(new Dimension(15,15));
        scrollpane.getVerticalScrollBar().setUI(new MyBasicScrollBarUI());
        scrollpane.getHorizontalScrollBar().setUI(new MyBasicScrollBarUI());

        Border border = BorderFactory.createEmptyBorder( 0, 0, 0, 0 );
        scrollpane.setBorder(border);

        getContentPane().add(scrollpane, BorderLayout.CENTER);
    }

    public static void main(String args[]) {
        ScrollList sl = new ScrollList();
        sl.setVisible(true);
    }
}