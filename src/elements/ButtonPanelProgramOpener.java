package elements;

import listener.ProgramOpenerListener;
import model.IconButton;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;

//Diese Klasse dient zum Öffnen der jeweiligen Programm-Icons, die man beim Sidebar Programm sieht
public class ButtonPanelProgramOpener {

    private JPanel jPanelProgramOpener;

    private final String[] iconStrings = {"word", "outlook", "oneNote", "firefox"};

    public ButtonPanelProgramOpener(){
        jPanelProgramOpener = new JPanel(new GridLayout(2,2, 5,5));

        //Mittels Foreach Schleife den iconbuttons die jeweiligen Bilder hinzugefügt
        for (String icString:iconStrings) {
            IconButton iconButton = new IconButton(icString, "2", icString);
            iconButton.setBorder(new LineBorder(Color.black));

            jPanelProgramOpener.add(iconButton); //Button in das Pane hinzugefügt
            //Listener registriert
            iconButton.addMouseListener(new ProgramOpenerListener());

        }

    }

    public JPanel getjPanelProgramOpener() {
        return jPanelProgramOpener;
    }

    public void setjPanelProgramOpener(JPanel jPanelProgramOpener) {
        this.jPanelProgramOpener = jPanelProgramOpener;
    }
}
