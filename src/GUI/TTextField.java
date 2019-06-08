package GUI;
import Interface.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

class TTextField extends JTextField implements FocusListener, Definition
{
    private TFrame frame;

    private Color back;
    private Color front;

    private String hint;
    private boolean showingHint;

    public TFrame getFrame() {
        return frame;
    }

    /**
     * Constructor of the SeachBox extends {@link JTextField}
     * @param frame : Ref to the main frame
     * @param hint : Hint (Text on the background)
     * @param x : width
     * @param y : heigth
     * @param back : Background Color
     * @param front : Front Color
     */
    public TTextField(TFrame frame, final String hint, int x, int y, Color back, Color front)
    {
        super(hint);

        this.frame = frame;

        this.back = back;
        this.front = front;
        this.hint = hint;
        this.showingHint = true;
        super.addFocusListener(this);

        this.setBackground(back);
        this.setForeground(front);
        this.setPreferredSize(new Dimension(x, y));
        this.setBorder(Definition.border);

        //textField = this;
        //scrollPane = frame.getContractScrollPane();
        //list = frame.getContractTList();
    }

    /**
     * FocusGained Override : Erase hint
     * @param e : Event
     */
    @Override
    public void focusGained(FocusEvent e)
    {
        if(this.getText().isEmpty())
        {
            super.setText("");
            showingHint = false;
        }
    }

    /**
     * FocusGained Override : display hint
     * @param e : Event
     */
    @Override
    public void focusLost(FocusEvent e)
    {
        if(this.getText().isEmpty())
        {
            super.setFont(new Font("Montserrat",Font.ROMAN_BASELINE, 12));
            super.setBackground(back);
            super.setForeground(front);
            super.setText(hint);
            showingHint = true;
        }
    }

    public void setHint(String hint)
    {
        this.hint = hint;
    }

    @Override
    public String getText()
    {
        return showingHint ? "" : super.getText();
    }

    /**
     * Get hint if no String is in, else get inpu
     * @return
     */
    public String getHintOrText()
    {
        if(this.getText().isEmpty())
        {
            return hint;
        }
        else
        {
            return this.getText();
        }
    }

    public void focusLost()
    {
        focusLost(new FocusEvent(this, 0, false, this));
    }
}

