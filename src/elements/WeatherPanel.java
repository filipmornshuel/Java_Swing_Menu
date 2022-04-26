package elements;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
In dieser Klass habe ich von https://openweathermap.org/ die API eingebunden.
Mittels dieser API zeige ich dann in der Sidebar die gewünschten Wetterinformationen an.
Benutzt wird die GSON-Bibliothek.
 */

public class WeatherPanel {

    //Panel
    private JPanel weatherJPanel;

    //GUI Elemente
    private JLabel weatherIconJLabel;
    private JLabel tempJLabel;
    private JLabel locationJLabel;
    private JButton updateJButton;

    //Variablen zum Abspeichern
    private final String ID = "2a0b1ff1da0bae336e6d541f525f5d9a";
    private final String LOCATION = "Zurich,CH";
    private final String LANGUAGE = "de";

    //Wetterdaten speichern
    private String weatherIcon; //WICHTIG --> nicht mit weatherIconID, API hat sich geändert, sondern mit weatherIcon (als String) siehe dazu ein Beispiel in der API
    private String weatherDescription;
    private double weatherTemp;

    //URL
    private String urlString = "https://api.openweathermap.org/data/2.5/weather?q="+LOCATION + "&appid=" +ID+ "&units=Metric" + "&lang="+LANGUAGE;

    public WeatherPanel(){

        //Jpanel erstellen
        weatherJPanel = new JPanel();
        weatherJPanel.setPreferredSize(new Dimension(150,150));
        BoxLayout boxLayout = new BoxLayout(weatherJPanel, BoxLayout.Y_AXIS);
        weatherJPanel.setLayout(boxLayout);

        //Wetterdaten laden
        getWeatherData();

        //GUI
        setGUI();

        //Update Button
        setUpdateButton();

        //Add to Panel
        addToJPanel();
    }

    //Kern von diesem Panel
    private void getWeatherData(){
        try{
            //Daten einlesen
            StringBuilder result = new StringBuilder();
            //URL öffnen
            URL url = new URL(urlString);
            URLConnection connection = url.openConnection();

            //von oben die Connection geholt mittels getInputStream, der die Zeichen vom JSON (API) einlesen wird.
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String tempString;

            //Daten auslesen, daten solange einlesen, bis fertig gelsen
            while ((tempString = bufferedReader.readLine()) != null){
                //Schritt vor Schritt einlesen in die Resultvariable mit der append-methode
                result.append(tempString);
            }




            //Testen der Verbindung
            System.out.println("Ergebnis:" +result);



            //BufferedReader schliessen, da er alles eingelesen hat.
            bufferedReader.close();

            //Wetter aus result auslesen und strukturieren mittels Map und jsonToMap --> von result Map wird schlussendlich alles geholt...
            Map<String, Object> resultMap = jsonToMap(result.toString());
            //aus ResultMap unter main die Daten aus Main geholt und in String umgewandelt --> Unterpunkt
            Map<String, Object> mainMap = jsonToMap(resultMap.get("main").toString());
            //aus resultmap unter wind die Daten aus wind geholt und in String umgewandelt -->Unterpunkt
            Map<String, Object> windMap = jsonToMap(resultMap.get("wind").toString());

            //Da bei der Kategorie Weather es nochmals eine Unterkategorie hat, habe ich hier einen Zwischenschritt mit der Arrayslist eingelegt
            ArrayList<Map<String, Object>> weather = (ArrayList<Map<String, Object>>)resultMap.get("weather");
            Map<String, Object> weatherMap = weather.get(0); //Index 0 alle Information von Weather



            //Tests
            System.out.println("Mainmap test: "+mainMap);
            System.out.println("Temperature test: "+mainMap.get("temp"));
            System.out.println("Pressure test:" +mainMap.get("pressure"));
            System.out.println("speed test: "+windMap.get("speed"));
            System.out.println("id test: "+weatherMap.get("id"));
            System.out.println("description test: "+weatherMap.get("description"));

            //Abspeicherung der Variablen mittels den jeweiligen maps
            weatherIcon = (String) weatherMap.get("icon");
            weatherDescription = (String) weatherMap.get("description");
            weatherTemp = (double) mainMap.get("temp");



        }catch (MalformedURLException e) { //Die Exceptions abgefangen
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setGUI(){
        //Die ImageIcons die man in der Sidebar sehen wird, hier erstellt
        ImageIcon imageIcon = new ImageIcon();

        //try catch falls etwas mit der URL schief läuft
        try {
            //imageIcon = new ImageIcon(new URL("http://openweathermap.org/img/wn/" + weatherIconID + ".png"));
            imageIcon = new ImageIcon(new URL("http://openweathermap.org/img/wn/" + weatherIcon +".png") );

        }catch (Exception e){
            System.out.println("Bild konnte nicht geladen werden");
            e.printStackTrace();
        }

        //Das TempLabel anzeigen lassen
        tempJLabel = new JLabel(weatherTemp + "C°");
        tempJLabel.setFont(new Font("Arial", Font.BOLD, 14));
        //Den Label in der Mitte darstellen lassen
        tempJLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        tempJLabel.setAlignmentY(Component.CENTER_ALIGNMENT);

        //Für das weathIconLabel das gleiche...
        weatherIconJLabel = new JLabel(weatherDescription);
        weatherIconJLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        weatherIconJLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        weatherIconJLabel.setAlignmentY(Component.CENTER_ALIGNMENT);
        weatherIconJLabel.setIcon(imageIcon);

        //Für das locationLabel das gleiche...
        locationJLabel = new JLabel(LOCATION);
        locationJLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        locationJLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        locationJLabel.setAlignmentY(Component.CENTER_ALIGNMENT);


    }

    //Update Methode, dass es eben den Wetterstatus aktualisiert
    private void setUpdateButton(){
        updateJButton = new JButton("Update");
        updateJButton.setPreferredSize(new Dimension(100,20));
        updateJButton.setFont(new Font("Arial", Font.PLAIN, 12));
        updateJButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        updateJButton.setAlignmentY(Component.CENTER_ALIGNMENT);

        //Lambda für den Updatebutton
        updateJButton.addActionListener(e -> {
            getWeatherData();
            setGUI();
        });


    }

    //Einfaches adden zum Panel
    private void addToJPanel(){
        weatherJPanel.add(tempJLabel);
        weatherJPanel.add(weatherIconJLabel);
        weatherJPanel.add(locationJLabel);
        weatherJPanel.add(updateJButton);
    }

    // Daten in eine Map umwandeln
    private Map<String, Object> jsonToMap(String string) {
        Map<String, Object> map = new Gson().fromJson(string, new TypeToken<HashMap<String, Object>>() {
        }.getType());
        return map;
    }

    //Getter / Setter
    public JPanel getWeatherJPanel() {
        return weatherJPanel;
    }

    public void setWeatherJPanel(JPanel weatherJPanel) {
        this.weatherJPanel = weatherJPanel;
    }

    /*
    public static void main(String[] args) {
        new WeatherPanel();
    }

     */


}
