package model;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class IconButton extends JButton {

    private final int BUTTON_WEIGHT = 45;
    private final int BUTTON_HEIGHT = 45;

    public IconButton(String command, String imageFolder, String iconName){
        setupButton(command, imageFolder, iconName);
    }

    private void setupButton(String command, String imageFolder, String iconName){
        //Button Text setzen, der nicht sichtbar ist
        setActionCommand(command);

        //Button GRösse
        //Preferred bessere Wahl
        setPreferredSize(new Dimension(BUTTON_WEIGHT, BUTTON_HEIGHT));
        setToolTipText(command); //Tooltip-Name gesetzt, kleines Hilffesnter

        //Icon hinzufügen
        URL imgUrl = getClass().getResource("/image" + imageFolder + "/" + iconName + ".png"); //Pfad Suche

        //Überprüfung ob URL noch besteht
        if (imgUrl != null){
            ImageIcon icon = new ImageIcon(imgUrl);
            setIcon(icon); //Icon hinzugefügt
        }
        else {
            setText(command);
            System.out.println("Bild konnte nicht geladen werden");
        }
    }


}
