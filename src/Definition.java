import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public interface Definition
{
    // Font
    Font mainFont = new Font("Montserrat", Font.PLAIN, 15);
    Font menuFont = new Font("Montserrat", Font.PLAIN, 20);

    // Colors
    Color WHITE = new Color(0xFFFFFF);
    Color BLACK = new Color(0);
    Color LIGHTGREY = new Color(0xDDDDDD);
    Color DARKGREY = new Color(0x555555);

    Color InterfaceMainColor = new Color(0x4773B9);
    Color InterfaceLightColor = new Color (0x6A9DDB);

    Color idleButtonColor = InterfaceMainColor;
    Color hoverButtonColor = new Color(0x416BAA);
    Color pressButtonColor = new Color(0x35549B);

    Color hoverCrossColor = new Color(0xe0552f);
    Color pressCrossColor = new Color(0xc13a15);

    Color backgroundSlideColor = new Color(0xDDDDDD);

    // Listes
    String[] buttonsName = {"Mes contrats", "Mes véhicules", "Mes clients"};

    String elementArray[] = { "Household", "Office", "Extended Family",
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

    ArrayList<String> elementArrayList = new ArrayList<String>(Arrays.asList(elementArray));

    // Bordure
    Border border = BorderFactory.createEmptyBorder( 0, 0, 0, 0 );
}
