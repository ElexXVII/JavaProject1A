import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

class TTextField extends JTextField implements FocusListener, ActionListener, Definition
{
    private TFrame frame;

    private final String hint;
    private boolean showingHint;

    TTextField textField;
    TScrollPane scrollPane;
    TList list;

    public TTextField(TFrame frame, final String hint, int x, int y, Color back, Color front)
    {
        super(hint);

        this.frame = frame;

        this.hint = hint;
        this.showingHint = true;
        super.addFocusListener(this);

        this.setBackground(back);
        this.setForeground(front);
        this.setPreferredSize(new Dimension(x, y));
        this.setBorder(border);

        textField = this;
        scrollPane = frame.getScrollPane();
        list = frame.getList();

        this.addActionListener(this);
    }

    @Override
    public void focusGained(FocusEvent e)
    {
        if(this.getText().isEmpty())
        {
            super.setText("");
            showingHint = false;
        }
    }
    @Override
    public void focusLost(FocusEvent e)
    {
        if(this.getText().isEmpty())
        {
            super.setFont(new Font("Montserrat",Font.ROMAN_BASELINE, 12));
            super.setBackground(new Color(0xDDDDDD));
            super.setForeground(new Color(0x555555));
            super.setText(hint);
            showingHint = true;
        }
    }

    @Override
    public String getText()
    {
        return showingHint ? "" : super.getText();
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        scrollPane.filterModel((DefaultListModel<String>) list.getModel(), textField.getText());
    }
}

