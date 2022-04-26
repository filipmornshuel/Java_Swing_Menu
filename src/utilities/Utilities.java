package utilities;

import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

//Diese Klasse dient zum Öffnen der Links/Programme
public class Utilities {

    //Static da ich kein Objekt von dieser Klasse erstellen will --> für das Öffnen der Links
    public static void openUrl(String urlString){
        //Mittels Try Catch sichergestellt, dass wenn Fehler eintreten, diese auch behandelt werden können
        try{
            //Zum vorherigen Link der jeweiligen Buttons auch noch https: hinzugefügt,da die Links sonst nicht geöffnet werden können.
            Desktop.getDesktop().browse(new URL("https://"+urlString + "/").toURI());

        }catch (URISyntaxException  | IOException e) {
            JOptionPane.showMessageDialog(null, "URL nicht möglich");
            System.out.println(e.getMessage());
        }
    }

    //Startprogramm-Methode für ProgramOpenerListener
    public static void startProgram(String path){
        //Try Catch für Process
        try {
            Process process = Runtime.getRuntime().exec(path);
            //Nach 5 Sekunden geöffnet werden
            try {
                Thread.sleep(5000);
            }catch (Exception e){
                e.printStackTrace();
            }
            process.destroy();


        }catch (IOException e) { //Behandlung der Exception von Process
            JOptionPane.showMessageDialog(null, "Programmpfad nicht gefunden");
            e.printStackTrace();
        }
    }

}
