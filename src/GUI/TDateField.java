package GUI;

import java.awt.*;
import java.util.Calendar;

public class TDateField extends TTextField {

    public TDateField(TFrame frame, String hint, int x, int y, Color back, Color front) {
        super(frame, hint, x, y, back, front);
    }

    public Calendar date () {

        Calendar c = Calendar.getInstance();
        c.set(Calendar.DAY_OF_MONTH, Integer.parseInt(this.getText().subSequence(0,2).toString()));
        c.set(Calendar.MONTH, Integer.parseInt(this.getText().subSequence(3,5).toString()));
        c.set(Calendar.YEAR, Integer.parseInt(this.getText().subSequence(6, 10).toString()));

        return c;

    }
}
