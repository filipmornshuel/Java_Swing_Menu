package listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

import utilities.Utilities;

public class ProgramOpenerListener implements MouseListener {

	//MouseListener
	@Override
	public void mouseClicked(MouseEvent e) {
		JButton button = (JButton) e.getSource();
		String text = button.getActionCommand();
		
		String path;

		//Mittels Switch Case die einzelnen Programme abgefragt und geöffnet
		switch (text) {
		case "oneNote":
			path = "C:\\Program Files\\Microsoft Office\\root\\Office16\\ONENOTE.EXE";
			Utilities.startProgram(path);
			break;
		case "firefox":
			path = "C:\\Program Files\\Mozilla Firefox\\firefox.exe";
			Utilities.startProgram(path);
			break;
		case "outlook":
			path = "C:\\Program Files\\Microsoft Office\\root\\Office16\\OUTLOOK.EXE";
			Utilities.startProgram(path);
			break;
		case "word":
			 path = "C:\\Program Files\\Microsoft Office\\root\\Office16\\WINWORD.EXE";
			 Utilities.startProgram(path);
			break;
		default:
			break;
		}
		
	}

	//Alle anderen mouseListener nicht berücksichtigt
	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

}
