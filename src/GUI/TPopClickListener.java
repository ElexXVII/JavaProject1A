package GUI;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class TPopClickListener extends MouseAdapter
{
    private TFrame frame;

    public void mousePressed(MouseEvent e)
    {
        if (e.isPopupTrigger())
            doPop(e);
    }

    public void mouseReleased(MouseEvent e)
    {
        if (e.isPopupTrigger())
            doPop(e);
    }

    private void doPop(MouseEvent e)
    {
        TList tlist = (TList) e.getSource();
        TPopUpMenu menu = new TPopUpMenu(frame, tlist.getWhichMenu(), tlist.getSelectedIndex());
        menu.show(e.getComponent(), e.getX(), e.getY());
    }

    public void initFrame(TFrame frame, int whichMenu)
    {
        this.frame = frame;
    }
}