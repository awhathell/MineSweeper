package dialog;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import element.StaticElements;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLayeredPane;

import main.MainFrame;
import panel.BackgroundPanel;

public class InfoJDialog extends JDialog {

    /**
     *
     */

    private BackgroundPanel panelbg = new BackgroundPanel(StaticElements.info);
    // private JPanel panel2=new JPanel();
    
    //  private JLayeredPane lp=new JLayeredPane();
    //  private Container container=this.getContentPane();
    InfoJDialog sweeping = null;

    public InfoJDialog(MainFrame mainFrame) {

        super(mainFrame);
        //sweeping = this;
        this.setTitle("关于");
        //this.add(getPanel());
        // JButton jb =new JButton("确定"); 
        /* panel2.add(jb);
                panel2.setOpaque(false);
                lp.add(panelbg,new Integer(0));
                lp.add(panel2,new Integer(1));
                container.add(lp,BorderLayout.CENTER);*/
        // this.setUndecorated(true);;
        
        this.add(panelbg, BorderLayout.CENTER);
        // this.add(jb,BorderLayout.SOUTH);
        this.setSize(new Dimension(1116, 750));
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        //this.setModal(true);
        //  container.setVisible(true);
        this.setVisible(true);

    }

    /*	private JPanel getPanel() {
		JPanel panel = new JPanel();
                labelIcon = new JLabel(StaticElements.info);
		JButton button = new JButton("确定");
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				sweeping.dispose();

			}
		});
		JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		panel1.add(button);
		panel.add(panel1);
		Border border = BorderFactory.createEtchedBorder();
		panel.setBorder(border);
		panelT = new JPanel(new BorderLayout());
		Border border2 = BorderFactory.createEmptyBorder(10, 10, 10, 10);
		panelT.add(panel);
		panelT.setBorder(border2);

		return panelT;

	}*/
}
