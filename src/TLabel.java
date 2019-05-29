import javax.swing.*;
import java.awt.*;

public class TLabel extends JLabel implements Definition
{
    public TLabel(String text, Color front)
    {
        super(text);

        this.setForeground(front);
        this.setFont(mainFont);
    }
}
