import javax.swing.*;

public class ClientPanel extends JPanel {

    private int id;

    public ClientPanel(int id) {
        this.id = id;
        this.setLayout(new BoxLayout(this, 0));
    }


}
