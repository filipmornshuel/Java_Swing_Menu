package elements;

import utilities.Utilities;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TextFieldURLOpener {

    private JTextField jTextField;
    private JScrollPane jScrollPane;



    public TextFieldURLOpener(){
        jTextField = new JTextField();
        jTextField.setFont(new Font("Arial", Font.ITALIC, 14));

        jScrollPane = new JScrollPane(jTextField, ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        jTextField.setPreferredSize(new Dimension(140, 40));

        //Anonyme Klasse
        jTextField.addKeyListener(new KeyListener() {

            String urlString;

            @Override
            public void keyTyped(KeyEvent e) {
            }

            //Nur Keypressed verwendet
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode()==KeyEvent.VK_ENTER){
                    //Überprüfung ob Textfeld leer ist
                    if (jTextField.getText() != null){
                        urlString = jTextField.getText();
                        //Wiederverwendung der Klasse Utilities
                        Utilities.openUrl(urlString);
                    }
                }

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }


    //Getter/Setter
    public JTextField getjTextField() {
        return jTextField;
    }

    public void setjTextField(JTextField jTextField) {
        this.jTextField = jTextField;
    }
}
