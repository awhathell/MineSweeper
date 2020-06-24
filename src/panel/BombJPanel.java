package panel;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

import operation.BricksListener;
import main.MainFrame;

import element.StaticElements;
import element.Brick;
import java.awt.Dimension;

public class BombJPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Brick[][] labels = new Brick[StaticElements.allrow][StaticElements.allcol];
	private BricksListener listener;
	private MainFrame mainFrame;

	public BombJPanel(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
                //this.setBorder(BorderFactory.createTitledBorder("БъЬт") );
		this.setLayout(new GridLayout(StaticElements.allrow, StaticElements.allcol));
                //this.mainFrame.pack();
                
		init();

	}

	private void init() {

		listener = new BricksListener(labels, mainFrame);

		for (int i = 0; i < labels.length; i++) {
			for (int j = 0; j < labels[i].length; j++) {
				labels[i][j] = new Brick(i, j);
				labels[i][j].setIcon(StaticElements.blankIcon);
				labels[i][j].addMouseListener(listener);
				this.add(labels[i][j]);
			}
		}
		Border borderLow = BorderFactory.createLoweredBevelBorder();

		Border borderEmpty = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		Border borderCom1 = BorderFactory.createCompoundBorder(borderEmpty,
				borderLow);

		this.setBorder(borderCom1);
		this.setBackground(Color.LIGHT_GRAY);

	}

}
