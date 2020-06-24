package timer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import element.StaticElements;

import main.MainFrame;

public class TimerListener implements ActionListener {
	MainFrame mainFrame;

	public TimerListener(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		StaticElements.timecount++;
		if (StaticElements.timecount > 999) {
			StaticElements.timecount = 999;

		}
		mainFrame.getFaceJPanel().setTime(StaticElements.timecount);

	}

}
