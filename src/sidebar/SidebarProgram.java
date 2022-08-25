package sidebar;

import elements.*;

import javax.swing.*;
import java.awt.*;

public class SidebarProgram {

    JFrame sidebarJFrame = null;

    private final int SIDEBARWIDTH = 150;
    private final int SIDEBARHEIGHT = 600;

    private Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize(); //Bildschirmgrösse

    //Elemente der Sidebar
    private DigitalClock digitalClock;
    private ButtonPaneUrl buttonPaneUrl;
    private TextFieldURLOpener textFieldURLOpener;
    private ButtonPanelProgramOpener buttonPanelProgramOpener;
    private ButtonProgramOpener buttonProgramOpener;
    private WeatherPanel weatherPanel;

    //KOnstruktor
    public SidebarProgram(){
        sidebarJFrame = new JFrame("Sidebar");
        sidebarJFrame.setSize(SIDEBARWIDTH, SIDEBARHEIGHT);
        sidebarJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        sidebarJFrame.setResizable(false);

        //Elemente der Sidebar erstellen
        digitalClock = new DigitalClock();
        buttonPaneUrl = new ButtonPaneUrl();
        textFieldURLOpener = new TextFieldURLOpener();
        buttonPanelProgramOpener = new ButtonPanelProgramOpener();
        buttonProgramOpener = new ButtonProgramOpener();
        weatherPanel = new WeatherPanel();

        //Elemente positionieren / Layout erstellen
        setLayout();

        sidebarJFrame.setVisible(true);
    }

    private void setLayout(){
       // System.out.println("Breite vom Bildschrimt" + dimension.width);
       // System.out.println("" + dimension.height);
        int screenWidth = dimension.width;
        int screenHeight = dimension.height;

        sidebarJFrame.setLocation(screenWidth - SIDEBARWIDTH, 0);
        //sidebarJFrame.setAlwaysOnTop(true);

        sidebarJFrame.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        //Elemente einfügen
        sidebarJFrame.getContentPane().add(digitalClock.getTimeLabel());
        sidebarJFrame.getContentPane().add(buttonPaneUrl.getButtonUrlPanel());
        createLabel("URL eingeben");
        sidebarJFrame.getContentPane().add(textFieldURLOpener.getjTextField());
        createLabel("Programme");
        sidebarJFrame.getContentPane().add(buttonPanelProgramOpener.getjPanelProgramOpener());
        createLabel("Programm öffnen");
        sidebarJFrame.getContentPane().add(buttonProgramOpener.getjButton());
        createLabel("Wetter Übersicht");
        sidebarJFrame.getContentPane().add(weatherPanel.getWeatherJPanel());
    }

    private void createLabel(String text){
        JLabel jLabel = new JLabel(text);
        jLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        sidebarJFrame.getContentPane().add(jLabel);



    }


    public static void main(String[] args) {
        new SidebarProgram();
    }
}
