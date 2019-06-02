import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public interface Definition
{
    // Vehicles States
    String STATE1 = "Neuf";
    String STATE2 = "Bon";
    String STATE3 = "Moyen";
    String STATE4 = "Mauvais";
    String STATE5 = "Abime";

    // Font
    Font mainFont = new Font("Montserrat", Font.PLAIN, 15);
    Font menuFont = new Font("Montserrat", Font.PLAIN, 20);

    // Colors
    Color WHITE = new Color(0xFFFFFF);
    Color BLACK = new Color(0);
    Color LIGHTGREY = new Color(0xCCDDDD);
    Color DARKGREY = new Color(0x555555);

    Color InterfaceMainColor = new Color(0x4773B9);
    Color InterfaceLightColor = new Color (0x6A9DDB);

    Color idleButtonLightColor = InterfaceLightColor;
    Color hoverButtonLightColor = new Color (0x5f91ce);
    Color pressButtonLightColor = InterfaceMainColor;

    Color idleButtonColor = InterfaceMainColor;
    Color hoverButtonColor = new Color(0x416BAA);
    Color pressButtonColor = new Color(0x35549B);

    Color hoverCrossColor = new Color(0xe0552f);
    Color pressCrossColor = new Color(0xc13a15);

    Color backgroundSlideColor = new Color(0xDDDDDD);

    // Listes
    String[] buttonsName = {"Mes contrats", "Mes véhicules", "Mes clients"};

    //Examples
    Vehicule Twingo = new Voiture("Twingo","Renault",  20, 100f, STATE1, 10000, 75f, 4);
    Vehicule Clio2 = new Voiture("Clio 2","Renault",  30, 150, STATE2, 50000, 100, 5);
    Vehicule R8 = new Voiture("R8","Audi",  75, 250, STATE1, 5000, 375, 2);

    Client Tony = new Client("Chouteau", "Tony", "0601020304", "7 rue des pissenlis Lille");
    Client George = new Client("Du Pont", "George", "0624586796", "9 avenue des pirles Paris");
    Client Marcel = new Client("Robert", "Marcel", "0605545448", "56 grande rue Massy");

    // Bordure
    Border border = BorderFactory.createEmptyBorder( 0, 0, 0, 0 );
}
