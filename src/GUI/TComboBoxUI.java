package GUI;

import Interface.Definition;

import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.ComboPopup;
import java.awt.*;

public class TComboBoxUI extends BasicComboBoxUI
{
    TComboBox c;
    BasicComboPopup p;

    /**
     * Constructor of the UI
     * @param c
     */
    public TComboBoxUI(TComboBox c)
    {
        super();
        this.c = c;
    }

    /**
     * Create our own "Increase" Button to display list
     * @return
     */
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

    /**
     * I paint my own background to use the same style
     * @param g : Graphics
     * @param bounds : Rectangle with lenght of the object to draw
     * @param hasFocus
     */
    @Override
    public void paintCurrentValueBackground(Graphics g, Rectangle bounds, boolean hasFocus)
    {
        g.setColor(Definition.InterfaceLightColor);
        g.fillRect(0, 0, (int) bounds.getWidth(), (int) bounds.getHeight());
    }

    /**
     * Create our own popup
     * @see {@link BasicComboPopup}
     * @return
     */
    public ComboPopup createPopup()
    {
        p = (BasicComboPopup) super.createPopup();

        p.setBackground(Color.WHITE);
        p.setForeground(Color.BLACK);
        p.setBorder(Definition.border);

        return p;
    }
}
