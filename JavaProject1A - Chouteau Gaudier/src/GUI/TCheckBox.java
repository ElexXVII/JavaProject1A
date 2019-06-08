package GUI;
import Interface.*;
import javax.swing.*;

public class TCheckBox extends JCheckBox {

    private boolean isEnabled;
    private int duration;

    /**
     * Setter
     * @param duration : Duration of the contract : duration>7 days allows discount
     */
    public void setDuration(int duration) {
        this.duration = duration;
        System.out.println(duration);
        if (duration >= 7) {
            this.enableCB();
        } else {
            this.disableCB();
        }
    }

    /**
     * Constructor of the "discount" CheckBox
     * @param name : Name of the CheckBox
     */
    public TCheckBox (String name) {
        super(name);
        isEnabled = false;
        this.setBackground(Definition.InterfaceLightColor);
        this.setFont(Definition.mainFont);
        this.setForeground(Definition.WHITE);

        this.disableCB();

        super.setBorderPainted(false);
        super.setFocusPainted(false);
    }

    public void disableCB () {
        this.setEnabled(false);
        isEnabled = false;
    }

    public void enableCB () {
        this.setEnabled(true);
        isEnabled = true;
    }

    public boolean getIsEnabled () {
        return isEnabled;
    }

}
