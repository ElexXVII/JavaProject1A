package GUI;
import Interface.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TContentButton extends TFlatButton implements Definition, ActionListener
{
    TFrame frame;

    TPanel areaToFillCardPanel;
    CardLayout cardLayout;

    int whichMenu;

    public TContentButton(TFrame frame, int whichMenu, String text, int x, int y)
    {
        super(text);

        this.frame = frame;
        this.whichMenu = whichMenu;
        this.setPreferredSize(new Dimension(x, y));
        this.setForeground(Definition.WHITE);
        this.setFont(Definition.menuFont);

        //System.out.println(whichMenu);
        switch(whichMenu)
        {
            case 0:
                areaToFillCardPanel = frame.getContractAreaToFillPanel();
                cardLayout = frame.getContractAreaLayout();
                //System.out.println((cardLayout==null)+"");
                break;
            case 1:
                areaToFillCardPanel = frame.getVehicleAreaToFillPanel();
                cardLayout = frame.getVehicleAreaLayout();
                break;
            case 2:
                areaToFillCardPanel = frame.getClientAreaToFillPanel();
                cardLayout = frame.getClientAreaLayout();
                break;
        }
        //System.out.println((cardLayout==null)+"");

        this.addActionListener(this);

        super.setBorderPainted(false);
        super.setFocusPainted(false);
        super.setContentAreaFilled(false);

        idleColor = Definition.idleButtonLightColor;
        hoverColor = Definition.hoverButtonLightColor;
        pressColor = Definition.pressButtonLightColor;
    }

    @Override
    public void paint(Graphics g)
    {
        if (getModel().isPressed())
        {
            g.setColor(pressColor);
        }
        else if (getModel().isRollover())
        {
            g.setColor(hoverColor);
        }
        else
        {
            g.setColor(idleColor);
        }

        Graphics2D g2 = (Graphics2D)g;
        RenderingHints rh = new RenderingHints(
                RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);
        g2.setRenderingHints(rh);

        g2.fillRect(0, 0, getWidth(), getHeight());

        g2.setColor(new Color(0xFFFFFF));
        //g2.fillRect(0, 0, 1, getHeight());
        //g2.fillRect(getWidth()-1, 0, getWidth(), getHeight());

        super.paintComponent(g);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        //System.out.println((areaToFillCardPanel==null)+"");
        cardLayout.show(areaToFillCardPanel, Definition.areaTofillCardName[1]);
        //System.out.println(Definition.areaTofillCardName[2]);
    }
}
