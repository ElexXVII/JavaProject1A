package GUI;

import javax.swing.*;
import java.awt.event.ActionListener;

public class TComboBox extends JComboBox implements ActionListener {

    public TComboBox() {
        super();
        this.addItem("Avion");
        this.addItem("Moto");
        this.addItem("Voiture");
    }


}
