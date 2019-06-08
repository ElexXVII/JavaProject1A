package GUI;
import Interface.*;

import javax.swing.*;
import java.awt.*;

public class TLabel extends JLabel implements Definition
{
    /**
     * Constructor
     * @param text : Text to display
     * @param front : Text Color
     */
    public TLabel(String text, Color front)
    {
        super(text);

        this.setForeground(front);
        this.setFont(Definition.mainFont);
    }
}
