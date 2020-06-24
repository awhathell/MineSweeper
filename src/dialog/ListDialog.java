package dialog;

import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JDialog;
import javax.swing.JPanel;
import panel.BackgroundPanel;
import main.MainFrame;

import element.StaticElements;

import java.awt.Font;
import javax.swing.JLabel;

public class ListDialog extends JDialog {

    private JPanel panel = null;
    private JLabel JLC = new JLabel();

    JLabel[][] labels = new JLabel[3][8];

    public ListDialog(MainFrame mainFrame) {
        super(mainFrame);
        this.setTitle("É¨À×Ó¢ÐÛ°ñ");
        this.add(getPanel());
        this.setSize(new Dimension(1116, 750));
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setModal(true);
        this.setVisible(true);
    }

    public JPanel getPanel() {
        panel = new BackgroundPanel(StaticElements.board);
        panel.setOpaque(false);
        panel.setLayout(null);
        for (int i = 0; i < labels.length; i++) {
            for (int j = 0; j < labels[i].length; j++) {
                labels[i][j] = new JLabel();
                labels[i][j].setText(" ");
                labels[i][j].setForeground(Color.WHITE);
                labels[i][j].setBounds(100 + i * 355, 235 + 40 * j, 200, 40);
                labels[i][j].setFont(new Font(null, Font.BOLD, 25));
                panel.add(labels[i][j]);
            }
        }
        //addMessage();
        return panel;
    }
/*
    private void addMessage() {
        int j = 0;
        for (HeroBean heroBean : StaticTool.treeSetC) {
            labels[0][j].setFont(new Font("ºÚÌå", Font.BOLD, 25));
            labels[0][j].setText(heroBean.toString() + "\n");
            j++;
        }
        j = 0;
        for (HeroBean heroBean : StaticTool.treeSetZ) {
            labels[1][j].setFont(new Font("ºÚÌå", Font.BOLD, 25));
            labels[1][j].setText(heroBean.toString() + "\n");
            j++;
        }
        j = 0;
        for (HeroBean heroBean : StaticTool.treeSetG) {
            labels[2][j].setFont(new Font("ºÚÌå", Font.BOLD, 25));
            labels[2][j].setText(heroBean.toString() + "\n");
            j++;
        }
    }*/
}
