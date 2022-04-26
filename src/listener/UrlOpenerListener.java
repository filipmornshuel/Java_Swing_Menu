package listener;

import utilities.Utilities;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class UrlOpenerListener implements MouseListener {
    @Override
    public void mouseClicked(MouseEvent e) {
        JButton jButton =(JButton) e.getSource();
        String textString = jButton.getActionCommand();

        String urlString="";

        //Switch Cases zu den Buttons die jeweiligen Links hinzugefügt
        switch (textString){
            case "fs":
                urlString = "www.maxihoster.com";
                Utilities.openUrl(urlString);
                break;
            case "ksh":
                urlString = "www.ksh.ch";
                Utilities.openUrl(urlString);
                break;

            case "bzz":
                urlString = "www.bzz.ch";
                Utilities.openUrl(urlString);
                break;
            default:
                urlString = "www.google.com";
                Utilities.openUrl(urlString);
                break;
        }
    }

    //Restliche MouseListenerMethoden nicht berücksichtigt
    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
