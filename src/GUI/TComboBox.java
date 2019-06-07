package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TComboBox extends JComboBox implements ActionListener {

    public TComboBox() {
        super();
        this.addItem("Avion");
        this.addItem("Moto");
        this.addItem("Voiture");

        this.addActionListener(this);
    }

    public void actionPerformed (ActionEvent e) {
        System.out.println(this.selectedItemReminder);

        if (this.selectedItemReminder.equals("Avion")) {



        } else if (this.selectedItemReminder.equals("Moto")){

        } else {

        }
    }

}
