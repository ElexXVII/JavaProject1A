package GUI;

import Interface.Definition;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TComboBox extends JComboBox implements ActionListener {

    private TFrame frame;

    /**
     * Constructor
     * @param frame : Ref to the main frame
     * @param x : width
     * @param y : height
     * @param back : Background Color
     * @param front : FrontColor Color
     */
    public TComboBox(TFrame frame, int x, int y, Color back, Color front)
    {
        super();
        this.frame = frame;
        this.addItem("Voiture");
        this.addItem("Moto");
        this.addItem("Avion");

        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(back);
        this.setForeground(front);

        this.setBorder(Definition.border);
        this.setUI(new TComboBoxUI(this));

        this.addActionListener(this);
    }

    /**
     * On click : Get class name of the selected item : Moto/Avion/Voiture
     * @param e : Event
     */
    public void actionPerformed (ActionEvent e)
    {
        System.out.println(this.selectedItemReminder);

        if (this.selectedItemReminder.equals("Voiture")) {

            this.afficher(0);

        } else if (this.selectedItemReminder.equals("Moto")){

            this.afficher(1);

        } else {
            this.afficher(2);
        }
    }

    /**
     * Display TextFields used to create a new agent : Depends of which Agent is created
     * @param i
     */
    public void afficher (int i)
    {

        switch (i)
        {
            case 0:
                frame.getVehiclePowerField().setVisible(true);
                frame.getVehicleNbSeatField().setVisible(true);
                frame.getVehicleOdometerField().setVisible(true);
                frame.getVehicleNbFlightHoursField().setVisible(false);
                frame.getVehicleNbEnginesField().setVisible(false);
                frame.getCenterPanel().setPreferredSize(new Dimension(500, ((int)frame.getVehicleAreaToFillPanel().getPreferredSize().getHeight()-12*30-13*15)/2));
                frame.pack();
                break;
            case 1:
                frame.getVehiclePowerField().setVisible(true);
                frame.getVehicleNbSeatField().setVisible(false);
                frame.getVehicleOdometerField().setVisible(true);
                frame.getVehicleNbFlightHoursField().setVisible(false);
                frame.getVehicleNbEnginesField().setVisible(false);
                frame.getCenterPanel().setPreferredSize(new Dimension(500, ((int)frame.getVehicleAreaToFillPanel().getPreferredSize().getHeight()-11*30-12*15)/2));
                frame.pack();
                break;
            case 2:
                frame.getVehiclePowerField().setVisible(false);
                frame.getVehicleNbSeatField().setVisible(false);
                frame.getVehicleOdometerField().setVisible(false);
                frame.getVehicleNbFlightHoursField().setVisible(true);
                frame.getVehicleNbEnginesField().setVisible(true);
                frame.getCenterPanel().setPreferredSize(new Dimension(500, ((int)frame.getVehicleAreaToFillPanel().getPreferredSize().getHeight()-11*30-12*15)/2));
                frame.pack();
                break;
        }

    }

}
