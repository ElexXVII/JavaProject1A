import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public interface Definition
{
    //Colors
    Color WHITE = new Color(0xFFFFFF);
    Color BLACK = new Color(0);

    Color idleButtonColor = new Color(0x4773B9);
    Color hoverButtonColor = new Color(0x416BAA);
    Color pressButtonColor = new Color(0x35549B);

    Color hoverCrossColor = new Color(0xe0552f);
    Color pressrossColor = new Color(0xc13a15);

    //Listes
    String liste[] = { "Household", "Office", "Extended Family",
            "Company (US)", "Company (World)", "Team", "Will",
            "Birthday Card List", "High School", "Country", "Continent",
            "Planet", "Household", "Office", "Extended Family",
            "Company (US)", "Company (World)", "Team", "Will",
            "Birthday Card List", "High School", "Country", "Continent",
            "Planet" , "Household", "Office", "Extended Family",
            "Company (US)", "Company (World)", "Team", "Will",
            "Birthday Card List", "High School", "Country", "Continent",
            "Planet" , "Household", "Office", "Extended Family",
            "Company (US)", "Company (World)", "Team", "Will",
            "Birthday Card List", "High School", "Country", "Continent",
            "Planet" , "Household", "Office", "Extended Family",
            "Company (US)", "Company (World)", "Team", "Will",
            "Birthday Card List", "High School", "Country", "Continent",
            "Planet" , "Household", "Office", "Extended Family",
            "Company (US)", "Company (World)", "Team", "Will",
            "Birthday Card List", "High School", "Country", "Continent",
            "Planet" };

    ArrayList<String> categories = new ArrayList<String>(Arrays.asList(liste));

    // Bordure
    Border border = BorderFactory.createEmptyBorder( 0, 0, 0, 0 );
}
