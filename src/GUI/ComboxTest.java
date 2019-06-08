package GUI;

import Interface.Definition;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ComboxTest extends JComboBox implements ActionListener {

    public ComboxTest(Frame frame, String Title, int x, int y, Color back, Color front, String... items)
    {
        super();
        this.addItem("Avion");
        this.addItem("Moto");
        this.addItem("Voiture");

        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(back);
        this.setForeground(front);

        this.setBorder(Definition.border);
        //this.setUI(new TBasicComboBoxUI(this));

        this.addActionListener(this);
    }


    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
    }

    public void actionPerformed (ActionEvent e)
    {
        System.out.println(this.getSelectedItem());

        if (this.selectedItemReminder.equals("Avion"))
        {

        }
        else if (this.selectedItemReminder.equals("Moto"))
        {

        }
        else
        {

        }
    }

    public static void main(String[] args) {
        JFrame f = new JFrame();

        ComboxTest c = new ComboxTest(f, "Test", 150, 30, Color.WHITE, Color.BLACK,"Avion", "Voiture", "Moto");

        f.setSize(200,100);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        f.setLocation((int) (dim.getWidth()/2-f.getSize().width/2), (int) (dim.getHeight()/2-f.getSize().height/2));

        JPanel p = (JPanel) f.getContentPane();
        p.setPreferredSize(new Dimension(200,100));
        p.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 100/2-30/2));
        p.add(c);

        f.pack();
        f.setVisible(true);
    }

}
