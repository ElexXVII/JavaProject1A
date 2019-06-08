package GUI;
import Interface.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

class TSearchBar extends JTextField implements FocusListener, ActionListener, Definition
{
    private TFrame frame;

    private Color back;
    private Color front;

    private final String hint;
    private boolean showingHint;
    private final int whichMenu;

    //GUI.TSearchBar textField;
    TScrollPane scrollPane;
    TList list;

    /**
     * Constructor of the SeachBox extends {@link JTextField}
     * @param frame : Ref to the main frame
     * @param whichMenu : Which menu to display
     * @param hint : Hint (Text on the background)
     * @param x : width
     * @param y : heigth
     * @param back : Background Color
     * @param front : Front Color
     */
    public TSearchBar(TFrame frame, int whichMenu, final String hint, int x, int y, Color back, Color front)
    {
        super(hint);

        this.frame = frame;

        this.whichMenu = whichMenu;
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
        switch(whichMenu)
        {
            case 0:
                scrollPane = frame.getContractScrollPane();
                list = frame.getContractTList();
                break;
            case 1:
                scrollPane = frame.getVehicleScrollPane();
                list = frame.getVehicleTList();
                break;
            case 2:
                scrollPane = frame.getClientScrollPane();
                list = frame.getClientTList();
                break;
            case 3:
                scrollPane = frame.getVehicleContractScrollPane();
                list = frame.getVehicleContractList();
                break;
            case 4:
                scrollPane = frame.getClientContractScrollPane();
                list = frame.getClientContractList();
                break;
        }

        this.addActionListener(this);
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

    @Override
    public String getText()
    {
        return showingHint ? "" : super.getText();
    }

    /**
     * Handle ActionEvent : Filter TList if Enter key is pressed
     */
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (whichMenu < 3)
        {
            scrollPane.filterModel((DefaultListModel<String>) list.getModel(), this.getText());
        }
        else
        {
            scrollPane.filterModel((DefaultListModel<String>) list.getModel(), this.getText());
        }
    }
}

