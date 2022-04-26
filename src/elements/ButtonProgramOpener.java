package elements;

import utilities.Utilities;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonProgramOpener {
    private JButton jButton;

    public ButtonProgramOpener(){
        jButton = new JButton("Programm öffnen");

        jButton.setPreferredSize(new Dimension(140,40));
        
        //Lambda Ausdruck, Abkürzung zur anonyme Klasse
        jButton.addActionListener(e -> {

            //Filechoser, dient zum Dateien auswählen
            JFileChooser jFileChooser = new JFileChooser();

            //Schauen was der Benutzer drückt und gebe es als int zurück --> z.B öffnen oder abbrechen
            int rueckGabeWert = jFileChooser.showOpenDialog(null);

            String pathString;

            //Pfad aus der Datei lesen
            if (rueckGabeWert == jFileChooser.APPROVE_OPTION){//ÖFFNEN gedrückt


                //Pfad abspeichern, den man durch getSelected File bekommt...
                pathString = jFileChooser.getSelectedFile().getAbsolutePath();
                Utilities.startProgram(pathString);


            } else if ( rueckGabeWert == JFileChooser.CANCEL_OPTION){
                //Abbrechen gedrückt
                System.out.println("Abbrechen gedrückt");
            }
        });
    }

    //Getter/Setter
    public JButton getjButton() {
        return jButton;
    }

    public void setjButton(JButton jButton) {
        this.jButton = jButton;
    }
}
