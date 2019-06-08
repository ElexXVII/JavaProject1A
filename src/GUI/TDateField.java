package GUI;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.time.Duration;
import java.util.Calendar;

/**
 * Classe {@link TDateField} fille de {@link TTextField} permettant de rentrer une date pour le contrat (début ou fin resp.).
 * Contient un booléen disant si la {@link TDateField} correspond à la date de début.
 * Contient l'autre {@link TDateField} nécessaire au calcul de la durée (fin ou début resp.)
 * Contient la {@link TCheckBox} pour l'activation de la réduction.
 */

public class TDateField extends TTextField implements DocumentListener {

    private boolean beginning;
    private TCheckBox reduc;
    private TDateField otherDate;
    private Calendar d;

    /**
     * Constructeur avec initialisation de {@link TDateField} basé sur celui de {@link TTextField}
     * @param frame {@link TFrame}
     * @param hint String
     * @param x int
     * @param y int
     * @param back {@link Color}
     * @param front {@link Color}
     * @param beginning boolean
     */
    public TDateField(TFrame frame, String hint, int x, int y, Color back, Color front, boolean beginning) {
        super(frame, hint, x, y, back, front);
        this.beginning = beginning;
        this.d = null;
        reduc = frame.getContractHasReduction();
        this.getDocument().addDocumentListener(this);
    }

    /**
     * Récupération de la date écrite dans le {@link TDateField}
     * @return Calendar : la date écrite par l'utilisateur
     */
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

    /**
     * Place le champ otherDate sur le {@link TDateField} de début ou de fin selon la valeur de beginning
     */
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

    /**
     * Lorsque l'utilisateur quitte un {@link TDateField}, la fonction suivante se lance
     * On calcule alors la durée si les deux {@link TDateField} associés sont remplis
     * @param e {@link FocusEvent}
     */
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
