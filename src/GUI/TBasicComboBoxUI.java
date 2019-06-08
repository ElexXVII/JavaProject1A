package GUI;

import Interface.Definition;

import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.ComboPopup;
import java.awt.*;

public class TBasicComboBoxUI extends BasicComboBoxUI
{
    TComboBox c;
    BasicComboPopup p;

    public TBasicComboBoxUI(TComboBox c)
    {
        super();
        this.c = c;
    }

    @Override
    public JButton createArrowButton()
    {
        return new TFrameButton("Increase");
    }

    /*@Override
    public Rectangle rectangleForCurrentValue()
    {
        return null;
    }*/



    @Override
    public void paintCurrentValueBackground(Graphics g, Rectangle bounds, boolean hasFocus)
    {
        g.setColor(Definition.InterfaceLightColor);
        g.fillRect(0, 0, (int) bounds.getWidth(), (int) bounds.getHeight());
    }

    public ComboPopup createPopup()
    {
        p = (BasicComboPopup) super.createPopup();

        p.setBackground(Color.WHITE);
        p.setForeground(Color.BLACK);
        p.setBorder(Definition.border);

        return p;
    }
}
