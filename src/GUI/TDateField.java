package GUI;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.time.Duration;
import java.util.Calendar;

public class TDateField extends TTextField implements DocumentListener {

    private boolean beginning;
    private TCheckBox reduc;
    private TDateField otherDate;
    private Calendar d;

    public TDateField(TFrame frame, String hint, int x, int y, Color back, Color front, boolean beginning) {
        super(frame, hint, x, y, back, front);
        this.beginning = beginning;
        this.d = null;
        reduc = frame.getContractHasReduction();
        this.getDocument().addDocumentListener(this);
    }

    public Calendar date () {

        Calendar c = Calendar.getInstance();
        try {
            c.set(Calendar.DAY_OF_MONTH, Integer.parseInt(this.getText().subSequence(0, 2).toString()));
            c.set(Calendar.MONTH, Integer.parseInt(this.getText().subSequence(3, 5).toString()));
            c.set(Calendar.YEAR, Integer.parseInt(this.getText().subSequence(6, 10).toString()));
        } catch (StringIndexOutOfBoundsException e) {
            return null;
        }
        return c;

    }

    public Calendar getD() {
        return d;
    }

    public void setOtherDate () {
        otherDate = beginning ? this.getFrame().getContractEndingField() : this.getFrame().getContractBeginningField();
    }

    public void setReduc () {
        reduc = getFrame().getContractHasReduction();
    }

    @Override
    public void insertUpdate(DocumentEvent e) {

    }

    @Override
    public void removeUpdate(DocumentEvent e) {

    }

    @Override
    public void focusLost (FocusEvent e)
    {
        super.focusLost(e);

        d = date();

        if (this.getD() != null && this.otherDate.getD() != null) {
            int dur = (int)Math.abs(Duration.between(this.getD().toInstant(), otherDate.getD().toInstant()).toDays());
            this.reduc.setDuration(dur);
        }
    }

    @Override
    public void changedUpdate(DocumentEvent e) {



    }
}
