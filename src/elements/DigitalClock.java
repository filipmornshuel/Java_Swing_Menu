package elements;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DigitalClock implements Runnable{

    private Thread thread = null;
    private int hours = 0;
    private int minutes = 0;
    private int seconds = 0;
    private String timeString = "";

    private JLabel timeLabel = null;

    public DigitalClock(){
        timeLabel = new JLabel(timeString);
        timeLabel.setFont(new Font("Arial", Font.BOLD,20));
        thread = new Thread(this); //Sucht nach Run Methode, die in der gleichen klasse ist.
        thread.start();
    }




    @Override
    public void run() {
        try{
            while (true){
                Calendar calendar = Calendar.getInstance();
                hours = calendar.get(Calendar.HOUR_OF_DAY);
                minutes = calendar.get(Calendar.MINUTE);
                seconds = calendar.get(Calendar.SECOND);

                //0-24
                SimpleDateFormat fDateFormat = new SimpleDateFormat("HH:mm:ss"); //HH gross 0-24 , klein hh wäre 0-12
                Date date = calendar.getTime();
                timeString = fDateFormat.format(date);

                timeLabel.setText(timeString);

                Thread.sleep(1000);
            }
        }catch (Exception e){

        }
    }

    public JLabel getTimeLabel() {
        return timeLabel;
    }

    public void setTimeLabel(JLabel timeLabel) {
        this.timeLabel = timeLabel;
    }
}
