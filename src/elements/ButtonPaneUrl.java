package elements;

import javafx.scene.shape.Box;
import listener.UrlOpenerListener;
import model.IconButton;

import javax.swing.*;

public class ButtonPaneUrl {

    private JPanel buttonUrlPanel; //Container für die Buttons



    private final String[] iconStrings = {"fs", "ksh", "bzz"};

    public ButtonPaneUrl(){
        buttonUrlPanel = new JPanel();
        BoxLayout boxLayout = new BoxLayout(buttonUrlPanel, BoxLayout.PAGE_AXIS); //Alle untereinander platzieren
        buttonUrlPanel.setLayout(boxLayout); //Hinzufügen vom Boxlayout zum Panel

        for (String iconName: iconStrings) {
            IconButton iconButton = new IconButton(iconName, "1", iconName);
            buttonUrlPanel.add(iconButton);

            iconButton.addMouseListener(new UrlOpenerListener());
        }

    }

    public JPanel getButtonUrlPanel() {
        return buttonUrlPanel;
    }

    public void setButtonUrlPanel(JPanel buttonUrlPanel) {
        this.buttonUrlPanel = buttonUrlPanel;
    }

}
