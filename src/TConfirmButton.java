import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TConfirmButton extends TFlatButton implements Definition, ActionListener
{
    TFrame frame;

    private final int whichMenu;
    TScrollPane scrollPane;
    TList list;

    public TConfirmButton(TFrame frame, int whichMenu, String text, int x, int y)
    {
        super(text);

        this.frame = frame;
        this.whichMenu = whichMenu;
        this.setPreferredSize(new Dimension(x, y));
        this.setForeground(WHITE);
        this.setFont(menuFont);

        super.setBorderPainted(false);
        super.setFocusPainted(false);
        super.setContentAreaFilled(false);

        this.addActionListener(this);

        idleColor = idleButtonLightColor;

        if (text.equals("Annuler"))
        {
            hoverColor = hoverCrossColor;
            pressColor = pressCrossColor;
        }
        else
        {
            hoverColor = hoverButtonLightColor;
            pressColor = pressButtonLightColor;
        }

        switch(whichMenu)
        {
            case 0:
                scrollPane = frame.getContractScrollPane();
                list = frame.getContractList();
                break;
            case 1:
                scrollPane = frame.getVehicleScrollPane();
                list = frame.getVehicleList();
                break;
            case 2:
                scrollPane = frame.getClientScrollPane();
                list = frame.getClientList();
                break;
        }
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
        System.out.println("Test");
        scrollPane.addElement((DefaultListModel<String>) list.getModel(), frame.getClientSurnameField().getText()+" "+frame.getClientNameField().getText());
    }
}
